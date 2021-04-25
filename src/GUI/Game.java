package GUI;

import entities.Player;
import entities.Skill;
import entities.SkillItem;
import entities.engimon.Beckoo;
import entities.engimon.Geni;
import enums.Elements;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;

// import java.awt.image.DataBufferInt;
// import java.awt.Color;
// import java.util.Scanner;

import GUI.Tiles.Tile;
import entities.Player;
import entities.engimon.Beckoo;
import entities.engimon.Engimon;
import entities.engimon.Geni;

public class Game extends JFrame implements Runnable{
    /*FIELDS*/
    private Canvas canvas = new Canvas();
    private BufferStrategy buffstrat;
    private RenderHandler renderer;

    //texture
    private BufferedImage mapImg;
    private SpriteSheet mapsprites;
    private Tiles tilesforMap;
    private Map map;

    //player avatar
    private BufferedImage avaImg;
    private SpriteSheet avasprites;
    private Player playya;

    //engimon avatar
    private BufferedImage engiImg;
    private SpriteSheet engisprites;
    private Tiles engiAvas;

    //objects
    private ArrayList<GameObject> objects;
    private ArrayList<Engimon> wildEngimons;
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

        // Coba coba status panel
        Player fabian = new Player();
        fabian.addEngimon(new Geni());
        fabian.addEngimon(new Beckoo());
        fabian.addSkillItem(new SkillItem(new Skill("Bakar Bakar", 100, 1, EnumSet.of(Elements.FIRE))), 5);
        fabian.addSkillItem(new SkillItem(new Skill("Halo", 100, 1, EnumSet.of(Elements.FIRE))), 10);
        System.out.println(fabian.countBag());
        add(new StatusPanel(fabian), BorderLayout.EAST);
        

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

        //load engimons
        engiImg = loadImage("assets/engimons.png");
        engisprites = new SpriteSheet(engiImg);
        engisprites.loadsprites(16, 16);
        engiAvas = new Tiles(new File("assets/Engimon.txt"), engisprites);

        //create an objects holder 4 the gaem
        objects = new ArrayList<>();
        wildEngimons = new ArrayList<>();

        //create a player and add it to the list of objects
        playya = new Player(avasprites, engiAvas);
        objects.add(playya);

        //create an engimon, beckoo and add it to the list of objects
        Beckoo bebeckqo = new Beckoo(engiAvas, "wkwkwk", 200, 200);
        objects.add(bebeckqo);

        //same thing but geni to spice things up a bit lol wkwkwkwk
        Geni gengens = new Geni(engiAvas);
        objects.add(gengens); //tetep add ke objects biar tetep keliatan
        wildEngimons.add(gengens);

        //Add listener
        canvas.addKeyListener(keyListener);
        canvas.addFocusListener(keyListener);
    }

    /*LOAD IMAGE AS A BUFFERED IMAGE*/
    public static BufferedImage loadImage(String path){
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

        //checkcollision
        for(Engimon e: wildEngimons){
            if(checkCollision(playya, e)){
                System.out.println("tabrakan di : "+e.getXpos());
            }
        }
    }

    private boolean checkCollision(Player p, Engimon e){
        if(p.getXpos() < e.getXpos() + e.getEngiWidth() &&
        p.getXpos() + p.getPlayerWidth() > e.getXpos() &&
        p.getYpos() < e.getYpos() + e.getEngiHeight() &&
        p.getYpos() + p.getPlayerHeight() > e.getYpos()) return true;
        else return false;
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