package GUI;

import entities.Player;
import entities.SkillItem;
import entities.engimon.Engimon;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

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
        engimonContainer.setLayout(new GridLayout(1,2,10,10));

        for (Engimon engimon : player.getEngiBag().getEngimonList()) {
            engimonContainer.add(new EngimonButton(engimon));
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
        skillContainer.setLayout(new GridLayout(1,2,10,10));

        List<SkillItem> skillItems = player.getSkillItemBag().getSkillList();
        List<Integer> countItems = player.getSkillItemBag().getJumlahTiapItem();

        for (int i = 0; i < skillItems.size(); i++) {
            skillContainer.add(new SkillButton(skillItems.get(i), countItems.get(i)));
        }

        skillPanel.add(title);
        skillPanel.add(skillContainer);
        return skillPanel;
    }

}
