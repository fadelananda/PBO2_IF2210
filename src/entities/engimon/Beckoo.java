package entities.engimon;

import entities.Skill;
import enums.Elements;

import java.util.EnumSet;

import GUI.Tiles;

public class Beckoo extends Engimon {
    public Beckoo(Tiles engiTiles) {
        this.setName("Wild Beckoo");
        this.addElement(Elements.ICE);
        this.addElement(Elements.WATER);
        this.addSkill(new Skill("Beku Dingin", 100, 1, EnumSet.of(Elements.ICE, Elements.WATER)));
        this.engiTiles = engiTiles;
        this.engiImg = engiTiles.getTileSprite("Beckoo");
    }

    public Beckoo(Tiles engiTiles, String name, int x, int y) {
        super(name, x, y);
        this.addElement(Elements.ICE);
        this.addElement(Elements.WATER);
        this.addSkill(new Skill("Beku Dingin", 100, 1, EnumSet.of(Elements.ICE, Elements.WATER)));
        this.engiTiles = engiTiles;
        this.engiImg = engiTiles.getTileSprite("Beckoo");
    }

    @Override
    public void interact() {
        System.out.println(this.getName() + " : Beckooooo!!!");
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
