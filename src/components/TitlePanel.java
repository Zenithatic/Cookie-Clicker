package components;
import java.awt.*;
import javax.swing.*;
import listeners.*;
import myClasses.Utils;

import java.io.*;
import javax.imageio.ImageIO;

/**
 * 
 * @author Patrick Wang, Andrew Yoo
 * @apiNote The title panel for the game
 *
 */
public class TitlePanel extends JPanel{
	
	/**
	 * 
	 * @apiNote Contructor for the TitlePanel component
	 * 
	 */
	public TitlePanel() {
		// initialize panel
        this.setLayout(null);
        
        // create start button
        JButton start = new JButton();
        start.setBounds(new Rectangle(300, 400, 400, 200));
        start.setContentAreaFilled(false);
        start.setBorder(null);
        
        // apply image onto the start button
        Utils.applyButtonImage(start, "assets\\start.png", 400, 200);
        
        // add mouse listener to start button
        start.addMouseListener(new StartListener());
        
        this.add(start);
	}
	
	
	// paint graphics onto panel
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// apply background
		try {
			// get and draw image
			Image bg = ImageIO.read(new File("assets\\titlebg.png"));
			g.drawImage(bg, 0, 0, null);
		} catch (IOException e) {
			// print traced error
			e.printStackTrace();
		}
	}
}
