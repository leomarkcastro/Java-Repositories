package shadow_casting_prototypes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.swing.JPanel;

import shadow_casting_prototypes.linepoint;

class no7_collision_givenpoints_hitthecorners_multiline_bordered_sorted extends JPanel implements Runnable, MouseMotionListener, MouseListener{
	
	Thread thread;
	boolean running;
	float angle = 0;
	ArrayList<linepoint> lppool;
	ArrayList<linepoint> redlines;
	linepoint line_dummy;
	
	ArrayList<linepoint> points;
	Scanner scan;
	
	int x = 0;
	
	int startx = 0, starty = 0;
	
	no7_collision_givenpoints_hitthecorners_multiline_bordered_sorted(){
		this.setBounds(0,0,800,800);
		this.setFocusable(true);
		addMouseMotionListener(this);
		addMouseListener(this);
		
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
		
		
		for(int i = 0; i < 5; i++)
			redlines.add(new linepoint((int) (800*Math.random()), (int) (800*Math.random()), (int) (800*Math.random()), (int) (800*Math.random())));
			
		
		while(running) {
			
			gotolines(2000);
			sortpoints();
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
					
					if(j == 0) s_angle = base_angle - 0.01;
					if(j == 1) s_angle = base_angle;
					if(j == 2) s_angle = base_angle + 0.01;
					
					//WE HAVE ISSUES WITH THE ANGLE
					
					int cast_x = (int) (startx + radius*Math.cos(s_angle));
					int cast_y = (int) (starty + radius*Math.sin(s_angle));
					
					double min_t = Double.POSITIVE_INFINITY;
					int min_px = 0;
					int min_py = 0;
					double min_angle = 0;
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
								min_angle = Math.atan2(min_py - starty, min_px - startx);
								pValid = true;
								
							}
							
							
							}
						
						}
						
						if(pValid) {
							//Converting angle from radian to degrees
							int conv_ang = 0;
							if(min_angle >= 0) {
								conv_ang = (int) ((min_angle * (180/Math.PI)) * 1000);
							}
							else if(min_angle < 0) {
								conv_ang = (int) ((360 + (min_angle * (180/Math.PI))) * 1000);
							}
							points.add(new linepoint(min_px, min_py, conv_ang));
							lppool.add(new linepoint(startx, starty, min_px, min_py, conv_ang));
					}
				}
			}
		}
	}
	
	void sortpoints() {
		
		Collections.sort(lppool, linepoint.sort_angle);
		lppool.sort(linepoint.sort_angle);
		
		Collections.sort(points, linepoint.sort_angle);
		points.sort(linepoint.sort_angle);
		
		//lppool = (ArrayList<linepoint>) lppool.stream().distinct().collect(Collectors.toList());
		
		/*
		for(linepoint l: lppool) System.out.println(l);
		System.out.println();
		*/
		
		
	}
	
	public void paint(Graphics g) {
		
		g.setColor(Color.black);
		g.fillRect(0, 0, 800, 800);
		
		g.setColor(Color.yellow);
		g.setFont(new Font("Calibri", Font.PLAIN, 25));
		g.drawString("Angle: " + lppool.size(), 0, 50);
		
		
		
		
		
		g.setColor(new Color(100,100,100));
		for(int i = 0; i < points.size()-1; i++) {
			
			int pointsx[] = {startx, points.get(i).sx, points.get(i+1).sx};
			int pointsy[] = {starty, points.get(i).sy, points.get(i+1).sy};
			g.fillPolygon(pointsx, pointsy, 3);
			
		}
		
		
		int points2x[] = {startx, points.get(points.size()-1).sx, points.get(0).sx};
		int points2y[] = {starty, points.get(points.size()-1).sy, points.get(0).sy};
		
		g.fillPolygon(points2x, points2y, 3);
		
		
		/*
		for(int i = 0; i < lppool.size(); i++) {
			g.setColor(Color.green);
			g.drawLine(lppool.get(i).sx, lppool.get(i).sy, lppool.get(i).ex, lppool.get(i).ey);
		}
		*/
		
		for(int i = 0; i < redlines.size(); i++) {
			g.setColor(Color.red);
			g.drawLine(redlines.get(i).sx, redlines.get(i).sy, redlines.get(i).ex, redlines.get(i).ey);
		}
		
		/*
		for(int i = 0; i < lppool.size(); i++) {
			g.setColor(Color.black);
			g.fillOval(points.get(i).sx-5, points.get(i).sy-5, 10, 10);
		}
		*/
		
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

	@Override
	public void mouseClicked(MouseEvent e) {
		/*if(x < lppool.size()-1) {
			x++;
		}
		else x = 0;
		*/
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
		
}