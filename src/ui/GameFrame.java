package ui;

import javax.swing.JFrame;

public class GameFrame extends JFrame {
    public GameFrame() {
        setTitle("Pikachu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);

        GamePanel panel = new GamePanel();
        setContentPane(panel);
    }
}
