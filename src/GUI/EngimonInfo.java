package GUI;

import entities.engimon.Engimon;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

public class EngimonInfo extends JFrame {
    public EngimonInfo(Engimon engimon) {
        ImageIcon img = new ImageIcon("assets/engimonIcon.png");
        JPanel infoContainer = new JPanel();
        infoContainer.setLayout(new GridLayout(4,2,0,0));
        JLabel name = new JLabel("Nama: " + engimon.getName(), SwingConstants.CENTER);
        JLabel life = new JLabel("Life: " + Integer.toString(engimon.getLife()), SwingConstants.CENTER);
        JLabel level = new JLabel("Level: " + Integer.toString(engimon.getLevel()), SwingConstants.CENTER);
        JLabel exp = new JLabel("EXP: " + Integer.toString(engimon.getExp()), SwingConstants.CENTER);
        JPanel elements = engimon.printAllElements();
        JPanel skills = engimon.printAllSkills();
        JButton interactBtn = new JButton("Interact");

        interactBtn.addActionListener(e -> JOptionPane.showMessageDialog(null, engimon.interact(), "Interact", JOptionPane.PLAIN_MESSAGE));
        this.setIconImage(img.getImage());
        this.setTitle("Engimon Info");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(500,500));

        infoContainer.add(name);
        infoContainer.add(life);
        infoContainer.add(level);
        infoContainer.add(exp);
        infoContainer.add(elements);
        infoContainer.add(engimon.printParents());
        infoContainer.add(skills);

        JScrollPane scrollPane = new JScrollPane(infoContainer);

        this.add(scrollPane);
        this.add(interactBtn, BorderLayout.SOUTH);

        this.pack();
        this.setLocationRelativeTo(null);
    }
}
