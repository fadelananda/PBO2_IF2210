package GUI;

import entities.Player;
import entities.SkillItem;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class SkillItemInfo extends JFrame {

    public SkillItemInfo(Player player, SkillItem skillItem, StatusPanel panel) {
        JButton learnBtn = new JButton("Learn");
        JButton deleteBtn = new JButton("Delete");
        JPanel infoPanel = new JPanel();
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 1, 0, 0));
        ImageIcon img = new ImageIcon("assets/engimonIcon.png");
        this.setIconImage(img.getImage());
        this.setTitle("Skill Item Info");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setPreferredSize(new Dimension(100,200));

        infoPanel.add(new JLabel(skillItem.toString()));
        infoPanel.add(new JLabel("Mastery Level: "+ Integer.toString(skillItem.getSkill().getBasePower())));
        infoPanel.add(skillItem.getSkill().printAllElements());
        learnBtn.addActionListener(e -> {
            JFrame learnFrame = new learnSkillFrame(player, skillItem, panel);
            learnFrame.setVisible(true);
        });
        deleteBtn.addActionListener(e -> {
            int idx = player.getSkillItemBag().getIdxByName(skillItem.getSkill().getName());
            player.getSkillItemBag().deleteItemByIdx(idx, 1);
            panel.updateSkillPanel();
            this.dispose();
        });

        buttonPanel.add(learnBtn);
        buttonPanel.add(deleteBtn);

        this.add(infoPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);

        this.pack();
        this.setLocationRelativeTo(null);
    }
}
