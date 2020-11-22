package physics_blocks2D;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

class no1_singleblock_newtonmotion extends JPanel implements Runnable, KeyListener{

	int interval = 12; //frames_per_second is 1000/interval. 1000/25 = 60fps.
	
	Thread thread;
	boolean running;
	
	ArrayList<Block> bl;
	Timer control, motion, collision;
	
	int bx = 0, by = 0;
	
	no1_singleblock_newtonmotion(){
		this.setBounds(0, 0, 800, 800);
		
		setFocusable(true);
		addKeyListener(this);
		
		bl = new ArrayList<Block>();
		
		bl.add(new Block(100,100,20));
		bl.add(new Block(400,400,20));
		bl.add(new Block(500,500,20));
		bl.get(0).mass = bl.get(1).mass = bl.get(2).mass = 100;
		
		control = new Timer();
		motion = new Timer();
		collision = new Timer();
		
		control.scheduleAtFixedRate(new controltask(), 0, interval);
		motion.scheduleAtFixedRate(new motiontask(), 0, interval);
		collision.scheduleAtFixedRate(new collisiontask(), 0, interval/3);
		
		thread = new Thread(this);
		running = true;
		thread.start();
		
	}
	
	@Override
	public void run() {
		while (running){
			repaint();
			//System.out.println("ForceX: " + bl.get(0).velox + " ForceY: " + bl.get(0).veloy);
			
			try {
				Thread.sleep(interval);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	public void paint(Graphics g) {
		
		g.setColor(Color.white);
		g.fillRect(0, 0, 800, 800);
		
		
		for(int i = 0; i < bl.size(); i++) {
			if(i == 0) g.setColor(Color.red);
			else g.setColor(Color.blue);
			g.fillRect(bl.get(i).sx, bl.get(i).sy, bl.get(i).width, bl.get(i).height);
		}
		
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyChar() == 'a') bx = -10;
		if(arg0.getKeyChar() == 'd') bx = 10;
		if(arg0.getKeyChar() == 's') by = 10;
		if(arg0.getKeyChar() == 'w') by = -10;
	}
	@Override
	public void keyReleased(KeyEvent e) {
		bx = by = 0;
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	private class controltask extends TimerTask{

		@Override
		public void run() {
			if (bx != 0) { bl.get(0).forcex = bx; }
			else { bl.get(0).forcex = 0; }
			
			if (by != 0) { bl.get(0).forcey = by; }
			else { bl.get(0).forcey = 0; }
			
		}
		
		
	}
	private class motiontask extends TimerTask{

		@Override
		public void run() {
			
			for(int i = 0; i < bl.size(); i++) {
				
			if (bl.get(i).sx < 0) { bl.get(i).sx = 0; bl.get(i).velox *= -1;}
			if (bl.get(i).sy < 0) { bl.get(i).sy = 0; bl.get(i).veloy*= -1;}
			if (bl.get(i).sx + bl.get(i).width > 800) { bl.get(i).sx = 800-bl.get(i).width; bl.get(i).velox *= -1;}
			if (bl.get(i).sy + bl.get(i).height > 800) { bl.get(i).sy = 800-bl.get(i).height ; bl.get(i).veloy *= -1;}
			bl.get(i).motion();
			
			}
		}
		
	}
	
	private class collisiontask extends TimerTask{

		@Override
		public void run() {
			
			
			for(int i = 0; i < bl.size(); i++) {
				
				Rectangle rect = (bl.get(i).getBounds());
				
				for(int j = 0; j < bl.size(); j++) {
					
					if(i != j) {
						if (rect.intersects(bl.get(j).getBounds())) {
							
							//System.out.println("hit");
							
							bl.get(j).velox = bl.get(i).velox;
							bl.get(j).veloy = bl.get(i).veloy;
							
							
							if (bl.get(i).velox > 1) bl.get(i).sx = bl.get(j).sx - bl.get(i).width - 3;
							else if (bl.get(i).velox < 0){bl.get(i).sx =  bl.get(j).sx + bl.get(j).width + 3; }
							
							if (bl.get(i).veloy > 1) bl.get(i).sy = bl.get(j).sy - bl.get(i).height - 3;
							else if (bl.get(i).veloy < 0){bl.get(i).sy =  bl.get(j).sy + bl.get(j).height + 3; }
							
							bl.get(i).velox = bl.get(i).veloy = bl.get(i).forcex = bl.get(i).forcey = 0;
							
							bl.get(j).motion();
							
						
						}
					}
				}
			}	
		}
	}
	
}
