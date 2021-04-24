import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map {
    /*FIELDS*/
    private ArrayList<mapTile> maptiles = new ArrayList<mapTile>();
    private Tiles tiles;
    private int filler;
    
    /*METHODS*/
    public Map(File mapFile, Tiles tiles){
        this.tiles = tiles;
        try{
            Scanner scanner = new Scanner(mapFile);
			while(scanner.hasNextLine()) 
			{
				String line = scanner.nextLine();
				if(line.contains(":")) 
                {
                    String[] splitString = line.split(":");
                    if(splitString[0].equalsIgnoreCase("Fill"))
                    {
                        filler = Integer.parseInt(splitString[1]);
                        continue;
                    }
                }


                String[] splitString = line.split(",");
                if(splitString.length >= 3)
                {
                    mapTile mappedTile = new mapTile(Integer.parseInt(splitString[0]),
                                                            Integer.parseInt(splitString[1]),
                                                            Integer.parseInt(splitString[2]));
                    maptiles.add(mappedTile);
                }
			}
            scanner.close();
        }
        catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public void renderMap(RenderHandler renderer, int xzoom, int yzoom){
        int xinc = 16*xzoom;
        int yinc = 16*yzoom;

        for(int i = 0; i < renderer.getCamera().width; i++)
            for(int j = 0; j < renderer.getCamera().height; j++)
                tiles.renderTile(filler, renderer, xinc*i, yinc*j, xzoom, yzoom);

        //load
        for(mapTile m : maptiles){
            tiles.renderTile(m.tileid, renderer, xinc*m.x, yinc*m.y, xzoom, yzoom);
        }
    }

    class mapTile{
        /*FIELDS*/
        int tileid;
        int x;
        int y;

        /*METHODS*/
        public mapTile(int tileid, int x, int y){
            this.tileid = tileid;
            this.x = x;
            this.y = y;
        }
    }
}
