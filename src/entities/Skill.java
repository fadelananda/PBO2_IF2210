package entities;

import enums.Elements;
import java.util.EnumSet;

public final class Skill {
    private String name;
    private int basePower;
    private int masteryLevel;
    private EnumSet<Elements> elements;

    public Skill(String name, int basePower, int masteryLevel, EnumSet<Elements> elements) {
        this.name = name;
        this.basePower = basePower;
        this.masteryLevel = masteryLevel;
        this.elements = elements;
    }

    public void addElement(Elements element) {
        this.elements.add(element);
    }

    // Getter
    public String getName() {
        return this.name;
    }

    public int getBasePower() {
        return this.basePower;
    }

    public int getMasteryLevel() {
        return this.masteryLevel;
    }

    public EnumSet<Elements> getElements() {
        return this.elements;
    }

    // Setter
    public void upMasterLevel() {
        this.masteryLevel++;
    }

    public void setBasePower(int power) {
        this.basePower = power;
    }

    public void setMasteryLevel(int level) {
        this.masteryLevel = level;
    }
}
