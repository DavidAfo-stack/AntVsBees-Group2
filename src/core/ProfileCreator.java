package core;

import java.awt.Dimension;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ProfileCreator 
{
	private JFrame creatorFrame;
	private JPanel creatorPanel;
	private JTextField creatorTextField;
	private JLabel label1;
	private JButton createButton; // Submit Button
	private Dimension FRAME_SIZE = new Dimension(300, 300);
	private ProfileSelection selector;
	public Boolean profileCreated;
	
	private String playerName;
	
	public ProfileCreator(ProfileSelection selector) throws ClassNotFoundException, IOException
	{
		this.selector = selector;
		profileCreated = false;
		
		setUpFrame();
		setUpPanel();
		setUpLabel();
		setUpTextField();
		setUpButton();
		
		mainMethod();
	}
	
	private void mainMethod() throws ClassNotFoundException, IOException
	{
		while (!profileCreated)
		{
			System.out.println("asdf"); // For some reason, if this is not here, the submit button won't work, I don't know why
			
			buttonCheck();
		}
		
		exitCreator();
	}
	
	private void setUpFrame()
	{
		creatorFrame = new JFrame("Create a new player profile");
		
		creatorFrame.setSize(FRAME_SIZE);
		creatorFrame.setResizable(false);
		creatorFrame.setLayout(null);
		creatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set this so that it won't break the entire system
		creatorFrame.setVisible(true);
		creatorFrame.setAlwaysOnTop(true);
	}
	
	private void setUpPanel()
	{
		creatorPanel = new JPanel();
		
		creatorPanel = new JPanel();
		creatorPanel.setBounds(-10, 25, 300, 300);
		creatorPanel.setVisible(true);
		creatorFrame.add(creatorPanel);
	}
	
	private void setUpButton()
	{
		createButton = new JButton("Submit");
		
		creatorPanel.add(createButton);
	}
	
	private void setUpTextField()
	{
		creatorTextField = new JTextField();
		
		creatorTextField.setPreferredSize(new Dimension(200, 20));
		creatorPanel.add(creatorTextField);
	}

	private void setUpLabel()
	{
		label1 = new JLabel("Please enter a new profile name below");
		
		creatorPanel.add(label1);
	}
	
	private void buttonCheck() throws ClassNotFoundException, IOException
	{
		if (createButton.getModel().isPressed())
		{
			if (creatorTextField.getText() != null && !creatorTextField.getText().isEmpty() && !creatorTextField.getText().isEmpty())
			{
				playerName = creatorTextField.getText();
				selector.serializeProfileHandler(createProfile());
				profileCreated = true;
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Profile name is not valid");
			}
				
		}
	}
	
	private void exitCreator()
	{
		selector.creator = null;
		
		creatorFrame.dispose();
	}

	private PlayerProfile createProfile()
	{
		PlayerProfile pp = new PlayerProfile(playerName);
		return pp;
	}
	
}
