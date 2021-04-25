package GUI;

import java.awt.image.BufferedImage;

public class Sprite {
    /*FIELDS*/
    private int width, height;
    private int[] pixels;

    /*METHODS*/
    public Sprite(SpriteSheet sheet, int startX, int startY, int width, int height){
        this.width = width;
        this.height = height;

        pixels = new int[width*height];
        sheet.getImage().getRGB(startX, startY, width, height, pixels, 0, width);
    }

    public Sprite(BufferedImage image){
        this.width = image.getWidth();
        this.height = image.getHeight();

        pixels = new int[width*height];
        image.getRGB(0, 0, width, height, pixels, 0, width);
    }

    public void createBorder(int width, int color){
        /*INSIDE BORDERS*/
        //top and bottom border
        for(int j = 0; j < width; j++)
            for(int i = 0; i < this.width; i++){
                pixels[i + j*this.width] = color;
                pixels[i + (this.height-j-1)*this.width] = color;
            }

        //left and right borders
        for(int i = 0; i < width; i++)
            for(int j = 0; j < this.height; j++){
                pixels[i + j*this.width] = color;
                pixels[(this.width-i-1) + j*this.width] = color;
            }
    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public int[] getPixels(){
        return pixels;
    }
}
