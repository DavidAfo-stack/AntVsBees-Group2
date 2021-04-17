package core;

import org.w3c.dom.html.HTMLImageElement;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;

public class PauseScreen

{
	AntColony colony;
	
	JFrame pauseScreen;
	JPanel pausePanel;
	JFrame gameInfoScreen;
	JButton continueButton = new JButton("Continue");
	JButton restartButton = new JButton("Restart");
	JButton gameInfoButton = new JButton("Game Guide");// initialize button for game description
	JButton quitButton = new JButton("Quit");
	JButton generalGuideButton, harvesterAntButton, throwerAntButton, hungryAntButton, fireAntButton, ninjaAntButton, wallAntButton, scubaAntButton, queenAntButton, bodyGuardAntButton; //Initialize buttons menu guide
	
	
	public static final Dimension FRAME_SIZE = new Dimension(300,300);
	public static final Dimension GUIDESCREEN_SIZE = new Dimension(300, 500);
	private boolean open = false;
	public boolean restart = false;
	public boolean exists = false;

	//set image path fot
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

		/**
		 * set up the game guide button == David Afolabi
		 * this button opens up a panel that includes different buttons
		 * displaying ants abilities
		 */
		gameInfoButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				gameInfoScreen = new JFrame();
				gameInfoScreen.setTitle("Game Info");
				gameInfoScreen.setVisible(true);
				gameInfoScreen.setSize(GUIDESCREEN_SIZE);
				gameInfoScreen.setAlwaysOnTop(true);
				gameInfoScreen.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // Makes sure that the window is closed on exit
				gameInfoScreen.setLayout(null);
				gameInfoScreen.setResizable(false);
				setGameGuideButtons();
				//help guide for harvester ant
				harvesterAntButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Runnable runnable = ()->{
							String harvesterAntAbility = "<html><body width='%1s'>"
									+ "<h1>Harvester Ant</h1>"
									+ "<h3>The Harvester ant produces 1 food for the colony</h3>"
									+ "</body></html>";
							ImageIcon img =  new ImageIcon("img/ant_harvester.gif");
							JLabel label = new JLabel(img);
							label.setText(harvesterAntAbility);
							JOptionPane.showMessageDialog(null, label);

						};
						SwingUtilities.invokeLater(runnable);
					}
				});

				//help guide for thrower ant
				throwerAntButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Runnable runnable = ()->{
							String throwerAntAbility = "<html><body width='%1s'>"
									+ "<h1>Thrower Ant</h1>"
									+ "<h3>The thrower ant does damage to the Bees by throwing leaves.</h3>"
									+ "</body></html>";
							ImageIcon img =  new ImageIcon("img/ant_thrower.gif");
							JLabel label = new JLabel(img);
							label.setText(throwerAntAbility);
							JOptionPane.showMessageDialog(null, label);

						};
						SwingUtilities.invokeLater(runnable);
					}
				});

				//help guide for wall ant
				wallAntButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Runnable runnable = ()->{
							String wallAntAbility = "<html><body width='%1s'>"
									+ "<h1>Wall Ant</h1>"
									+ "<h3>The Wall ant has a very large armor value.</h3>"
									+ "</body></html>";
							ImageIcon img =  new ImageIcon("img/ant_wall.gif");
							JLabel label = new JLabel(img);
							label.setText(wallAntAbility);
							JOptionPane.showMessageDialog(null, label);

						};
						SwingUtilities.invokeLater(runnable);
					}
				});

				//help guide for hungry ant
				hungryAntButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Runnable runnable = ()->{
							String hungryAntAbility1 = "<html><body width='%1s'>"
									+ "<h1>Hungry Ant</h1>"
									+ "<h3>The Hungry ant eats a random Bee from its place, instantly killing the Bee. </h3>"
									+ "</body></html>";
							String hungryAntAbility2 = "<html><body width='%1s'>"
									+ "<h3>However, after eating a Bee, it spends 3 turns digesting before eating the again.</h3>"
									+ "</body></html>";
							JPanel panel = new JPanel();
							ImageIcon img =  new ImageIcon("img/ant_hungry.gif");
							JLabel icon = new JLabel(img);
							JLabel text = new JLabel(hungryAntAbility1);
							JLabel text2 = new JLabel(hungryAntAbility2);
							panel.setLayout(new BorderLayout());
							panel.add(icon, BorderLayout.NORTH);
							panel.add(text, BorderLayout.CENTER);
							panel.add(text2, BorderLayout.SOUTH);
							JOptionPane.showMessageDialog(null, panel,"Hungry ant", JOptionPane.PLAIN_MESSAGE);
						};
						SwingUtilities.invokeLater(runnable);
					}
				});

				//help guide for fire ant
				fireAntButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Runnable runnable = ()->{
							String fireAntAbility = "<html><body>"
									+ "<h1>Fire Ant</h1>"
									+ "<h3> When its Armor is zero, it reduces the armor of co-located bees.</h3>"
									+ "</body></html>";
							ImageIcon img =  new ImageIcon("img/ant_fire.gif");
							JLabel label = new JLabel(img);
							label.setText(fireAntAbility);
							JOptionPane.showMessageDialog(null, label);
						};
						SwingUtilities.invokeLater(runnable);
					}
				});

				//help guide for ninja ant
				ninjaAntButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Runnable runnable = ()->{
							String ninjaAntAbility = "<html><body width='%1s'>"
									+ "<h1>Ninja Ant</h1>"
									+ "<h3>Invincible Ant that damages Bees that pass its place.</h3>"
									+ "</body></html>";
							ImageIcon img =  new ImageIcon("img/ant_ninja.gif");
							JLabel label = new JLabel(img);
							label.setText(ninjaAntAbility);
							JOptionPane.showMessageDialog(null, label);
						};
						SwingUtilities.invokeLater(runnable);
					}
				});

				//help guide for scuba ant
				scubaAntButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Runnable runnable = ()->{
							String scubaAntAbility = "<html><body width='%1s'>"
									+ "<h1>Scuba Ant</h1>"
									+ "<p>The scuba ant can swim in water unlike the thrower ant.</p>"
									+ "</body></html>";
							ImageIcon img =  new ImageIcon("img/ant_scuba.gif");
							JLabel label = new JLabel(img);
							label.setText(scubaAntAbility);
							JOptionPane.showMessageDialog(null, label);
						};
						SwingUtilities.invokeLater(runnable);
					}
				});

				//help guide for queen ant
				queenAntButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Runnable runnable = ()->{
							String queenAntAbility = "<html><body width='%1s'>"
									+ "<h1>Queen Ant</h1>"
									+ "<h3>Whenever the QueenAnt throws a leaf, she doubles the "
									+ "damage of the ants on either side of her.</h3>"
									+ "</body></html>";
							ImageIcon img =  new ImageIcon("img/ant_queen.gif");
							JLabel label = new JLabel(img);
							label.setText(queenAntAbility);
							JOptionPane.showMessageDialog(null, label);
						};
						SwingUtilities.invokeLater(runnable);
					}
				});

				//help guide for body guard ant
				bodyGuardAntButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Runnable runnable = ()->{
							String bodyGuardAntAbility = "<html><body width='%1s'>"
									+ "<h1>BodyGuard Ant</h1>"
									+ "<h3>The Bodyguard ant protects other ants in its place.</h3>"
									+ "</body></html>";
							ImageIcon img =  new ImageIcon("img/ant_weeds.gif");
							JLabel label = new JLabel(img);
							label.setText(bodyGuardAntAbility);
							JOptionPane.showMessageDialog(null, label);
						};
						SwingUtilities.invokeLater(runnable);
					}
				});

				//general guide for the game
				generalGuideButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Runnable run = ()->{
							String innerContent = "<html><body width='%1s'>"
												+ "<h1>Game Instruction</h1>"
												+ "<h2>The game is about protecting the Ants colony from the bees. The bees "
												+ "have been designed to sting the ant to death but different ants with different abilities were also "
												+ "designed to protect the colony from the evil bees. Remember, there can be only one true Queen. "
												+ "If a bee ever enters the place occupied by the queen, then the bees immediately win the game. The "
												+ "game ends even if the queen is protected by a bodyguard. The bees also win if any bee reaches the "
												+ "end of a tunnel where the queen normally would reside. The true (first) queen cannot be removed, "
												+ "that is, it cannot be moved or damaged. Attempts to remove the queen should have no effect."
												+ "Protect the Ants colony at all cost to win the game. "
												+ "Enjoy the game! </h2>"
									  			+ "</body></html>";

							//set width of JOption pane
							int size = 500;
							JOptionPane.showMessageDialog(null, String.format(innerContent, size, size));
						};
						SwingUtilities.invokeLater(run);
					}
				});
				//end of general guide for the game
			}
		});
      // end of guide guide screen
	}
	/**
	 * set up game guide buttons for different features of the game
	 * once the button is clicked, the information appears for the feature
	 * David Afolabi
	 */
	private void setGameGuideButtons(){
		//set text for buttons
		generalGuideButton = new JButton("Help");
		harvesterAntButton = new JButton("Harvester-Ant-Ability");
		throwerAntButton = new JButton("Thrower-Ant-Ability");
		hungryAntButton =new JButton("Hungry-Ant-Ability");
		fireAntButton = new JButton("Fire-Ant-Ability");
		wallAntButton = new JButton("Wall-Ant-Ability");
		ninjaAntButton = new JButton("Ninja-Ant-Ability");
		scubaAntButton = new JButton("Scuba-Ant-Ability");
		queenAntButton = new JButton("Queen-Ant-Ability");
		bodyGuardAntButton = new JButton("BodyGuard-Ant-Ability");
		//add buttons
		gameInfoScreen.add(generalGuideButton);
		gameInfoScreen.add(harvesterAntButton);
		gameInfoScreen.add(throwerAntButton);
		gameInfoScreen.add(hungryAntButton);
		gameInfoScreen.add(fireAntButton);
		gameInfoScreen.add(wallAntButton);
		gameInfoScreen.add(ninjaAntButton);
		gameInfoScreen.add(scubaAntButton);
		gameInfoScreen.add(queenAntButton);
		gameInfoScreen.add(bodyGuardAntButton);
		//harvester ant btn
		harvesterAntButton.setBounds(50,30,170,40);
		harvesterAntButton.setVisible(true);
		harvesterAntButton.setBackground(Color.YELLOW);
		//thrower ant
		throwerAntButton.setBounds(50,70,170,40);
		throwerAntButton.setVisible(true);
		throwerAntButton.setBackground(Color.YELLOW);
		//wall ant
		wallAntButton.setBounds(50,110,170,40);
		wallAntButton.setVisible(true);
		wallAntButton.setBackground(Color.YELLOW);
		//hungry ant
		hungryAntButton.setBounds(50,150,170,40);
		hungryAntButton.setVisible(true);
		hungryAntButton.setBackground(Color.YELLOW);
		//fire ant
		fireAntButton.setBounds(50,190,170,40);
		fireAntButton.setVisible(true);
		fireAntButton.setBackground(Color.YELLOW);
		//ninja ant
		ninjaAntButton.setBounds(50,230,170,40);
		ninjaAntButton.setVisible(true);
		ninjaAntButton.setBackground(Color.YELLOW);
		//scuba ant
		scubaAntButton.setBounds(50,270,170,40);
		scubaAntButton.setVisible(true);
		scubaAntButton.setBackground(Color.YELLOW);
		//queen ant
		queenAntButton.setBounds(50,310,170,40);
		queenAntButton.setVisible(true);
		queenAntButton.setBackground(Color.YELLOW);
		//bodyGuard ant
		bodyGuardAntButton.setBounds(50,350,170,40);
		bodyGuardAntButton.setVisible(true);
		bodyGuardAntButton.setBackground(Color.YELLOW);
		//help button
		generalGuideButton.setBounds(50,390,170,40);
		generalGuideButton.setVisible(true);
		generalGuideButton.setBackground(Color.YELLOW);
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
		pausePanel.setBounds(80, 80, 100, 150);
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
		pausePanel.add(gameInfoButton);// add new button for game instruction ==David
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
