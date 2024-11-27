package logic;

import ui.TileButton;
import java.awt.Point;

public class GameLogic {
    private TileButton[][] buttons;
    private final int rows;
    private final int cols;

    public GameLogic(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        buttons = new TileButton[rows][cols];
    }

    public void setTile(int row, int col, TileButton button) {
        buttons[row][col] = button;
    }

    public boolean isMatchable(TileButton first, TileButton second) {
        if (first == second || first.getId() != second.getId()) {
            return false;
        }

        Point p1 = new Point(first.getRow(), first.getCol());
        Point p2 = new Point(second.getRow(), second.getCol());

        // Kiểm tra đường thẳng
        if (checkLineX(p1.y, p2.y, p1.x) || checkLineY(p1.x, p2.x, p1.y)) {
            return true;
        }

        // Kiểm tra đường trong hình chữ nhật
        if (checkRectX(p1, p2) != -1 || checkRectY(p1, p2) != -1) {
            return true;
        }

        // Kiểm tra đường mở rộng
        if (checkMoreLineX(p1, p2, 1) != -1 || checkMoreLineX(p1, p2, -1) != -1) {
            return true;
        }

        if (checkMoreLineY(p1, p2, 1) != -1 || checkMoreLineY(p1, p2, -1) != -1) {
            return true;
        }

        return false;
    }

    // Các hàm kiểm tra đường nối
    private boolean checkLineX(int y1, int y2, int x) {
        int min = Math.min(y1, y2);
        int max = Math.max(y1, y2);
        for (int y = min; y <= max; y++) {
            if (buttons[x][y] != null && buttons[x][y].isVisible() && y != y1 && y != y2) {
                return false;
            }
        }
        return true;
    }

    private boolean checkLineY(int x1, int x2, int y) {
        int min = Math.min(x1, x2);
        int max = Math.max(x1, x2);
        for (int x = min; x <= max; x++) {
            if (buttons[x][y] != null && buttons[x][y].isVisible() && x != x1 && x != x2) {
                return false;
            }
        }
        return true;
    }

    private int checkRectX(Point p1, Point p2) {
        Point pMinY = p1, pMaxY = p2;
        if (p1.y > p2.y) {
            pMinY = p2;
            pMaxY = p1;
        }
        for (int y = pMinY.y + 1; y < pMaxY.y; y++) {
            if (checkLineX(pMinY.y, y, pMinY.x) && checkLineY(pMinY.x, pMaxY.x, y) && checkLineX(y, pMaxY.y, pMaxY.x)) {
                return y;
            }
        }
        return -1;
    }

    private int checkRectY(Point p1, Point p2) {
        Point pMinX = p1, pMaxX = p2;
        if (p1.x > p2.x) {
            pMinX = p2;
            pMaxX = p1;
        }
        for (int x = pMinX.x + 1; x < pMaxX.x; x++) {
            if (checkLineY(pMinX.x, x, pMinX.y) && checkLineX(pMinX.y, pMaxX.y, x) && checkLineY(x, pMaxX.x, pMaxX.y)) {
                return x;
            }
        }
        return -1;
    }

    private int checkMoreLineX(Point p1, Point p2, int type) {
        Point pMinY = p1, pMaxY = p2;
        if (p1.y > p2.y) {
            pMinY = p2;
            pMaxY = p1;
        }
        int y = pMaxY.y;
        int row = pMinY.x;
        if (type == -1) {
            y = pMinY.y;
            row = pMaxY.x;
        }
        if (checkLineX(pMinY.y, pMaxY.y, row)) {
            while (isValidPoint(row, y) && buttons[pMinY.x][y] == null && buttons[pMaxY.x][y] == null) {
                if (checkLineY(pMinY.x, pMaxY.x, y)) {
                    return y;
                }
                y += type;
            }
        }
        return -1;
    }

    private int checkMoreLineY(Point p1, Point p2, int type) {
        Point pMinX = p1, pMaxX = p2;
        if (p1.x > p2.x) {
            pMinX = p2;
            pMaxX = p1;
        }
        int x = pMaxX.x;
        int col = pMinX.y;
        if (type == -1) {
            x = pMinX.x;
            col = pMaxX.y;
        }
        if (checkLineY(pMinX.x, pMaxX.x, col)) {
            while (isValidPoint(x, col) && buttons[x][pMinX.y] == null && buttons[x][pMaxX.y] == null) {
                if (checkLineX(pMinX.y, pMaxX.y, x)) {
                    return x;
                }
                x += type;
            }
        }
        return -1;
    }

    private boolean isValidPoint(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }
}
