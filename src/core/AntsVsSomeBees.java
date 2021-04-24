package core;

import javax.sound.sampled.*;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.io.IOException;

/**
 * A driver for the Ants vs. Some-Bees game
 */
public class AntsVsSomeBees
{
	private static MainMenu menu;
	
	/*
	 * Values related to the creation of a new instance of the game.
	 */
	
	public boolean difficultySelected;
	
	public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException, ClassNotFoundException 
	{	
		menu = new MainMenu(); // Launches the main menu where the game is started.
	}
	
	static void launchGame(int tunnels, int length, int speed, int startingFood) throws IOException, UnsupportedAudioFileException, LineUnavailableException
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