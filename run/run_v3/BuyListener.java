
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

import javax.sound.sampled.*;

/**
 * 
 * @author Patrick Wang, Andrew Yoo
 * @apiNote The custom MouseListener for buy JButtons
 *
 */
public class BuyListener implements MouseListener{
	
	// declare sound variables
    public static String soundPath = "assets\\kaching.wav";
    private Clip audioClip;
    private AudioInputStream inputStream;
	
	/**
     * 
     * @apiNote Constructor for the BuyListener class
     * 
     */
    public BuyListener() {
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
            System.out.println("LineUnavailableException occured in the BuyListener class!");
        }
    }

    // implement these methods to fulfill abstraction
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {      
        // perform buy action
        int currentCookies = Main.getMainFrame().getCookies();
        int price = Main.getMainFrame().getGamePanel().getMultiPrice();
        
        if (currentCookies >= price) {
        	// set new values
        	Main.getMainFrame().setMultiplier(Main.getMainFrame().getMultiplier() + 1);
        	Main.getMainFrame().subtractCookies(price);
        	
        	// update game panel labels
        	Main.getMainFrame().getGamePanel().updateCookies(currentCookies - price);
        	Main.getMainFrame().getGamePanel().updateMultiplier(Main.getMainFrame().getMultiplier());
        	
            // play kaching audio
            audioClip.stop();
            audioClip.setFramePosition(0);
            audioClip.start();
        }
        else {
        	// play error sound
        	Toolkit.getDefaultToolkit().beep();
        }
	}


	public void mouseEntered(MouseEvent e) {
		// replace Image Icon of buy button with selected form
        JButton buyButton = (JButton) e.getSource();
        Utils.applyButtonImage(buyButton, "assets\\buySelected.png", 100, 80);
	}

	public void mouseExited(MouseEvent e) {
		// replace Image Icon of buy button with non-selected form
        JButton buyButton = (JButton) e.getSource();
        Utils.applyButtonImage(buyButton, "assets\\buy.png", 100, 80);
	}
}
