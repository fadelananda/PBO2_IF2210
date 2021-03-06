package GUI;

import entities.Player;
import entities.ReadWriteGameState;
import entities.Skill;
import entities.SkillItem;
import entities.engimon.*;
import enums.Elements;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.Random;

public class Game extends JFrame implements Runnable{
    /*FIELDS*/
    private Canvas canvas = new Canvas();
    private BufferStrategy buffstrat;
    private RenderHandler renderer;
    private StatusPanel statusPanel;

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
    private int counter;

    /*METHODS*/
    public Game(String engichoice){
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

        counter = 370;
        

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

        //setup player Engimon
        if(engichoice.equals("Geni")){
            Geni choice1 = new Geni(engiAvas, "Gwenii", 400, 450);
            objects.add(choice1);
            playya.addEngimon(choice1);
        }
        if(engichoice.equals("Gledek")){
            Gledek choice2 = new Gledek(engiAvas, "Gluedekk", 400, 450);
            objects.add(choice2);
            playya.addEngimon(choice2);
        }
        if(engichoice.equals("Teles")){
            Teles choice3 = new Teles(engiAvas, "Twelesee", 400, 450);
            objects.add(choice3);
            playya.addEngimon(choice3);
        }
        playya.setIdxCurrActiveEngimon(1);

        //same thing but geni to spice things up a bit lol wkwkwkwk
        Lapindoo gengens = new Lapindoo(engiAvas);
        wildEngimons.add(gengens);
        Teles telessss = new Teles(engiAvas);
        wildEngimons.add(telessss);
        Wadem wademe = new Wadem(engiAvas);
        wildEngimons.add(wademe);
        Beckoo beckoo = new Beckoo(engiAvas);
        wildEngimons.add(beckoo);
        Geni genius = new Geni(engiAvas);
        wildEngimons.add(genius);
        Gledek gluedek = new Gledek(engiAvas);
        wildEngimons.add(gluedek);
        Koobong kobong = new Koobong(engiAvas);
        wildEngimons.add(kobong);
        Watoo watoe = new Watoo(engiAvas);
        wildEngimons.add(watoe);

        JMenuBar mb = new JMenuBar();
        JMenu menu = new JMenu("Save");
        menu.setFocusable(false);

        menu.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                ReadWriteGameState g = new ReadWriteGameState();
                g.writeGameState(playya, "save");
            }

            @Override
            public void menuDeselected(MenuEvent e) {}

            @Override
            public void menuCanceled(MenuEvent e) {}

        });

        mb.add(menu);
        setJMenuBar(mb);

        this.statusPanel = new StatusPanel(playya);
        add(this.statusPanel, BorderLayout.EAST);

        //Add listener
        canvas.addKeyListener(keyListener);
        canvas.addFocusListener(keyListener);
    }

    public Game(Player p){
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

        counter = 370;

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
        playya = p;
        objects.add(playya);

        //create an engimon, beckoo and add it to the list of objects
        Beckoo bebeckqo = new Beckoo(engiAvas, "wkwkwk", 200, 200);
        objects.add(bebeckqo);

        //same thing but geni to spice things up a bit lol wkwkwkwk
        Geni gengens = new Geni(engiAvas);
        wildEngimons.add(gengens);
        Teles telessss = new Teles(engiAvas);
        wildEngimons.add(telessss);
        // objects.add(telessss);
        Wadem wademe = new Wadem(engiAvas);
        // objects.add(wademe);
        wildEngimons.add(wademe);

        //Add listener
        canvas.addKeyListener(keyListener);
        canvas.addFocusListener(keyListener);

        // Coba coba status panel
        bebeckqo.addSkill(new Skill("Bakar Bakar", 100, 1, EnumSet.of(Elements.WATER)));
        bebeckqo.addSkill(new Skill("Test1", 100, 1, EnumSet.of(Elements.WATER)));
        bebeckqo.setLevel(31);
        wademe.setLevel(31);
        playya.addEngimon(bebeckqo);
        playya.addEngimon(wademe);
        playya.addSkillItem(new SkillItem(new Skill("Bakar Bakar", 100, 1, EnumSet.of(Elements.FIRE))), 5);
        playya.addSkillItem(new SkillItem(new Skill("Halo", 100, 1, EnumSet.of(Elements.WATER))), 1);
        this.statusPanel = new StatusPanel(playya);
        add(this.statusPanel, BorderLayout.EAST);
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

    public ArrayList<GameObject> getObjects(){
        return objects;
    }


    /*RENDER/
    /*RUNS EVERYTIME TO ACTUALLY SHOW STUFF*/
    public void render(){
        //get the buffer strategy from the canvas
        buffstrat = canvas.getBufferStrategy();
        
        //get the graphics from said buffer strategy because graphics is the one being rendered
        Graphics graphics = buffstrat.getDrawGraphics();
        
        //its like "renderer" is the one doing the drawing, so tells the renderer what to draw
        //render map
        map.renderMap(renderer, 3, 3);

        //render wild engimons
        for(Engimon e: wildEngimons){
            e.render(renderer, 3, 3);
        }

        //render player
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
        Random rand = new Random();
        int random = rand.nextInt(8);
        counter--;
        if(counter==0){
            if(wildEngimons.size() < 15){ //limit wild engimon aktif
                if(random == 1)
                    wildEngimons.add(new Beckoo(engiAvas));
                if(random == 2)
                    wildEngimons.add(new Wadem(engiAvas));
                if(random == 3)
                    wildEngimons.add(new Geni(engiAvas));
                if(random == 4)
                    wildEngimons.add(new Teles(engiAvas));
                if(random == 5)
                    wildEngimons.add(new Gledek(engiAvas));
                if(random == 6)
                    wildEngimons.add(new Watoo(engiAvas));
                if(random == 7)
                    wildEngimons.add(new Koobong(engiAvas));
                if(random == 0)
                    wildEngimons.add(new Lapindoo(engiAvas));
            }
            counter = 370;
        }

        //variabels lol
        int todelete = -1;

        //update player and pet engimon
        for(GameObject obj: objects){
            obj.update(this);
        }

        if(checkCollision(playya, (Engimon) objects.get(1))){
            JOptionPane.showMessageDialog(null,
                    ((Engimon) objects.get(1)).interact(), "Battle Report", JOptionPane.PLAIN_MESSAGE);
            Engimon e = (Engimon) objects.get(1);
            e.setXpos(playya.getXpos()+50);
            e.setYpos(playya.getYpos()+50);
        }

        //update wild engimons
        for(Engimon e: wildEngimons){
            e.update(this);
            if(checkCollision(playya, e)){
                todelete = wildEngimons.indexOf(e);
            }
        }

        //delete if necesasraraeyu
        if(todelete != -1) {
            playya.battlePrepare(this.statusPanel, wildEngimons.get(todelete));
            wildEngimons.remove(todelete);
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
}