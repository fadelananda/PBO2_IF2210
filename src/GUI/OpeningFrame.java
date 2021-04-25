package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.*;
import javax.swing.border.*;

public class OpeningFrame extends JFrame {
    private JLabel title;
    private JPanel buttonPanel;

    public OpeningFrame() {
        // Set Layout Opening Panel
        ImageIcon img = new ImageIcon("assets/engimonIcon.png");
        this.setIconImage(img.getImage());
        this.setTitle("Engimon Mboh Wes");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(0,0));
        this.setPreferredSize(new Dimension(1000,800));
        this.setBackground(Color.LIGHT_GRAY);

        // Get title label and button panel
        title = this.getTitleLabel();
        buttonPanel = this.getButtonPanel();

        // Add label and buttons to panel
        this.add(title, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private JLabel getTitleLabel() {
        JLabel label = new JLabel("ENGIMON", SwingConstants.CENTER);
        label.setSize(10,10);
        label.setFont(new Font("Segoe UI", Font.BOLD, 50));

        return label;
    }

    private JPanel getButtonPanel() {
        JPanel buttonPanel = new JPanel();
        JButton newGameBtn = new JButton("New Game");
        JButton loadGameBtn = new JButton("Load Game");

        newGameBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        loadGameBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        newGameBtn.setFont(new Font("Papyrus", Font.BOLD, 50));
        loadGameBtn.setFont(new Font("Papyrus", Font.BOLD, 50));
        newGameBtn.setBackground(Color.GRAY);
        loadGameBtn.setBackground(Color.GRAY);
        newGameBtn.setFocusable(false);
        loadGameBtn.setFocusable(false);

        newGameBtn.addActionListener(e -> {
            this.dispose();
            JFrame newGame = new NewGameFrame();
            newGame.setVisible(true);
        });

        loadGameBtn.addActionListener(e -> {
            this.dispose();
        });

        buttonPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.setPreferredSize(new Dimension(100, 300));
        buttonPanel.setLayout(new GridLayout(2, 1, 10, 10));
        buttonPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
        buttonPanel.add(newGameBtn);
        buttonPanel.add(loadGameBtn);

        return buttonPanel;
    }
}
