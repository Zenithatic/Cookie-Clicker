
import java.awt.*;
import javax.swing.*;
import java.io.*;

/**
 * 
 * @author Patrick Wang, Andrew Yoo
 *  The Main JFrame where the game will be displayed and managed
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
	public static final String MULTIPLIER_FILE = "multiplier.txt";

	// create global components
	private HomePanel home;
	private HelpPanel help;
	private SettingsPanel settings;
	private BackgroundMusicPlayer bmp;
	private LoadPanel load;
	private GamePanel game;
	private TitlePanel title;

	// initialize game data variables
	private int currentSlot = 0;
	private int cookies = 0;
	private int multiplier = 1;

	/**
	 * 
	 * @param title - String
	 *  Constructor for the Main JFrame component
	 * 
	 */
	public MainFrame(String name) {
		// call frame initialization methods
		super(name);
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
		
		// add the title panel
		title = new TitlePanel();
		this.add(title);
		
		// create the Home panel
		home = new HomePanel();

		// create the Help panel
		help = new HelpPanel();

		// create the Settings panel
		settings = new SettingsPanel();
		
		// create the new Load panel
		load = new LoadPanel();
		
		// create the new Game panel
		game = new GamePanel(this);

		// set the frame to visible
		this.setVisible(true);
	}

	/**
	 *  Getter method to get the amount of cookies
	 * @return int - amount of cookies in the game
	 */
	public int getCookies(){
		return this.cookies;
	}
	
	/**
	 * @return multiplier - int
	 *  Method to get the current multiplier of the game
	 */
	public int getMultiplier() {
		return this.multiplier;
	}
	
	/**
	 * @param multi - int
	 *  Setter method for multiplier
	 */
	public void setMultiplier(int multi) {
		this.multiplier = multi;
	}

	/**
	 *  Method to add cookies to balance
	 * @param cookies
	 */
	public void addCookies(int cookies){
		this.cookies += cookies;
	}
	
	/**
	 * @param cookies - int
	 *  Method to subtract cookies to balance
	 */
	public void subtractCookies(int cookies) {
		this.cookies -= cookies;
	}

	/**
	 * @param int - id 
	 *  Method to set the current visible panel
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
	 * @return BackgroundMusicPlayer of the game
	 *  This method returns the instance of the BackgroundMusicPlayer class in the game. 
	 */
	public BackgroundMusicPlayer getMusic(){
		return this.bmp;
	}
	
	/**
	 * @return the game panel - GamePanel
	 *  This method returns the instance of the current GamePanel.
	 */
	public GamePanel getGamePanel() {
		return this.game;
	}
	
	/**
	 * @return current slot number - int
	 *  This method returns the current loaded slot number in the game
	 */
	public int getSlot() {
		return this.currentSlot;
	}
	
	/**
	 * @param slot - String
	 *  This method is used to load up data from a slot.
	 */
	public void loadSlot(String slot) {
		// determine which slot to load
		String fileDirectoryToLoad= "";
		
		if (slot.equals("load1")) {
			fileDirectoryToLoad = "slot1";
			this.currentSlot = 1;
		}
		else if (slot.equals("load2")) {
			fileDirectoryToLoad = "slot2";
			this.currentSlot = 2;
		}
		else if (slot.equals("load3")) {
			fileDirectoryToLoad = "slot3";
			this.currentSlot = 3;
		}
		
		// load slot 
		try {
			// declare required local variables
			File directory = new File("saves\\" + fileDirectoryToLoad);
			File[] fileList = directory.listFiles();
			
			// load data
			for (int i = 0; i < fileList.length; i++) {
				// create reader and read from file
				FileReader file = new FileReader(fileList[i]);
				BufferedReader buffer = new BufferedReader(file);
				int value = Integer.parseInt(buffer.readLine());
				buffer.close();
				
				String fileName = fileList[i].getName();
				
				// check what kind of data it is then load the data
				if (fileName.equals(COOKIE_FILE)) {
					this.cookies = value;
				}
				else if (fileName.equals(MULTIPLIER_FILE)) {
					this.multiplier = value;
				}
			}
		} catch (IOException e2) {
			// output traced error
			e2.printStackTrace();
		}
		
		// update data
		game.updateCookies(this.cookies);
		game.updateMultiplier(this.multiplier);
	}
}
