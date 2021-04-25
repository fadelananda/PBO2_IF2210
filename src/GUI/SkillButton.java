package GUI;

import entities.SkillItem;

import javax.swing.*;
import java.awt.*;

public class SkillButton extends JButton {
    public SkillButton(SkillItem skillItem) {
        this.setPreferredSize(new Dimension(200,100));
        this.setBackground(Color.LIGHT_GRAY);
        this.setBorder(BorderFactory.createRaisedBevelBorder());
        this.setFont(new Font("Roboto", Font.BOLD, 15));
        this.setFocusable(false);
        this.setText(skillItem.getSkill().getName());
//        this.setIcon(icon);
    }
}