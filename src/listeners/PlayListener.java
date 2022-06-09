package listeners;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import components.MainFrame;
import main_pkg.Main;

/**
 * 
 * @author Patrick Wang, Andrew Yoo
 * @apiNote The custom MouseListener for the play button
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
        try {
            // load and apply image
            Image playImage = ImageIO.read(new File("assets\\play.png")).getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
			playButton.setIcon(new ImageIcon(playImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }  
    }

    public void mouseEntered(MouseEvent e){
        // replace Image Icon of play button with selected form
        JButton playButton = (JButton) e.getSource();
        try {
            // load and apply image
            Image playImage = ImageIO.read(new File("assets\\playSelected.png")).getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
			playButton.setIcon(new ImageIcon(playImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }

    }
    public void mouseExited(MouseEvent e){
        // replace Image Icon of play button with non-selected form
        JButton playButton = (JButton) e.getSource();
        try {
            // load and apply image
            Image playImage = ImageIO.read(new File("assets\\play.png")).getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
			playButton.setIcon(new ImageIcon(playImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
    } 
}
