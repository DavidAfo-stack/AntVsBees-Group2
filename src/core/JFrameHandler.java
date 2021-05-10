package core;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Nial and David
 */
public class JFrameHandler 
{
	public static JFrame frame;
	public static JPanel panel;
	public static final Dimension FRAME_SIZE = new Dimension(300,300);
	
	
	public JFrameHandler()
	{
		setUpFrame();
		setUpPanel();
	}
	
	private static void setUpFrame()
	{
		frame = new JFrame("Ants vs some Bees Main Menu");
		frame.setSize(FRAME_SIZE);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private static void setUpPanel()
	{
		panel = new JPanel();
		panel.setBounds(60, 50, 150, 200);
		panel.setVisible(true);
		frame.add(panel);
	}
	
}
