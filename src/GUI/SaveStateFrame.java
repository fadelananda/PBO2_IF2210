package GUI;

import entities.Player;
import entities.ReadWriteGameState;
import entities.Skill;
import entities.SkillItem;
import entities.engimon.Geni;
import entities.engimon.Teles;
import enums.Elements;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.EnumSet;

import static GUI.Game.loadImage;

public class SaveStateFrame extends JFrame {
    private JLabel title;
    private JPanel buttonPanel;
    private JPanel fileInfoPanel;
    private JTextField fileName;
    private Player savedPlayer;

    public SaveStateFrame(Player p) {
        savedPlayer = p;
        ImageIcon img = new ImageIcon("assets/engimonIcon.png");
        this.setIconImage(img.getImage());
        this.setTitle("Save Game State");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(0,0));
        //this.setPreferredSize(new Dimension(1000,800));
        this.setBackground(Color.LIGHT_GRAY);

        title = getTitleLabel();
        buttonPanel = getStartButton();
        fileInfoPanel = getFileInfoPanel();

        this.add(title, BorderLayout.NORTH);
        this.add(buttonPanel, BorderLayout.SOUTH);
        this.add(fileInfoPanel, BorderLayout.CENTER);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    private JPanel getFileInfoPanel() {
        JPanel fileInfo = new JPanel();
        JPanel textFieldPanel = getTextFieldPanel();

        fileInfo.setLayout(new GridLayout(2,1,20,10));
        fileInfo.setBorder(new EmptyBorder(100, 50, 100, 50));

        fileInfo.add(textFieldPanel);

        return fileInfo;
    }

    private JPanel getStartButton() {
        JPanel buttonPanel = new JPanel();
        JButton startBtn = new JButton("Save File");

        startBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        startBtn.setFont(new Font("Roboto", Font.BOLD, 30));
        startBtn.setForeground(Color.WHITE);
        startBtn.setBackground(Color.GRAY);
        startBtn.setFocusable(false);

        startBtn.addActionListener(e -> {
            ReadWriteGameState rw = new ReadWriteGameState();
            if(rw.isSaveGameAlreadyExist(fileName.getText() + ".json")){
                String[] options = new String[] {"Overwrite", "Cancel"};
                int res = JOptionPane.showOptionDialog(null, "Save file dengan nama tersebut sudah ada, Overwrite?", "Error", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[1]);
                if(res == 0){
                    rw.writeGameState(savedPlayer, fileName.getText());
                    JOptionPane.showMessageDialog(null, "State Game berhasil dioverwrite", "Success", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            else {
                rw.writeGameState(savedPlayer, fileName.getText());
                JOptionPane.showMessageDialog(null, "State Game berhasil disimpan dengan nama: " + fileName.getText(), "Success", JOptionPane.INFORMATION_MESSAGE);
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
        JLabel label = new JLabel("SAVE GAME STATE", SwingConstants.CENTER);
        label.setSize(10,10);
        label.setFont(new Font("Segoe UI", Font.BOLD, 50));

        return label;
    }

    private JPanel getTextFieldPanel() {
        this.fileName = new JTextField();
        this.fileName.setPreferredSize(new Dimension(240,30));

        JLabel playerLabel = new JLabel("Save File Name:");
        playerLabel.setFont(new Font("Roboto", Font.PLAIN, 20));

        JPanel textFieldPanel = new JPanel();
        textFieldPanel.add(playerLabel);
        textFieldPanel.add(this.fileName);

        return textFieldPanel;
    }

    public static void main(String[] args){
        Player tang = new Player();
        Teles engi1 = new Teles("pokemon1", 20,20);
        Geni engi2 = new Geni("pokemon2", 21,20);
        Teles engi3 = new Teles("pokemon3", 22,20);
        Geni engi4 = new Geni("pokemon4", 23,20);
        engi2.setLevel(5);
        engi3.setLevel(5);

        tang.addEngimon(engi1);
        tang.addEngimon(engi2);
        tang.addEngimon(engi4);
        tang.addEngimon(engi3);

        tang.setActiveEngimon();

        Skill sk1 = new Skill("lari",200,2, EnumSet.of(Elements.WATER));
        Skill sk2 = new Skill("mangan",300,2,EnumSet.of(Elements.WATER));
        Skill sk3 = new Skill("turu",200,2,EnumSet.of(Elements.WATER));
        Skill sk4 = new Skill("nglamun",400,2,EnumSet.of(Elements.ELECTRIC));

        SkillItem ski1 = new SkillItem(sk1);
        SkillItem ski2 = new SkillItem(sk2);
        SkillItem ski3 = new SkillItem(sk3);
        SkillItem ski4 = new SkillItem(sk4);

        tang.addSkillItem(ski1, 1);
        tang.addSkillItem(ski2,1);
        tang.addSkillItem(ski3,1);
        tang.addSkillItem(ski4,1);

        JFrame saveStateFrame = new SaveStateFrame(tang);
        saveStateFrame.setVisible(true);
    }
}
