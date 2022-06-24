package main_pkg;
import components.*;

/**
 * 
 * Main class where everything starts and is initialized.
 * @author Patrick Wang, Andrew Yoo
 * 
 */
public class Main {
	
	// declare static components
	private static MainFrame game;
	
	/**
	 * 
	 *  Main method to intialize the entire program
	 * 
	 */
	public static void main(String[] args) {
		// Initalize game frame
		game = new MainFrame("Cookie Clickers");
		game.addCookies(0);
	}
	
	/**
	 * 
	 * Method to return the MainFrame of the game
	 * @return MainFrame for the game
	 *
	 */
	public static MainFrame getMainFrame(){
		// return the MainFrame 'game'
		return game;
	}
}
