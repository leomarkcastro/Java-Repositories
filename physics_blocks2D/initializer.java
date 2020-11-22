package physics_blocks2D;

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
				
				mainframe.add(new no1_singleblock_newtonmotion());
				
				mainframe.setVisible(true);
				
				
			}
			
		});
		
	}
	
}

class Block{
	
	int mass = 10; //done
	int sx = 0, sy = 0, width = 10, height = 10; //done
	float forcex = 0, forcey = 0;
	float accelx = 0, accely = 0;
	float velox = 0, veloy = 0;
	float fricx = 0, fricy = 0;
	
	Block(int sx, int sy){
		this.sx = sx;
		this.sy = sy;
	}
	
	Block(int sx, int sy, int width){
		this.sx = sx;
		this.sy = sy;
		this.width = this.height = width;
	}
	
	Block(int sx, int sy, int width, int height){
		this.sx = sx;
		this.sy = sy;
		this.width = width;
		this.height = height;
	}

	void motion(){
		this.sx += velox;
		this.sy += veloy;
		
		velox += accelx;
		veloy += accely;
		
		accelx = forcex / mass;
		accely = forcey / mass;
	}
	
	
	Rectangle getBounds() {
		return new Rectangle(sx, sy, width, height);
	}
}
