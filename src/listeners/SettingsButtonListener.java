package listeners;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import components.*;
import main_pkg.Main;

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
        try {
            // load and apply image
            Image settingsImage = ImageIO.read(new File("assets\\settingsGear.png")).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
			settingsButton.setIcon(new ImageIcon(settingsImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
    }

    public void mouseEntered(MouseEvent e){
        // replace Image Icon of settings button with selected form
        JButton settingsButton = (JButton) e.getSource();
        try {
            // load and apply image
            Image settingsImage = ImageIO.read(new File("assets\\settingsGearSelected.png")).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
			settingsButton.setIcon(new ImageIcon(settingsImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
    }

    public void mouseExited(MouseEvent e){
        // replace Image Icon of settings button with non-selected form
        JButton settingsButton = (JButton) e.getSource();
        try {
            // load and apply image
            Image settingsImage = ImageIO.read(new File("assets\\settingsGear.png")).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
			settingsButton.setIcon(new ImageIcon(settingsImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
    } 
}
