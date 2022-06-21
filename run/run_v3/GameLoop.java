
import java.lang.Runnable;


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
			int grandmaCookies = Main.getMainFrame().getGrandmas() * 3;
			int farmCookies = Main.getMainFrame().getFarms() * 10;
			int mineCookies = Main.getMainFrame().getMines() * 50;
			int factoryCookies = Main.getMainFrame().getFactories() * 250;
			
			int totalCookies = cursorCookies + grandmaCookies + farmCookies + mineCookies + factoryCookies; 
			
			// add cookies to game
			Main.getMainFrame().addCookies(totalCookies);
			
			// update cookies on JLabel
			Main.getMainFrame().getGamePanel().updateCookies(Main.getMainFrame().getCookies());
		}
	}
}
