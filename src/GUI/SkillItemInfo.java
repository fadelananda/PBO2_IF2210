package GUI;

import entities.Player;
import entities.SkillItem;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

public class SkillItemInfo extends JFrame {

    public SkillItemInfo(Player player, SkillItem skillItem, StatusPanel panel) {
        JButton learnBtn = new JButton("Learn");
        JPanel infoPanel = new JPanel();
        ImageIcon img = new ImageIcon("assets/engimonIcon.png");
        this.setIconImage(img.getImage());
        this.setTitle("Skill Item Info");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(100,150));

        infoPanel.add(new JLabel(skillItem.toString()));
        infoPanel.add(new JLabel("Mastery Level: "+ Integer.toString(skillItem.getSkill().getBasePower())));
        infoPanel.add(skillItem.getSkill().printAllElements());
        learnBtn.addActionListener(e -> {
            JFrame learnFrame = new learnSkillFrame(player, skillItem, panel);
            learnFrame.setVisible(true);
        });

        this.add(infoPanel, BorderLayout.CENTER);
        this.add(learnBtn, BorderLayout.SOUTH);

        this.pack();
        this.setLocationRelativeTo(null);
    }
}
