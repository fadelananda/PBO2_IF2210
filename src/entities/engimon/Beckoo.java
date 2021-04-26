package entities.engimon;

import entities.Skill;
import enums.Elements;

import java.util.EnumSet;
import java.util.Random;

import GUI.Tiles;

public class Beckoo extends Engimon {
    public Beckoo(Tiles engiTiles) {
        Random rand = new Random();
        int rand1 = rand.nextInt(5);
        rand1 += 1;
        this.setLevel(rand1);
        this.setName("Wild Beckoo");
        this.addElement(Elements.ICE);
        this.addElement(Elements.WATER);
        this.addSkill(new Skill("Beku Dingin", 100, 1, EnumSet.of(Elements.ICE, Elements.WATER)));
        this.engiTiles = engiTiles;
        this.engiImg = engiTiles.getTileSprite("Beckoo");
        this.engiwidth = engiImg.getWidth();
        this.engiheight = engiImg.getHeight();
        this.engiEnv = 1;
        this.xpos = 600;
        this.ypos = 450;
    }

    public Beckoo(Tiles engiTiles, String name, int x, int y) {
        super(name, x, y);
        this.addElement(Elements.ICE);
        this.addElement(Elements.WATER);
        this.addSkill(new Skill("Beku Dingin", 100, 1, EnumSet.of(Elements.ICE, Elements.WATER)));
        this.engiTiles = engiTiles;
        this.engiImg = engiTiles.getTileSprite("Beckoo");
        this.engiwidth = engiImg.getWidth();
        this.engiheight = engiImg.getHeight();
        this.engiEnv = 1;
    }

    //for testing method
    public Beckoo(String name, int x, int y) {
        super(name, x, y);
        this.addElement(Elements.ICE);
        this.addElement(Elements.WATER);
        this.addSkill(new Skill("Beku Dingin", 100, 1, EnumSet.of(Elements.ICE, Elements.WATER)));
    }

    @Override
    public String interact() {
        return this.getName() + " : Beckooooo!!!";
    }

    @Override
    public String getSpeciesName() {
        return "Beckoo";
    }

    @Override
    public void showDescription() {
        System.out.println("Bisa membeku semua barang yang ada.");
    }
}
