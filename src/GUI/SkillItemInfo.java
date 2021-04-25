package GUI;

import entities.SkillItem;

import javax.swing.*;
import java.awt.*;

public class SkillItemInfo extends JFrame {
    private SkillItem skillItem;
    public SkillItemInfo(SkillItem skillItem) {
        JButton learnBtn = new JButton("Learn");
        JPanel infoPanel = new JPanel();
        this.skillItem = skillItem;
        ImageIcon img = new ImageIcon("assets/engimonIcon.png");
        this.setIconImage(img.getImage());
        this.setTitle("Skill Item Info");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(100,150));

        infoPanel.add(new JLabel(skillItem.toString()));
        infoPanel.add(new JLabel("Mastery Level: "+ Integer.toString(skillItem.getSkill().getBasePower())));
        infoPanel.add(skillItem.getSkill().printAllElements());
        learnBtn.addActionListener(e -> JOptionPane.showMessageDialog(null, "Hi", "Learn", JOptionPane.PLAIN_MESSAGE));

        this.add(infoPanel, BorderLayout.CENTER);
        this.add(learnBtn, BorderLayout.SOUTH);

        this.pack();
        this.setLocationRelativeTo(null);
    }
}
