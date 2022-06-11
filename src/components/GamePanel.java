package components;
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
	
	/**
	 * 
	 * @apiNote Constructor for the GamePanel class
	 * 
	 */
	public GamePanel() {
		// initialize panel
		this.setLayout(null);
		
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
