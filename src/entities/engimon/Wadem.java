package entities.engimon;

import GUI.Game;
import GUI.KeyboardListener;
import GUI.Tiles;
import entities.Skill;
import enums.Elements;

import java.util.EnumSet;
import java.util.Random;

public class Wadem extends Engimon{
    public Wadem(Tiles engiTiles) {
        this.setName("Wild Wadem");
        this.addElement(Elements.ICE);
        this.addSkill(new Skill("Es Puter", 100, 1, EnumSet.of(Elements.ICE)));
        this.engiTiles = engiTiles;
        this.engiImg = engiTiles.getTileSprite("Wadem");
        this.BORDER_UP = 430;
        this.BORDER_RIGHT = 300;
    }

    public Wadem(Tiles engiTiles, String name, int x, int y) {
        super(name, x, y);
        this.addElement(Elements.ICE);
        this.addSkill(new Skill("Es Puter", 100, 1, EnumSet.of(Elements.ICE)));
        this.engiTiles = engiTiles;
        this.engiImg = engiTiles.getTileSprite("Wadem");
        this.xpos = x;
        this.ypos = y;
        this.BORDER_UP = 430;
        this.BORDER_RIGHT = 300;
    }

    //for testing method
    public Wadem(String name, int x, int y) {
        super(name, x, y);
        this.addElement(Elements.ICE);
        this.addSkill(new Skill("Es Puter", 100, 1, EnumSet.of(Elements.ICE)));
    }

    @Override
    public String interact() {
        return this.getName() + " : Wushhhhh!!!!";
    }

    @Override
    public String getSpeciesName() {
        return "Wadem";
    }

    @Override
    public void showDescription() {
        System.out.println("Engimon AC alami.");
    }

    // @Override
    // public void update(Game game){
    //     KeyboardListener keyListener = game.getKeyListener();
    //     if(isTame){
    //         if(keyListener.up() && (xpos <= ypos)){
    //             ypos -= speed;
    //         }
    //         if(keyListener.down() && (ypos <= BORDER_DOWN)){
    //             ypos += speed;
    //         }
    //         if(keyListener.left() && (xpos >= BORDER_LEFT)){
    //             xpos -= speed;
    //         }
    //         if(keyListener.right() && (xpos <= BORDER_RIGHT) && (ypos >= BORDER_UP)){
    //             xpos += speed;
    //         }
    //     }
    //     else{
    //         Random rand = new Random();
    //         if(nRandoms == 0){
    //             whereRandom = rand.nextInt(6);
    //             nRandoms = 25;
    //         }
    //         if(whereRandom == 0 && (ypos >= BORDER_UP)){
    //             ypos -= 1;
    //             nRandoms--;
    //         }
    //         else if(whereRandom == 1 && (ypos <= BORDER_DOWN)){
    //             ypos += 1;
    //             nRandoms--;
    //         }
    //         else if(whereRandom == 2 && (xpos >= BORDER_LEFT)){
    //             xpos -= 1;
    //             nRandoms--;
    //         }
    //         else if(whereRandom == 3 && (xpos <= BORDER_RIGHT)){
    //             xpos += 1;
    //             nRandoms--;
    //         }
    //         else if(whereRandom == 4 || whereRandom == 5){
    //             nRandoms--;
    //         }
    //         else{
    //             nRandoms--;
    //         }
    //     }
    // }
}
