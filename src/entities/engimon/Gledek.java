package entities.engimon;

import GUI.Tiles;
import entities.Skill;
import enums.Elements;

import java.util.EnumSet;

public class Gledek extends Engimon {
    public Gledek(Tiles engiTiles) {
        this.setName("Wild Gledek");
        this.addElement(Elements.ELECTRIC);
        this.addSkill(new Skill("Jedor", 100, 1, EnumSet.of(Elements.ELECTRIC)));
        this.engiTiles = engiTiles;
        this.engiImg = engiTiles.getTileSprite("Gledek");
    }

    public Gledek(Tiles engiTiles, String name, int x, int y) {
        super(name, x, y);
        this.addElement(Elements.ELECTRIC);
        this.addSkill(new Skill("Jedor", 100, 1, EnumSet.of(Elements.ELECTRIC)));
        this.engiTiles = engiTiles;
        this.engiImg = engiTiles.getTileSprite("Gledek");
    }

    //for testing method
    public Gledek(String name, int x, int y) {
        super(name, x, y);
        this.addElement(Elements.ELECTRIC);
        this.addSkill(new Skill("Jedor", 100, 1, EnumSet.of(Elements.ELECTRIC)));
    }

    @Override
    public void interact() {
        System.out.println(this.getName() + " : Jedorrrrr!!!!");
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
