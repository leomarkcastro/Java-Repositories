package birck_breaker_prototypes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

class no1_smooth_keyboard_move extends JPanel implements Runnable, KeyListener{

	Thread thread;
	boolean running;
	
	int move_x = 0;
	int box_x = 400;
	int box_y = 600;
	
	Timer move;
	
	no1_smooth_keyboard_move(){
		this.setBounds(0, 0, 800, 800);
		this.setFocusable(true);
		addKeyListener(this);
		
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
	
	public void paint(Graphics g) {
		
		g.setColor(Color.white);
		g.fillRect(0, 0, 800, 800);
		
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
