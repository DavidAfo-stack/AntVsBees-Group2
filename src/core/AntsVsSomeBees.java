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

	public static void main(String[] args) throws IOException, UnsupportedAudioFileException, LineUnavailableException 
	{
		setUpMenu();
		setUpPanel();
		setUpButtons();
		
		while (diff == 0)
			handleButtons();
		
		mainMenu.dispose();
		// System.exit(0);
	}
	
	private static void handleButtons() throws IOException, UnsupportedAudioFileException, LineUnavailableException
	{
		System.out.println("Handling Buttons");
		
		if (diff1.getModel().isPressed())
		{
			// Easy selected
			System.out.println("Easy Selected");
			diff = 1;
			
			launchGame(1, 8, 4, 40); // Spawns 1 tunnel that is 8 places in length, turn length is 4 seconds and starting food is 40.
		}
		
		if (diff2.getModel().isPressed())
		{
			// Medium selected
			System.out.println("Medium Selected");
			diff = 2;
			
			launchGame(3, 8, 3, 25); // Spawns 3 tunnels that are 8 places in length, turn length is 3 seconds and starting food is 25
		}
		if (diff3.getModel().isPressed())
		{
			// Hard Selected
			System.out.println("Hard Selected");
			diff = 3;
			
			launchGame(4, 7, 2, 30); // Spawns 4 tunnels that are 7 places in length, turn length is 2 seconds and starting food is 20
		}
		if (close.getModel().isPressed())
		{
			System.out.println("Closing Game");
			System.exit(0);
		}
	}
	
	private static void setUpMenu()
	{
		mainMenu = new JFrame("Ants vs some Bees Main Menu");
		mainMenu.setSize(FRAME_SIZE);
		mainMenu.setResizable(false);
		mainMenu.setLayout(null);
		mainMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainMenu.setVisible(true);
	}
	
	private static void setUpPanel()
	{
		menuPanel = new JPanel();
		menuPanel.setBounds(80, 80, 100, 150);
		// menuPanel.setLayout(new GridBagLayout()); // Centres the buttons.
		// menuPanel.setAlignmentY(Component.CENTER_ALIGNMENT);
		menuPanel.setVisible(true);
		mainMenu.add(menuPanel);
	}
	
	private static void setUpButtons()
	{
		diff1 = new JButton("Easy");
		diff2 = new JButton("Medium");
		diff3 = new JButton("Hard");
		close = new JButton("Quit");
		
		menuPanel.add(diff1);
		menuPanel.add(Box.createVerticalStrut(20));
		menuPanel.add(diff2);
		menuPanel.add(Box.createVerticalStrut(20));
		menuPanel.add(diff3);
		menuPanel.add(Box.createVerticalStrut(20));
		menuPanel.add(close);
	}
	
	private static void launchGame(int tunnels, int length, int speed, int startingFood) throws IOException, UnsupportedAudioFileException, LineUnavailableException
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