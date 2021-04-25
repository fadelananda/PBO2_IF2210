package GUI;

import javax.swing.*;
import java.awt.*;

public class StatusPanel extends JTabbedPane {
    JPanel playerStatus;
    JPanel engimonPanel;
    JPanel skillItemPanel;

    public StatusPanel() {
        this.setPreferredSize(new Dimension(400,750));
        this.setBackground(Color.BLUE);
        this.playerStatus = getPlayerStatus();
        this.engimonPanel = getEngimonPanel();
        this.skillItemPanel = getSkillItemPanel();

        this.add("Player Status", this.playerStatus);
        this.add("Engimons", this.engimonPanel);
        this.add("Skill Items", this.skillItemPanel);
    }

    private JPanel getPlayerStatus() {
        JPanel playerStatus = new JPanel();
        playerStatus.setBackground(Color.RED);

        return playerStatus;
    }

    private JPanel getEngimonPanel() {
        JPanel engimonPanel = new JPanel();
        engimonPanel.setBackground(Color.BLUE);

        return engimonPanel;
    }

    private JPanel getSkillItemPanel() {
        JPanel skillPanel = new JPanel();
        skillPanel.setBackground(Color.BLACK);

        return skillPanel;
    }

}
