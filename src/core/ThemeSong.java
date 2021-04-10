package core;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class ThemeSong {
    /**
     * Author: David Afolabi
     * Theme song
     * the method below adds sound to the game
     */
    public static void themeSound(String filepath) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        File file = new File(filepath);
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        Clip clip = AudioSystem.getClip();
        clip.open(audioInputStream);
        clip.start();
        int counter = 1;
        clip.loop(counter++);
    }
}
