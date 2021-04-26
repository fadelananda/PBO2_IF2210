package GUI;

import entities.SkillItem;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class SkillButton extends JButton {
    public SkillButton(SkillItem skillItem, int n) {
        JLabel skillName = new JLabel(skillItem.getSkill().getName(), SwingConstants.CENTER);
        JLabel amount = new JLabel("Jumlah: " + Integer.toString(n), SwingConstants.CENTER);
        amount.setBorder(new EmptyBorder(0,0,20,0));
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(200,100));
        this.setBackground(Color.LIGHT_GRAY);
        this.setBorder(BorderFactory.createRaisedBevelBorder());
        this.setFocusable(false);

        skillName.setFont(new Font("Roboto", Font.BOLD, 15));
        amount.setFont(new Font("Roboto", Font.BOLD, 15));
        this.add(skillName, BorderLayout.CENTER);
        this.add(amount, BorderLayout.SOUTH);
    }
}