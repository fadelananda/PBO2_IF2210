package GUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

public class NewGameFrame extends JFrame {
    private JLabel title;
    private JPanel buttonPanel;
    private JPanel playerInfoPanel;
    private JTextField playerName;
    private String engimonChoice;

    public NewGameFrame() {
        ImageIcon img = new ImageIcon("assets/engimonIcon.png");
        this.setIconImage(img.getImage());
        this.setTitle("Create New Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(0,0));
        this.setPreferredSize(new Dimension(1000,800));
        this.setBackground(Color.LIGHT_GRAY);

        title = getTitleLabel();
        buttonPanel = getStartButton();
        playerInfoPanel = getPlayerInfoPanel();

        this.add(title, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(playerInfoPanel, BorderLayout.CENTER);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    private JPanel getPlayerInfoPanel() {
        JPanel playerInfo = new JPanel();
        JPanel textFieldPanel = getTextFieldPanel();
        JPanel engimonChoicePanel = getEngimonChoicePanel();

        playerInfo.setLayout(new GridLayout(2,1,20,10));
        playerInfo.setBorder(new EmptyBorder(100, 50, 100, 50));
        playerInfo.setPreferredSize(new Dimension(500,500));
        playerInfo.add(textFieldPanel);
        playerInfo.add(engimonChoicePanel);

        return playerInfo;
    }

    private JPanel getStartButton() {
        JPanel buttonPanel = new JPanel();
        JButton startBtn = new JButton("Start Game");

        startBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        startBtn.setFont(new Font("Roboto", Font.BOLD, 30));
        startBtn.setForeground(Color.WHITE);
        startBtn.setBackground(Color.GRAY);
        startBtn.setFocusable(false);

        startBtn.addActionListener(e -> {
            if (!this.playerName.getText().equals("") && this.engimonChoice != null) {
                this.dispose();
                GUI.Game game = new Game();
                Thread gameThread = new Thread(game);
                gameThread.start();
            } else {
                JOptionPane.showMessageDialog(null, "Belum Selesai Setup Player!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        buttonPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.setPreferredSize(new Dimension(100, 200));
        buttonPanel.setLayout(new BorderLayout(0,0));
        buttonPanel.add(startBtn, BorderLayout.CENTER);
        buttonPanel.setBorder(new EmptyBorder(40, 50, 40, 50));

        return buttonPanel;
    }

    private JLabel getTitleLabel() {
        JLabel label = new JLabel("CREATE PLAYER", SwingConstants.CENTER);
        label.setSize(10,10);
        label.setFont(new Font("Segoe UI", Font.BOLD, 50));

        return label;
    }

    private JPanel getTextFieldPanel() {
        this.playerName = new JTextField();
        this.playerName.setPreferredSize(new Dimension(240,30));

        JLabel playerLabel = new JLabel("Player Name:");
        playerLabel.setFont(new Font("Roboto", Font.PLAIN, 20));

        JPanel textFieldPanel = new JPanel();
        textFieldPanel.add(playerLabel);
        textFieldPanel.add(this.playerName);

        return textFieldPanel;
    }

    private JPanel getEngimonChoicePanel() {
        JPanel radioPanel = new JPanel();
        ButtonGroup buttonGroup = new ButtonGroup();
        String[] choices = {"Geni", "Gledek", "Teles"};
        radioPanel.setPreferredSize(new Dimension(0,30));
        radioPanel.setLayout(new GridLayout(3,1,10,10));

        for (String choice : choices) {
            JRadioButton radioButton = new JRadioButton(choice);
            radioButton.setFont(new Font("Roboto", Font.PLAIN, 20));
            radioButton.setFocusable(false);
            radioButton.setHorizontalAlignment(SwingConstants.CENTER);
            radioButton.addActionListener(e -> this.engimonChoice = choice);
            buttonGroup.add(radioButton);
            radioPanel.add(radioButton);
        }

        TitledBorder title = BorderFactory.createTitledBorder("Pilih Starter Engimon");

        title.setBorder(new EmptyBorder(10,10,10,10));
        title.setTitleFont(new Font("Roboto", Font.BOLD, 30));
        title.setTitleJustification(TitledBorder.CENTER);

        radioPanel.setBorder(title);

        return radioPanel;
    }
}
