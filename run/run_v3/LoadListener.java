
import java.awt.event.*;
import javax.swing.*;


/**
 * 
 * @author Patrick Wang, Andrew Yoo
 *  The custom MouseListener for the load buttons
 * 
 */
public class LoadListener implements MouseListener{
	// implement these methods to fulfill abstraction
    public void mouseClicked(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    
    public void mousePressed(MouseEvent e){
    	// load up the game
    	JButton loadButton = (JButton) e.getSource();
    	Main.getMainFrame().loadSlot(loadButton.getName());
		Main.getMainFrame().setCurrentPanel(MainFrame.GAMEPANEL);
		
		// reset image
		Utils.applyButtonImage(loadButton, "assets\\load.png", 300, 150);
    }
    
    public void mouseEntered(MouseEvent e){
        // replace Image Icon of load button with selected form
        JButton loadButton = (JButton) e.getSource();
        Utils.applyButtonImage(loadButton, "assets\\loadSelected.png", 300, 150);
    }

    public void mouseExited(MouseEvent e){
    	// replace Image Icon of load button with non-selected form
        JButton loadButton = (JButton) e.getSource();
        Utils.applyButtonImage(loadButton, "assets\\load.png", 300, 150);
    }
}
