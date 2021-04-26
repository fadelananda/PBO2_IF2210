package GUI;

import entities.Player;
import entities.SkillItem;
import entities.engimon.Engimon;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.List;

public class learnSkillFrame extends JFrame {
    public learnSkillFrame(Player player, SkillItem skillItem, JPanel panel) {
        JLabel label = new JLabel("Pilih Engimon", SwingConstants.CENTER);
        JButton learnBtn = new JButton("Learn");
        JComboBox comboBox = new JComboBox();
        label.setFont(new Font("Roboto", Font.BOLD, 15));
        ImageIcon img = new ImageIcon("assets/engimonIcon.png");
        this.setIconImage(img.getImage());
        this.setTitle("Learn Skill");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(100,200));

        for (Engimon engimon : player.getEngiBag().getEngimonList()) {
            comboBox.addItem(engimon);
        }

        learnBtn.addActionListener(e -> {
            int index = comboBox.getSelectedIndex();
            player.getSkillItemBag().learnSkillItem(skillItem, player.getEngiBag().getEngimonList().get(index));
            panel.removeAll();

            // Update panel
            JPanel skillContainer = new JPanel();
            JLabel title = new JLabel("Skill Item Inventory");
            title.setFont(new Font("Segoe UI", Font.BOLD, 35));
            skillContainer.setLayout(new GridLayout(1,2,10,10));

            java.util.List<SkillItem> skillItems = player.getSkillItemBag().getSkillList();
            List<Integer> countItems = player.getSkillItemBag().getJumlahTiapItem();

            for (int i = 0; i < skillItems.size(); i++) {
                SkillItem skill = skillItems.get(i);
                SkillButton skillBtn = new SkillButton(skill, countItems.get(i));
                skillBtn.addActionListener(e1 -> {
                    JFrame skillFrame = new SkillItemInfo(player, skill, panel);
                    skillFrame.setVisible(true);
                });
                skillContainer.add(skillBtn);
            }

            panel.add(title);
            panel.add(skillContainer);
            this.dispose();
        });

        this.add(label, BorderLayout.NORTH);
        this.add(comboBox, BorderLayout.CENTER);
        this.add(learnBtn, BorderLayout.SOUTH);

        this.pack();
        this.setLocationRelativeTo(null);
    }
}
