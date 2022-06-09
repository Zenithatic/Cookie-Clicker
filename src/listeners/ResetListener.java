package listeners;
import java.awt.Image;
import java.awt.event.*;
import java.io.File;
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
	// implement these methods to fulfill abstraction
    public void mouseClicked(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    
    public void mousePressed(MouseEvent e){

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
