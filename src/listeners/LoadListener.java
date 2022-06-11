package listeners;
import java.awt.Image;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import main_pkg.Main;

/**
 * 
 * @author Patrick Wang, Andrew Yoo
 * @apiNote The custom MouseListener for the load buttons
 * 
 */
public class LoadListener implements MouseListener{
	// implement these methods to fulfill abstraction
    public void mouseClicked(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    
    public void mousePressed(MouseEvent e){
    	JButton loadButton = (JButton) e.getSource();
    	Main.getMainFrame().loadSlot(loadButton.getName());
    }
    
    public void mouseEntered(MouseEvent e){
        // replace Image Icon of load button with selected form
        JButton loadButton = (JButton) e.getSource();
        try {
            // load and apply image
            Image loadImage = ImageIO.read(new File("assets\\loadSelected.png")).getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
            loadButton.setIcon(new ImageIcon(loadImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
    }

    public void mouseExited(MouseEvent e){
    	// replace Image Icon of load button with non-selected form
        JButton loadButton = (JButton) e.getSource();
        try {
            // load and apply image
            Image loadImage = ImageIO.read(new File("assets\\load.png")).getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
            loadButton.setIcon(new ImageIcon(loadImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
    }
}
