package listeners;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import main_pkg.Main;
import myClasses.Utils;
import javax.sound.sampled.*;

/**
 * 
 * The custom MouseListener for the Buy Farm button
 * @author Patrick Wang, Andrew Yoo
 *
 */
public class BuyFarmListener implements MouseListener{
	
	// declare sound variables
    public static String soundPath = "assets\\kaching.wav";
    private Clip audioClip;
    private AudioInputStream inputStream;
    
    /**
     * 
     *  Constructor for the MouseListener class
     * 
     */
    public BuyFarmListener() {
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
            System.out.println("LineUnavailableException occured in the BuyFarmListener class!");
        }
    }

	// implement these methods to fulfill abstraction
	public void mouseClicked(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}

	public void mousePressed(MouseEvent e) {
		// perform buy action
        int currentCookies = Main.getMainFrame().getCookies();
        int price = Main.getMainFrame().getGamePanel().getFarmPrice();
        
        if (currentCookies >= price) {
        	// set new values
        	Main.getMainFrame().setFarms(Main.getMainFrame().getFarms() + 1);
        	Main.getMainFrame().subtractCookies(price);
        	Main.getMainFrame().getGamePanel().updateFarmPrice();
        	
        	// update game panel labels
        	Main.getMainFrame().getGamePanel().updateCookies(currentCookies - price);
        	Main.getMainFrame().getGamePanel().getDescLabel().setText("<html><b><u>Farm</u></b><br><br>Farms 10 cookies per second<br><br>Owned: " + Main.getMainFrame().getFarms() + "<br>Next price: $" + Main.getMainFrame().getGamePanel().getFarmPrice() + "</html>");
        	
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
        Utils.applyButtonImage(buyButton, "assets\\buyFarmSelected.png", 250, 70);
        
        // show cursor upgrade info
        Main.getMainFrame().getGamePanel().getDescLabel().setText("<html><b><u>Farm</u></b><br><br>Farms 10 cookies per second<br><br>Owned: " + Main.getMainFrame().getFarms() + "<br>Next price: $" + Main.getMainFrame().getGamePanel().getFarmPrice() + "</html>");
	}

	public void mouseExited(MouseEvent e) {
		// replace Image Icon of buy button with non-selected form
        JButton buyButton = (JButton) e.getSource();
        Utils.applyButtonImage(buyButton, "assets\\buyFarm.png", 250, 70);
        
        // hide cursor upgrade info
        Main.getMainFrame().getGamePanel().getDescLabel().setText("");
	}
}
