package logic;

import java.util.Random;

public class GameLogic {
    private int[] tiles;

    public GameLogic() {
        tiles = new int[60];
        generateTiles();
    }

    public void generateTiles() {
        Random rand = new Random();
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = rand.nextInt(15);
        }
    }

    public int[] getTiles() {
        return tiles;
    }
}
