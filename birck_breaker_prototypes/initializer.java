package birck_breaker_prototypes;

import java.awt.EventQueue;
import java.awt.Rectangle;
import java.util.Comparator;

import javax.swing.JFrame;

class initializer {
	
	public static void main(String args[]) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				JFrame mainframe = new JFrame();
				mainframe.setSize(800, 800);
				//mainframe.setLocationRelativeTo(null);
				mainframe.setDefaultCloseOperation(mainframe.EXIT_ON_CLOSE);
				mainframe.setAlwaysOnTop(true);
				
				mainframe.setUndecorated(true);
				
				mainframe.add(new no3_movement_collisiondetection());
				
				mainframe.setVisible(true);
				
				
			}
			
		});
		
	}
	
}

class bricks {
	
	int sx, sy;
	int width = 100, height = 50;
	boolean exist = true;
	
	bricks(int sx, int sy){
		this.sx = sx;
		this.sy = sy;
	}
	
	
	Rectangle getBounds(){
		
		Rectangle rect = new Rectangle(sx, sy, width, height);
		
		return rect;
		
	}
	
}

class ball {
	
	int sx, sy;
	int ballsize = 15;
	
	ball(int sx, int sy){
		this.sx = sx;
		this.sy = sy;
	}
	
	Rectangle getBounds(){
		
		Rectangle rect = new Rectangle(sx, sy, ballsize, ballsize);
		
		return rect;
		
	}
	
}