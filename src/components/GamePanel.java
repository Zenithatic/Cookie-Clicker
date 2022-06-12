package components;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;

import listeners.CookieListener;

/**
 * 
 * @author Patrick Wang, Andrew Yoo
 * @apiNote The game panel where the user will be able to play Cookie Clickers
 *
 */
public class GamePanel extends JPanel{
	// declare instance variables
	private JLabel cookieCount;
	private MainFrame mainFrame;
	
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
		cookieCount.setFont(new Font("Showcard Gothic", Font.PLAIN, 45));
		cookieCount.setForeground(Color.WHITE);
		
		// set Image Icon of cookie count label
        try {
            // load and apply image
            Image cookieCountImage = ImageIO.read(new File("assets\\cookieCount.png")).getScaledInstance(300, 80, java.awt.Image.SCALE_SMOOTH);
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
        
        // set Image Icon of cookie label
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
	}
	
	public void updateData(int cookies) {
		cookieCount.setText(String.valueOf(cookies));
	}
	
	// paint graphics onto panel
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// apply background
		try {
            // get and draw image
			Image bg = ImageIO.read(new File("assets\\gamebg.png")).getScaledInstance(1000, 770, java.awt.Image.SCALE_SMOOTH);
			g.drawImage(bg, 0, 0, null);
		} catch (IOException e) {
			// print traced error
			e.printStackTrace();
		}
	}	
}
