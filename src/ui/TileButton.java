package ui;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class TileButton extends JButton {
    private final int id;
    private final int row;
    private final int col;

    public TileButton(int id, ImageIcon icon, int row, int col) {
        super(icon);
        this.id = id;
        this.row = row;
        this.col = col;
    }

    public int getId() {
        return id;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
