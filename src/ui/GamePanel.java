package ui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Color;

public class GamePanel extends JPanel {
    private JButton[] buttons;
    private JLabel scoreLabel, timeLabel;

    public GamePanel() {
        setLayout(new GridLayout(6, 10));
        buttons = new JButton[60];

        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            add(buttons[i]);
        }

        scoreLabel = new JLabel("Score: 0");
        timeLabel = new JLabel("Time: 120");
        add(scoreLabel);
        add(timeLabel);
    }
}
