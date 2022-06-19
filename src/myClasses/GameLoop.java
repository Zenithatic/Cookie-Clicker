package myClasses;
import java.lang.Runnable;

import main_pkg.Main;

/**
 * 
 * @author Patrick Wang, Andrew Yoo
 * @apiNote Game loop class to manage automatic cookies, etc
 *
 */
public class GameLoop implements Runnable{
	
	// run method 
	@Override
	public void run() {
		// run game loop
		while (true) {
			// rest for a second
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// calculate cookies to generate
			int cursorCookies = Main.getMainFrame().getCursors();
			int grandmaCookies = Main.getMainFrame().getGrandmas() * 5;
			
			int totalCookies = cursorCookies + grandmaCookies; 
			
			// add cookies to game
			Main.getMainFrame().addCookies(totalCookies);
			
			// update cookies on JLabel
			Main.getMainFrame().getGamePanel().updateCookies(Main.getMainFrame().getCookies());
		}
	}
}