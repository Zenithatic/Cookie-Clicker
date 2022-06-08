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

        // re-use BackListener and add it to the back button
        goBack.addMouseListener(new BackListener());

        // add button to panel
        this.add(goBack);

        // read previous volume
        int vol = 0;
		try {
			// read volumeConfig file and load up previous volume
			FileReader file = new FileReader("saves\\volumeConfig.txt");
			BufferedReader buffer = new BufferedReader(file);
			vol = Integer.parseInt(buffer.readLine());
            // close readers
            buffer.close();
            file.close();

		} catch (IOException e) {
			// print traced error
			e.printStackTrace();
		}

        // create JSlider for volume and customize it
        JSlider volume = new JSlider(-50, 0, vol);
        volume.setPaintTicks(true);
        volume.setPaintLabels(true);
        volume.setMajorTickSpacing(10);
        volume.setMinorTickSpacing(1);
        volume.setLabelTable(volume.createStandardLabels(10));
        volume.setBounds(new Rectangle(375, 158, 500, 55));
        volume.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        
        // add change listener to slider
        volume.addChangeListener(new VolumeChangeListener());
        this.add(volume);

    }

    // paint graphics onto panel
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// apply background
		try {
            // get and draw image
			Image bg = ImageIO.read(new File("assets\\settingsbg.png")).getScaledInstance(1000, 770, java.awt.Image.SCALE_SMOOTH);
			g.drawImage(bg, 0, 0, null);
		} catch (IOException e) {
			// print traced error
			e.printStackTrace();
		}
	}
}
