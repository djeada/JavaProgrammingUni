package Projekt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JComponent;

public class AnimationPanel extends JComponent { 
		
		int width=this.getWidth();
		int height=this.getHeight();
		static int N = 100;
		static Color bgColor = Color.white;
		static Color ballColor = Color.red;
		static int Radius = 50, radius = 5;
		static int Mass = 100, mass = 10;
		Graphics2D graphicSettings;
		
		//holds every particle we create
		public ArrayList<Particle> particles = new ArrayList<Particle>();
		
		//creates n Particle objects and stores them in the ArrayList
		public AnimationPanel() { 
			populate ();
		} 
		
		//holds all graphics settings
		public void paint(Graphics g) { 
			
			// Allows me to make many settings changes in regards to graphics
			graphicSettings = (Graphics2D)g; 
			
			// Draw a black background that is as big as the game board
			graphicSettings.setColor(bgColor);
			graphicSettings.fillRect(0, 0, getWidth(), getHeight());
			
			// makes rendering more beautiful
			graphicSettings.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); 
			
			graphicSettings.setColor(ballColor);
			
			//drawing the big particle
			Particle big = particles.get(0);
			graphicSettings.fillOval(big.x,big.y, 2*big.radius, 2*big.radius); 

			// Cycle through all of the Particles objects
			for(Particle p : particles.subList(1, particles.size())){								
				// Stroke the particle on the screen
				graphicSettings.setColor(Color.getHSBColor((float)(p.vx/p.vy), 1f, (float)(p.vx/p.vy)));
				graphicSettings.fillOval(p.x,p.y, 2*radius, 2*radius);  
			} 
			
		} 

		public void populate () {
			
			//creating one big particle
			Particle big = new Particle(400, 200, 0, 0, Radius, Mass);
			particles.add(big);

			//creating n number of smaller particles
			for(int i = 0; i < N; i++){
				Particle p = new Particle(radius, mass);
				particles.add(p);
			}
		}
		
		public void reset() {
			particles.clear();
			bgColor = Color.black;
			ballColor = Color.white;  
			
			populate ();
		}
		
		public void setBgColor(Color bgColor) {
			AnimationPanel.bgColor = bgColor;
		}
		
		public void setBallColor(Color ballColor) {
			AnimationPanel.ballColor = ballColor;
		}
		
		public void setN(int n) {
			AnimationPanel.N = n;
		}
		
		public void setRadius(int r) {
			AnimationPanel.Radius = r;
		}
		
}
