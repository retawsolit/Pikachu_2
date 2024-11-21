package ui;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class ImagePanel extends JPanel {
    private Image background;

    public ImagePanel(String imagePath) {
        this.background = new ImageIcon(imagePath).getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, getWidth(), getHeight(), null);
    }
}
