package entities.engimon;

import entities.Skill;
import enums.Elements;

import java.util.EnumSet;

public class Geni extends Engimon {
    public Geni() {
        this.setName("Wild Geni");
        this.addElement(Elements.FIRE);
        this.addSkill(new Skill("Bakar Bakar", 100, 1, EnumSet.of(Elements.FIRE)));
    }

    public Geni(String name, int x, int y) {
        super(name, x, y);
        this.addElement(Elements.FIRE);
        this.addSkill(new Skill("Bakar Bakar", 100, 1, EnumSet.of(Elements.FIRE)));
    }

    @Override
    public void showAura() {
        System.out.println("Lho celanaku kok kebakaran?");
    }

    @Override
    public String getSpeciesName() {
        return "Beckoo";
    }

    @Override
    public void showDescription() {
        System.out.println("Bisa membakar semua barang di dunia ini");
    }
}
