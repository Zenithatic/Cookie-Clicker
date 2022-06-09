package components;
import java.awt.*;
import javax.swing.*;
import listeners.BackListener;
import listeners.LoadListener;
import listeners.ResetListener;

import java.io.*;
import javax.imageio.ImageIO;

/**
 * 
 * @author Patrick Wang, Andrew Yoo
 * @apiNote the JPanel where the user will be able to load up or reset their data
 *
 */
public class LoadPanel extends JPanel{
	/**
	 * 
	 * @apiNote Constructor for the LoadPanel component
	 * 
	 */
	public LoadPanel() {
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
        
        // add listener to back button
        goBack.addMouseListener(new BackListener());

        // add back button
        this.add(goBack);
        
        
        // create load button for slot 1
        JButton load1 = new JButton();
        load1.setContentAreaFilled(false);
        load1.setBorder(null);
        load1.setBounds(new Rectangle(25, 300, 300, 150));
        
        // apply image onto the load button
        try{
            // get and set image
            Image loadImage = ImageIO.read(new File("assets\\load.png")).getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
            load1.setIcon(new ImageIcon(loadImage));
        }
        catch (IOException e){
            // print out traced error
            e.printStackTrace();
        }
        
        // add load1 button
        this.add(load1);
        
        
        // create load button for slot 2
        JButton load2 = new JButton();
        load2.setContentAreaFilled(false);
        load2.setBorder(null);
        load2.setBounds(new Rectangle(348, 300, 300, 150));
        
        // apply image onto the load button
        try{
            // get and set image
            Image loadImage = ImageIO.read(new File("assets\\load.png")).getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
            load2.setIcon(new ImageIcon(loadImage));
        }
        catch (IOException e){
            // print out traced error
            e.printStackTrace();
        }
        
        // add load2 button
        this.add(load2);
        
        
        // create load button for slot 3
        JButton load3 = new JButton();
        load3.setContentAreaFilled(false);
        load3.setBorder(null);
        load3.setBounds(new Rectangle(670, 300, 300, 150));
        
        // apply image onto the load button
        try{
            // get and set image
            Image loadImage = ImageIO.read(new File("assets\\load.png")).getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
            load3.setIcon(new ImageIcon(loadImage));
        }
        catch (IOException e){
            // print out traced error
            e.printStackTrace();
        }
        
        // add load2 button
        this.add(load3);
        
        // add mouse listeners to 3 load buttons
        load1.addMouseListener(new LoadListener());
        load2.addMouseListener(new LoadListener());
        load3.addMouseListener(new LoadListener());
        
        // set ids (names) of 3 load buttons
        load1.setName("load1");
        load2.setName("load2");
        load3.setName("load3");
        
        
        // create reset button for slot 1
        JButton reset1 = new JButton();
        reset1.setContentAreaFilled(false);
        reset1.setBorder(null);
        reset1.setBounds(new Rectangle(25, 475, 300, 150));
        
        // apply image onto the reset button
        try{
            // get and set image
            Image resetImage = ImageIO.read(new File("assets\\reset.png")).getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
            reset1.setIcon(new ImageIcon(resetImage));
        }
        catch (IOException e){
            // print out traced error
            e.printStackTrace();
        }
        
        // add reset2 button
        this.add(reset1);
        
        
        // create reset button for slot 2
        JButton reset2 = new JButton();
        reset2.setContentAreaFilled(false);
        reset2.setBorder(null);
        reset2.setBounds(new Rectangle(348, 475, 300, 150));
        
        // apply image onto the reset button
        try{
            // get and set image
            Image resetImage = ImageIO.read(new File("assets\\reset.png")).getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
            reset2.setIcon(new ImageIcon(resetImage));
        }
        catch (IOException e){
            // print out traced error
            e.printStackTrace();
        }
        
        // add reset2 button
        this.add(reset2);
        
        
        // create reset button for slot 3
        JButton reset3 = new JButton();
        reset3.setContentAreaFilled(false);
        reset3.setBorder(null);
        reset3.setBounds(new Rectangle(670, 475, 300, 150));
        
        // apply image onto the reset button
        try{
            // get and set image
            Image resetImage = ImageIO.read(new File("assets\\reset.png")).getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
            reset3.setIcon(new ImageIcon(resetImage));
        }
        catch (IOException e){
            // print out traced error
            e.printStackTrace();
        }
        
        // add reset3 button
        this.add(reset3);
        
        // add mouse listeners to 3 reset buttons
        reset1.addMouseListener(new ResetListener());
        reset2.addMouseListener(new ResetListener());
        reset3.addMouseListener(new ResetListener());
        
        // set ids (name) of 3 reset buttons
        reset1.setName("reset1");
        reset2.setName("reset2");
        reset3.setName("reset3");
	}
	
	// paint graphics onto panel
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// apply background
		try {
            // get and draw image
			Image bg = ImageIO.read(new File("assets\\loadbg.png")).getScaledInstance(1000, 770, java.awt.Image.SCALE_SMOOTH);
			g.drawImage(bg, 0, 0, null);
		} catch (IOException e) {
			// print traced error
			e.printStackTrace();
		}
	}
}
