package GUI;

import entities.Player;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

// import java.awt.image.DataBufferInt;
// import java.awt.Color;
// import java.util.Scanner;

public class Game extends JFrame implements Runnable{
    /*FIELDS*/
    private Canvas canvas = new Canvas();
    private BufferStrategy buffstrat;
    private RenderHandler renderer;

    //textures and avatars
    private BufferedImage mapImg;
    private BufferedImage avaImg;
    private SpriteSheet mapsprites;
    private SpriteSheet avasprites;
    private Tiles tilesforMap;
    private Map map;
    private PlayerT player;

    //objects
    private ArrayList<GameObject> objects;
    private KeyboardListener keyListener = new KeyboardListener();

    /*STATICS*/
    //buat transparency
    public static int alpha = 0xFFFF00DC;

    /*METHODS*/
    public Game(){
        /**WINDOW PROPERTIES**/
        //exit program waktu diclose
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Set title
        setTitle("Engimon Adventure");
        //set image icon
        ImageIcon img = new ImageIcon("assets/engimonIcon.png");
        super.setIconImage(img.getImage());
        //ukuran windownya
        setBounds(0,0, 1120, 750);
        //biar ga bisa diresize
        setResizable(false);
        //taroh di tengah
        setLocationRelativeTo(null);
        //biar frame nya keliatan
        setVisible(true);
        //layout manager

        /**RANAH ITEMS**/
        //add graphics component
        add(canvas);
        add(new StatusPanel(new Player()), BorderLayout.EAST);
        

        // create out object for buffer stregy
        canvas.createBufferStrategy(3);

        //create render handler of window width and height
        renderer = new RenderHandler(720, 720);

        //load tiles buat map
        mapImg = loadImage("assets/rpg_tiles.png"); //load image doang
        mapsprites = new SpriteSheet(mapImg); //masukin img ke spritesheetnya
        mapsprites.loadsprites(16, 16); //mecah mecah jadi 16x16 biar bisa dipake
        tilesforMap = new Tiles(new File("assets/Tiles.txt"), mapsprites); //load tiles yang bisa dipake berd. spritesheet yg tadi
        map = new Map(new File("assets/Map.txt"), tilesforMap); //define map nya

        //load avatar
        avaImg = loadImage("assets/bard.png");
        avasprites = new SpriteSheet(avaImg);
        avasprites.loadsprites(32, 32);

        //create an objects holder 4 the gaem
        objects = new ArrayList<>();

        //create a player and add it to the list of objects
        PlayerT joni = new PlayerT(avasprites);
        objects.add(joni);

        //Add listener
        canvas.addKeyListener(keyListener);
        canvas.addFocusListener(keyListener);
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

    /*getter keylistener*/
    public KeyboardListener getKeyListener(){
        return keyListener;
    }


    /*RENDER/
    /*RUNS EVERYTIME TO ACTUALLY SHOW STUFF*/
    public void render(){
        //get the buffer strategy from the canvas
        buffstrat = canvas.getBufferStrategy();
        
        //get the graphics from said buffer strategy because graphics is the one being rendered
        Graphics graphics = buffstrat.getDrawGraphics();
        
        //its like "renderer" is the one doing the drawing, so tells the renderer what to draw
        map.renderMap(renderer, 3, 3);
        for(GameObject obj: objects){
            obj.render(renderer, 3, 3);
        }

        //the renderer knows what to draw, not it only need somewhere to draw, the canvas (has been turned into a graphics)
        renderer.render(graphics);
        graphics.dispose();

        //show the graphics to the world through bufferstrategy, the graphics component has been drawn into
        buffstrat.show();
    }

    /*TO UPDATE WHAT'S GOING TO BE DRAWN*/
    public void update(){
        for(GameObject obj: objects){
            obj.update(this);
        }
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