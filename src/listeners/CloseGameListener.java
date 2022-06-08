package listeners;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * 
 * @author Patrick Wang, Andrew Yoo
 * @apiNote The custom MouseListener for the close game button
 * 
 */
public class CloseGameListener implements MouseListener {
    // implement these methods to fulfill abstraction
    public void mouseClicked(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    
    public void mousePressed(MouseEvent e){
        // close the application
        System.exit(0);
    }
    
    public void mouseEntered(MouseEvent e){
        // replace Image Icon of close button with selected form
        JButton closeButton = (JButton) e.getSource();
        try {
            // load and apply image
            Image closeImage = ImageIO.read(new File("assets\\closeSelected.png")).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
			closeButton.setIcon(new ImageIcon(closeImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
    }

    public void mouseExited(MouseEvent e){
        // replace Image Icon of close button with non-selected form
        JButton closeButton = (JButton) e.getSource();
        try {
            // load and apply image
            Image closeImage = ImageIO.read(new File("assets\\close.png")).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
			closeButton.setIcon(new ImageIcon(closeImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
    }
}
