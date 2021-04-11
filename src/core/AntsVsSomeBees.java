package core;

import javax.sound.sampled.*;
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
<<<<<<< HEAD
		new AntGame(colony, hive); //launch the game
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
=======
		new AntGame(colony,hive); //launch the game
		ThemeSong.themeSound("themesong.wav");//theme music for the game ==> David Afolabi
>>>>>>> 7c7564b025f5175e94bdff34d96b0af70587e753
	}
}
