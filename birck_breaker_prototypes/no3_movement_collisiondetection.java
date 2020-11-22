package birck_breaker_prototypes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

class no3_movement_collisiondetection extends JPanel implements Runnable, KeyListener{

	Thread thread;
	boolean running;
	
	int move_x = 0;
	int box_x = 400;
	int box_y = 600;
	
	//Ball_traverse direction
	int ballt_x = 1;
	int ballt_y = 1;
	
	Timer move;
	Timer motiontimer;
	
	ArrayList<bricks> blocks = new ArrayList<bricks>();
	ball rball;
	
	no3_movement_collisiondetection(){
		this.setBounds(0, 0, 800, 800);
		this.setFocusable(true);
		addKeyListener(this);
		
		initializeblocks();
		
		rball = new ball(400,400);
		
		move = new Timer();
		move.scheduleAtFixedRate(new movebar(), 0, 12);
		motiontimer = new Timer();
		motiontimer.scheduleAtFixedRate(new motionactions(), 0, 12);
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		while(running) {
			repaint();
			
			try {
				Thread.sleep(12);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	void initializeblocks() {
		
		for(int y = 0; y < 5; y++) {
			for(int x = 0; x < 6; x++) {
				blocks.add(new bricks(x*105, y*55));
			}
		}
		
	}
	
	public void paint(Graphics g) {
		
		g.setColor(Color.white);
		g.fillRect(0, 0, 800, 800);
		
		g.setColor(Color.green);
		for(int i = 0; i < blocks.size(); i++) {
			if(blocks.get(i).exist)
			g.fillRect((blocks.get(i).sx),(blocks.get(i).sy+10), blocks.get(i).width, blocks.get(i).height);
		}
		
		g.setColor(Color.blue);
		g.fillOval(rball.sx, rball.sy, rball.ballsize, rball.ballsize);
		
		g.setColor(Color.red);
		g.fillRect(box_x, box_y, 100, 20);
		
	}
	
	
	@Override
	public void keyPressed(KeyEvent e) {
		
		switch(e.getKeyChar()) {
			case 'a': 
				move_x = -5;
				break;
			case 'd':
				move_x = 5;
				break;
			case 'A': 
				move_x = -20;
				break;
			case 'D':
				move_x = 20;
				break;
		}
		
	}
	@Override
	public void keyReleased(KeyEvent e) {
		move_x = 0;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
	
	private class movebar extends TimerTask{

		@Override
		public void run() {
			if(move_x > 0) {
				box_x += move_x;
			}
			if (move_x < 0) {
				box_x += move_x;
			}
		}
		
	}
	
	private class motionactions extends TimerTask{

		@Override
		public void run() {
			if((rball.sx + rball.ballsize >= 800) || (rball.sx <= 0)) {
				ballt_x *= -1;
			}
			if((rball.sy + rball.ballsize >= 800) || (rball.sy <= 0)) {
				ballt_y *= -1;
			}
			
			Rectangle rectball = rball.getBounds();
			
			for(bricks b: blocks) {
				
				if(rectball.intersects(b.getBounds()) && b.exist) {
					b.exist = false;
					
					if((rball.sy >= b.sy-10) && (rball.sy + rball.ballsize <= b.sy + b.height+10)) {
						ballt_x *= -1;
						//if((rball.sx + rball.ballsize <= b.sx)) ballt_x *= -1;
						//else if ((rball.sx >= b.sx + b.width)) ballt_x *= -1;
					}
					if((rball.sx >= b.sx-10) && (rball.sx + rball.ballsize <= b.sx + b.width+10)) {
						ballt_y *= -1;
						//if((rball.sx + rball.ballsize <= b.sx)) ballt_x *= -1;
						//else if ((rball.sx >= b.sx + b.width)) ballt_x *= -1;
					}
					else {
						ballt_y *= 1;
					}
					
				}
				
			}
			
			if(rectball.intersects(box_x, box_y, 100, 18)) {
				ballt_y *= -1;
				if(rball.sx + rball.ballsize > box_x+50) ballt_x = 1;
				else ballt_x = -1;
			}
			
			rball.sx += ballt_x*3;
			rball.sy += ballt_y*3;

		}
		
	}
	
}
