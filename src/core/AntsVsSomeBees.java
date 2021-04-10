package core;

<<<<<<< HEAD
=======
//import sun.audio.AudioData;
//import sun.audio.AudioPlayer;
//import sun.audio.AudioStream;
//import sun.audio.ContinuousAudioDataStream;

>>>>>>> 7c751d62f5fd997d19872b074fe580b34afe7a59
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * A driver for the Ants vs. Some-Bees game
 */
public class AntsVsSomeBees
{
	public static int startingFood = 25; // ==Niall== I just added this so that it could be easily identified and altered.

	public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		AntColony colony = new AntColony(3, 8, 0, startingFood); //specify the colony [tunnels, length, moats, food]
		//Hive hive = Hive.makeTestHive(); //specify the attackers (the hive)
		Hive hive = Hive.makeFullHive();
		//Hive hive = Hive.makeInsaneHive();
		new AntGame(colony,hive); //launch the game
<<<<<<< HEAD
		ThemeSong.themeSound("themesong.wav");//theme music for the game ==> David Afolabi
=======
		themeSound("themesong.wav"); //theme music for the game ==> David Afolabi


	}
	
	/**
	 * Author: David Afolabi
	 * Theme song
	 * the method below adds sound to the game
	 */
	public static void themeSound(String filepath) throws IOException, UnsupportedAudioFileException, LineUnavailableException {
		//Scanner scanner = new Scanner(System.in);
		File file = new File(filepath);
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start();
		int counter = 1;
		clip.loop(counter++);
		//String response = scanner.next();
>>>>>>> 7c751d62f5fd997d19872b074fe580b34afe7a59
	}
}
