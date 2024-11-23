package ui;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class TileButton extends JButton {
    private final int id;

    public TileButton(int id, ImageIcon icon) {
        super(icon);
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
