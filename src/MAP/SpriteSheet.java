import java.awt.image.BufferedImage;

public class SpriteSheet {
    /*FIELDS*/
    private BufferedImage image;
    private int[] pixels;
    public final int SIZEX;
    public final int SIZEY;
    private Sprite[] loadedSprites = null;
    private boolean isSpriteLoaded = false;
    private int xChunk;

    /*METHODS*/
    public SpriteSheet(BufferedImage sheetImage){
        SIZEX = sheetImage.getWidth();
        SIZEY = sheetImage.getHeight();
        image = sheetImage;
        pixels = new int[SIZEX*SIZEY];
        pixels = sheetImage.getRGB(0, 0, SIZEX, SIZEY, pixels, 0, SIZEX);

    }

    public void loadsprites(int spriteSizeX, int spriteSizeY){
        loadedSprites = new Sprite[(SIZEX/spriteSizeX)*(SIZEY/spriteSizeY)];
        int spriteID = 0;
        for(int y = 0; y <SIZEY; y+=spriteSizeY){
            for (int x = 0; x < SIZEX; x+=spriteSizeX){
                loadedSprites[spriteID] = new Sprite(this, x, y, spriteSizeX, spriteSizeY);
                spriteID++;
            }
        }
        this.xChunk = SIZEX/spriteSizeX;
        isSpriteLoaded = true;
    }

    public Sprite getSprite(int x, int y){
        if(isSpriteLoaded){
            int spriteid = x + y*xChunk;
            if(spriteid < loadedSprites.length)
                return loadedSprites[spriteid];
            else
                return null;
        }   
        else
            return null;
    }

    public int[] getPixels(){
        return pixels;
    }

    public BufferedImage getImage(){
        return image;
    }
}
