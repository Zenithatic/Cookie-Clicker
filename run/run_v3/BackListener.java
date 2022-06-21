
import java.awt.event.*;
import javax.swing.*;


/**
 * 
 * @author Patrick Wang, Andrew Yoo
 * @apiNote The custom MouseListener for the return to main menu button in the help panel
 * 
 */
public class BackListener implements MouseListener{
    // implement these methods to fulfill abstraction
    public void mouseClicked(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}

    public void mousePressed(MouseEvent e){
        // make home panel visible
        MainFrame mainFrame = Main.getMainFrame();
        mainFrame.setCurrentPanel(MainFrame.HOMEPANEL);

        // replace Image Icon of play button with non-selected form
        JButton backButton = (JButton) e.getSource();
        Utils.applyButtonImage(backButton, "assets\\back.png", 100, 100);
    }

    public void mouseEntered(MouseEvent e){
        // replace Image Icon of play button with selected form
        JButton backButton = (JButton) e.getSource();
        Utils.applyButtonImage(backButton, "assets\\backSelected.png", 100, 100);
    }

    public void mouseExited(MouseEvent e){
        // replace Image Icon of play button with non-selected form
        JButton backButton = (JButton) e.getSource();
        Utils.applyButtonImage(backButton, "assets\\back.png", 100, 100);
    }
}
