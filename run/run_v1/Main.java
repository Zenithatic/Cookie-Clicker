

/**
 * 
 * @author Patrick Wang, Andrew Yoo
 *  Main class where everything starts and is initialized.
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
	 *  Constructor for the HomePanel component
	 * @return MainFrame for the game
	 *
	 */
	public static MainFrame getMainFrame(){
		// return the MainFrame 'game'
		return game;
	}
}
