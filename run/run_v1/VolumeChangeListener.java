
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.io.*;


/**
 * 
 * @author Patrick Wang
 *  The ChangeListener for when the user changes the volume
 * 
 */
public class VolumeChangeListener implements ChangeListener{
    public void stateChanged(ChangeEvent e){
        // set the value of the decibel controller to the value of the JSlider
        JSlider volumeSlider = (JSlider) e.getSource();
        int value = volumeSlider.getValue();

        if (value == -50){
            // if decibels is -50, silence the song
            Main.getMainFrame().getMusic().setVolume(-80f);
        }
        else{
            Main.getMainFrame().getMusic().setVolume((float) value);
        }

        // save setting to a file
        try {
            FileWriter file = new FileWriter("saves\\volumeConfig.txt", false);
            BufferedWriter buffer = new BufferedWriter(file);
            buffer.write(String.valueOf(value));
            buffer.close();
            file.close();
        }
        // catch IOException
        catch (IOException exception){
            // output traced error
            exception.printStackTrace();
        }
    }
}
