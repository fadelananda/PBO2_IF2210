package entities.engimon;

import GUI.Tiles;
import entities.Skill;
import enums.Elements;

import java.util.EnumSet;

public class Teles extends Engimon {
    public Teles(Tiles engiTiles) {
        this.setName("Wild Teles");
        this.addElement(Elements.WATER);
        this.addSkill(new Skill("Jebyur", 100, 1, EnumSet.of(Elements.WATER)));
        this.engiTiles = engiTiles;
        this.engiImg = engiTiles.getTileSprite("Teles");
        this.engiwidth = engiImg.getWidth();
        this.engiheight = engiImg.getHeight();
        this.BORDER_LEFT = 540;
        this.xpos = 550;
        this.ypos = 200;
        this.engiEnv = 1;
    }

    public Teles(Tiles engiTiles, String name, int x, int y) { //no need to set boundary becoz tame engimon
        super(name, x, y);
        this.addElement(Elements.WATER);
        this.addSkill(new Skill("Jebyur", 100, 1, EnumSet.of(Elements.WATER)));
        this.engiTiles = engiTiles;
        this.engiImg = engiTiles.getTileSprite("Teles");
        this.engiwidth = engiImg.getWidth();
        this.engiheight = engiImg.getHeight();
        this.xpos = x;
        this.ypos = y;
        this.engiEnv = 1;
    }

    //for testing method
    public Teles(String name, int x, int y) {
        super(name, x, y);
        this.addElement(Elements.WATER);
        this.addSkill(new Skill("Jebyur", 100, 1, EnumSet.of(Elements.WATER)));
    }

    @Override
    public String interact() {
        return this.getName() + " : Tuelesssss!!!!";
    }

    @Override
    public String getSpeciesName() {
        return "Teles";
    }

    @Override
    public void showDescription() {
        System.out.println("Memiliki kebiasaan membasahi Trainer-nya.");
    }
}
