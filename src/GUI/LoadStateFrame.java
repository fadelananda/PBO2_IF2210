package GUI;


import entities.Player;
import entities.ReadWriteGameState;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;

public class LoadStateFrame extends JFrame {
    private JLabel title;
    private JPanel saveFilePanel;

    public File[] loadSaveFiles(){
        File dir = new File("state/");
        File[] files = dir.listFiles((d, name) -> name.endsWith(".json"));
        return files;
    }

    public LoadStateFrame() {
        // Set Layout Opening Panel
        ImageIcon img = new ImageIcon("assets/engimonIcon.png");
        this.setIconImage(img.getImage());
        this.setTitle("Load Save File");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(0,0));
        this.setPreferredSize(new Dimension(1000,800));
        this.setBackground(Color.LIGHT_GRAY);

        // Get title label and button panel
        title = this.getTitleLabel();
        saveFilePanel = this.getButtonPanel();

        // Add label and buttons to panel
        this.add(title, BorderLayout.NORTH);
        this.add(saveFilePanel, BorderLayout.CENTER);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private JLabel getTitleLabel() {
        JLabel label = new JLabel("CHOOSE SAVE FILE", SwingConstants.CENTER);
        label.setSize(5,5);
        label.setFont(new Font("Segoe UI", Font.BOLD, 50));

        return label;
    }

    private JPanel getButtonPanel() {
        JPanel buttonPanel = new JPanel();

        buttonPanel.setBackground(Color.LIGHT_GRAY);
        buttonPanel.setPreferredSize(new Dimension(100, 300));
        buttonPanel.setLayout(new GridLayout(2, 1, 10, 10));
        buttonPanel.setBorder(new EmptyBorder(50, 50, 50, 50));

        File[] listSaveFiles = loadSaveFiles();
        int it = 0;
        for(File f: listSaveFiles){
            it++;

            JButton saveFileButton;
            saveFileButton = new JButton("Save File #" + it + " : " +  f.getName());
            saveFileButton.setFont(new Font("Papyrus", Font.BOLD, 20));
            saveFileButton.setFont(new Font("Papyrus", Font.BOLD, 20));

            saveFileButton.setBackground(Color.GRAY);
            saveFileButton.setBackground(Color.GRAY);

            saveFileButton.setFocusable(false);
            saveFileButton.setFocusable(false);

            saveFileButton.addActionListener(e -> {
                this.dispose();
                ReadWriteGameState rw = new ReadWriteGameState();
                Player loadedPlayer = rw.loadGameState(f.getName());
                GUI.Game game = new Game(loadedPlayer);
                Thread gameThread = new Thread(game);
                gameThread.start();
            });

            buttonPanel.add(saveFileButton);
        }

        return buttonPanel;
    }
}
