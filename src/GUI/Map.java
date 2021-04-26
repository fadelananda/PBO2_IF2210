package GUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map {
    /*FIELDS*/
    private static ArrayList<MapTile> maptiles = new ArrayList<MapTile>();
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
                    MapTile mappedTile = new MapTile(Integer.parseInt(splitString[0]),
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

        // Rectangle camera = renderer.getCamera();
        // for(int y = camera.y - yinc - (camera.y % yzoom); y < camera.y + camera.height; y+= yinc)
        //     for(int x = camera.x - xinc - (camera.x % xinc); x < camera.x + camera.width; x+= xinc)
        //         tiles.renderTile(filler, renderer, x, y, xzoom, yzoom);


        // for(int i = 0; i < renderer.getCamera().width; i++)
        //     for(int j = 0; j < renderer.getCamera().height; j++)
        //         tiles.renderTile(filler, renderer, xinc*i, yinc*j, xzoom, yzoom);

        for(MapTile m : maptiles){
            tiles.renderTile(m.tileid, renderer, xinc*m.x, yinc*m.y, xzoom, yzoom);
        }
    }

    public static int whatTileId(int xpos, int ypos){
        for(MapTile m : maptiles){ 
            if(
                (m.x-1)*48 <= xpos && xpos <= (m.x-1)*48+48
                && (m.y-1)*48 <= ypos && ypos <= (m.y-1)*48+48
            ){
                return m.tileid;
            }
        }
        return -1;
    }

    /*SUBCLASS INSIDE MAP*/
    class MapTile{
        /*FIELDS*/
        int tileid;
        int x;
        int y;

        /*METHODS*/
        public MapTile(int tileid, int x, int y){
            this.tileid = tileid;
            this.x = x;
            this.y = y;
        }
    }
}
