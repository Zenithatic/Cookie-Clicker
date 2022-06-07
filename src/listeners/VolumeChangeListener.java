package listeners;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import main_pkg.Main;

/**
 * 
 * @author Patrick Wang
 * @apiNote The ChangeListener for when the user changes the volume
 * 
 */
public class VolumeChangeListener implements ChangeListener{
    public void stateChanged(ChangeEvent e){
        // set the value of the decibel controller to the value of the JSlider
        JSlider volumeSlider = (JSlider) e.getSource();
        int value = volumeSlider.getValue();
        if (value == -50){
            Main.getMainFrame().getMusic().setVolume(-80f);
        }
        else{
            Main.getMainFrame().getMusic().setVolume((float) value);
        }
    }
}
