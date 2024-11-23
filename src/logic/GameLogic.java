package logic;

import ui.TileButton;
import ui.GamePanel;
import javax.swing.JOptionPane;

public class GameLogic {
    private static TileButton firstTile = null; // Nút đầu tiên được click
    private static TileButton secondTile = null; // Nút thứ hai được click
    private static int score = 0;
    private static GamePanel gamePanel;

    public static void setGamePanel(GamePanel panel) {
        gamePanel = panel;
    }

    public static void onTileClicked(TileButton tile) {
        if (firstTile == null) {
            firstTile = tile;
            firstTile.setEnabled(false); // Tạm thời vô hiệu hóa nút
        } else if (secondTile == null) {
            secondTile = tile;
            secondTile.setEnabled(false); // Tạm thời vô hiệu hóa nút

            // Kiểm tra hai nút có giống nhau không
            checkMatch();
        }
    }

    private static void checkMatch() {
        if (firstTile.getId() == secondTile.getId()) {
            firstTile.setMatched(true);
            secondTile.setMatched(true);
            score += 10;
            JOptionPane.showMessageDialog(null, "Matched! Score: " + score);
        } else {
            firstTile.setEnabled(true);
            secondTile.setEnabled(true);
            JOptionPane.showMessageDialog(null, "Not Matched!");
        }

        firstTile = null;
        secondTile = null;

        // Kiểm tra nếu tất cả các nút đã được matched
        if (checkGameFinished()) {
            JOptionPane.showMessageDialog(null, "Congratulations! You've finished the game with score: " + score);
        }
    }

    private static boolean checkGameFinished() {
        for (TileButton button : gamePanel.getButtons()) {
            if (!button.isMatched()) {
                return false;
            }
        }
        return true;
    }
}