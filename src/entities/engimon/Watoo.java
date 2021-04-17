package entities.engimon;

import entities.Skill;
import enums.Elements;

import java.util.EnumSet;

public class Watoo extends Engimon{
    public Watoo() {
        this.setName("Wild Watoo");
        this.addElement(Elements.GROUND);
        this.addSkill(new Skill("Lempar Batu", 100, 1, EnumSet.of(Elements.GROUND)));
    }

    public Watoo(String name, int x, int y) {
        super(name, x, y);
        this.addElement(Elements.GROUND);
        this.addSkill(new Skill("Lempar Batu", 100, 1, EnumSet.of(Elements.GROUND)));
    }

    @Override
    public void interact() {
        System.out.println(this.getName() + " : Watossssss!!!");
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
