package main_pkg;
import components.*;

/**
 * 
 * @author Patrick Wang, Andrew Yoo
 * @apiNote Main class where everything starts and is initialized.
 */

public class Main {
	
	// declare static components
	private static MainFrame game;
	
	public static void main(String[] args) {
		// Initalize game frame
		game = new MainFrame("Cookie Clickers");
		game.addCookies(0);
	}

	public static MainFrame getMainFrame(){
		return game;
	}
	
}
