package core;

import java.awt.Dimension;
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
	
	private JFrame profileFrame;
	private JPanel profilePanel;
	private JButton newProfileButton;
	private JButton selectProfileButton;
	private JButton quitButton;
	private static JComboBox<String> profileList;
	public static final Dimension FRAME_SIZE = new Dimension(300, 300);
	public ProfileCreator creator;
	
	public String profile;
	
	public ProfileSelection() throws ClassNotFoundException, IOException
	{
		serializer = new Serialize();
		
		setUpFrame();
		setUpPanel();
		setUpComboBox();
		setUpButtons();
		
		while (!profileSelected()) {
			buttonCheck();
			profilePanel.revalidate();
			profilePanel.repaint();
		}
		
		profileFrame.dispose();
	}
	
	private void setUpFrame()
	{
		profileFrame = new JFrame("Ants vs Some Bees");
		
		profileFrame.setMinimumSize(profileFrame.getPreferredSize());
		profileFrame.setSize(FRAME_SIZE);
		profileFrame.setResizable(true);
		profileFrame.setLayout(null);
		profileFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		profileFrame.setVisible(true);
	}
	
	private void setUpPanel()
	{
		profilePanel = new JPanel();
		
		profilePanel.setBounds(70, 70, 150, 150);
		profilePanel.setVisible(true);
		profileFrame.add(profilePanel);
	}
	
	private void setUpButtons()
	{
		newProfileButton = new JButton("Create a new Profile");
		selectProfileButton = new JButton("Select Profile");
		quitButton = new JButton("Quit");
		
		profilePanel.add(selectProfileButton);
		profilePanel.add(Box.createVerticalStrut(20));
		profilePanel.add(newProfileButton);
		profilePanel.add(Box.createVerticalStrut(20));
		profilePanel.add(quitButton);
	}
	
	private void setUpComboBox() throws ClassNotFoundException, IOException
	{
		profileList = new JComboBox<String>();
		getProfiles();
		
		profilePanel.add(profileList);
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
