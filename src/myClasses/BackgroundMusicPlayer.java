package myClasses;
import java.io.*;
import javax.sound.sampled.*;;;

/**
 * 
 * @author Patrick Wang, Andrew Yoo
 * @apiNote A class to play the background music
 * 
 */
public class BackgroundMusicPlayer {

    // declare variables
    public static String musicPath = "assets\\bgMusic.wav";
    private Clip audioClip;
    private AudioInputStream inputStream;
    private FloatControl masterVolume;

    /**
     * 
     * @apiNote The constructor for the BackgroundMusicPlayer class
     * 
     */
    public BackgroundMusicPlayer(){
        // attempt to load and play music
        try{
            // load up audio stream and clip
            inputStream = AudioSystem.getAudioInputStream(new File(musicPath).getAbsoluteFile());
            audioClip = AudioSystem.getClip();

            // open the clip and set it to loop
            audioClip.open(inputStream);
            audioClip.loop(Clip.LOOP_CONTINUOUSLY);

            // create volume control
            masterVolume = (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
 
            // start music
            audioClip.start();
        }
        // catch exceptions and output traced errors
        catch (IOException e){
            e.printStackTrace();
        }
        catch (UnsupportedAudioFileException e){
            e.printStackTrace();
        }
        catch (LineUnavailableException e){
            System.out.println("LineUnavailableException occured in the BackgroundMusicPlayer class!");
        }
    }

    /**
     * 
     * @param decibels - float
     * @apiNote This method sets the decibel volume for the audio.
     * 
     */
    public void setVolume (float decibels){
		// set decibel offset
		// default decibel value: 0.0 (6.0206 max, -80.0 min) (70 preferred min)
        masterVolume.setValue(decibels);
    }
}
