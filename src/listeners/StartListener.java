package listeners;
import javax.swing.*;
import components.MainFrame;
import java.awt.event.*;
import main_pkg.Main;
import myClasses.Utils;

/**
 * 
 * The MouseListener for the start button
 * @author Patrick Wang
 * 
 */
public class StartListener implements MouseListener{

	// implement these methods to fulfill abstraction
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {
		// replace Image Icon of start button with non-selected form
        JButton startButton = (JButton) e.getSource();
        Utils.applyButtonImage(startButton, "assets\\start.png", 400, 200);
        
        // load home panel
        Main.getMainFrame().setCurrentPanel(MainFrame.HOMEPANEL);
	}

	public void mouseEntered(MouseEvent e) {
		// replace Image Icon of start button with selected form
        JButton startButton = (JButton) e.getSource();
        Utils.applyButtonImage(startButton, "assets\\startSelected.png", 400, 200);
	}

	public void mouseExited(MouseEvent e) {
		// replace Image Icon of start button with non-selected form
        JButton startButton = (JButton) e.getSource();
        Utils.applyButtonImage(startButton, "assets\\start.png", 400, 200);
	}
}
