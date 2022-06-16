package listeners;
import java.awt.event.*;
import javax.swing.*;

import myClasses.Utils;

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
        Utils.applyButtonImage(closeButton, "assets\\closeSelected.png", 100, 100);
    }

    public void mouseExited(MouseEvent e){
        // replace Image Icon of close button with non-selected form
        JButton closeButton = (JButton) e.getSource();
        Utils.applyButtonImage(closeButton, "assets\\close.png", 100, 100);
    }
}
