import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
// import java.awt.image.DataBufferInt;
import java.awt.Canvas;
// import java.awt.Color;
import java.awt.Graphics;

import javax.imageio.ImageIO;

import java.lang.Runnable;
// import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Game extends JFrame implements Runnable{
    /*FIELDS*/
    private Canvas canvas = new Canvas();
    private BufferStrategy buffstrat;
    private RenderHandler renderer;
    private BufferedImage mapImg;
    private SpriteSheet mapsprites;
    private Tiles tilesforMap;
    private Map map;

    /*STATICS*/
    //buat transparency
    public static int alpha = 0xFF00DC;

    /*METHODS*/
    public Game(){
        /**WINDOW PROPERTIES**/
        //exit program waktu diclose
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set title
        setTitle("Engimon Adventure");
        //set image icon
        ImageIcon img = new ImageIcon("engimonIcon.png");
        super.setIconImage(img.getImage());
        //ukuran windownya
        setBounds(0,0, 800, 800);
        //biar ga bisa diresize
        setResizable(false);
        //taroh di tengah
        setLocationRelativeTo(null);
        //biar frame nya keliatan
        setVisible(true);

        /**RANAH ITEMS**/
        //add graphics component
        add(canvas);

        // create out object for buffer stregy
        canvas.createBufferStrategy(3);

        //create render handler of window width and height
        renderer = new RenderHandler(getWidth(), getHeight());

        //load tiles buat map
        mapImg = loadImage("assets/rpg_tiles.png"); //load image doang
        mapsprites = new SpriteSheet(mapImg); //masukin img ke spritesheetnya
        mapsprites.loadsprites(16, 16); //mecah mecah jadi 16x16 biar bisa dipake
        
        tilesforMap = new Tiles(new File("assets/Tiles.txt"), mapsprites); //load tiles yang bisa dipake berd. spritesheet yg tadi
        map = new Map(new File("assets/Map.txt"), tilesforMap); //define map nya
    }

    /*LOAD IMAGE AS A BUFFERED IMAGE*/
    public BufferedImage loadImage(String path){
        try{
            BufferedImage loadedImage = ImageIO.read(Game.class.getResource(path));
            BufferedImage formatted = new BufferedImage(loadedImage.getWidth(),
                                                        loadedImage.getHeight(),
                                                        BufferedImage.TYPE_INT_RGB);
            formatted.getGraphics().drawImage(loadedImage, 0, 0, null);
            return formatted;
        }
        catch(IOException a){
            a.printStackTrace();
            return null;
        }
    }

    /*RENDER/
    /*RUNS EVERYTIME TO ACTUALLY SHOW STUFF*/
    public void render(){
        //get the buffer strategy from the canvas
        buffstrat = canvas.getBufferStrategy();
        
        //get the graphics from said buffer strategy because graphics is the one being rendered
        Graphics graphics = buffstrat.getDrawGraphics();
        
        //its like "renderer" is the one doing the drawing, so tells the renderer what to draw
        // renderer.renderImage(map, xPosition, yPosition, 1, 1);
        map.renderMap(renderer, 3, 3);

        //the renderer knows what to draw, not it only need somewhere to draw, the canvas (has been turned into a graphics)
        renderer.render(graphics);
        graphics.dispose();

        //show the graphics to the world through bufferstrategy, the graphics component has been drawn into
        buffstrat.show();
    }

    /*TO UPDATE WHAT'S GOING TO BE DRAWN*/
    public void update(){
        //
    }

    public void run(){
        //set frames per second
        Long lastTime = System.nanoTime();
        double nanoSecConversion = 1000000000.0/60; //60 frames per second
        double deltaSec = 0;

        while(true){
            Long now = System.nanoTime();
            deltaSec += (now-lastTime)/nanoSecConversion;

            if(deltaSec >= 1){
                update();
                deltaSec=0;
            }

            render();
            lastTime = now;
        }
    }

    //MAIN
    public static void main(String[] args) {
        Game game = new Game();
        Thread gameThread = new Thread(game);
        gameThread.start();
    }
}