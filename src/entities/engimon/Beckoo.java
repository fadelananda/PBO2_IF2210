package entities.engimon;

import entities.Skill;
import enums.Elements;

import java.util.EnumSet;

public class Beckoo extends Engimon {
    public Beckoo() {
        this.setName("Wild Beckoo");
        this.addElement(Elements.ICE);
        this.addElement(Elements.WATER);
        this.addSkill(new Skill("Beku Dingin", 100, 1, EnumSet.of(Elements.ICE, Elements.WATER)));
    }

    public Beckoo(String name, int x, int y) {
        super(name, x, y);
        this.addElement(Elements.ICE);
        this.addElement(Elements.WATER);
        this.addSkill(new Skill("Beku Dingin", 100, 1, EnumSet.of(Elements.ICE, Elements.WATER)));
    }

    @Override
    public void showAura() {
        System.out.println("Kok tiba-tiba semua barang membeku ya?");
    }

    @Override
    public String getSpeciesName() {
        return "Beckoo";
    }

    @Override
    public void showDescription() {
        System.out.println("Bisa membeku semua barang yang ada");
    }
}
