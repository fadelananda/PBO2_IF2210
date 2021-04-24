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
                tiles.add(new Tile(entry[0], spritesh.getSprite(x, y)));
            }
            scanner.close();
        }
        catch(FileNotFoundException ex){
            ex.printStackTrace();
        }
    }

    public void renderTile(int tileID, RenderHandler renderer, int xPosition, int yPosition, int xZoom, int yZoom){
        if(tileID >= 0 && tiles.size() > tileID)
            renderer.renderSprite(tiles.get(tileID).sprite, xPosition, yPosition, xZoom, yZoom);
    }

    class Tile{
        public String tilename;
        public Sprite sprite;

        public Tile(String name, Sprite sp){
            this.tilename = name;
            this.sprite = sp;
        }
        
    }
}
