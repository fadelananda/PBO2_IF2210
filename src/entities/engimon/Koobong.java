package entities.engimon;

import GUI.Tiles;
import entities.Skill;
import enums.Elements;

import java.util.EnumSet;

public class Koobong extends Engimon {
    public Koobong(Tiles engiTiles) {
        this.setName("Wild Koobong");
        this.addElement(Elements.FIRE);
        this.addElement(Elements.ELECTRIC);
        this.addSkill(new Skill("Setrum Kobongan", 100, 1, EnumSet.of(Elements.ELECTRIC, Elements.FIRE)));
        this.engiTiles = engiTiles;
        this.engiImg = engiTiles.getTileSprite("Koobong");
        this.engiwidth = engiImg.getWidth();
        this.engiheight = engiImg.getHeight();
    }

    public Koobong(Tiles engiTiles, String name, int x, int y) {
        super(name, x, y);
        this.addElement(Elements.FIRE);
        this.addElement(Elements.ELECTRIC);
        this.addSkill(new Skill("Setrum Kobongan", 100, 1, EnumSet.of(Elements.ELECTRIC, Elements.FIRE)));
        this.engiTiles = engiTiles;
        this.engiImg = engiTiles.getTileSprite("Koobong");
        this.engiwidth = engiImg.getWidth();
        this.engiheight = engiImg.getHeight();
    }

    //for testing method
    public Koobong(String name, int x, int y) {
        super(name, x, y);
        this.addElement(Elements.FIRE);
        this.addElement(Elements.ELECTRIC);
        this.addSkill(new Skill("Setrum Kobongan", 100, 1, EnumSet.of(Elements.ELECTRIC, Elements.FIRE)));
    }

    @Override
    public void interact() {
        System.out.println(this.getName() + " : Bongobongobong!!!");
    }

    @Override
    public String getSpeciesName() {
        return "Koobong";
    }

    @Override
    public void showDescription() {
        System.out.println("Awas! Kamu bisa mati kesetrum kalau enggak mati kebakar.");
    }
}
