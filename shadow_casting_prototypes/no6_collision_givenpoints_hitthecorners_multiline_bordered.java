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

class no6_collision_givenpoints_hitthecorners_multiline_bordered extends JPanel implements Runnable, MouseMotionListener{

	Thread thread;
	boolean running;
	float angle = 0;
	ArrayList<linepoint> lppool;
	ArrayList<linepoint> redlines;
	linepoint line2;
	
	ArrayList<linepoint> points;
	Scanner scan;
	
	int startx = 0, starty = 0;
	
	no6_collision_givenpoints_hitthecorners_multiline_bordered(){
		this.setBounds(0,0,800,800);
		this.setFocusable(true);
		addMouseMotionListener(this);
		
		
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	@Override
	public void run() {
		
		redlines = new ArrayList<linepoint>();
		
		redlines.add(new linepoint(0,0,0,800));
		redlines.add(new linepoint(0,0,800,0));
		redlines.add(new linepoint(0,800,800,800));
		redlines.add(new linepoint(800,0,800,800));
		
		
		for(int i = 0; i < 10; i++)
			redlines.add(new linepoint((int) (800*Math.random()), (int) (800*Math.random()), (int) (800*Math.random()), (int) (800*Math.random())));
			
		
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
		
		for(int r = 0; r < redlines.size(); r++) {
			for(int i = 0; i < 2; i++) {
				
				//distance_away
				int da_x = ((i == 0) ? redlines.get(r).sx : redlines.get(r).ex) - startx;
				int da_y = ((i == 0) ? redlines.get(r).sy : redlines.get(r).ey) - starty;
				
				double base_angle = Math.atan2(da_y, da_x);
				double s_angle = 0; //spread_angle
				
				for(int j = 0; j < 3; j++) {
					
					if(j == 0) s_angle = base_angle - 0.001;
					if(j == 1) s_angle = base_angle;
					if(j == 2) s_angle = base_angle + 0.001;
					
					//WE HAVE ISSUES WITH THE ANGLE
					
					int cast_x = (int) (startx + radius*Math.cos(s_angle));
					int cast_y = (int) (starty + radius*Math.sin(s_angle));
					
					double min_t = Double.POSITIVE_INFINITY;
					int min_px = 0;
					int min_py = 0;
					boolean pValid = false;
					
					for(int r2 = 0; r2 < redlines.size(); r2++){
						
						float denom = (startx - cast_x)*(redlines.get(r2).sy - redlines.get(r2).ey) - (starty - cast_y)*(redlines.get(r2).sx - redlines.get(r2).ex);
						
						float t = ( (startx - redlines.get(r2).sx)*(redlines.get(r2).sy - redlines.get(r2).ey) - (starty - redlines.get(r2).sy)*(redlines.get(r2).sx - redlines.get(r2).ex) ) / denom; 
						
						float u = -(((startx - cast_x)*(starty - redlines.get(r2).sy) - (starty - cast_y)*(startx - redlines.get(r2).sx))/denom);
						
						if(t >= 0 && t <= 1 && u >= 0 && u <= 1) {
							
							if(min_t > t) {
								min_t = t;
								min_px = (int) (startx + t*(cast_x - startx));
								min_py = (int) (starty + t*(cast_y - starty));
								pValid = true;
								
							}
							
							
							}
						
						}
						
						if(pValid) {
							points.add(new linepoint(min_px, min_py));
							lppool.add(new linepoint(startx, starty, min_px, min_py));
					}
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
		
		
		for(int i = 0; i < redlines.size(); i++) {
			g.setColor(Color.red);
			g.drawLine(redlines.get(i).sx, redlines.get(i).sy, redlines.get(i).ex, redlines.get(i).ey);
		}
		
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