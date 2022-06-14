
import java.awt.Image;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;


/**
 * 
 * @author Patrick Wang, Andrew Yoo
 * @apiNote the custom MouseListener for the Save button
 *
 */
public class SaveListener implements MouseListener{
	// implement these methods to fulfill abstraction
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {
		// replace Image Icon of save button with non-selected form
        JButton saveButton = (JButton) e.getSource();
        try {
            // load and apply image
            Image saveImage = ImageIO.read(new File("assets\\save.png")).getScaledInstance(100, 80, java.awt.Image.SCALE_SMOOTH);
            saveButton.setIcon(new ImageIcon(saveImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
        
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
				
				// close writers
				buffer.close();
				file.close();
 			}
 		} catch (IOException e2) {
 			// output traced error
 			e2.printStackTrace();
 		}
	}

	public void mouseEntered(MouseEvent e) {
		// replace Image Icon of save button with selected form
        JButton saveButton = (JButton) e.getSource();
        try {
            // load and apply image
            Image saveImage = ImageIO.read(new File("assets\\saveSelected.png")).getScaledInstance(100, 80, java.awt.Image.SCALE_SMOOTH);
            saveButton.setIcon(new ImageIcon(saveImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
	}

	public void mouseExited(MouseEvent e) {
		// replace Image Icon of save button with non-selected form
        JButton saveButton = (JButton) e.getSource();
        try {
            // load and apply image
            Image saveImage = ImageIO.read(new File("assets\\save.png")).getScaledInstance(100, 80, java.awt.Image.SCALE_SMOOTH);
            saveButton.setIcon(new ImageIcon(saveImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
	}
}
