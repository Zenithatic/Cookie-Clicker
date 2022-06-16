package listeners;
import java.awt.Toolkit;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import components.MainFrame;
import myClasses.Utils;

/**
 * 
 * @author Patrick Wang, Andrew Yoo
 * @apiNote the custom MouseListener class for reset buttons
 *
 */
public class ResetListener implements MouseListener{
	
	// declare final static integer variable for the ascii value of "0"
	public final static int ZERO = 48;
	
	// implement these methods to fulfill abstraction
    public void mouseClicked(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    
    public void mousePressed(MouseEvent e){
    	// get components
    	JButton resetButton = (JButton) e.getSource();
    	
    	// ding
    	Toolkit.getDefaultToolkit().beep();
    	
    	// get user choice
		int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to reset this slot?", "Action Confirmation", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
    	
		// check if option isn't yes, if so, stop reset process
		if (option != 0) {
			return;
		}
		
		// determine which slot to load
		String fileDirectoryToClear= "";
		
		if (resetButton.getName().equals("reset1")) {
			fileDirectoryToClear = "slot1";
		}
		else if (resetButton.getName().equals("reset2")) {
			fileDirectoryToClear = "slot2";
		}
		else if (resetButton.getName().equals("reset3")) {
			fileDirectoryToClear = "slot3";
		}
		
		// start clearing data
		try {
			// declare required local variables
			File directory = new File("saves\\" + fileDirectoryToClear);
			File[] fileList = directory.listFiles();
			
			// set everything in save directory to default value
			for (int i = 0; i < fileList.length; i++) {
				// check if file is called multiplier.txt first
				if (fileList[i].getName().equals(MainFrame.MULTIPLIER_FILE)) {
					// write 1
					FileWriter file = new FileWriter(fileList[i]);
					file.write(ZERO + 1);
					file.close();
				}
				else {
					// write 0
					FileWriter file = new FileWriter(fileList[i]);
					file.write(ZERO);
					file.close();
				}
			}
		} catch (IOException e2) {
			// output traced error
			e2.printStackTrace();
		}
    }
    
    public void mouseEntered(MouseEvent e){
        // replace Image Icon of reset button with selected form
        JButton resetButton = (JButton) e.getSource();
        Utils.applyButtonImage(resetButton, "assets\\resetSelected.png", 300, 150);
    }

    public void mouseExited(MouseEvent e){
    	// replace Image Icon of reset button with non-selected form
        JButton resetButton = (JButton) e.getSource();
        Utils.applyButtonImage(resetButton, "assets\\reset.png", 300, 150);
    }
}
