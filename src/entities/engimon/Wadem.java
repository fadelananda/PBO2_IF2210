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
        this.xpos = 50;
        this.ypos = 600;
        this.BORDER_UP = 430;
        this.BORDER_RIGHT = 300;
        this.engiEnv = 3;
        this.xpos = 20;
        this.ypos = 500;
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
        this.engiEnv = 3;
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
}
