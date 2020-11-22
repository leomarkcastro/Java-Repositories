package shadow_casting_prototypes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

import shadow_casting_prototypes.linepoint;

class no10_shadow_block_v1_arcclip_keymove extends JPanel implements Runnable, MouseMotionListener, MouseListener, KeyListener{
	
	int world_length = 40;
	int world_height = 40;
	int blocksize = 800 / world_height;
	
	Thread thread;
	boolean running;
	float angle = 0;
	ArrayList<linepoint> lppool;
	World blocks[];
	linepoint line_dummy;
	
	ArrayList<linepoint> intersect;
	Scanner scan;
	
	boolean dark_mode = false;
	int light_angle = 45;
	
	int x = 0;
	
	Timer movethread;
	int mousex = 0, mousey = 0;
	int startx = 400, starty = 400;
	int movex = 0, movey = 0;
	
	int light_on = 0;
	
	no10_shadow_block_v1_arcclip_keymove(){
		this.setBounds(0,0,800,800);
		this.setFocusable(true);
		addMouseMotionListener(this);
		addMouseListener(this);
		addKeyListener(this);
		
		movethread = new Timer();
		movethread.scheduleAtFixedRate(new cursor_move(), 0, 25);
		
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	@Override
	public void run() {
		
		/*
		for(int i = 0; i < 5; i++)
			redlines.add(new linepoint((int) (800*Math.random()), (int) (800*Math.random()), (int) (800*Math.random()), (int) (800*Math.random())));
		*/
		
		gpinitialize();
		
		for(int i = 0; i < world_length - 2; i++) {
			blocks[world_length + i].exist = true; 
			blocks[(world_height-1)*38+i+1].exist = true;
			}
		for(int i = 0; i < world_height - 2; i++) {
			blocks[39+ (i*(world_height-1) + 1)].exist = true; 
			blocks[39+ (i*(world_height-1) + 38)].exist = true; 
			}
		
		while(running) {
			
			repaint();
			
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	void gpinitialize() {
		lppool = new ArrayList<linepoint>();
		
		blocks = new World[world_length * world_height];
		for(int i = 0; i < world_height * world_length ; i++) {
			blocks[i] = new World();
		}
		gpincrereset();
	}
	
	void gpincrereset(){
		lppool = new ArrayList<linepoint>();
		for(int i = 0; i <  world_height * world_length ; i++) {
			blocks[i].edge_id = new int[4];
			blocks[i].edge_exist = new boolean[4];
		}
	}
	
	//EDGE_EXIST ID
		byte NORTH = 0;
		byte EAST = 1;
		byte SOUTH = 2;
		byte WEST = 3;
	
	void gridtopoints() {

			gpincrereset();
			
			int n,s,e,w;
			
			for(int y = 0; y < world_height - 1; y++) {
				for(int x = 0; x < world_length - 1; x++) {
					
					int currentbox = (world_length- 1)*y+x;
					
					if(blocks[currentbox].exist) {
						
						n = (world_length - 1)*(y-1)+x;
						s = (world_length - 1)*(y+1)+x;
						e = (world_length - 1)*y+(x+1);
						w = (world_length - 1)*y+(x-1);
						
						if (!blocks[n].exist) {
							
							if(blocks[w].edge_exist[NORTH]) {
								lppool.get(blocks[w].edge_id[NORTH]).ex += blocksize;
								blocks[currentbox].edge_exist[NORTH] = true;
								blocks[currentbox].edge_id[NORTH] = blocks[w].edge_id[NORTH];
							}
							
							else {
								lppool.add(new linepoint(x*blocksize, y*blocksize, (x+1)*blocksize, (y)*blocksize));
								blocks[currentbox].edge_exist[NORTH] = true;
								blocks[currentbox].edge_id[NORTH] = lppool.size() - 1;
							}
							
						}
						
						if (!blocks[e].exist) {
							
							if(blocks[n].edge_exist[EAST]) {
								lppool.get(blocks[n].edge_id[EAST]).ey += blocksize;
								blocks[currentbox].edge_exist[EAST] = true;
								blocks[currentbox].edge_id[EAST] = blocks[n].edge_id[EAST];
							}
							
							else {
								lppool.add(new linepoint((x+1)*blocksize, y*blocksize, (x+1)*blocksize, (y+1)*blocksize));
								blocks[currentbox].edge_exist[EAST] = true;
								blocks[currentbox].edge_id[EAST] = lppool.size() - 1;
							}
							
						}
						
						if (!blocks[s].exist) {
							
							if(blocks[w].edge_exist[SOUTH]) {
								lppool.get(blocks[w].edge_id[SOUTH]).ex += blocksize;
								blocks[currentbox].edge_exist[SOUTH] = true;
								blocks[currentbox].edge_id[SOUTH] = blocks[w].edge_id[SOUTH];
							}
							
							else {
								lppool.add(new linepoint((x)*blocksize, (y+1)*blocksize, (x+1)*blocksize, (y+1)*blocksize));
								blocks[currentbox].edge_exist[SOUTH] = true;
								blocks[currentbox].edge_id[SOUTH] = lppool.size() - 1;
							}
							
						}
						
						if (!blocks[w].exist) {
							
							if(blocks[n].edge_exist[WEST]) {
								lppool.get(blocks[n].edge_id[WEST]).ey += blocksize;
								blocks[currentbox].edge_exist[WEST] = true;
								blocks[currentbox].edge_id[WEST] = blocks[n].edge_id[WEST];
							}
							
							else {
								lppool.add(new linepoint((x)*blocksize, (y)*blocksize, (x)*blocksize, (y+1)*blocksize));
								blocks[currentbox].edge_exist[WEST] = true;
								blocks[currentbox].edge_id[WEST] = lppool.size() - 1;
							}
							
						}
					}
				}
			}
			
		}
	
	void gotolines(int radius) {
		
		intersect = new ArrayList<linepoint>();
		
		for(int r = 0; r < lppool.size(); r++) {
			for(int i = 0; i < 2; i++) {
				
				//distance_away
				int da_x = ((i == 0) ? lppool.get(r).sx : lppool.get(r).ex) - startx;
				int da_y = ((i == 0) ? lppool.get(r).sy : lppool.get(r).ey) - starty;
				
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
					
					for(int r2 = 0; r2 < lppool.size(); r2++){
						
						float denom = (startx - cast_x)*(lppool.get(r2).sy - lppool.get(r2).ey) - (starty - cast_y)*(lppool.get(r2).sx - lppool.get(r2).ex);
						
						float t = ( (startx - lppool.get(r2).sx)*(lppool.get(r2).sy - lppool.get(r2).ey) - (starty - lppool.get(r2).sy)*(lppool.get(r2).sx - lppool.get(r2).ex) ) / denom; 
						
						float u = -(((startx - cast_x)*(starty - lppool.get(r2).sy) - (starty - cast_y)*(startx - lppool.get(r2).sx))/denom);
						
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
							
							intersect.add(new linepoint(startx, starty, min_px, min_py, conv_ang));
					}
				}
			}
		}
	}
	
	void sortpoints() {
		
		
		Collections.sort(intersect, linepoint.sort_angle);
		intersect.sort(linepoint.sort_angle);
		
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
		
		if(dark_mode) {
		g.setColor(Color.yellow);
		g.fillOval(startx-5, starty-5, 10, 10);
		
		double light_angle_2 =  Math.atan2(mousex - startx, mousey - starty);
		
		Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);
		
		arc.setFrame(startx - 200, starty-200, 400, 400);
		arc.setAngleStart((light_angle_2 / Math.PI * 180)-135);
		arc.setAngleExtent(90);
		
		g.setClip(arc);
		}
		
		
		for(int y = 0; y < world_height-1; y++) {
			for(int x = 0; x < world_length-1; x++) {
				if(blocks[(world_length - 1)*y+x].exist) {
					g.fillRect(x*blocksize, y*blocksize, blocksize, blocksize);
				}
			}
		}
		
		
		/*
		g.setColor(Color.red);
		for(int i = 0; i < lppool.size(); i++) {
			g.drawLine(lppool.get(i).sx, lppool.get(i).sy, lppool.get(i).ex, lppool.get(i).ey);
		}
		
		g.setColor(Color.blue);
		for(int i = 0; i < lppool.size(); i++) {
			g.fillOval(lppool.get(i).sx-2, lppool.get(i).sy-2, 4, 4);
			g.fillOval(lppool.get(i).ex-2, lppool.get(i).ey-2, 4, 4);
		}
		*/
		
		if(intersect.size() != 0 && light_on == 1) {
		g.setColor(new Color(100,100,100));
		for(int i = 0; i < intersect.size()-1; i++) {
			int pointsx[] = {startx, intersect.get(i).ex, intersect.get(i+1).ex};
			int pointsy[] = {starty, intersect.get(i).ey, intersect.get(i+1).ey};
			g.fillPolygon(pointsx, pointsy, 3);
		}
		int points2x[] = {startx, intersect.get(intersect.size()-1).ex, intersect.get(0).ex};
		int points2y[] = {starty, intersect.get(intersect.size()-1).ey, intersect.get(0).ey};
		g.fillPolygon(points2x, points2y, 3);
		}
		
		if(light_on == 2) {
		for(int i = 0; i < intersect.size(); i++) {
			g.setColor(Color.green);
			g.drawLine(startx, starty, intersect.get(i).ex, intersect.get(i).ey);
		}
		}
		
		/*
		for(int i = 0; i < lppool.size(); i++) {
			g.setColor(Color.red);
			g.drawLine(lppool.get(i).sx, lppool.get(i).sy, lppool.get(i).ex, lppool.get(i).ey);
		}
		*/
		
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
		mousex = e.getX();
		mousey = e.getY();
		
		gotolines(2000);
		sortpoints();
		repaint();
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
		if(e.getButton() == 1) {
			
			int mx = e.getX();
			int my = e.getY();
			
			
			if (!( (mx/blocksize <= 0) || (mx/blocksize >= world_length-1) || (my/blocksize <= 0) || (my/blocksize >= world_height-1))) {
			
			if( !blocks[(world_length - 1)*(my/blocksize)+(mx/blocksize)].exist ) {
				
				blocks[(world_length - 1)*(my/blocksize)+(mx/blocksize)].exist = true;
				}
			
			else {
	
				blocks[(world_length - 1)*(my/blocksize)+(mx/blocksize)].exist = false;
			}
			
			}
			
			gridtopoints();
			repaint();
		}
		if(e.getButton() == 2) {
			if(dark_mode) dark_mode = false;
			else dark_mode = true;
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		
		if(e.getButton() == 3) {
			
			light_on += 1;
			light_on %= 3;
		}

		
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyChar() == 'a') movex = -1;
		if(arg0.getKeyChar() == 'd') movex = 1;
		if(arg0.getKeyChar() == 's') movey = 1;
		if(arg0.getKeyChar() == 'w') movey = -1;

		gotolines(2000);
		sortpoints();
		repaint();
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		movex = 0;
		movey = 0;
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
	}
	
	class cursor_move extends TimerTask{

		@Override
		public void run() {
			if (movex != 0) {
				System.out.println(movex);
				startx += movex;
			}
			if (movey != 0) {
				System.out.println(movey);
				starty += movey;
			}
			try {
				if(movex != 0 || movey != 0) {
					gotolines(2000);
					sortpoints();
					repaint();
				}
			}catch(Exception e) {
				
			}
			
		}
		
	}
	
}







