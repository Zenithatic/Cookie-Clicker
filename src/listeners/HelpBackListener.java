package listeners;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import main_pkg.Main;
import components.*;

/**
 * 
 * @author Patrick Wang
 * @apiNote The custom MouseListener for the return to main menu button in the help panel
 * 
 */
public class HelpBackListener implements MouseListener{
    // implement these methods to fulfill abstraction
    public void mouseClicked(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}

    public void mousePressed(MouseEvent e){
        // make home panel visible
        MainFrame mainFrame = Main.getMainFrame();
        mainFrame.setCurrentPanel(MainFrame.HOMEPANEL);

        // replace Image Icon of play button with non-selected form
        JButton backButton = (JButton) e.getSource();
        try {
            // load and apply image
            Image backImage = ImageIO.read(new File("assets\\back.png")).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
            backButton.setIcon(new ImageIcon(backImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
    }

    public void mouseEntered(MouseEvent e){
        // replace Image Icon of play button with selected form
        JButton backButton = (JButton) e.getSource();
        try {
            // load and apply image
            Image backImage = ImageIO.read(new File("assets\\backSelected.png")).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
			backButton.setIcon(new ImageIcon(backImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
    }

    public void mouseExited(MouseEvent e){
        // replace Image Icon of play button with non-selected form
        JButton backButton = (JButton) e.getSource();
        try {
            // load and apply image
            Image backImage = ImageIO.read(new File("assets\\back.png")).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
            backButton.setIcon(new ImageIcon(backImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
    }
    
}
