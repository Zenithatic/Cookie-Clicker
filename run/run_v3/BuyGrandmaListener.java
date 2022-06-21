
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import javax.sound.sampled.*;

/**
 * 
 * @author Patrick Wang, Andrew Yoo
 * @apiNote The custom MouseListener for the Buy Grandma button
 *
 */
public class BuyGrandmaListener implements MouseListener{
	
	// declare sound variables
    public static String soundPath = "assets\\kaching.wav";
    private Clip audioClip;
    private AudioInputStream inputStream;
    
    /**
     * 
     * @apiNote Constructor for the MouseListener class
     * 
     */
    public BuyGrandmaListener() {
    	// load up audio stream and clip
        try {
			inputStream = AudioSystem.getAudioInputStream(new File(soundPath).getAbsoluteFile());
	        audioClip = AudioSystem.getClip();
	        audioClip.open(inputStream);
		} 
        // catch exceptions and output traced errors
        catch (IOException e){
            e.printStackTrace();
        }
        catch (UnsupportedAudioFileException e){
            e.printStackTrace();
        }
        catch (LineUnavailableException e){
            System.out.println("LineUnavailableException occured in the BuyCursorListener class!");
        }
    }

	// implement these methods to fulfill abstraction
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {
		// perform buy action
        int currentCookies = Main.getMainFrame().getCookies();
        int price = Main.getMainFrame().getGamePanel().getGrandmaPrice();
        
        if (currentCookies >= price) {
        	// set new values
        	Main.getMainFrame().setGrandmas(Main.getMainFrame().getGrandmas() + 1);
        	Main.getMainFrame().subtractCookies(price);
        	Main.getMainFrame().getGamePanel().updateGrandmaPrice();
        	
        	// update game panel labels
        	Main.getMainFrame().getGamePanel().updateCookies(currentCookies - price);
        	Main.getMainFrame().getGamePanel().getDescLabel().setText("<html><b><u>Grandma</u></b><br><br>Bakes 3 cookies per second<br><br>Owned: " + Main.getMainFrame().getGrandmas() + "<br>Next price: $" + Main.getMainFrame().getGamePanel().getGrandmaPrice() + "</html>");
        	
            // play kaching audio
            audioClip.stop();
            audioClip.setFramePosition(0);
            audioClip.start();
        }
        else {
        	// play error sound
        	Toolkit.getDefaultToolkit().beep();
        }
        
        // update perSec counter
        Main.getMainFrame().getGamePanel().updatePerSec();
	}

	public void mouseEntered(MouseEvent e) {
		// replace Image Icon of buy button with selected form
        JButton buyButton = (JButton) e.getSource();
        Utils.applyButtonImage(buyButton, "assets\\buyGrandmaSelected.png", 250, 70);
        
        // show cursor upgrade info
        Main.getMainFrame().getGamePanel().getDescLabel().setText("<html><b><u>Grandma</u></b><br><br>Bakes 3 cookies per second<br><br>Owned: " + Main.getMainFrame().getGrandmas() + "<br>Next price: $" + Main.getMainFrame().getGamePanel().getGrandmaPrice() + "</html>");
	}

	public void mouseExited(MouseEvent e) {
		// replace Image Icon of buy button with non-selected form
        JButton buyButton = (JButton) e.getSource();
        Utils.applyButtonImage(buyButton, "assets\\buyGrandma.png", 250, 70);
        
        // hide cursor upgrade info
        Main.getMainFrame().getGamePanel().getDescLabel().setText("");
	}
}
