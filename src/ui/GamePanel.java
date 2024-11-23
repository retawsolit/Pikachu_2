package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utils.ImageLoader;
import java.util.ArrayList;
import java.util.Collections;

public class GamePanel extends JPanel implements ActionListener {
    private TileButton[] buttons;
    private JLabel scoreLabel, timeLabel;
    private TileButton firstSelected = null;
    private int score = 0;

    public GamePanel() {
        setLayout(new GridLayout(6, 10));
        buttons = new TileButton[36]; // Tổng cộng 36 ô để tìm cặp
        ArrayList<Integer> icons = new ArrayList<>();

        // Thêm các cặp hình ảnh (mỗi hình ảnh có 2 bản sao)
        for (int i = 0; i < 18; i++) {
            icons.add(i);
            icons.add(i);
        }

        Collections.shuffle(icons);

        for (int i = 0; i < buttons.length; i++) {
            ImageIcon icon = ImageLoader.getImage(icons.get(i));
            buttons[i] = new TileButton(icons.get(i), icon);
            buttons[i].addActionListener(this);
            add(buttons[i]);
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
            // Lựa chọn ô đầu tiên
            firstSelected = clickedButton;
            firstSelected.setEnabled(false);
        } else {
            // Lựa chọn ô thứ hai
            if (firstSelected.getId() == clickedButton.getId()) {
                // Tìm thấy cặp trùng
                clickedButton.setEnabled(false);
                firstSelected.setVisible(false);
                clickedButton.setVisible(false);
                score += 10;
                scoreLabel.setText("Score: " + score);
            } else {
                // Không trùng, bật lại ô đầu tiên
                firstSelected.setEnabled(true);
            }
            firstSelected = null;
        }
    }
}
