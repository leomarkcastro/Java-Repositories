package shadow_casting_prototypes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;

import shadow_casting_prototypes.linepoint;

class no4_collision_givenpoints_hitthecorners extends JPanel implements Runnable, MouseMotionListener{

	Thread thread;
	boolean running;
	float angle = 0;
	ArrayList<linepoint> lppool;
	linepoint line2;
	
	ArrayList<linepoint> points;
	Scanner scan;
	
	int startx = 0, starty = 0;
	
	no4_collision_givenpoints_hitthecorners(){
		this.setBounds(0,0,800,800);
		this.setFocusable(true);
		addMouseMotionListener(this);
		
		
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	@Override
	public void run() {
		
		line2 = new linepoint((int) (800*Math.random()), (int) (800*Math.random()), (int) (800*Math.random()), (int) (800*Math.random()));
		
		while(running) {
			
			gotolines(1000);
			repaint();
			
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	void gotolines(int radius) {
		
		lppool = new ArrayList<linepoint>();
		points = new ArrayList<linepoint>();
		
		for(int i = 0; i < 2; i++) {
			
			//distance_away
			int da_x = ((i == 0) ? line2.sx : line2.ex) - startx;
			int da_y = ((i == 0) ? line2.sy : line2.ey) - starty;
			
			double base_angle = Math.atan2(da_y, da_x);
			double s_angle = 0; //spread_angle
			
			for(int j = 0; j < 3; j++) {
				
				if(j == 0) s_angle = base_angle - 0.001;
				if(j == 1) s_angle = base_angle;
				if(j == 2) s_angle = base_angle + 0.001;
				
				//WE HAVE ISSUES WITH THE ANGLE
				
				int cast_x = (int) (startx + radius*Math.cos(s_angle));
				int cast_y = (int) (starty + radius*Math.sin(s_angle));
				
				float denom = (startx - cast_x)*(line2.sy - line2.ey) - (starty - cast_y)*(line2.sx - line2.ex);
				
				float t = ( (startx - line2.sx)*(line2.sy - line2.ey) - (starty - line2.sy)*(line2.sx - line2.ex) ) / denom; 
				
				float u = -(((startx - cast_x)*(starty - line2.sy) - (starty - cast_y)*(startx - line2.sx))/denom);
				
				if(t >= 0 && t <= 1 && u >= 0 && u <= 1) {
					
					int px = (int) (startx + t*(cast_x - startx));
					int py = (int) (starty + t*(cast_y - starty));
					
					points.add(new linepoint(px, py));
					lppool.add(new linepoint(startx, starty, px, py));
					
				}
				
			}
			
		}
		
	}

	public void paint(Graphics g) {
		
		g.setColor(Color.white);
		g.fillRect(0, 0, 800, 800);
		
		g.setColor(Color.black);
		g.setFont(new Font("Calibri", Font.PLAIN, 25));
		g.drawString("Angle: " + lppool.size(), 0, 50);
		
		for(int i = 0; i < lppool.size(); i++) {
			g.setColor(new Color(0,0,255,32));
			g.drawLine(lppool.get(i).sx, lppool.get(i).sy, lppool.get(i).ex, lppool.get(i).ey);
		}
		
		g.setColor(Color.red);
		g.drawLine(line2.sx, line2.sy, line2.ex, line2.ey);
		
		for(int i = 0; i < lppool.size(); i++) {
			g.setColor(Color.black);
			g.fillOval(points.get(i).sx-5, points.get(i).sy-5, 10, 10);
		}
		
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		startx = e.getX();
		starty = e.getY();
	}
	
}