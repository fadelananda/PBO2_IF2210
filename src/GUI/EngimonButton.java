package GUI;

import entities.engimon.Engimon;

import javax.swing.*;
import java.awt.*;

public class EngimonButton extends JButton {
    public EngimonButton(Engimon engimon) {
        this.setPreferredSize(new Dimension(200,100));
        this.setBackground(Color.LIGHT_GRAY);
        this.setBorder(BorderFactory.createRaisedBevelBorder());
        this.setFont(new Font("Roboto", Font.BOLD, 15));
        this.setFocusable(false);
        this.setText(engimon.getName());
//        this.setIcon(icon);
    }
}
