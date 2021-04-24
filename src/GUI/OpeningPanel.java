package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.*;

public class OpeningPanel extends JPanel {
    private JLabel title;
    private JPanel buttonPanel;

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
        newGameBtn.setFont(new Font("Roboto", Font.BOLD, 30));
        loadGameBtn.setFont(new Font("Roboto", Font.BOLD, 30));
        newGameBtn.setBackground(Color.GRAY);
        loadGameBtn.setBackground(Color.GRAY);
        newGameBtn.setFocusable(false);
        loadGameBtn.setFocusable(false);
        newGameBtn.addActionListener(e -> {
            System.out.println("New Game");
        });
        loadGameBtn.addActionListener(e -> {
            System.out.println("Load Game");
        });

        buttonPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.setPreferredSize(new Dimension(100, 300));
        buttonPanel.setLayout(new GridLayout(2, 2, 10, 10));
        buttonPanel.setBorder(new EmptyBorder(50, 50, 50, 50));
        buttonPanel.add(newGameBtn);
        buttonPanel.add(loadGameBtn);

        return buttonPanel;
    }

    public OpeningPanel() {
        // Set Layout Opening Panel
        this.setLayout(new BorderLayout(0,0));
        this.setBounds(0,0, 1000, 800);
        this.setBackground(Color.LIGHT_GRAY);

        // Get title label and button panel
        title = this.getTitleLabel();
        buttonPanel = this.getButtonPanel();

        // Add label and buttons to panel
        this.add(title, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }
}
