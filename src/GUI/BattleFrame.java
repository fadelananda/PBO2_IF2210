package GUI;

import entities.Player;
import entities.engimon.Engimon;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class BattleFrame extends JFrame {
    private JLabel title;
    private JPanel vsPanel;
    private JPanel buttonPanel;
    private Player player;
    private Engimon opponent;
    private Engimon activeEngimon;

    public BattleFrame(Player player, Engimon Opponent, Engimon ActiveEngimon) {
        // Set Layout Opening Panel
        ImageIcon img = new ImageIcon("assets/engimonIcon.png");
        this.setIconImage(img.getImage());
        this.setTitle("Battle");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(0,0));
        this.setPreferredSize(new Dimension(500,500));
        this.setBackground(Color.LIGHT_GRAY);

        // Get title label and button panel
        this.opponent = Opponent;
        this.activeEngimon = ActiveEngimon;
        this.player = player;
        title = this.getTitleLabel();
        vsPanel = this.powerLevelPanel();
        buttonPanel = this.getButtonPanel();

        // Add label and buttons to panel
        this.add(title, BorderLayout.NORTH);
        this.add(vsPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private JPanel powerLevelPanel() {
        JPanel powerLevel = new JPanel(new BorderLayout());

        // Hitung power
        int playerLevel = this.activeEngimon.getLevel();
        int oppLevel = this.opponent.getLevel();
        float playerElmtAdvantage = player.getAdvantage(activeEngimon.getElements(), opponent.getElements());
        float oppElmtAdvantage = player.getAdvantage(opponent.getElements(), activeEngimon.getElements());
        //sum every skill base power * mastery_level
        float playerSkillPoint = player.calSkillPoint(activeEngimon);
        float oppSkillPoint = player.calSkillPoint(opponent);

        float playerPower = playerLevel*playerElmtAdvantage + playerSkillPoint;
        float oppPower = oppLevel*oppElmtAdvantage + oppSkillPoint;

        JLabel oppLabel = new JLabel(opponent.getName() + " : " + Float.toString(oppPower) + " (OPPONENT)", SwingConstants.CENTER);
        JLabel vs = new JLabel("VS", SwingConstants.CENTER);
        JLabel playerLabel = new JLabel(activeEngimon.getName() + " : " + Float.toString(playerPower) + " (PLAYER)", SwingConstants.CENTER);

        oppLabel.setFont(new Font("Papyrus", Font.BOLD, 20));
        vs.setFont(new Font("Papyrus", Font.BOLD, 20));
        playerLabel.setFont(new Font("Papyrus", Font.BOLD, 20));

        powerLevel.setBorder(new EmptyBorder(10,20,10,20));
        powerLevel.add(oppLabel, BorderLayout.NORTH);
        powerLevel.add(vs, BorderLayout.CENTER);
        powerLevel.add(playerLabel, BorderLayout.SOUTH);

        return powerLevel;
    }

    private JLabel getTitleLabel() {
        JLabel label = new JLabel("BATTLE", SwingConstants.CENTER);
        label.setSize(10,10);
        label.setFont(new Font("Segoe UI", Font.BOLD, 50));

        return label;
    }

    private JPanel getButtonPanel() {
        JPanel buttonPanel = new JPanel();
        JButton battleBtn = new JButton("Battle");
        JButton fleeBtn = new JButton("Flee");

        battleBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        fleeBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        battleBtn.setFont(new Font("Papyrus", Font.BOLD, 50));
        fleeBtn.setFont(new Font("Papyrus", Font.BOLD, 50));
        battleBtn.setBackground(Color.GRAY);
        fleeBtn.setBackground(Color.GRAY);
        battleBtn.setFocusable(false);
        fleeBtn.setFocusable(false);

//        battleBtn.addActionListener(e -> {
//
//        });
//
//        fleeBtn.addActionListener(e -> {
//
//        });

        buttonPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.setPreferredSize(new Dimension(100, 200));
        buttonPanel.setLayout(new GridLayout(2, 1, 10, 10));
        buttonPanel.setBorder(new EmptyBorder(20, 50, 20, 50));
        buttonPanel.add(battleBtn);
        buttonPanel.add(fleeBtn);

        return buttonPanel;
    }


}
