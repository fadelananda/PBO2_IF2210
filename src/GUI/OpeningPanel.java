package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class OpeningPanel extends JPanel {
    private JLabel title;
    private JPanel buttonPanel;

    private JLabel getTitleLabel() {
        JLabel label = new JLabel("ENGIMON", SwingConstants.CENTER);
        label.setSize(10,10);
        label.setFont(new Font("TimesNewRoman", Font.BOLD, 36));

        return label;
    }

    private JPanel getButtonPanel() {
        JPanel buttonPanel = new JPanel();
        JButton newGameBtn = new JButton("New Game");
        JButton loadGameBtn = new JButton("New Game");
        buttonPanel.setSize(100, 100);
        buttonPanel.add(newGameBtn);
        buttonPanel.add(loadGameBtn);

        return buttonPanel;
    }

    public OpeningPanel() {
        this.setLayout(new BorderLayout(20,20));
        this.setBounds(0,0, 1000, 800);
        this.setBackground(Color.LIGHT_GRAY);

        title = this.getTitleLabel();
        buttonPanel = this.getButtonPanel();

        this.add(title, SwingConstants.CENTER);
        this.add(buttonPanel, BorderLayout.PAGE_END);
    }
}
