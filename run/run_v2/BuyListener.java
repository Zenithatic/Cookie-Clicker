
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.sound.sampled.*;

/**
 * 
 * @author Patrick Wang, Andrew Yoo
 *  The custom MouseListener for buy JButtons
 *
 */
public class BuyListener implements MouseListener{
	
	// declare sound variables
    public static String soundPath = "assets\\kaching.wav";
    private Clip audioClip;
    private AudioInputStream inputStream;
	
	/**
     * 
     *  Constructor for the CookieListener class
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
		// replace Image Icon of buy button with non-selected form
        JButton buyButton = (JButton) e.getSource();
        try {
            // load and apply image
            Image buyImage = ImageIO.read(new File("assets\\buy.png")).getScaledInstance(100, 80, java.awt.Image.SCALE_SMOOTH);
            buyButton.setIcon(new ImageIcon(buyImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
        
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
        try {
            // load and apply image
            Image buyImage = ImageIO.read(new File("assets\\buySelected.png")).getScaledInstance(100, 80, java.awt.Image.SCALE_SMOOTH);
            buyButton.setIcon(new ImageIcon(buyImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
	}

	public void mouseExited(MouseEvent e) {
		// replace Image Icon of buy button with non-selected form
        JButton buyButton = (JButton) e.getSource();
        try {
            // load and apply image
            Image buyImage = ImageIO.read(new File("assets\\buy.png")).getScaledInstance(100, 80, java.awt.Image.SCALE_SMOOTH);
            buyButton.setIcon(new ImageIcon(buyImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
	}
}
