package entities.engimon;

import GUI.Tiles;
import entities.Skill;
import enums.Elements;

import java.util.EnumSet;

public class Wadem extends Engimon{
    public Wadem(Tiles engiTiles) {
        this.setName("Wild Wadem");
        this.addElement(Elements.ICE);
        this.addSkill(new Skill("Es Puter", 100, 1, EnumSet.of(Elements.ICE)));
        this.engiTiles = engiTiles;
        this.engiImg = engiTiles.getTileSprite("Wadem");
    }

    public Wadem(Tiles engiTiles, String name, int x, int y) {
        super(name, x, y);
        this.addElement(Elements.ICE);
        this.addSkill(new Skill("Es Puter", 100, 1, EnumSet.of(Elements.ICE)));
        this.engiTiles = engiTiles;
        this.engiImg = engiTiles.getTileSprite("Wadem");
    }

    //for testing method
    public Wadem(String name, int x, int y) {
        super(name, x, y);
        this.addElement(Elements.ICE);
        this.addSkill(new Skill("Es Puter", 100, 1, EnumSet.of(Elements.ICE)));
    }

    @Override
    public void interact() {
        System.out.println(this.getName() + " : Wushhhhh!!!!");
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
