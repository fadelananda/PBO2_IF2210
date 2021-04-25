package entities;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import entities.engimon.Geni;
import entities.engimon.Teles;
import enums.Elements;

import java.io.File;
import java.util.EnumSet;
import java.util.Scanner;

public class ReadWriteGameState {
    private ObjectMapper o;

    ReadWriteGameState(){
        o = new ObjectMapper();
        o.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        o.enableDefaultTyping();
        o.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
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

    public Player loadGameState(){
        loadSaveFiles();
        Scanner sc = new Scanner(System.in);
        System.out.print("\nMasukkan nama save file: ");
        String fileName = sc.nextLine();
        try{
            Player p = o.readValue(new File("state/" + fileName + ".json"), Player.class);
            return p;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public void writeGameState(Player p){
        Scanner sc = new Scanner(System.in);
        System.out.print("Berikan nama pada save file: ");
        String fileName = sc.nextLine();
        try{
            o.writeValue(new File("state/" + fileName + ".json"), p);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        // TESTING
        Player tang = new Player();

        Teles engi1 = new Teles("pokemon1", 20,20);
        Geni engi2 = new Geni("pokemon2", 21,20);
        Teles engi3 = new Teles("pokemon3", 22,20);
        Geni engi4 = new Geni("pokemon4", 23,20);
        engi2.setLevel(5);
        engi3.setLevel(5);

        tang.addEngimon(engi1);
        tang.addEngimon(engi2);
        tang.addEngimon(engi4);
        tang.addEngimon(engi3);

        System.out.println();
        System.out.println("===================engi bag");
        tang.tampilkanListEngimon();
        System.out.println("===================jml item");
        System.out.println("total " + tang.countBag());
        System.out.println();

        System.out.println();
        tang.setActiveEngimon();
        System.out.println("===================active engi");
        tang.tampilkanDataEngimon(tang.getActiveEngimon());
        System.out.println();
        System.out.println("===================interact");
        tang.interactActiveEngimon();
        System.out.println("===================jml item");
        System.out.println("total " + tang.countBag());
        System.out.println();

        Skill sk1 = new Skill("lari",200,2, EnumSet.of(Elements.WATER));
        Skill sk2 = new Skill("mangan",300,2,EnumSet.of(Elements.WATER));
        Skill sk3 = new Skill("turu",200,2,EnumSet.of(Elements.WATER));
        Skill sk4 = new Skill("nglamun",400,2,EnumSet.of(Elements.ELECTRIC));

        SkillItem ski1 = new SkillItem(sk1);
        SkillItem ski2 = new SkillItem(sk2);
        SkillItem ski3 = new SkillItem(sk3);
        SkillItem ski4 = new SkillItem(sk4);

        tang.addSkillItem(ski1, 1);
        tang.addSkillItem(ski2,1);
        tang.addSkillItem(ski3,1);
        tang.addSkillItem(ski4,1);

        System.out.println();
        System.out.println("===================skillitem bag");
        tang.tampilkanListSkillItem();
        System.out.println("===================jml item");
        System.out.println("total " + tang.countBag());
        System.out.println();

        System.out.println();
        tang.useSkillItem(tang.getActiveEngimon());
        System.out.println("===================active engi");
        tang.tampilkanDataEngimon(tang.getActiveEngimon());
        System.out.println("===================jml item");
        System.out.println("total " + tang.countBag());
        System.out.println();

        //TESTING BATTLE

        boolean isBattleFinised = false;
        tang.battle(engi4, isBattleFinised);
        System.out.println(tang.getActiveEngimon().getJumlahSkill());

        ReadWriteGameState g = new ReadWriteGameState();

        g.writeGameState(tang);
        Player p = g.loadGameState();
    }
}
