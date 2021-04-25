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
    }

    public Teles(Tiles engiTiles, String name, int x, int y) {
        super(name, x, y);
        this.addElement(Elements.WATER);
        this.addSkill(new Skill("Jebyur", 100, 1, EnumSet.of(Elements.WATER)));
        this.engiTiles = engiTiles;
        this.engiImg = engiTiles.getTileSprite("Teles");
        this.engiwidth = engiImg.getWidth();
        this.engiheight = engiImg.getHeight();
        this.BORDER_LEFT = 540;
        this.xpos = x;
        this.ypos = y;
    }

    //for testing method
    public Teles(String name, int x, int y) {
        super(name, x, y);
        this.addElement(Elements.WATER);
        this.addSkill(new Skill("Jebyur", 100, 1, EnumSet.of(Elements.WATER)));
    }

    @Override
    public void interact() {
        System.out.println(this.getName() + " : Tuelesssss!!!!");
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
