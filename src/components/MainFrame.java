package components;
import java.awt.*;
import javax.swing.*;
import myClasses.*;


/**
 * 
 * @author Patrick Wang
 * @apiNote The Main JFrame where the game will be displayed and managed
 *
 */
public class MainFrame extends JFrame{

	private static final long serialVersionUID = 1L;
	
	// intialize final static fields
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 800;
	public static final int HOMEPANEL = 1;
	public static final int HELPPANEL = 2;

	// create global components
	HomePanel home;
	HelpPanel help;

	// initialize game data variables
	private int cookies = 0;

	/**
	 * 
	 * @param title - String
	 * @apiNote Constructor for the Main JFrame component
	 * 
	 */
	public MainFrame(String title) {
		// call frame initialization methods
		super(title);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(new Rectangle(100, 100, WIDTH, HEIGHT));

		// instantiate the BackgroundMusicPlayer class
		BackgroundMusicPlayer bmp = new BackgroundMusicPlayer();
		bmp.setVolume(0.0f);

		// add the Home panel
		home = new HomePanel();
		this.add(home);

		// create the Help panel
		help = new HelpPanel();



		// set the frame to visible
		this.setVisible(true);
	}

	/**
	 * @apiNote Getter method to get the amount of cookies
	 * @return int - amount of cookies in the game
	 */
	public int getCookies(){
		return this.cookies;
	}

	/**
	 * @apiNote Method to add cookies to balance
	 * @param cookies
	 */
	public void addCookies(int cookies){
		this.cookies += cookies;
	}

	/**
	 * 
	 * @param int - id 
	 * @apiNote Method to set the current visible panel
	 * 
	 */
	public void setCurrentPanel(int id){
		if (id == HOMEPANEL){
			this.add(home);
			this.remove(help);
			this.revalidate();
			this.repaint();
		}
		else if (id == HELPPANEL){
			this.add(help);
			this.remove(home);
			this.revalidate();
			this.repaint();
		}
	}
	
}
