package utils;

import javax.swing.ImageIcon;
import java.util.HashMap;

public class ImageLoader {
    private static final HashMap<Integer, ImageIcon> imageMap = new HashMap<>();

    static {
        for (int i = 0; i < 37; i++) { // Số lượng hình ảnh từ h0 đến h36
            String path = "/resources/h" + i + ".jpg"; // Đường dẫn bắt đầu từ root
            System.out.println("Trying to load image from path: " + path); // Debug thông báo
            try {
                ImageIcon icon = new ImageIcon(ImageLoader.class.getResource(path));
                imageMap.put(i, icon);
                if (icon.getImageLoadStatus() != java.awt.MediaTracker.COMPLETE) {
                    System.out.println("Image not loaded successfully: " + path);
                } else {
                    System.out.println("Image loaded successfully: " + path);
                }
            } catch (Exception e) {
                System.out.println("Error loading image: " + path);
                e.printStackTrace();
            }
        }
    }

    //
    public static ImageIcon getImage(int index) {
        return imageMap.get(index);
    }
}
