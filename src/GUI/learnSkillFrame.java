package GUI;

import entities.Player;
import entities.SkillItem;
import entities.engimon.Engimon;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

public class learnSkillFrame extends JFrame {
    public learnSkillFrame(Player player, SkillItem skillItem, StatusPanel panel) {
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
            panel.updateSkillPanel();
            panel.updateEngimonPanel();
            this.dispose();
        });

        this.add(label, BorderLayout.NORTH);
        this.add(comboBox, BorderLayout.CENTER);
        this.add(learnBtn, BorderLayout.SOUTH);

        this.pack();
        this.setLocationRelativeTo(null);
    }
}
