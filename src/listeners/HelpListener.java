package listeners;
import java.awt.event.*;
import javax.swing.*;
import main_pkg.Main;
import myClasses.Utils;
import components.*;

/**
 * 
 * @author Patrick Wang, Andrew Yoo
 * @apiNote The custom MouseListener for the help button
 * 
 */
public class HelpListener implements MouseListener{
    // implement these methods to fulfill abstraction
    public void mouseClicked(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}

    public void mousePressed(MouseEvent e){
        // make help panel visible
        MainFrame mainFrame = Main.getMainFrame();
        mainFrame.setCurrentPanel(MainFrame.HELPPANEL);

        // replace Image Icon of help button with non-selected form
        JButton helpButton = (JButton) e.getSource();
        Utils.applyButtonImage(helpButton, "assets\\help.png", 300, 150);
    }

    public void mouseEntered(MouseEvent e){
        // replace Image Icon of help button with selected form
        JButton helpButton = (JButton) e.getSource();
        Utils.applyButtonImage(helpButton, "assets\\helpSelected.png", 300, 150);
    }

    public void mouseExited(MouseEvent e){
        // replace Image Icon of help button with non-selected form
        JButton helpButton = (JButton) e.getSource();
        Utils.applyButtonImage(helpButton, "assets\\help.png", 300, 150);
    }
}
