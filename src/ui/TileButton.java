package ui;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class TileButton extends JButton {
    private int value;

    public TileButton(int value, ImageIcon icon) {
        this.value = value;
        setIcon(icon);
    }

    public int getValue() {
        return value;
    }
}
