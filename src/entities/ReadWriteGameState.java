package entities;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

public class ReadWriteGameState {
    private ObjectMapper o;

    public ReadWriteGameState(){
        o = new ObjectMapper();
        o.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        o.enableDefaultTyping();
        o.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public boolean isSaveGameAlreadyExist(String fileName){
        File dir = new File("state/");
        File[] files = dir.listFiles((d, name) -> (name.equals(fileName)));
        System.out.println(files.length);
        return (files.length > 0);
    }

    public void loadSaveFiles(){
        File dir = new File("state/");
        File[] files = dir.listFiles((d, name) -> name.endsWith(".json"));
        int i = 0;
        for(File f : files){
            i++;
            System.out.println("Save file #" + i + " : " + f.getName());
        }
    }

    public Player loadGameState(String fileName){
        try{
            Player p = o.readValue(new File("state/" + fileName), Player.class);
            return p;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void writeGameState(Player p, String fileName){
        try{
            o.writeValue(new File("state/" + fileName + ".json"), p);
            System.out.println("Save");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
