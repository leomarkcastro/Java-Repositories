package shadow_casting_prototypes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Scanner;

import javax.swing.JPanel;

class no1_angletest_givenangle_radians extends JPanel implements Runnable{

	Thread thread;
	boolean running;
	float angle = 0;
	int x2 = 0, y2 = 0;
	Scanner scan;
	
	no1_angletest_givenangle_radians(){
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
			angle = scan.nextFloat();
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
		
		x2 = (int) (400 + 400*Math.cos(angle));
		y2 = (int) (400 + 400*Math.sin(angle));
		
	}
	
	public void paint(Graphics g) {
		
		g.setColor(Color.white);
		g.fillRect(0, 0, 800, 800);
		
		g.setColor(Color.black);
		g.setFont(new Font("Calibri", Font.PLAIN, 25));
		g.drawString("Angle: " + angle, 0, 50);
		
		g.drawLine(400, 400, x2, y2);
		
	}
	
	
}