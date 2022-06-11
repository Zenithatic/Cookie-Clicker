package components;
import java.awt.*;
import javax.swing.*;
import myClasses.*;
import java.io.*;

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
	
	// panel IDS for the setCurrentPanel() method
	public static final int HOMEPANEL = 1;
	public static final int HELPPANEL = 2;
	public static final int SETTINGSPANEL = 3;
	public static final int LOADPANEL = 4;
	public static final int GAMEPANEL = 5;
	
	// file name IDS for the loadSlot() method
	public static final String COOKIE_FILE = "cookies.txt";

	// create global components
	private HomePanel home;
	private HelpPanel help;
	private SettingsPanel settings;
	private BackgroundMusicPlayer bmp;
	private LoadPanel load;
	private GamePanel game;

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
		// load saved volume from last time
		try {
			// read volumeConfig file and load up previous volume
			FileReader file = new FileReader("saves\\volumeConfig.txt");
			BufferedReader buffer = new BufferedReader(file);
			int vol = Integer.parseInt(buffer.readLine());
			// close writers
			buffer.close();
            file.close();
			// set volume
			bmp.setVolume((float) vol);

		} catch (IOException e) {
			// print traced error
			e.printStackTrace();
		}

		// add the Home panel
		home = new HomePanel();
		this.add(home);

		// create the Help panel
		help = new HelpPanel();

		// create the Settings panel
		settings = new SettingsPanel();
		
		// create the new Load panel
		load = new LoadPanel();
		
		// create the new Game panel
		game = new GamePanel();

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
		else if (id == LOADPANEL) {
			this.getContentPane().removeAll();
			this.getContentPane().add(load);
			this.getContentPane().invalidate();
			this.getContentPane().revalidate();
			this.getContentPane().repaint();
		}
		else if (id == GAMEPANEL) {
			this.getContentPane().removeAll();
			this.getContentPane().add(game);
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
	
	/**
	 * 
	 * @param slot - String
	 * @apiNote This method is used to load up data from a slot.
	 * 
	 */
	public void loadSlot(String slot) {
		// determine which slot to load
		String fileDirectoryToLoad= "";
		
		if (slot.equals("load1")) {
			fileDirectoryToLoad = "slot1";
		}
		else if (slot.equals("load2")) {
			fileDirectoryToLoad = "slot2";
		}
		else if (slot.equals("load3")) {
			fileDirectoryToLoad = "slot3";
		}
		
		// load slot 
		try {
			// declare required local variables
			File directory = new File("saves\\" + fileDirectoryToLoad);
			File[] fileList = directory.listFiles();
			
			// load data
			for (int i = 0; i < fileList.length; i++) {
				// create reader and read from file
				BufferedReader buffer = new BufferedReader(new FileReader(fileList[i]));
				int value = Integer.parseInt(buffer.readLine());
				buffer.close();

				// check what kind of data it is then load the data
				if (fileList[i].getName().equals(COOKIE_FILE)) {
					this.cookies = value;
					System.out.println(this.cookies);
				}
			}
		} catch (IOException e2) {
			// output traced error
			e2.printStackTrace();
		}
		
	}
}
