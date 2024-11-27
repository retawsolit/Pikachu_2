package utils;

import javax.swing.ImageIcon;
import java.util.HashMap;

public class ImageLoader {
    private static final HashMap<Integer, ImageIcon> imageMap = new HashMap<>();

    static {
        for (int i = 0; i < 37; i++) { // Number of images from h0 to h36
            String path = "resources/h" + i + ".jpg";
            try {
                ImageIcon icon = new ImageIcon(path);
                imageMap.put(i, icon);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static ImageIcon getImage(int index) {
        return imageMap.get(index);
    }
}