package Test;

import utils.ImageLoader;
import javax.swing.*;
import java.awt.*;

public class TestImageLoader {
    public static void main(String[] args) {
        int testIndex = 0;  // Image index to test
        ImageIcon icon = ImageLoader.getImage(testIndex);

        if (icon == null) {
            System.out.println("Image not found for index: " + testIndex);
            return;
        }

        if (icon.getImageLoadStatus() != MediaTracker.COMPLETE) {
            System.out.println("Image not loaded successfully for index: " + testIndex);
        } else {
            System.out.println("Image loaded successfully for index: " + testIndex);

            // Display image in JFrame for visual confirmation
            JFrame frame = new JFrame("Image Test");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JLabel label = new JLabel(icon);
            frame.add(label);
            frame.pack();
            frame.setLocationRelativeTo(null); // Center the frame
            frame.setVisible(true);
        }
    }
}
