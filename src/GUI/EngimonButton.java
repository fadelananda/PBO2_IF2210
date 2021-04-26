package GUI;

import entities.engimon.Engimon;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class EngimonButton extends JButton {
    public EngimonButton(Engimon engimon) {
        JLabel engimonName = new JLabel(engimon.getName(), SwingConstants.CENTER);
        JLabel engimonInfo = new JLabel(engimon.getSpeciesName() + " Lvl. " + engimon.getLevel(), SwingConstants.CENTER);
        this.setLayout(new BorderLayout());
        engimonInfo.setBorder(new EmptyBorder(0,0,20,0));
        this.setPreferredSize(new Dimension(200,100));
        this.setBackground(Color.LIGHT_GRAY);
        this.setBorder(BorderFactory.createRaisedBevelBorder());
        this.setFocusable(false);

        engimonName.setFont(new Font("Roboto", Font.BOLD, 15));
        engimonInfo.setFont(new Font("Roboto", Font.BOLD, 15));
        this.add(engimonName, BorderLayout.CENTER);
        this.add(engimonInfo, BorderLayout.SOUTH);
    }
}
