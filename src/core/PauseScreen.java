package core;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PauseScreen

{
	AntColony colony;
	
	JFrame pauseScreen;
	JPanel pausePanel;
	JButton continueButton = new JButton("Continue");
	JButton restartButton = new JButton("Restart");
	JButton quitButton = new JButton("Quit");
	
	
	public static final Dimension FRAME_SIZE = new Dimension(300,300);
	private boolean open = false;
	public boolean restart = false;
	public boolean exists = false;
	
	public PauseScreen(AntColony thisColony)
	{
		colony = thisColony;
	}
	
	
	public void createWindow ()
	{	
		if (exists) // The exists boolean is used to check if the window has been created already, if so, it prevents another from being created.
		{
			return;
		}
		exists = true;
		open = true;
		// This creates a JFrame with a single button, at present, I don't know why the button takes up the entire window, but it functions for now.
		
		setUpPauseScreen();
		setUpJpanel();
		addButtons();
		
		pauseScreen.add(pausePanel);
		pauseScreen.setVisible(true);
		
		MainPauseLoop();
	}
	
	private void setUpPauseScreen()
	{
		pauseScreen = new JFrame("Pause Screen");
		pauseScreen.setSize(FRAME_SIZE);
		pauseScreen.setAlwaysOnTop(true);
		pauseScreen.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Makes sure that the window cannot be closed by the operating system interface
		// As this would cause issues.
		pauseScreen.setLayout(null);
		pauseScreen.setResizable(false);
	}
	
	private void setUpJpanel()
	{
		pausePanel = new JPanel();
		pausePanel.setBounds(80, 80, 100, 100);
		pausePanel.setVisible(true);
	}
	
	public void MainPauseLoop()
	{
		continueButtonCheck();
		quitButtonCheck();
		restartButtonCheck();
	}
	
	private void continueButtonCheck()
	{
		if (continueButton.getModel().isPressed())
		{
			Continue(); // Simply checks if the close button has been pressed, if so it triggers the Close function.
		}
	}
	
	private void quitButtonCheck()
	{
		if (quitButton.getModel().isPressed())
		{
			Quit();
		}
	}
	
	private void restartButtonCheck()
	{
		if (restartButton.getModel().isPressed())
		{
			RestartGame();
		}
	}
	
	private void addButtons()
	{
		pausePanel.add(continueButton);
		pausePanel.add(restartButton);
		pausePanel.add(quitButton);
	}
	
	public void Continue()
	{
		open = false;
		
		pauseScreen.dispose(); // Disposes of the JFrame so that it can be freshly re-made when needed.
	}
	
	private void Quit()
	{
		System.exit(0);
	}
	
	public void RestartGame()
	{
		restart = true;
		
		pauseScreen.dispose();
	}
	
	public boolean getOpen()
	{
		return open;
	}
	
	public boolean getRestart()
	{
		return restart;
	}
	
}
