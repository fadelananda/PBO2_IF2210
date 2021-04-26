package entities;

import enums.Elements;

import javax.swing.*;
import java.awt.*;
import java.util.EnumSet;

public final class Skill {
    private String name;
    private int basePower;
    private int masteryLevel;
    private EnumSet<Elements> elements;

    public Skill(){}

    public Skill(String name, int basePower, int masteryLevel, EnumSet<Elements> elements) {
        this.name = name;
        this.basePower = basePower;
        this.masteryLevel = masteryLevel;
        this.elements = elements;
    }

    public String printElement(Elements element) {
        if (element == Elements.FIRE) return "Fire";
        if (element == Elements.WATER) return "Water";
        if (element == Elements.ELECTRIC) return "Electric";
        if (element == Elements.GROUND) return "Ground";
        if (element == Elements.ICE) return "Ice";

        return null;
    }

    public JPanel printAllElements() {
        JPanel elements = new JPanel();
        elements.setLayout(new FlowLayout());
        elements.add(new JLabel("Element: "));

        for (Elements element : this.getElements()) {
            JLabel elementName = new JLabel(this.printElement(element));
            elements.add(elementName);
        }

        return elements;
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
