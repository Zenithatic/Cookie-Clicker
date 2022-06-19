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
 * @author Patrick Wang, Andrew Yoo
 * @apiNote The custom MouseListener for the cookie button
 * 
 */
public class CookieListener implements MouseListener{
	
	// declare sound variables
    public static String soundPath = "assets\\cookieClick.wav";
    private Clip audioClip;
    private AudioInputStream inputStream;
	
    /**
     * 
     * @apiNote Constructor for the CookieListener class
     * 
     */
    public CookieListener() {
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
            System.out.println("LineUnavailableException occured in the CookieListener class!");
        }
    }
    
    
	// implement these methods to fulfill abstraction
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	
	public void mousePressed(MouseEvent e) {
        JButton cookieButton = (JButton) e.getSource();
        Utils.applyButtonImage(cookieButton, "assets\\cookieClicked.png", 270, 270);
    
        // set cookie size smaller
        cookieButton.setBounds(new Rectangle(360, 210, 270, 270));
        
        // add a cookie to the game
        Main.getMainFrame().addCookies(1 * Main.getMainFrame().getMultiplier());
        
        // update cookie count JPanel
        Main.getMainFrame().getGamePanel().updateCookies(Main.getMainFrame().getCookies());
        
        // play click sound
        audioClip.start();
	}
	
	public void mouseReleased(MouseEvent e) {
		// replace Image Icon of cookie button with non-selected form
        JButton cookieButton = (JButton) e.getSource();
        Utils.applyButtonImage(cookieButton, "assets\\cookie.png", 300, 300);

          
        // set cookie size back to normal
        cookieButton.setBounds(new Rectangle(345, 200, 300, 300));
        
        // reset audio clip
        audioClip.setFramePosition(0);
	}
}
