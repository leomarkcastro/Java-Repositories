package shadow_casting_prototypes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Scanner;

import javax.swing.JPanel;

class no2_angletest_givensides extends JPanel implements Runnable{

	Thread thread;
	boolean running;
	float angle = 0;
	int x2 = 0, y2 = 0, x3 = 0, y3 = 0;
	Scanner scan;
	
	no2_angletest_givensides(){
		this.setBounds(0,0,800,800);
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	@Override
	public void run() {
		scan = new Scanner(System.in);
		while(running) {
			//angle += 1;
			x2 = scan.nextInt();
			y2 = scan.nextInt();
			processangle();
			repaint();
			
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	void processangle() {
		
		angle = (float) Math.atan2(y2-400, x2-400);
		
		x3 = (int) (400 + 400*Math.cos(angle));
		y3 = (int) (400 + 400*Math.sin(angle));
		
	}
	
	public void paint(Graphics g) {
		
		g.setColor(Color.white);
		g.fillRect(0, 0, 800, 800);
		
		g.setColor(Color.black);
		g.setFont(new Font("Calibri", Font.PLAIN, 25));
		g.drawString("Angle: " + angle, 0, 50);
		g.drawString("x3: " + x3, 0, 100);
		g.drawString("y3: " + y3, 0, 150);
		
		g.setColor(Color.blue);
		g.drawLine(400, 400, x2, 400);
		g.setColor(Color.green);
		g.drawLine(400, 400, 400, y2);
		g.setColor(new Color(255,0,0,32));
		g.drawLine(400, 400, x3, y3);
		
	}
	
	
}