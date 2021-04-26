package GUI;

import entities.Player;
import entities.SkillItem;
import entities.engimon.Engimon;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.List;

public class StatusPanel extends JTabbedPane {
    Player player;
    JPanel breedPanel;
    JPanel engimonPanel;
    JPanel skillItemPanel;

    public StatusPanel(Player player) {
        this.player = player;
        this.setPreferredSize(new Dimension(400,750));
        this.setFont(new Font("Roboto", Font.BOLD, 20));
        this.breedPanel = getBreedPanel();
        this.engimonPanel = getEngimonPanel();
        this.skillItemPanel = getSkillItemPanel();

        this.add("Engimons", this.engimonPanel);
        this.add("Skill Items", this.skillItemPanel);
        this.add("Breeding", this.breedPanel);
    }

    public void updateEngimonPanel() {
        this.engimonPanel.removeAll();

        JPanel engimonContainer = new JPanel();
        JLabel title = new JLabel("Engimon Inventory");
        title.setFont(new Font("Segoe UI", Font.BOLD, 35));
        engimonContainer.setPreferredSize(new Dimension(450,750));
        engimonContainer.setLayout(new FlowLayout());

        for (Engimon engimon : player.getEngiBag().getEngimonList()) {
            JButton engimonBtn = new EngimonButton(engimon);
            engimonBtn.addActionListener(e -> {
                JFrame engiFrame = new EngimonInfo(engimon);
                engiFrame.setVisible(true);
            });
            engimonContainer.add(engimonBtn);
        }

        this.engimonPanel.add(title);
        this.engimonPanel.add(engimonContainer);
    }

    public void updateSkillPanel(){
        this.skillItemPanel.removeAll();

        // Update panel
        JPanel skillContainer = new JPanel();
        JLabel title = new JLabel("Skill Item Inventory");
        title.setFont(new Font("Segoe UI", Font.BOLD, 35));
        skillContainer.setLayout(new GridLayout(1,2,10,10));

        java.util.List<SkillItem> skillItems = player.getSkillItemBag().getSkillList();
        List<Integer> countItems = player.getSkillItemBag().getJumlahTiapItem();

        for (int i = 0; i < skillItems.size(); i++) {
            SkillItem skill = skillItems.get(i);
            SkillButton skillBtn = new SkillButton(skill, countItems.get(i));
            skillBtn.addActionListener(e1 -> {
                JFrame skillFrame = new SkillItemInfo(player, skill, this);
                skillFrame.setVisible(true);
            });
            skillContainer.add(skillBtn);
        }

        this.skillItemPanel.add(title);
        this.skillItemPanel.add(skillContainer);
    }

    public void updateBreedPanel() {
        this.breedPanel.removeAll();

        // Update Panel
        JPanel choicePanel = new JPanel(new GridLayout(3,1,0,0));
        JTextField namaAnak = new JTextField();
        JComboBox dad = new JComboBox();
        JComboBox mom = new JComboBox();
        JLabel title = new JLabel("Breeding", SwingConstants.CENTER);
        JButton breedBtn = new JButton("Breed");
        title.setFont(new Font("Segoe UI", Font.BOLD, 35));
        breedPanel.setLayout(new BorderLayout());
        breedBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        breedBtn.setFont(new Font("Roboto", Font.BOLD, 30));
        breedBtn.setForeground(Color.WHITE);
        breedBtn.setBackground(Color.GRAY);
        breedBtn.setFocusable(false);
        TitledBorder dadBorder = BorderFactory.createTitledBorder("Dad");
        TitledBorder momBorder = BorderFactory.createTitledBorder("Mom");
        TitledBorder anakBorder = BorderFactory.createTitledBorder("Masukkan Nama Anak");
        dadBorder.setTitleFont(new Font("Roboto", Font.BOLD, 15));
        momBorder.setTitleFont(new Font("Roboto", Font.BOLD, 15));
        anakBorder.setTitleFont(new Font("Roboto", Font.BOLD, 15));
        dad.setBorder(dadBorder);
        mom.setBorder(momBorder);
        namaAnak.setBorder(anakBorder);

        breedBtn.addActionListener(e -> {
            int indexDad = dad.getSelectedIndex();
            int indexMom = mom.getSelectedIndex();
            Engimon dadEngi = player.getEngiBag().getEngimonList().get(indexDad);
            Engimon momEngi = player.getEngiBag().getEngimonList().get(indexMom);

            try {
                Engimon child = player.breed(dadEngi, momEngi, namaAnak.getText());
                this.player.addEngimon(child);
                this.updateEngimonPanel();
                this.updateBreedPanel();
                JOptionPane.showMessageDialog(null, "Breed!", "Breeding Success", JOptionPane.PLAIN_MESSAGE);
            } catch (Exception errorBreed) {
                JOptionPane.showMessageDialog(null, errorBreed.getMessage(), "Breeding Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        for (Engimon engimon : this.player.getEngiBag().getEngimonList()) {
            dad.addItem(engimon);
            mom.addItem(engimon);
        }

        choicePanel.add(namaAnak);
        choicePanel.add(dad);
        choicePanel.add(mom);

        this.breedPanel.add(title, BorderLayout.NORTH);
        this.breedPanel.add(choicePanel, BorderLayout.CENTER);
        this.breedPanel.add(breedBtn, BorderLayout.SOUTH);

    }

    private JPanel getBreedPanel() {
        JPanel breedPanel = new JPanel();
        JPanel choicePanel = new JPanel(new GridLayout(3,1,0,0));
        JTextField namaAnak = new JTextField();
        JComboBox dad = new JComboBox();
        JComboBox mom = new JComboBox();
        JLabel title = new JLabel("Breeding", SwingConstants.CENTER);
        JButton breedBtn = new JButton("Breed");
        title.setFont(new Font("Segoe UI", Font.BOLD, 35));
        breedPanel.setLayout(new BorderLayout());
        breedBtn.setBorder(BorderFactory.createRaisedBevelBorder());
        breedBtn.setFont(new Font("Roboto", Font.BOLD, 30));
        breedBtn.setForeground(Color.WHITE);
        breedBtn.setBackground(Color.GRAY);
        breedBtn.setFocusable(false);
        TitledBorder dadBorder = BorderFactory.createTitledBorder("Dad");
        TitledBorder momBorder = BorderFactory.createTitledBorder("Mom");
        TitledBorder anakBorder = BorderFactory.createTitledBorder("Masukkan Nama Anak");
        dadBorder.setTitleFont(new Font("Roboto", Font.BOLD, 15));
        momBorder.setTitleFont(new Font("Roboto", Font.BOLD, 15));
        anakBorder.setTitleFont(new Font("Roboto", Font.BOLD, 15));
        dad.setBorder(dadBorder);
        mom.setBorder(momBorder);
        namaAnak.setBorder(anakBorder);

        breedBtn.addActionListener(e -> {
            int indexDad = dad.getSelectedIndex();
            int indexMom = mom.getSelectedIndex();
            Engimon dadEngi = player.getEngiBag().getEngimonList().get(indexDad);
            Engimon momEngi = player.getEngiBag().getEngimonList().get(indexMom);

            try {
                Engimon child = player.breed(dadEngi, momEngi, namaAnak.getText());
                this.player.addEngimon(child);
                this.updateEngimonPanel();
                this.updateBreedPanel();
                JOptionPane.showMessageDialog(null, "Breed!", "Breeding Success", JOptionPane.PLAIN_MESSAGE);
            } catch (Exception errorBreed) {
                JOptionPane.showMessageDialog(null, errorBreed.getMessage(), "Breeding Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        for (Engimon engimon : this.player.getEngiBag().getEngimonList()) {
            dad.addItem(engimon);
            mom.addItem(engimon);
        }

        choicePanel.add(namaAnak);
        choicePanel.add(dad);
        choicePanel.add(mom);

        breedPanel.add(title, BorderLayout.NORTH);
        breedPanel.add(choicePanel, BorderLayout.CENTER);
        breedPanel.add(breedBtn, BorderLayout.SOUTH);
        return breedPanel;
    }

    private JPanel getEngimonPanel() {
        JPanel engimonPanel = new JPanel();
        JPanel engimonContainer = new JPanel();
        JLabel title = new JLabel("Engimon Inventory");
        title.setFont(new Font("Segoe UI", Font.BOLD, 35));
        engimonContainer.setPreferredSize(new Dimension(450,750));
        engimonContainer.setLayout(new FlowLayout());

        for (Engimon engimon : player.getEngiBag().getEngimonList()) {
            JButton engimonBtn = new EngimonButton(engimon);
            engimonBtn.addActionListener(e -> {
                JFrame engiFrame = new EngimonInfo(engimon);
                engiFrame.setVisible(true);
            });
            engimonContainer.add(engimonBtn);
        }

        engimonPanel.add(title);
        engimonPanel.add(engimonContainer);

        return engimonPanel;
    }

    private JPanel getSkillItemPanel() {
        JPanel skillPanel = new JPanel();
        JPanel skillContainer = new JPanel();
        JLabel title = new JLabel("Skill Item Inventory");
        title.setFont(new Font("Segoe UI", Font.BOLD, 35));
        skillContainer.setLayout(new GridLayout(1,2,10,10));

        List<SkillItem> skillItems = player.getSkillItemBag().getSkillList();
        List<Integer> countItems = player.getSkillItemBag().getJumlahTiapItem();

        for (int i = 0; i < skillItems.size(); i++) {
            SkillItem skillItem = skillItems.get(i);
            SkillButton skillBtn = new SkillButton(skillItem, countItems.get(i));
            skillBtn.addActionListener(e -> {
                JFrame skillFrame = new SkillItemInfo(player, skillItem, this);
                skillFrame.setVisible(true);
            });
            skillContainer.add(skillBtn);
        }

        skillPanel.add(title);
        skillPanel.add(skillContainer);
        return skillPanel;
    }

}
