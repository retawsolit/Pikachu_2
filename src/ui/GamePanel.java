package ui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Color;
import utils.ImageLoader;
import javax.swing.ImageIcon;

public class GamePanel extends JPanel {
    private JButton[] buttons;
    private JLabel scoreLabel, timeLabel;

    public GamePanel() {
        setLayout(new GridLayout(6, 10));
        buttons = new TileButton[60];  // Use TileButton instead of JButton

        for (int i = 0; i < buttons.length; i++) {
            // Assuming ImageLoader.getImage(i) returns a valid ImageIcon
            ImageIcon icon = ImageLoader.getImage(i);
            buttons[i] = new TileButton(i, icon);  // Use TileButton instead
            add(buttons[i]);
        }

        scoreLabel = new JLabel("Score: 0");
        timeLabel = new JLabel("Time: 120");
        add(scoreLabel);
        add(timeLabel);
    }
}
