package GUI;

import entities.Player;
import entities.Skill;
import entities.SkillItem;
import entities.engimon.Geni;
import enums.Elements;

import javax.swing.*;
import java.awt.*;
import java.util.EnumSet;

public class StatusPanel extends JTabbedPane {
    Player player;
    JPanel breedPanel;
    JPanel engimonPanel;
    JPanel skillItemPanel;

    public StatusPanel(Player player) {
        this.player = player;
        this.setPreferredSize(new Dimension(400,750));
        this.setFont(new Font("Roboto", Font.BOLD, 20));
        this.breedPanel = getBreedPanel();
        this.engimonPanel = getEngimonPanel();
        this.skillItemPanel = getSkillItemPanel();

        this.add("Engimons", this.engimonPanel);
        this.add("Skill Items", this.skillItemPanel);
        this.add("Breeding", this.breedPanel);
    }

    private JPanel getBreedPanel() {
        JPanel breedPanel = new JPanel();
        JLabel title = new JLabel("Breeding");
        title.setFont(new Font("Segoe UI", Font.BOLD, 35));

        breedPanel.add(title);
        return breedPanel;
    }

    private JPanel getEngimonPanel() {
        JPanel engimonPanel = new JPanel();
        JPanel engimonContainer = new JPanel();
        JLabel title = new JLabel("Engimon Inventory");
        title.setFont(new Font("Segoe UI", Font.BOLD, 35));
        engimonContainer.setLayout(new GridLayout(2,1,10,10));

        for (int i = 0; i < 3; i++) {
            engimonContainer.add(new EngimonButton(new Geni()));
        }

        engimonPanel.add(title);
        engimonPanel.add(engimonContainer);

        return engimonPanel;
    }

    private JPanel getSkillItemPanel() {
        JPanel skillPanel = new JPanel();
        JPanel skillContainer = new JPanel();
        JLabel title = new JLabel("Skill Item Inventory");
        title.setFont(new Font("Segoe UI", Font.BOLD, 35));
        skillContainer.setLayout(new GridLayout(2,1,10,10));

        for (int i = 0; i < 3; i++) {
            Skill skill = new Skill("Bakar Bakar", 100, 1, EnumSet.of(Elements.FIRE));
            skillContainer.add(new SkillButton(new SkillItem(skill)));
        }

        skillPanel.add(title);
        skillPanel.add(skillContainer);
        return skillPanel;
    }

}
