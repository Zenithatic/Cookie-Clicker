
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Image;
import java.awt.event.*;
import java.io.*;


/**
 * 
 * @author Patrick Wang
 * @apiNote The MouseListener for the start button
 * 
 */
public class StartListener implements MouseListener{

	// implement these methods to fulfill abstraction
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {
		// replace Image Icon of start button with non-selected form
        JButton startButton = (JButton) e.getSource();
        try {
            // load and apply image
            Image startImage = ImageIO.read(new File("assets\\start.png")).getScaledInstance(400, 200, java.awt.Image.SCALE_SMOOTH);
            startButton.setIcon(new ImageIcon(startImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
        
        // load home panel
        Main.getMainFrame().setCurrentPanel(MainFrame.HOMEPANEL);
	}

	public void mouseEntered(MouseEvent e) {
		// replace Image Icon of start button with selected form
        JButton startButton = (JButton) e.getSource();
        try {
            // load and apply image
            Image startImage = ImageIO.read(new File("assets\\startSelected.png")).getScaledInstance(400, 200, java.awt.Image.SCALE_SMOOTH);
            startButton.setIcon(new ImageIcon(startImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
	}

	public void mouseExited(MouseEvent e) {
		// replace Image Icon of start button with non-selected form
        JButton startButton = (JButton) e.getSource();
        try {
            // load and apply image
            Image startImage = ImageIO.read(new File("assets\\start.png")).getScaledInstance(400, 200, java.awt.Image.SCALE_SMOOTH);
            startButton.setIcon(new ImageIcon(startImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
	}
}
