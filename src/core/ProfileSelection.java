package core;

import java.io.IOException;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ProfileSelection
{
	private static Serialize serializer;
	
	private static JFrameHandler frameHandler;
	private JButton newProfileButton;
	private JButton selectProfileButton;
	private JButton quitButton;
	private static JComboBox<String> profileList;
	public ProfileCreator creator;
	
	public String profile;
	
	public ProfileSelection() throws ClassNotFoundException, IOException
	{
		frameHandler = new JFrameHandler();
		
		serializer = new Serialize();
		
		setUpFrame(frameHandler.frame);
		setUpPanel(frameHandler.panel, frameHandler.frame);
		setUpComboBox(frameHandler.panel);
		setUpButtons(frameHandler.panel);
		
		while (!profileSelected()) {
			buttonCheck();
			frameHandler.panel.revalidate();
			frameHandler.panel.repaint();
		}
		
		frameHandler.frame.dispose();
	}
	
	private void setUpFrame(JFrame frame)
	{
		frame.setTitle("Ants vs Some Bees");
		
//		frame.setMinimumSize(frame.getPreferredSize());
//		frame.setSize(FRAME_SIZE);
//		frame.setResizable(true);
//		frame.setLayout(null);
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	private void setUpPanel(JPanel panel, JFrame frame)
	{
		panel.setBounds(70, 70, 150, 150);
		panel.setVisible(true);
	}
	
	private void setUpButtons(JPanel panel)
	{
		newProfileButton = new JButton("Create a new Profile");
		selectProfileButton = new JButton("Select Profile");
		quitButton = new JButton("Quit");
		
		panel.add(selectProfileButton);
		panel.add(Box.createVerticalStrut(20));
		panel.add(newProfileButton);
		panel.add(Box.createVerticalStrut(20));
		panel.add(quitButton);
	}
	
	private void setUpComboBox(JPanel panel) throws ClassNotFoundException, IOException
	{
		profileList = new JComboBox<String>();
		getProfiles();
		
		panel.add(profileList);
	}
	
	private void buttonCheck() throws ClassNotFoundException, IOException
	{
		if (newProfileButton.getModel().isPressed())
		{
			creator = new ProfileCreator(this);
			
			while (!creator.profileCreated)
			{
				
			}
			
			getProfiles();
		}
		
		if (selectProfileButton.getModel().isPressed())
		{
			if (profileList.getSelectedItem() != null)
			{
				profile = (String) profileList.getSelectedItem();
				
				System.out.println("Profile is: " + profile);
			}
		}
		
		if (quitButton.getModel().isPressed())
		{
			System.exit(0);
		}
	}
	
	public boolean profileSelected()
	{
		if (profile == null)
			return false;
		else
			return true;
	}

	public void getProfiles() throws ClassNotFoundException, IOException
	{
		profileList.removeAllItems();
		
		serializer.LoadFiles();
		
		for (PlayerProfile pp : serializer.playerProfiles)
		{
			profileList.addItem(pp.getPlayerName());
		}
	}

	public static void serializeProfileHandler(PlayerProfile pp) throws ClassNotFoundException, IOException
	{
		for (PlayerProfile profile : Serialize.playerProfiles)
		{
			if (profile.getPlayerName().matches(pp.getPlayerName()))
			{
				System.out.println("A profile with this name has already been created, no profile has been added");
				JOptionPane.showMessageDialog(null, "Profile name is not valid");
				
				break;
			}
		}
		
		serializer.Serializer(pp);
	}
	
}
