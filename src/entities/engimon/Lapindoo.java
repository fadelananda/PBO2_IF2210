package entities.engimon;

import GUI.Tiles;
import entities.Skill;
import enums.Elements;

import java.util.EnumSet;
import java.util.Random;

public class Lapindoo extends Engimon{
    public Lapindoo(Tiles engiTiles) {
        Random rand = new Random();
        int rand1 = rand.nextInt(5);
        rand1 += 1;
        this.setLevel(rand1);
        this.setName("Wild Lapindoo");
        this.addElement(Elements.WATER);
        this.addElement(Elements.GROUND);
        this.addSkill(new Skill("Tanah Tenggelam", 100, 1, EnumSet.of(Elements.WATER, Elements.GROUND)));
        this.engiTiles = engiTiles;
        this.engiImg = engiTiles.getTileSprite("Lapindoo");
        this.engiwidth = engiImg.getWidth();
        this.engiheight = engiImg.getHeight();
        this.engiEnv = 0;
        this.xpos = 300;
        this.ypos = 300;
    }

    public Lapindoo(Tiles engiTiles, String name, int x, int y) {
        super(name, x, y);
        this.addElement(Elements.WATER);
        this.addElement(Elements.GROUND);
        this.addSkill(new Skill("Tanah Tenggelam", 100, 1, EnumSet.of(Elements.WATER, Elements.GROUND)));
        this.engiTiles = engiTiles;
        this.engiImg = engiTiles.getTileSprite("Lapindoo");
        this.engiwidth = engiImg.getWidth();
        this.engiheight = engiImg.getHeight();
        this.engiEnv = 0;
        this.xpos = x;
        this.ypos = y;
    }

    //for testing method
    public Lapindoo(String name, int x, int y) {
        super(name, x, y);
        this.addElement(Elements.WATER);
        this.addElement(Elements.GROUND);
        this.addSkill(new Skill("Tanah Tenggelam", 100, 1, EnumSet.of(Elements.WATER, Elements.GROUND)));
    }

    @Override
    public String interact() {
        return this.getName() + " : Glugluglug!!!!";
    }

    @Override
    public String getSpeciesName() {
        return "Lapindoo";
    }

    @Override
    public void showDescription() {
        System.out.println("Penyebab insiden Lumpur Lapindo.");
    }
}
