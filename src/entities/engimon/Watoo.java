package entities.engimon;

import GUI.Tiles;
import entities.Skill;
import enums.Elements;

import java.util.EnumSet;

public class Watoo extends Engimon{
    public Watoo(Tiles engiTiles) {
        this.setName("Wild Watoo");
        this.addElement(Elements.GROUND);
        this.addSkill(new Skill("Lempar Batu", 100, 1, EnumSet.of(Elements.GROUND)));
        this.engiTiles = engiTiles;
        this.engiImg = engiTiles.getTileSprite("Watoo");
        this.engiEnv = 0;
        this.xpos = 300;
        this.ypos = 300;
    }

    public Watoo(Tiles engiTiles, String name, int x, int y) {
        super(name, x, y);
        this.addElement(Elements.GROUND);
        this.addSkill(new Skill("Lempar Batu", 100, 1, EnumSet.of(Elements.GROUND)));
        this.engiTiles = engiTiles;
        this.engiImg = engiTiles.getTileSprite("Watoo");
        this.engiEnv = 0;
    }

    //for testing method
    public Watoo(String name, int x, int y) {
        super(name, x, y);
        this.addElement(Elements.GROUND);
        this.addSkill(new Skill("Lempar Batu", 100, 1, EnumSet.of(Elements.GROUND)));
    }

    @Override
    public String interact() {
        return this.getName() + " : Watossssss!!!";
    }

    @Override
    public String getSpeciesName() {
        return "Watoo";
    }

    @Override
    public void showDescription() {
        System.out.println("Badan Engimon ini sangat keras.");
    }
}
