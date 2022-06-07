package components;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import listeners.*;

/**
 * 
 * @author Patrick Wang, Andrew Yoo
 * @apiNote the JPanel subclass for the settings page
 * 
 */
public class SettingsPanel extends JPanel{
    /**
     * 
     * @apiNote Constructor for the SettingsPanel component
     * 
     */
    public SettingsPanel(){
        // initialize panel
        this.setLayout(null);

        // create back button
        JButton goBack = new JButton();
        goBack.setContentAreaFilled(false);
        goBack.setBorder(null);
        goBack.setBounds(new Rectangle(0, 0, 100, 100));

        // apply image onto the back button
        try{
            // get and set image
            Image backImage = ImageIO.read(new File("assets\\back.png")).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
            goBack.setIcon(new ImageIcon(backImage));
        }
        catch (IOException e){
            // print out traced error
            e.printStackTrace();
        }

        // re-use HelpBackListener and add it to the back button
        goBack.addMouseListener(new HelpBackListener());

        // add button to panel
        this.add(goBack);
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
