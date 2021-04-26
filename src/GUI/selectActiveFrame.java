package GUI;

import entities.Player;
import entities.engimon.Engimon;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

public class selectActiveFrame extends JDialog {
    private JLabel title;
    private JPanel engimonChoice;
    private JPanel buttonPanel;
    private Player player;
    private ArrayList<GameObject> objc;

    public selectActiveFrame(Player player, ArrayList<GameObject> objc) {
        ImageIcon img = new ImageIcon("assets/engimonIcon.png");
        this.setIconImage(img.getImage());
        this.setTitle("Select Engimon");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout(0,0));
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.LIGHT_GRAY);

        this.title = getTitleLabel();
        this.player = player;
        this.objc = objc;
        this.buttonPanel = getSelectButton();
        this.engimonChoice = getEngimonChoice();

        this.add(this.title, BorderLayout.NORTH);
        this.add(this.engimonChoice, BorderLayout.CENTER);
        this.add(this.buttonPanel, BorderLayout.SOUTH);

        this.pack();
        this.setLocationRelativeTo(null);
    }

    private JLabel getTitleLabel() {
        JLabel label = new JLabel("SELECT ENGIMON", SwingConstants.CENTER);
        label.setSize(10,10);
        label.setFont(new Font("Segoe UI", Font.BOLD, 50));

        return label;
    }

    private JPanel getEngimonChoice() {
        JPanel radioPanel = new JPanel();
        ButtonGroup buttonGroup = new ButtonGroup();

        int count = 1;
        for (Engimon engimon : player.getEngiBag().getEngimonList()) {
            int temp = count;
            JRadioButton radioButton = new JRadioButton(engimon.toString());
            radioButton.setFont(new Font("Roboto", Font.PLAIN, 20));
            radioButton.setFocusable(false);
            radioButton.setHorizontalAlignment(SwingConstants.CENTER);
            radioButton.addActionListener(e -> player.setIdxCurrActiveEngimon(temp));
            buttonGroup.add(radioButton);
            radioPanel.add(radioButton);
            count++;
        }

        return radioPanel;
    }

    private JPanel getSelectButton() {
        JPanel buttonPanel = new JPanel();
        JButton selectBtn = new JButton("Select Engimon");

        selectBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        selectBtn.setFont(new Font("Roboto", Font.BOLD, 30));
        selectBtn.setForeground(Color.WHITE);
        selectBtn.setBackground(Color.GRAY);
        selectBtn.setFocusable(false);

        selectBtn.addActionListener(e -> {
            Engimon temp = player.getActiveEngimon();
            Engimon temp1 = (Engimon) objc.get(1);
            temp.setXpos(temp1.getXpos());
            temp.setYpos(temp1.getYpos());
            objc.set(1, temp);
            this.dispose();
        });

        buttonPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.setPreferredSize(new Dimension(100, 200));
        buttonPanel.setLayout(new BorderLayout(0,0));
        buttonPanel.add(selectBtn, BorderLayout.CENTER);
        buttonPanel.setBorder(new EmptyBorder(40, 50, 40, 50));

        return buttonPanel;
    }
}
