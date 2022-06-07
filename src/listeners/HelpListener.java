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
        try {
            // load and apply image
            Image helpImage = ImageIO.read(new File("assets\\help.png")).getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
			helpButton.setIcon(new ImageIcon(helpImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }     
    }

    public void mouseEntered(MouseEvent e){
        // replace Image Icon of help button with selected form
        JButton helpButton = (JButton) e.getSource();
        try {
            // load and apply image
            Image helpImage = ImageIO.read(new File("assets\\helpSelected.png")).getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
			helpButton.setIcon(new ImageIcon(helpImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }

    }

    public void mouseExited(MouseEvent e){
        // replace Image Icon of help button with non-selected form
        JButton helpButton = (JButton) e.getSource();
        try {
            // load and apply image
            Image helpImage = ImageIO.read(new File("assets\\help.png")).getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
			helpButton.setIcon(new ImageIcon(helpImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
    }
    
}
