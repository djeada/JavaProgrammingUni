package Projekt;

import java.awt.BorderLayout;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

public class Main extends JFrame{
	private Menu menu;
	private	AnimationPanel gamePanel;
	private BottomPanel bottomPanel;
	public static JFrame frame;

	public Main () {
		frame = new JFrame();

		frame.setSize(1000, 800);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
		frame.setTitle("Brownian Motion");
		setLayout(new BorderLayout());
		
		gamePanel = new AnimationPanel();

		// Make the drawing area take up the rest of the frame
		
		frame.add(gamePanel, BorderLayout.CENTER);
		
		menu = new Menu();
		frame.setJMenuBar(menu);
		
		bottomPanel = new BottomPanel(gamePanel);		
		frame.add(bottomPanel, BorderLayout.SOUTH);
				
		// Show the frame
		
		frame.setVisible(true);
	}
	
	 public static void main(String[] args) {
	        Main main = new Main();
	 }
}
