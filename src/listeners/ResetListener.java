package listeners;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * 
 * @author Patrick Wang, Andrew Yoo
 * @apiNote the custom MouseListener class for reset buttons
 *
 */
public class ResetListener implements MouseListener{
	
	// declare final static integer variable for the ascii value of "0"
	final static int ZERO = 48;
	
	// implement these methods to fulfill abstraction
    public void mouseClicked(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    
    public void mousePressed(MouseEvent e){
    	// get components
    	JButton resetButton = (JButton) e.getSource();
    	// get user choice
		int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset this slot?", "Action Confirmation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
    	
		// check if option isn't yes, if so, stop reset process
		if (option != 0) {
			return;
		}
		
    	// 1) check which slot the button will reset
    	// 2) prompt user for verification
    	// 3) reset slot if confirmed
    	if (resetButton.getName().equals("reset1")) {
    		// erase slot 1
    		try {
				// erase cookies
				FileWriter cookieFile = new FileWriter("saves\\slot1\\cookies.txt");
				cookieFile.write(ZERO);
				cookieFile.close();
			} catch (IOException e2) {
				// output traced error
				e2.printStackTrace();
			}
    	}
    	else if (resetButton.getName().equals("reset2")) {
    		// erase slot 2
    		try {
				// erase cookies
				FileWriter cookieFile = new FileWriter("saves\\slot2\\cookies.txt");
				cookieFile.write(ZERO);
				cookieFile.close();
			} catch (IOException e2) {
				// output traced error
				e2.printStackTrace();
			}
    	}
    	else if (resetButton.getName().equals("reset3")) {
    		// erase slot 3
    		try {
				// erase cookies
				FileWriter cookieFile = new FileWriter("saves\\slot3\\cookies.txt");
				cookieFile.write(ZERO);
				cookieFile.close();
			} catch (IOException e2) {
				// output traced error
				e2.printStackTrace();
			}
    	}
    }
    
    public void mouseEntered(MouseEvent e){
        // replace Image Icon of reset button with selected form
        JButton resetButton = (JButton) e.getSource();
        try {
            // load and apply image
            Image resetImage = ImageIO.read(new File("assets\\resetSelected.png")).getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
            resetButton.setIcon(new ImageIcon(resetImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
    }

    public void mouseExited(MouseEvent e){
    	// replace Image Icon of reset button with non-selected form
        JButton resetButton = (JButton) e.getSource();
        try {
            // load and apply image
            Image resetImage = ImageIO.read(new File("assets\\reset.png")).getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
            resetButton.setIcon(new ImageIcon(resetImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
    }
}
