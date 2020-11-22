package shadow_casting_prototypes;

import java.awt.EventQueue;
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
				
				mainframe.add(new no13_shadow_block_v1_multiclipping());
				
				mainframe.setVisible(true);
			}
			
		});
		
	}
	
}

class linepoint{
	
	int sx, sy;
	int ex, ey;
	int angle = 0;
	
	linepoint(int sx, int sy, int ex, int ey){
		this.sx = sx;
		this.sy = sy;
		this.ex = ex;
		this.ey = ey;
	}
	
	linepoint(int sx, int sy, int ex, int ey, int angle){
		this.sx = sx;
		this.sy = sy;
		this.ex = ex;
		this.ey = ey;
		this.angle = angle;
	}
	
	linepoint(int sx, int sy){
		this.sx = sx;
		this.sy = sy;
	}
	
	linepoint(int sx, int sy, int angle){
		this.sx = sx;
		this.sy = sy;
		this.angle = angle;
	}
	
	public static Comparator<linepoint> sort_angle = new Comparator<linepoint>() {
		
		public int compare (linepoint l1, linepoint l2) {
			
			int l1a = l1.angle;
			int l2a = l2.angle;
			
			return l1a - l2a;
			
		}
		
	};
	
	public String toString(){
		return "sx: " + sx + " sy: " + sy + " ex: " + ex + " ey: " + ey + " angle: " + angle;
	}
	
}

class World{
	
	int edge_id[] = new int[4];
	boolean edge_exist[] = new boolean[4];
	boolean exist = false;
	
}