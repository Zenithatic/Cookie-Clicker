package myClasses;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * 
 *  Utils class that has a bunch of methods to reduce repetition
 * @author Patrick Wang
 *
 */
public class Utils {
	/**
	 *  Method to apply an image to a JButton
	 * @param item - int
	 * @param filePath - String
	 * @param width - int
	 * @param height - height
	 */
	public static void applyButtonImage(JButton item, String filePath, int width, int height) {
		// set Image Icon of the button
        try {
            // load and apply image
            Image image = ImageIO.read(new File(filePath)).getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
            item.setIcon(new ImageIcon(image));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
	}
	
	/**
	 *  Method to apply an image to a JLabel
	 * @param item - int
	 * @param filePath - String
	 * @param width - int
	 * @param height - height
	 */
	public static void applyLabelImage(JLabel item, String filePath, int width, int height) {
		// set Image Icon of the label
        try {
            // load and apply image
            Image image = ImageIO.read(new File(filePath)).getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
            item.setIcon(new ImageIcon(image));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
	}
}
