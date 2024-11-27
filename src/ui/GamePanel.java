package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import logic.GameLogic;
import utils.ImageLoader;
import java.util.ArrayList;
import java.util.Collections;

public class GamePanel extends JPanel implements ActionListener {
    private TileButton[][] buttons;
    private JLabel scoreLabel, timeLabel;
    private TileButton firstSelected = null;
    private GameLogic gameLogic;
    private int score = 0;
    private final int rows = 6;
    private final int cols = 10;

    public GamePanel() {
        setLayout(new GridLayout(rows, cols));
        buttons = new TileButton[rows][cols];
        ArrayList<Integer> icons = new ArrayList<>();
        gameLogic = new GameLogic(rows, cols);

        // Adding pairs of icons (2 of each)
        for (int i = 0; i < (rows * cols) / 2; i++) {
            icons.add(i);
            icons.add(i);
        }

        Collections.shuffle(icons);

        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ImageIcon icon = ImageLoader.getImage(icons.get(index));
                buttons[i][j] = new TileButton(icons.get(index), icon, i, j);
                buttons[i][j].addActionListener(this);
                add(buttons[i][j]);
                gameLogic.setTile(i, j, buttons[i][j]);
                index++;
            }
        }

        scoreLabel = new JLabel("Score: 0");
        timeLabel = new JLabel("Time: 120");
        add(scoreLabel);
        add(timeLabel);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TileButton clickedButton = (TileButton) e.getSource();

        if (firstSelected == null) {
            // First tile selected
            firstSelected = clickedButton;
            firstSelected.setEnabled(false);
        } else {
            // Second tile selected
            if (gameLogic.isMatchable(firstSelected, clickedButton)) {
                // Match found
                clickedButton.setEnabled(false);
                firstSelected.setVisible(false);
                clickedButton.setVisible(false);
                score += 10;
                scoreLabel.setText("Score: " + score);
            } else {
                // No match, re-enable the first button
                firstSelected.setEnabled(true);
            }
            firstSelected = null;
        }
    }
}
