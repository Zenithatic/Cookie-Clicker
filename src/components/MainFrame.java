package components;
import java.awt.*;
import javax.swing.*;
import myClasses.*;
import java.io.*;

/**
 * 
 * The Main JFrame where the game will be displayed and managed
 * @author Patrick Wang, Andrew Yoo
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
	public static final String CURSOR_FILE = "cursors.txt";
	public static final String GRANDMA_FILE = "grandmas.txt";
	public static final String FARM_FILE = "farms.txt";
	public static final String MINE_FILE = "mines.txt";
	public static final String FACTORY_FILE = "factories.txt";

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
	private int cursors = 0;
	private int grandmas = 0;
	private int farms = 0;
	private int mines = 0;
	private int factories = 0;

	/**
	 * 
	 * Constructor for the Main JFrame component
	 * @param title - String
	 * 
	 */
	public MainFrame(String name) {
		// call frame initialization methods
		super(name);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(new Rectangle(0, 0, WIDTH, HEIGHT));

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
		
		// start game loop
		Thread gameLoop = new Thread(new GameLoop());
		gameLoop.start();
	}

	/**
	 * Getter method to get the amount of cookies
	 * @return int - amount of cookies in the game
	 */
	public int getCookies(){
		return this.cookies;
	}
	
	/**
	 * Method to get the current multiplier of the game
	 * @return multiplier - int
	 */
	public int getMultiplier() {
		return this.multiplier;
	}
	
	/**
	 * Setter method for multiplier
	 * @param multi - int
	 */
	public void setMultiplier(int multi) {
		this.multiplier = multi;
	}

	/**
	 * Method to add cookies to balance
	 * @param cookies
	 */
	public void addCookies(int cookies){
		this.cookies += cookies;
	}
	
	/**
	 * Method to subtract cookies to balance
	 * @param cookies - int
	 */
	public void subtractCookies(int cookies) {
		this.cookies -= cookies;
	}
	
	/**
	 * Method that returns the amount of cursors in the game
	 * @return amount of cursors user owns - int
	 */
	public int getCursors() {
		return this.cursors;
	}
	
	/**
	 * Method to set the amount of cursors in the game
	 * @param cursors - int
	 */
	public void setCursors(int cursors) {
		this.cursors = cursors;
	}
	
	/**
	 * Method that returns the amount of grandmas in the game
	 * @return amount of grandmas user owns - int
	 */
	public int getGrandmas() {
		return this.grandmas;
	}
	
	/**
	 * 
	 *  Method to set the amount of grandmas in the game
	 * @param grandmas - int
	 */
	public void setGrandmas(int grandmas) {
		this.grandmas = grandmas;
	}
	
	/**
	 *  Method that returns the amount of farms in the game
	 * @return amount of farms user owns - int
	 */
	public int getFarms() {
		return this.farms;
	}
	
	/**
	 *  Method to set the amount of farms in the game
	 * @param farms - int
	 */
	public void setFarms(int farms) {
		this.farms = farms;
	}
	
	/**
	 *  Method that returns the amount of mines in the game
	 * @return amount of mines user owns - int
	 */
	public int getMines() {
		return this.mines;
	}
	
	/**
	 * 
	 *  Method to set the amount of farms in the game
	 * @param farms - int
	 */
	public void setMines(int mines) {
		this.mines = mines;
	}
	
	/**
	 *  Method that returns the amount of mines in the game
	 * @return amount of factories user owns - int
	 */
	public int getFactories() {
		return this.factories;
	}
	
	/**
	 * 
	 *  Method to set the amount of factories in the game
	 * @param factories - int
	 * 
	 */
	public void setFactories(int factories) {
		this.factories = factories;
	}

	/**
	 *  Method to set the current visible panel
	 * @param int - id 
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
	 *  This method returns the instance of the BackgroundMusicPlayer class in the game. 
	 * @return BackgroundMusicPlayer of the game
	 */
	public BackgroundMusicPlayer getMusic(){
		return this.bmp;
	}
	
	/**
	 *  This method returns the instance of the current GamePanel.
	 * @return the game panel - GamePanel
	 */
	public GamePanel getGamePanel() {
		return this.game;
	}
	
	/**
	 *  This method returns the current loaded slot number in the game
	 * @return current slot number - int
	 */
	public int getSlot() {
		return this.currentSlot;
	}
	
	/**
	 *  This method is used to load up data from a slot.
	 * @param slot - String
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
				else if (fileName.equals(CURSOR_FILE)) {
					this.cursors = value;
				}
				else if (fileName.equals(GRANDMA_FILE)) {
					this.grandmas = value;
				}
				else if (fileName.equals(FARM_FILE)) {
					this.farms = value;
				}
				else if (fileName.equals(MINE_FILE)) {
					this.mines = value;
				}
				else if (fileName.equals(FACTORY_FILE)) {
					this.factories = value;
				}
			}
		} catch (IOException e2) {
			// output traced error
			e2.printStackTrace();
		}
		
		// update data
		game.updateCookies(this.cookies);
		game.updateMultiplier(this.multiplier);
		game.updateCursorPrice();
		game.updateGrandmaPrice();
		game.updateFarmPrice();
		game.updateMinePrice();
		game.updatePerSec();
		game.updateFactoryPrice();
	}
}
