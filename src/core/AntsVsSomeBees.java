package core;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * A driver for the Ants vs. Some-Bees game
 */
public class AntsVsSomeBees
{
	// The difficulty of this could be altered to change the number of bees spawned 
	
	public static JFrame mainMenu;
	public static JPanel menuPanel;
	private static JButton diff1;
	private static JButton diff2;
	private static JButton diff3;
	private static JButton close;
	public static final Dimension FRAME_SIZE = new Dimension(300,300);
	public static int diff = 0; // 1 for easy, 2 for medium, 3 for hard
	
	public static int startingFood = 25; // ==Niall== I just added this so that it could be easily identified and altered.
	private static MainMenu menu;
	
	/*
	 * Values related to the creation of a new instance of the game.
	 */
	
	public boolean difficultySelected;
	
	public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException, ClassNotFoundException 
	{	
		menu = new MainMenu(); // Launches the main menu where the game is started.
	}
	
	public static void launchGame(int tunnels, int length, int speed, int startingFood) throws IOException, UnsupportedAudioFileException, LineUnavailableException
	{
//		AntColony colony = new AntColony(3, 8,0, startingFood); //specify the colony [tunnels, length, moats, food]

		AntColony colony = new AntColony(tunnels, length, speed, startingFood); //specify the colony [tunnels, length, moats, food]
		//Hive hive = Hive.makeTestHive(); //specify the attackers (the hive)
		Hive hive = Hive.makeFullHive();
		//Hive hive = Hive.makeInsaneHive();
		new AntGame(colony,hive); //launch the game
		ThemeSong.themeSound("themesong.wav");//theme music for the game ==> David Afolabi
	}
	
}