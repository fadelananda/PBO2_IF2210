package entities.engimon;

import entities.Skill;
import enums.Elements;

import java.util.EnumSet;

public class Gledek extends Engimon {
    public Gledek() {
        this.setName("Wild Gledek");
        this.addElement(Elements.ELECTRIC);
        this.addSkill(new Skill("Jedor", 100, 1, EnumSet.of(Elements.ELECTRIC)));
    }

    public Gledek(String name, int x, int y) {
        super(name, x, y);
        this.addElement(Elements.ELECTRIC);
        this.addSkill(new Skill("Jedor", 100, 1, EnumSet.of(Elements.ELECTRIC)));
    }

    @Override
    public void showAura() {
        System.out.println("Jedor!");
    }

    @Override
    public String getSpeciesName() {
        return "Gledek";
    }

    @Override
    public void showDescription() {
        System.out.println("Awas! Engimon ini bisa membunuh orang lewat setrumnya");
    }
}
