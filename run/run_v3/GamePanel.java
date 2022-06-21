
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;



/**
 * 
 * @author Patrick Wang, Andrew Yoo
 * @apiNote The game panel where the user will be able to play Cookie Clickers
 *
 */
public class GamePanel extends JPanel{
	// declare instance variables
	private JLabel cookieCount;
	private JLabel multiplierLabel;
	private JLabel multiplierPriceLabel;
	private JLabel cookiesPerSecond;
	private JLabel upgradeDescription;
	
	private int nextMultiPrice = 0;
	private int nextCursorPrice = 0;
	private int nextGrandmaPrice = 0;
	private int nextFarmPrice = 0;
	private int nextMinePrice = 0;
	private int nextFactoryPrice = 0;
	
	/**
	 * 
	 * @apiNote Constructor for the GamePanel class
	 * 
	 */
	public GamePanel(MainFrame mainFrame) {
		// initialize panel
		this.setLayout(null);
		
		// create cookie count label
		cookieCount = new JLabel();
		cookieCount.setBounds(new Rectangle(345, 35, 300, 80));
		cookieCount.setHorizontalTextPosition(SwingConstants.CENTER);
		cookieCount.setFont(new Font("Showcard Gothic", Font.PLAIN, 40));
		cookieCount.setForeground(Color.BLACK);
		
		// set Image Icon of cookie count label
        Utils.applyLabelImage(cookieCount, "assets\\sign.png", 300, 80);
        
        // add cookieCount Jlabel
        this.add(cookieCount);
        
        
        // create cookie button
        JButton cookie = new JButton();
        cookie.setBounds(new Rectangle(345, 200, 300, 300));
        cookie.setContentAreaFilled(false);
        cookie.setBorder(null);
        
        // set Image Icon of cookie button
        Utils.applyButtonImage(cookie, "assets\\cookie.png", 300, 300);
        
        // add mouse listener to cookie button
        cookie.addMouseListener(new CookieListener());
        
        // add cookie button
        this.add(cookie);
        
        
        // create save and exit button
        JButton save_and_exit = new JButton();
        save_and_exit.setBounds(new Rectangle(5, 5, 200, 80));
        save_and_exit.setContentAreaFilled(false);
        save_and_exit.setBorder(null);
        
        // set Image Icon of save and exit button
        Utils.applyButtonImage(save_and_exit, "assets\\save_exit.png", 200, 80);
        
        // add mouse listener to button
        save_and_exit.addMouseListener(new SaveExitListener());
        
        // add save and exit button
        this.add(save_and_exit);
        
        
        // create save button
        JButton save = new JButton();
        save.setBounds(new Rectangle(5, 90, 100, 80));
        save.setContentAreaFilled(false);
        save.setBorder(null);
        
        // set Image Icon of save button
        Utils.applyButtonImage(save, "assets\\save.png", 100, 80);
        
        // add mouse listener to save button
        save.addMouseListener(new SaveListener());
        
        // add save button
        this.add(save);
        
        
        // create multiplier label 
        multiplierLabel = new JLabel();
        multiplierLabel.setBounds(new Rectangle(5, 580, 300, 80));
        multiplierLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        multiplierLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
        multiplierLabel.setForeground(Color.BLACK);
        
        // set Image Icon of multiplier label
        Utils.applyLabelImage(multiplierLabel, "assets\\sign.png", 300, 80);
        
        // add multiplier Jlabel
        this.add(multiplierLabel);
        
        
        // create next multiplier price label 
        multiplierPriceLabel = new JLabel();
        multiplierPriceLabel.setBounds(new Rectangle(5, 670, 300, 80));
        multiplierPriceLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        multiplierPriceLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
        multiplierPriceLabel.setForeground(Color.BLACK);
        
        // set Image Icon of multiplier price label
        Utils.applyLabelImage(multiplierPriceLabel, "assets\\sign.png", 300, 80);
        
        // add multiplier price Jlabel
        this.add(multiplierPriceLabel);
        
        
        // add buy button for the multiplier
        JButton buyMulti = new JButton();
        buyMulti.setBounds(new Rectangle(315, 670, 100, 80));
        buyMulti.setBorder(null);
        buyMulti.setContentAreaFilled(false);
        buyMulti.setName("multiplierUpgrade");
        
        // set Image Icon of multiplier buy button
        Utils.applyButtonImage(buyMulti, "assets\\buy.png", 100, 80);
        
        // add mouse listener to button
        buyMulti.addMouseListener(new BuyListener());
        
        // add buy button to panel
        this.add(buyMulti);
        
        
        // create cookies per sec label
        cookiesPerSecond = new JLabel("Per second: ");
        cookiesPerSecond.setBounds(new Rectangle(370, 120, 250, 70));
        cookiesPerSecond.setHorizontalTextPosition(SwingConstants.CENTER);
        cookiesPerSecond.setFont(new Font("Showcard Gothic", Font.PLAIN, 20));
        cookiesPerSecond.setForeground(Color.BLACK);
        Utils.applyLabelImage(cookiesPerSecond, "assets\\sign.png", 250, 70);
        
        this.add(cookiesPerSecond);
        
        // add description of upgrade panel
        upgradeDescription = new JLabel();
        upgradeDescription.setBounds(new Rectangle(700, 50, 250, 250));
        upgradeDescription.setForeground(Color.WHITE);
        upgradeDescription.setFont(new Font("Comic Sans MS", Font.PLAIN, 22));
        upgradeDescription.setOpaque(false);
        upgradeDescription.setVerticalAlignment(SwingConstants.TOP);
        this.add(upgradeDescription);
        
        // create buy cursor button
        JButton buyCursor = new JButton();
        buyCursor.setBounds(new Rectangle(700, 300, 250, 70));
        buyCursor.setBorder(null);
        buyCursor.setContentAreaFilled(false);
        Utils.applyButtonImage(buyCursor, "assets\\buyCursor.png", 250, 70);
        buyCursor.addMouseListener(new BuyCursorListener());
        this.add(buyCursor);
        
        // create buy grandma button
        JButton buyGrandma = new JButton();
        buyGrandma.setBounds(new Rectangle(700, 380, 250, 70));
        buyGrandma.setBorder(null);
        buyGrandma.setContentAreaFilled(false);
        Utils.applyButtonImage(buyGrandma, "assets\\buyGrandma.png", 250, 70);
        buyGrandma.addMouseListener(new BuyGrandmaListener());
        this.add(buyGrandma);
        
        // create buy farm button
        JButton buyFarm = new JButton();
        buyFarm.setBounds(new Rectangle(700, 460, 250, 70));
        buyFarm.setBorder(null);
        buyFarm.setContentAreaFilled(false);
        Utils.applyButtonImage(buyFarm, "assets\\buyFarm.png", 250, 70);
        buyFarm.addMouseListener(new BuyFarmListener());
        this.add(buyFarm);
        
        // create buy mine button
        JButton buyMine = new JButton();
        buyMine.setBounds(new Rectangle(700, 540, 250, 70));
        buyMine.setBorder(null);
        buyMine.setContentAreaFilled(false);
        Utils.applyButtonImage(buyMine, "assets\\buyMine.png", 250, 70);
        buyMine.addMouseListener(new BuyMineListener());
        this.add(buyMine);
        
        // create buy factory button
        JButton buyFactory = new JButton();
        buyFactory.setBounds(new Rectangle(700, 620, 250, 70));
        buyFactory.setBorder(null);
        buyFactory.setContentAreaFilled(false);
        Utils.applyButtonImage(buyFactory, "assets\\buyFactory.png", 250, 70);
        buyFactory.addMouseListener(new BuyFactoryListener());
        this.add(buyFactory);
	}
	
	/**
	 * @param cookies - int
	 * @apiNote Method that the cookie count JPanel to the new amount of cookies
	 */
	public void updateCookies(int cookies) {
		this.cookieCount.setText(String.valueOf(cookies) + "$");
	}
	
	/**
	 * @param multiplier - int
	 * @apiNote Method that updates the multiplier label and price tag
	 */
	public void updateMultiplier(int multiplier) {
		this.multiplierLabel.setText("Click Multiplier: " + multiplier + "x");
		this.nextMultiPrice = (multiplier + 1) * (multiplier) * 10;
		this.multiplierPriceLabel.setText("Upgrade: " + this.nextMultiPrice + "$");
	}
	
	/**
	 * @apiNote Method to update the cookies per second label
	 */
	public void updatePerSec() {
		// initial value
		int perSecond = 0;
		
		// add cursor value
		int cursors = Main.getMainFrame().getCursors();
		perSecond += cursors * 1;
		
		// add grandma value
		int grandmas = Main.getMainFrame().getGrandmas();
		perSecond += grandmas * 3;
		
		// add farm value
		int farms = Main.getMainFrame().getFarms();
		perSecond += farms * 10;
		
		// add mine value
		int mines = Main.getMainFrame().getMines();
		perSecond += mines * 50;
		
		// add factory value
		int factories = Main.getMainFrame().getFactories();
		perSecond += factories * 250;
		
		
		// update JLabel
		cookiesPerSecond.setText("Per second: " + perSecond + "$");
	}
	
	/**
	 * @apiNote Method to update the next cursor price
	 */
	public void updateCursorPrice() {
		this.nextCursorPrice = Main.getMainFrame().getCursors() * Main.getMainFrame().getCursors() + 10;
	}
	
	/**
	 * @apiNote Method to update the next grandma price
	 */
	public void updateGrandmaPrice() {
		this.nextGrandmaPrice = Main.getMainFrame().getGrandmas() * Main.getMainFrame().getGrandmas() + 200;
	}
	
	/**
	 * @apiNote Method to update the next farm price
	 */
	public void updateFarmPrice() {
		this.nextFarmPrice = Main.getMainFrame().getFarms() * Main.getMainFrame().getFarms() + 1000;
	}
	
	/**
	 * @apiNote Method to update the next mine price
	 */
	public void updateMinePrice() {
		this.nextMinePrice = Main.getMainFrame().getMines() * Main.getMainFrame().getMines() + 5000;
	}
	
	/**
	 * @apiNote Method to update the next mine price
	 */
	public void updateFactoryPrice() {
		this.nextFactoryPrice = Main.getMainFrame().getFactories() * Main.getMainFrame().getFactories() + 25000;
	}
	
	
	/**
	 * 
	 * @return the price for the next multiplier - int
	 * @apiNote Method that returns the next multiplier upgrade price
	 * 
	 */
	public int getMultiPrice() {
		return this.nextMultiPrice;
	}
	
	/**
	 * 
	 * @return the price for the next cursor - int
	 * @apiNote Method that returns the next cursor upgrade price
	 * 
	 */
	public int getCursorPrice() {
		return this.nextCursorPrice;
	}
	
	/**
	 * 
	 * @return the price for the next farm - int
	 * @apiNote Method that returns the next farm upgrade price
	 * 
	 */
	public int getFarmPrice() {
		return this.nextFarmPrice;
	}
	
	/**
	 * 
	 * @return the price for the next grandma - int
	 * @apiNote Method that returns the next grandma upgrade price
	 * 
	 */
	public int getGrandmaPrice() {
		return this.nextGrandmaPrice;
	}
	
	/**
	 * 
	 * @return the price for the next mine - int
	 * @apiNote Method that returns the next mine upgrade price
	 * 
	 */
	public int getMinePrice() {
		return this.nextMinePrice;
	}
	
	/**
	 * 
	 * @return the price for the next factory - int
	 * @apiNote Method that returns the next factory upgrade price
	 * 
	 */
	public int getFactoryPrice() {
		return this.nextFactoryPrice;
	}
	
	/**
	 * 
	 * @return upgrade description label - JLabel
	 * @apiNote Method that returns the upgrade desc JLabel
	 * 
	 */
	public JLabel getDescLabel() {
		return this.upgradeDescription;
	}
	
	
	// paint graphics onto panel
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// apply background
		try {
            // get and draw image
			Image bg = ImageIO.read(new File("assets\\background.png")).getScaledInstance(1000, 770, java.awt.Image.SCALE_SMOOTH);
			g.drawImage(bg, 0, 0, null);
		} catch (IOException e) {
			// print traced error
			e.printStackTrace();
		}
	}	
}
