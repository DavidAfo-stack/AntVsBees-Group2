package core;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;

public class PauseScreen

{
	JFrame pauseScreen;
	JButton aButton = new JButton("Close");
	
	public static final Dimension FRAME_SIZE = new Dimension(720,480);
	private boolean open = false;
	public boolean exists = false;
	
	public void createWindow ()
	{	
		if (exists) // The exists boolean is used to check if the window has been created already, if so, it prevents another from being created.
		{
			return;
		}
		
		exists = true;
		
		open = true;
		
		// This creates a JFrame with a single button, at present, I don't know why the button takes up the entire window, but it functions for now.
		
		pauseScreen = new JFrame("Pause Screen");
		pauseScreen.setSize(FRAME_SIZE);
		pauseScreen.setAlwaysOnTop(true);
		pauseScreen.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Makes sure that the window cannot be closed by the operating system interface
		// As this would cause issues.
		aButton.setBounds(1, 1, 20, 20);
		pauseScreen.add(aButton);
		pauseScreen.setVisible(true);
		
		MainPauseLoop();
	}
	
	public void MainPauseLoop()
	{
		if (aButton.getModel().isPressed())
		{
			Close(); // Simply checks if the close button has been pressed, if so it triggers the Close function.
		}
	}
	
	public void Close()
	{
		open = false;
		
		pauseScreen.dispose(); // Disposes of the JFrame so that it can be freshly re-made when needed.
	}
	
	public boolean getOpen()
	{
		return open;
	}
	
}
