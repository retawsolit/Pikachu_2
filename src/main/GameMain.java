package main;

import ui.GameFrame;
import javax.swing.SwingUtilities;

public class GameMain {
    public static void main(String[] args) {
        System.out.println("GameMain is starting...");
        SwingUtilities.invokeLater(() -> {
            GameFrame frame = new GameFrame();
            frame.setVisible(true);
        });
    }
}
