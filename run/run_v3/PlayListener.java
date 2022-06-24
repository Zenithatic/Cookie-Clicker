
import java.awt.event.*;
import javax.swing.*;

/**
 * 
 * @author Patrick Wang, Andrew Yoo
 *  The custom MouseListener for the play button
 * 
 */
public class PlayListener implements MouseListener{
    // implement these methods to fulfill abstraction
    public void mouseClicked(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
    
    public void mousePressed(MouseEvent e){
    	// make load panel visible
        MainFrame mainFrame = Main.getMainFrame();
        mainFrame.setCurrentPanel(MainFrame.LOADPANEL);

        // replace Image Icon of play button with non-selected form
        JButton playButton = (JButton) e.getSource();
        Utils.applyButtonImage(playButton, "assets\\play.png", 300, 150);
    }

    public void mouseEntered(MouseEvent e){
        // replace Image Icon of play button with selected form
        JButton playButton = (JButton) e.getSource();
        Utils.applyButtonImage(playButton, "assets\\playSelected.png", 300, 150);
    }
    
    public void mouseExited(MouseEvent e){
        // replace Image Icon of play button with non-selected form
        JButton playButton = (JButton) e.getSource();
        Utils.applyButtonImage(playButton, "assets\\play.png", 300, 150);
    } 
}
