package birck_breaker_prototypes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

class no2_createobject_bricks_ball extends JPanel implements Runnable, KeyListener{

	Thread thread;
	boolean running;
	
	int move_x = 0;
	int box_x = 400;
	int box_y = 600;
	
	Timer move;
	ArrayList<bricks> blocks = new ArrayList<bricks>();
	
	ball rball;
	
	no2_createobject_bricks_ball(){
		this.setBounds(0, 0, 800, 800);
		this.setFocusable(true);
		addKeyListener(this);
		
		initializeblocks();
		
		rball = new ball(400,400);
		
		move = new Timer();
		move.scheduleAtFixedRate(new movebar(), 0, 25);
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
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
			g.fillRect(75+(blocks.get(i).sx),50+(blocks.get(i).sy+10), blocks.get(i).width, blocks.get(i).height);
		}
		
		g.setColor(Color.blue);
		g.fillOval(rball.sx, rball.sy, 15, 15);
		
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
	
}
