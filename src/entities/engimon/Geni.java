package entities.engimon;

import entities.Skill;
import enums.Elements;

import java.util.EnumSet;
import java.util.Random;

import GUI.Tiles;

public class Geni extends Engimon {
    public Geni(Tiles engiTiles) {
        Random rand = new Random();
        int rand1 = rand.nextInt(5);
        rand1 += 1;
        this.setLevel(rand1);
        this.setName("Wild Geni");
        this.addElement(Elements.FIRE);
        this.addSkill(new Skill("Bakar Bakar", 100, 1, EnumSet.of(Elements.FIRE)));
        this.engiTiles = engiTiles;
        this.engiImg = engiTiles.getTileSprite("Geni");
        this.engiwidth = engiImg.getWidth();
        this.engiheight = engiImg.getHeight();
        this.engiEnv = 2;
        this.xpos = 10;
        this.ypos = 50;
    }

    public Geni(Tiles engiTiles, String name, int x, int y) {
        super(name, x, y);
        this.addElement(Elements.FIRE);
        this.addSkill(new Skill("Bakar Bakar", 100, 1, EnumSet.of(Elements.FIRE)));
        this.engiTiles = engiTiles;
        this.engiImg = engiTiles.getTileSprite("Geni");
        this.engiwidth = engiImg.getWidth();
        this.engiheight = engiImg.getHeight();
        this.engiEnv = 2;
    }

    //for testing method
    public Geni(String name, int x, int y) {
        super(name, x, y);
        this.addElement(Elements.FIRE);
        this.addSkill(new Skill("Bakar Bakar", 100, 1, EnumSet.of(Elements.FIRE)));
    }

    @Override
    public String interact() {
        return this.getName() + " : Geniiiii!!!";
    }

    @Override
    public String getSpeciesName() {
        return "Geni";
    }

    @Override
    public void showDescription() {
        System.out.println("Bisa membakar semua barang di dunia ini.");
    }
}
