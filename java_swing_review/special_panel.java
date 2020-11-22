package java_swing_review;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

class special_panel extends JPanel implements Runnable{
	
	private Thread thread;
	private boolean running = false;
	
	Timer task1;
	
	int WIDTH;
	int HEIGHT;
	
	int POSITx = 0;
	int POSITy = 0;
	
	int TRAVx = 1;
	int TRAVy = 1;
	
	long TICK = System.currentTimeMillis();
	
	int interval = 5;
	
	special_panel(int width, int height){
		
		this.setBounds(0, 0, width, height);
		this.WIDTH = width;
		this.HEIGHT = height;
		
		this.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent m) {
				if(m.getButton() == MouseEvent.BUTTON1) {
					TRAVy *= -1;
				}
				if(m.getButton() == MouseEvent.BUTTON3) {
					TRAVx *= -1;
				}
				if(m.getButton() == MouseEvent.BUTTON2) {
					task1.cancel();
				}
			}
		});
		
		start();
	}
	
	public void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		
		task1 = new Timer();
		task1.scheduleAtFixedRate(new movement(), 0, interval);
		
		/*
		
		while(running) {
			if(POSITx > WIDTH - 50 || POSITx < 0) TRAVx *= -1;
			if(POSITy > HEIGHT - 50 || POSITy < 0) TRAVy *= -1;
			
			
			POSITx += (1 * TRAVx) * (((System.currentTimeMillis() - TICK) > interval) ? 1 : 0);
			POSITy += (1 * TRAVy) * (((System.currentTimeMillis() - TICK) > interval) ? 1 : 0);
			if ((System.currentTimeMillis() - TICK) > interval) TICK = System.currentTimeMillis();
			
			
			POSITx += (1 * TRAVx);
			POSITy += (1 * TRAVy);
			
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
		
			
			
		}
			

	
	public void stop() {
		try {
			thread.join();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void paint(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		
		g2.clearRect(0, 0, WIDTH, HEIGHT);
		g2.setColor(Color.WHITE);
		g2.setStroke(new BasicStroke(3));
		g2.fillRoundRect(0, 0, WIDTH-1, HEIGHT-1, 50, 50);
		g2.setColor(Color.RED);
		g2.fillOval(POSITx, POSITy, 50, 50);
		
	}

	private class movement extends TimerTask{
		@Override
		public void run() {
			if(POSITx > WIDTH - 50 || POSITx < 0) TRAVx *= -1;
			if(POSITy > HEIGHT - 50 || POSITy < 0) TRAVy *= -1;
			
			POSITx += (1 * TRAVx);
			POSITy += (1 * TRAVy);
			
			repaint();
		
			
		}
	}

}
