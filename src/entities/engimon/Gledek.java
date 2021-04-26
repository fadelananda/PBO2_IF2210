package entities.engimon;

import GUI.Tiles;
import entities.Skill;
import enums.Elements;

import java.util.EnumSet;
import java.util.Random;

public class Gledek extends Engimon {
    public Gledek(Tiles engiTiles) {
        Random rand = new Random();
        int rand1 = rand.nextInt(5);
        rand1 += 1;
        this.setLevel(rand1);
        this.setName("Wild Gledek");
        this.addElement(Elements.ELECTRIC);
        this.addSkill(new Skill("Jedor", 100, 1, EnumSet.of(Elements.ELECTRIC)));
        this.engiTiles = engiTiles;
        this.engiImg = engiTiles.getTileSprite("Gledek");
        this.engiwidth = engiImg.getWidth();
        this.engiheight = engiImg.getHeight();
        this.engiEnv = 0;
        this.xpos = 300;
        this.ypos = 300;
    }

    public Gledek(Tiles engiTiles, String name, int x, int y) {
        super(name, x, y);
        this.addElement(Elements.ELECTRIC);
        this.addSkill(new Skill("Jedor", 100, 1, EnumSet.of(Elements.ELECTRIC)));
        this.engiTiles = engiTiles;
        this.engiImg = engiTiles.getTileSprite("Gledek");
        this.engiwidth = engiImg.getWidth();
        this.engiheight = engiImg.getHeight();
        this.engiEnv = 0;
        this.xpos = x;
        this.ypos = y;
    }

    //for testing method
    public Gledek(String name, int x, int y) {
        super(name, x, y);
        this.addElement(Elements.ELECTRIC);
        this.addSkill(new Skill("Jedor", 100, 1, EnumSet.of(Elements.ELECTRIC)));
    }

    @Override
    public String interact() {
        return this.getName() + " : Jedorrrrr!!!!";
    }

    @Override
    public String getSpeciesName() {
        return "Gledek";
    }

    @Override
    public void showDescription() {
        System.out.println("Awas! Engimon ini bisa membunuh orang lewat setrumnya.");
    }
}
