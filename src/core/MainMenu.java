package core;

import java.io.IOException;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenu
{
	// The difficulty of this could be altered to change the number of bees spawned 
	
	/*
	 * Values related to the main menu JFrame
	 */
	private static JFrameHandler frameHandler;
	
	private static JButton diff1; // Easy difficulty
	private static JButton diff2; // Medium difficulty
	private static JButton diff3; // Hard difficulty
	private static JButton close; // Close button
	private static JButton changeProfile; // Button to open profile selector.
	
	/*
	 * Player profile values
	 */
	private static String playerProfile; // The selected player profile.
	private static ProfileSelection selector; // A reference to the profile selector.
	
	/*
	 * Values related to the creation of a new instance of the game.
	 */
	public static AntsVsSomeBees client;
	public static int diff = 0; // 1 for easy, 2 for medium, 3 for hard
	public static int startingFood = 25; // ==Niall== I just added this so that it could be easily identified and altered.
	
	public MainMenu() throws ClassNotFoundException, IOException, UnsupportedAudioFileException, LineUnavailableException
	{
		frameHandler = new JFrameHandler();

		setUpButtons(frameHandler.panel);
		
		changeProfile();
		
		
		while (diff <= 0)
		{
			handleButtons();
			// mainMenu.revalidate();
			frameHandler.frame.repaint();
		}
		
		frameHandler.frame.dispose();
	}
	
	private static void handleButtons() throws IOException, UnsupportedAudioFileException, LineUnavailableException, ClassNotFoundException
	{
		//while (diff <= 0)
			// // // System.out.println("Handling Buttons"); // For some reason, commenting this out makes the buttons not work.
		
			if (diff1.getModel().isPressed())
			{
				// Easy selected
				// // System.out.println("Easy Selected");
				diff = 1;
			
				AntsVsSomeBees.launchGame(1, 8, 4, 40); // Spawns 1 tunnel that is 8 places in length, turn length is 4 seconds and starting food is 40.
			}
		
			else if (diff2.getModel().isPressed())
			{
				// Medium selected
				// // System.out.println("Medium Selected");
				diff = 2;
			
				AntsVsSomeBees.launchGame(3, 8, 3, 25); // Spawns 3 tunnels that are 8 places in length, turn length is 3 seconds and starting food is 25
			}
			else if (diff3.getModel().isPressed())
			{
				// Hard Selected
				// // System.out.println("Hard Selected");
				diff = 3;
			
				AntsVsSomeBees.launchGame(4, 7, 2, 30); // Spawns 4 tunnels that are 7 places in length, turn length is 2 seconds and starting food is 20
			}
			else if (close.getModel().isPressed())
			{
				// // System.out.println("Closing Game");
				System.exit(0);
			}
			else if (changeProfile.getModel().isPressed())
			{
				changeProfile();
				changeProfile.getModel().setPressed(false); // Had to add this because after pressing it it would count as pressed all the time.
				return;
			}
		}

	private static void setUpButtons(JPanel panel)
	{	
		diff1 = new JButton("Easy");
		diff2 = new JButton("Medium");
		diff3 = new JButton("Hard");
		close = new JButton("Quit");
		changeProfile = new JButton("Change Profile");
		
		panel.add(diff1);
		panel.add(Box.createVerticalStrut(20));
		panel.add(diff2);
		panel.add(Box.createVerticalStrut(20));
		panel.add(diff3);
		panel.add(Box.createVerticalStrut(20));
		panel.add(changeProfile);
		panel.add(Box.createVerticalStrut(20));
		panel.add(close);
	}

	private static void changeProfile() throws ClassNotFoundException, IOException
	{
		JFrame thisFrame = frameHandler.frame;
		
		thisFrame.setVisible(false);
		
		selector = new ProfileSelection();
		
		playerProfile = selector.profile;
		
		selector = null;
		
		thisFrame.setVisible(true);
	}
	
}