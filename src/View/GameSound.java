package View;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * Class that implements sound into the game.
 *
 * @author Marc Larsen, Marcus Hansen, Mathias Mortensen, Simon Pileborg.
 */

public class GameSound {

    private Clip clip;

    public GameSound(String filename){

        // Open sound file as InputStream
        File soundFile = new File(filename);
        AudioInputStream audioIn;

        try {
            audioIn = AudioSystem.getAudioInputStream(soundFile);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }


        try {
            this.clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }

        try {
            this.clip.open(audioIn);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

    }

    public void play(){
        if (clip.isRunning()){
            clip.stop();
        }
        clip.setFramePosition(0);
        clip.start();
    }
}
