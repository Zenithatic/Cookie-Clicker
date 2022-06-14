
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
	private MainFrame mainFrame;
	private int nextMultiPrice = 0;
	
	/**
	 * 
	 * @apiNote Constructor for the GamePanel class
	 * 
	 */
	public GamePanel(MainFrame mainFrame) {
		// initialize panel
		this.setLayout(null);
		this.mainFrame = mainFrame;
		
		// create cookie count label
		cookieCount = new JLabel();
		cookieCount.setBounds(new Rectangle(345, 35, 300, 80));
		cookieCount.setHorizontalTextPosition(SwingConstants.CENTER);
		cookieCount.setFont(new Font("Showcard Gothic", Font.PLAIN, 40));
		cookieCount.setForeground(Color.BLACK);
		
		// set Image Icon of cookie count label
        try {
            // load and apply image
            Image cookieCountImage = ImageIO.read(new File("assets\\sign.png")).getScaledInstance(300, 80, java.awt.Image.SCALE_SMOOTH);
            cookieCount.setIcon(new ImageIcon(cookieCountImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
        
        // add cookieCount Jlabel
        this.add(cookieCount);
        
        
        // create cookie button
        JButton cookie = new JButton();
        cookie.setBounds(new Rectangle(345, 130, 300, 300));
        cookie.setContentAreaFilled(false);
        cookie.setBorder(null);
        
        // set Image Icon of cookie button
        try {
            // load and apply image
            Image cookieImage = ImageIO.read(new File("assets\\cookie.png")).getScaledInstance(300, 300, java.awt.Image.SCALE_SMOOTH);
            cookie.setIcon(new ImageIcon(cookieImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
        
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
        try {
            // load and apply image
            Image saveExitImage = ImageIO.read(new File("assets\\save_exit.png")).getScaledInstance(200, 80, java.awt.Image.SCALE_SMOOTH);
            save_and_exit.setIcon(new ImageIcon(saveExitImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
        
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
        try {
            // load and apply image
            Image saveImage = ImageIO.read(new File("assets\\save.png")).getScaledInstance(100, 80, java.awt.Image.SCALE_SMOOTH);
            save.setIcon(new ImageIcon(saveImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
        
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
        try {
            // load and apply image
            Image multiplierImage = ImageIO.read(new File("assets\\sign.png")).getScaledInstance(300, 80, java.awt.Image.SCALE_SMOOTH);
            multiplierLabel.setIcon(new ImageIcon(multiplierImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
        
        // add multiplier Jlabel
        this.add(multiplierLabel);
        
        
        // create next multiplier price label 
        multiplierPriceLabel = new JLabel();
        multiplierPriceLabel.setBounds(new Rectangle(5, 670, 300, 80));
        multiplierPriceLabel.setHorizontalTextPosition(SwingConstants.CENTER);
        multiplierPriceLabel.setFont(new Font("Showcard Gothic", Font.PLAIN, 22));
        multiplierPriceLabel.setForeground(Color.BLACK);
        
        // set Image Icon of multiplier price label
        try {
            // load and apply image
            Image multiplierImage = ImageIO.read(new File("assets\\sign.png")).getScaledInstance(300, 80, java.awt.Image.SCALE_SMOOTH);
            multiplierPriceLabel.setIcon(new ImageIcon(multiplierImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
        
        // add multiplier price Jlabel
        this.add(multiplierPriceLabel);
        
        
        // add buy button for the multiplier
        JButton buyMulti = new JButton();
        buyMulti.setBounds(new Rectangle(315, 670, 100, 80));
        buyMulti.setBorder(null);
        buyMulti.setContentAreaFilled(false);
        buyMulti.setName("multiplierUpgrade");
        
        // set Image Icon of multiplier buy button
        try {
            // load and apply image
            Image buyImage = ImageIO.read(new File("assets\\buy.png")).getScaledInstance(100, 80, java.awt.Image.SCALE_SMOOTH);
            buyMulti.setIcon(new ImageIcon(buyImage));
        } catch (IOException exception) {
            // output traced error
            exception.printStackTrace();
        }
        
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
