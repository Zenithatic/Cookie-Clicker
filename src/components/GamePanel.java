package components;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import listeners.*;
import myClasses.Utils;

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
	private int nextMultiPrice = 0;
	
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
        cookie.setBounds(new Rectangle(345, 130, 300, 300));
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
	}
	
	/**
	 * 
	 * @param cookies - int
	 * @apiNote Method that the cookie count JPanel to the new amount of cookies
	 * 
	 */
	public void updateCookies(int cookies) {
		this.cookieCount.setText(String.valueOf(cookies) + "$");
	}
	
	/**
	 * 
	 * @param multiplier - int
	 * @apiNote Method that updates the multiplier label and price tag
	 * 
	 */
	public void updateMultiplier(int multiplier) {
		this.multiplierLabel.setText("Click Multiplier: " + multiplier + "x");
		this.nextMultiPrice = (multiplier + 1) * (multiplier) * 10;
		this.multiplierPriceLabel.setText("Upgrade: " + this.nextMultiPrice + "$");
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
