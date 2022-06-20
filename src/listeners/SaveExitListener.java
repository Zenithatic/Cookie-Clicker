package listeners;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import components.MainFrame;
import main_pkg.Main;
import myClasses.Utils;

/**
 * 
 * @author Patrick Wang, Andrew Yoo
 * @apiNote the custom MouseListener for the Save and Exit button
 *
 */
public class SaveExitListener implements MouseListener{
	// implement these methods to fulfill abstraction
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {
		// replace Image Icon of save and exit button with non-selected form
        JButton saveButton = (JButton) e.getSource();
        Utils.applyButtonImage(saveButton, "assets\\save_exit.png", 200, 80);
        
        // find and save slot data
        int slotNumber = Main.getMainFrame().getSlot();
        
        // save slot 
 		try {
 			// declare required local variables
 			File directory = new File("saves\\slot" + slotNumber);
 			File[] fileList = directory.listFiles();
 			
 			// save data
 			for (int i = 0; i < fileList.length; i++) {
 				// create writer
				FileWriter file = new FileWriter(fileList[i]);
				BufferedWriter buffer = new BufferedWriter(file);

				String fileName = fileList[i].getName();

				// check what kind of data it is then save the data
				if (fileName.equals(MainFrame.COOKIE_FILE)) {
					buffer.write(String.valueOf(Main.getMainFrame().getCookies()));
				}
				else if (fileName.equals(MainFrame.MULTIPLIER_FILE)) {
					buffer.write(String.valueOf(Main.getMainFrame().getMultiplier()));
				}
				else if (fileName.equals(MainFrame.CURSOR_FILE)) {
					buffer.write(String.valueOf(Main.getMainFrame().getCursors()));
				}
				else if (fileName.equals(MainFrame.GRANDMA_FILE)) {
					buffer.write(String.valueOf(Main.getMainFrame().getGrandmas()));
				}
				else if (fileName.equals(MainFrame.FARM_FILE)) {
					buffer.write(String.valueOf(Main.getMainFrame().getFarms()));
				}
				else if (fileName.equals(MainFrame.MINE_FILE)) {
					buffer.write(String.valueOf(Main.getMainFrame().getMines()));
				}
				
				// close writers
				buffer.close();
				file.close();
 			}
 		} catch (IOException e2) {
 			// output traced error
 			e2.printStackTrace();
 		}
 		
 		// return to main menu
 		Main.getMainFrame().setCurrentPanel(MainFrame.HOMEPANEL);
	}

	public void mouseEntered(MouseEvent e) {
		// replace Image Icon of save and exit button with selected form
        JButton saveButton = (JButton) e.getSource();
        Utils.applyButtonImage(saveButton, "assets\\save_exit_selected.png", 200, 80);
	}

	public void mouseExited(MouseEvent e) {
		// replace Image Icon of save and exit button with non-selected form
        JButton saveButton = (JButton) e.getSource();
        Utils.applyButtonImage(saveButton, "assets\\save_exit.png", 200, 80);
	}
}
