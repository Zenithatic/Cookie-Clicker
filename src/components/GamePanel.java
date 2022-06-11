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
	/**
	 * 
	 * @apiNote Constructor for the GamePanel class
	 * 
	 */
	public GamePanel() {
		// initialize panel
		this.setLayout(null);
		
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
