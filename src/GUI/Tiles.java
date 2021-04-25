package GUI;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Tiles {
    private ArrayList<Tile> tiles = new ArrayList<>();
    private SpriteSheet spritesh;

    public Tiles(File tilesFile, SpriteSheet spritesh){
        this.spritesh = spritesh;
        try{
            Scanner scanner = new Scanner(tilesFile);
            while(scanner.hasNextLine()){
                String[] entry = scanner.nextLine().split("-");
                int x = Integer.parseInt(entry[1]);
                int y = Integer.parseInt(entry[2]);
                tiles.add(new Tile(spritesh.getSprite(x, y), entry[0]));
            }
            scanner.close();
        }
        catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public void renderTile(int tileID, RenderHandler renderer, int xPosition, int yPosition, int xZoom, int yZoom){
        if(0 <= tileID && tileID < tiles.size())
            renderer.renderSprite(tiles.get(tileID).sprite, xPosition, yPosition, xZoom, yZoom);
        // else{
        //     System.out.println("nope");
        // }
    }

    public Sprite getTileSprite(String namaTile){
        for(Tile t: tiles){
            if(namaTile.equals(t.tilename))
            return t.sprite;
        }
        return null;
    }

    class Tile{
        public Sprite sprite;
        public String tilename;

        public Tile(Sprite sp, String name){
            this.sprite = sp;
            this.tilename = name;
        }
    }
}
