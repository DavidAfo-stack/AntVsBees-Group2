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
	private static JFrameHandler frameHandler;
	
	private JTextField creatorTextField;
	private JLabel label1;
	private JButton createButton; // Submit Button
	private ProfileSelection selector;
	public Boolean profileCreated;
	
	private String playerName;
	
	public ProfileCreator(ProfileSelection selector) throws ClassNotFoundException, IOException
	{
		frameHandler = new JFrameHandler();
		
		this.selector = selector;
		profileCreated = false;
		
		setUpFrame(frameHandler.frame);
		setUpPanel(frameHandler.panel);
		setUpLabel(frameHandler.panel);
		setUpTextField(frameHandler.panel);
		setUpButton(frameHandler.panel);
		
		mainMethod();
	}
	
	private void mainMethod() throws ClassNotFoundException, IOException
	{
		while (!profileCreated)
		{
			buttonCheck();
			
			frameHandler.frame.repaint(); // Without this the button does not work.
		}
		
		exitCreator();
	}
	
	private void setUpFrame(JFrame frame)
	{
		frame.setTitle("Create a new player profile");
		frame.setVisible(true);
		frame.setAlwaysOnTop(true);
	}
	
	private void setUpPanel(JPanel panel)
	{
		panel.setBounds(-10, 25, 300, 300);
	}
	
	private void setUpButton(JPanel panel)
	{
		createButton = new JButton("Submit");
		
		panel.add(createButton);
	}
	
	private void setUpTextField(JPanel panel)
	{
		creatorTextField = new JTextField();
		
		creatorTextField.setPreferredSize(new Dimension(200, 20));
		panel.add(creatorTextField);
	}

	private void setUpLabel(JPanel panel)
	{
		label1 = new JLabel("Please enter a new profile name below");
		
		panel.add(label1);
	}
	
	private void buttonCheck() throws ClassNotFoundException, IOException
	{
		if (createButton.getModel().isPressed())
		{
			if (creatorTextField.getText() != null && !creatorTextField.getText().isBlank() && !creatorTextField.getText().isEmpty())
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
		
		frameHandler.frame.dispose();
	}

	private PlayerProfile createProfile()
	{
		PlayerProfile pp = new PlayerProfile(playerName);
		return pp;
	}
	
}
