package utils;

import javax.swing.ImageIcon;
import java.util.HashMap;

public class ImageLoader {
    private static final HashMap<Integer, ImageIcon> imageMap = new HashMap<>();

    static {
        for (int i = 0; i < 37; i++) { // Number of images from h0 to h36
            String path = "resources/h" + i + ".jpg"; // Path starting from the resources folder
            System.out.println("Trying to load image from path: " + path); // Debug message
            try {
                // Use ClassLoader to load from resources folder
                ImageIcon icon = new ImageIcon(ImageLoader.class.getClassLoader().getResource(path));
                imageMap.put(i, icon);

                // Check if the image was successfully loaded
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

    // Method to retrieve images by index
    public static ImageIcon getImage(int index) {
        return imageMap.get(index);
    }
}
