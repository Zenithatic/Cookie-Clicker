

/**
 * 
 * @author Patrick Wang, Andrew Yoo
 * @apiNote Main class where everything starts and is initialized.
 * 
 */
public class Main {
	
	// declare static components
	private static MainFrame game;
	
	/**
	 * 
	 * @apiNote Main method to intialize the entire program
	 * 
	 */
	public static void main(String[] args) {
		// Initalize game frame
		game = new MainFrame("Cookie Clickers");
		game.addCookies(0);
	}
	
	/**
	 * 
	 * @apiNote Constructor for the HomePanel component
	 * @return MainFrame for the game
	 *
	 */
	public static MainFrame getMainFrame(){
		// return the MainFrame 'game'
		return game;
	}
}
