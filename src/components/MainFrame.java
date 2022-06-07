package components;
import java.awt.*;
import javax.swing.*;
import myClasses.*;

/**
 * 
 * @author Patrick Wang, Andrew Yoo
 * @apiNote The Main JFrame where the game will be displayed and managed
 *
 */
public class MainFrame extends JFrame{
	// intialize final static fields
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 800;

	public static final int HOMEPANEL = 1;
	public static final int HELPPANEL = 2;
	public static final int SETTINGSPANEL = 3;

	// create global components
	HomePanel home;
	HelpPanel help;
	SettingsPanel settings;
	BackgroundMusicPlayer bmp;

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
		bmp = new BackgroundMusicPlayer();
		bmp.setVolume(0.0f);

		// add the Home panel
		home = new HomePanel();
		this.add(home);

		// create the Help panel
		help = new HelpPanel();

		// create the Settings panel
		settings = new SettingsPanel();


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
		// check for panel id and make that panel visible
		if (id == HOMEPANEL){
			this.getContentPane().removeAll();
			this.getContentPane().add(home);
			this.getContentPane().invalidate();
			this.getContentPane().revalidate();
			this.getContentPane().repaint();
		}
		else if (id == HELPPANEL){
			this.getContentPane().removeAll();
			this.getContentPane().add(help);
			this.getContentPane().invalidate();
			this.getContentPane().revalidate();
			this.getContentPane().repaint();
		}
		else if (id == SETTINGSPANEL){
			this.getContentPane().removeAll();
			this.getContentPane().add(settings);
			this.getContentPane().invalidate();
			this.getContentPane().revalidate();
			this.getContentPane().repaint();
		}
	}

	/**
	 * 
	 * @return BackgroundMusicPlayer of the game
	 * @apiNote This method returns the instance of the BackgroundMusicPlayer class in the game. 
	 * 
	 */
	public BackgroundMusicPlayer getMusic(){
		return this.bmp;
	}
}
