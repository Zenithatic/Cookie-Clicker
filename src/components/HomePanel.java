package components;
import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.ImageIO;
import listeners.*;

/**
 * 
 * @author Patrick Wang, Andrew Yoo
 * @apiNote The first JPanel the user will see where there is an option to view settings, view how to play, and load data
 *
 */
public class HomePanel extends JPanel{
	/**
	 * 
	 * @apiNote Constructor for the HomePanel component
	 * 
	 */
	public HomePanel() {
		// starter methods
		this.setLayout(null);

		// add subpanel for buttons
		JPanel subPanel = new JPanel();
		subPanel.setOpaque(false);
		subPanel.setBounds(new Rectangle(350, 300, 300, 400));
		subPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 20));
		this.add(subPanel);

		// create play button
		JButton playButton = new JButton();
		playButton.setPreferredSize(new Dimension(300, 150));
		playButton.setContentAreaFilled(false);
		playButton.setBorder(null);
		// add play button image
		try {
			// get and set image
			Image playImage = ImageIO.read(new File("assets\\play.png")).getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
			playButton.setIcon(new ImageIcon(playImage));

		} catch (IOException e) {
			// output traced error
			e.printStackTrace();
		}
		// add a mouse listener to the button 
		playButton.addMouseListener(new PlayListener());
		// add play button to panel
		subPanel.add(playButton);

		// create help button
		JButton helpButton = new JButton();
		helpButton.setPreferredSize(new Dimension(300, 150));
		helpButton.setContentAreaFilled(false);
		helpButton.setBorder(null);
		// add help button image
		try {
			// get and set image
			Image helpImage = ImageIO.read(new File("assets\\help.png")).getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
			helpButton.setIcon(new ImageIcon(helpImage));

		} catch (IOException e) {
			// output traced error
			e.printStackTrace();
		}
		// add a mouse listener to the button 
		helpButton.addMouseListener(new HelpListener());
		// add help button to panel
		subPanel.add(helpButton);

		// create title label
		JLabel title = new JLabel();
		title.setBounds(new Rectangle(250, 50, 500, 200));
		// add title image
		try {
			// get and set image
			Image titleImage = ImageIO.read(new File("assets\\title.png")).getScaledInstance(500, 200, java.awt.Image.SCALE_SMOOTH);
			title.setIcon(new ImageIcon(titleImage));

		} catch (IOException e) {
			// output traced error
			e.printStackTrace();
		}
		// add title label to panel
		this.add(title);

		// create close button
		JButton closeButton = new JButton();
		closeButton.setBounds(new Rectangle(30, 30, 100, 100));
		closeButton.setContentAreaFilled(false);
		closeButton.setBorder(null);
		// add close image
		try {
			Image closeImage = ImageIO.read(new File("assets\\close.png")).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
			closeButton.setIcon(new ImageIcon(closeImage));

		} catch (IOException e) {
			// output traced error
			e.printStackTrace();
		}
		// add a mouse listener to the button 
		closeButton.addMouseListener(new CloseGameListener());
		// add close button to panel
		this.add(closeButton);

		// create settings button
		JButton settingsButton = new JButton();
		settingsButton.setBounds(new Rectangle(855, 30, 100, 100));
		settingsButton.setContentAreaFilled(false);
		settingsButton.setBorder(null);
		// add settings image
		try {
			Image settingsImage = ImageIO.read(new File("assets\\settingsGear.png")).getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
			settingsButton.setIcon(new ImageIcon(settingsImage));

		} catch (IOException e) {
			// output traced error
			e.printStackTrace();
		}
		// add a mouse listener to the button
		settingsButton.addMouseListener(new SettingsButtonListener());
		// add settings button to panel
		this.add(settingsButton);
	}
	
	// paint graphics onto panel
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// apply background
		try {
			// get and draw image
			Image bg = ImageIO.read(new File("assets\\background.png"));
			g.drawImage(bg, 0, 0, null);
		} catch (IOException e) {
			// print traced error
			e.printStackTrace();
		}
	}
}
