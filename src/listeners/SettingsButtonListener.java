package listeners;
import java.awt.event.*;
import javax.swing.*;
import components.*;
import main_pkg.Main;
import myClasses.Utils;

/**
 * 
 * @author Patrick Wang, Andrew Yoo
 * @apiNote The custom MouseListener for the settings button
 * 
 */
public class SettingsButtonListener implements MouseListener{
    // implement these methods to fulfill abstraction
    public void mouseClicked(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}

    public void mousePressed(MouseEvent e){
        // make settings panel visible
        MainFrame mainFrame = Main.getMainFrame();
        mainFrame.setCurrentPanel(MainFrame.SETTINGSPANEL);

        // replace Image Icon of settings button with non-selected form
        JButton settingsButton = (JButton) e.getSource();
        Utils.applyButtonImage(settingsButton, "assets\\settingsGear.png", 100, 100);
    }

    public void mouseEntered(MouseEvent e){
        // replace Image Icon of settings button with selected form
        JButton settingsButton = (JButton) e.getSource();
        Utils.applyButtonImage(settingsButton, "assets\\settingsGearSelected.png", 100, 100);
    }

    public void mouseExited(MouseEvent e){
        // replace Image Icon of settings button with non-selected form
        JButton settingsButton = (JButton) e.getSource();
        Utils.applyButtonImage(settingsButton, "assets\\settingsGear.png", 100, 100);
    } 
}
