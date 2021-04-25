package entities.engimon;

import entities.Skill;
import enums.Elements;

import java.util.EnumSet;

import GUI.Tiles;

public class Geni extends Engimon {
    public Geni(Tiles engiTiles) {
        this.setName("Wild Geni");
        this.addElement(Elements.FIRE);
        this.addSkill(new Skill("Bakar Bakar", 100, 1, EnumSet.of(Elements.FIRE)));
        this.engiTiles = engiTiles;
        this.engiImg = engiTiles.getTileSprite("Geni");
        this.engiwidth = engiImg.getWidth();
        this.engiheight = engiImg.getHeight();
    }

    public Geni(Tiles engiTiles, String name, int x, int y) {
        super(name, x, y);
        this.addElement(Elements.FIRE);
        this.addSkill(new Skill("Bakar Bakar", 100, 1, EnumSet.of(Elements.FIRE)));
        this.engiTiles = engiTiles;
        this.engiImg = engiTiles.getTileSprite("Geni");
        this.engiwidth = engiImg.getWidth();
        this.engiheight = engiImg.getHeight();
    }

    //for testing method
    public Geni(String name, int x, int y) {
        super(name, x, y);
        this.addElement(Elements.FIRE);
        this.addSkill(new Skill("Bakar Bakar", 100, 1, EnumSet.of(Elements.FIRE)));
    }

    @Override
    public void interact() {
        System.out.println(this.getName() + " : Geniiiii!!!");
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
