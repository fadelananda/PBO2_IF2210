package entities.engimon;

import entities.Skill;
import enums.Elements;

import java.util.EnumSet;

public class Teles extends Engimon {
    public Teles() {
        this.setName("Wild Teles");
        this.addElement(Elements.WATER);
        this.addSkill(new Skill("Jebyur", 100, 1, EnumSet.of(Elements.WATER)));
    }

    public Teles(String name, int x, int y) {
        super(name, x, y);
        this.addElement(Elements.WATER);
        this.addSkill(new Skill("Jebyur", 100, 1, EnumSet.of(Elements.WATER)));
    }

    @Override
    public void showAura() {
        System.out.println("Lingkungan sekitar jadi basah");
    }

    @Override
    public String getSpeciesName() {
        return "Teles";
    }

    @Override
    public void showDescription() {
        System.out.println("Memiliki kebiasaan membasahi Trainer-nya");
    }
}
