package shadow_casting_prototypes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Scanner;

import javax.swing.JPanel;

class no3_collision_givenpoints_trial1 extends JPanel implements Runnable, MouseMotionListener{

	Thread thread;
	boolean running;
	float angle = 0;
	int mx = 0, my = 0, mx0 = 200, my0 = 200;
	int x0 = 0, y0 = 0, x1 = 0, y1 = 0;
	int px = 0, py = 0;
	Scanner scan;
	
	no3_collision_givenpoints_trial1(){
		this.setBounds(0,0,800,800);
		this.setFocusable(true);
		addMouseMotionListener(this);
		running = true;
		thread = new Thread(this);
		thread.start();
		
	}
	
	@Override
	public void run() {
		
		scan = new Scanner(System.in);
		
		x0 = (int) (Math.random()*800);
		y0 = (int) (Math.random()*800);
		x1 = (int) (Math.random()*800);
		y1 = (int) (Math.random()*800);
		
		while(running) {
			
			processpoint();
			repaint();
			
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	void processpoint() {
		
		float denom = (mx0 - mx)*(y0 - y1) - (my0 - my)*(x0 - x1);
		
		float t =    ( (mx0 - x0)*(y0 - y1) - (my0 - y0)*(x0 - x1) ) / denom; 
		
		float u = -( ( (mx0 - mx)*(my0 - y0) - (my0 - my)*(mx0 - x0) ) / denom );
		
		if(t >= 0 && t <= 1 && u >= 0 && u <= 1) {
			
			px = (int) (mx0 + t*(mx - mx0));
			py = (int) (my0 + t*(my - my0));
			
		}
		
	}
	
	public void paint(Graphics g) {
		
		g.setColor(Color.white);
		g.fillRect(0, 0, 800, 800);
		
		g.setColor(Color.black);
		g.setFont(new Font("Calibri", Font.PLAIN, 25));
		g.drawString("Angle: " + angle, 0, 50);
		g.drawString("mx: " + mx, 0, 80);
		g.drawString("my: " + my, 0, 110);
		
		g.setColor(Color.blue);
		g.drawLine(x0, y0, x1, y1);
		g.setColor(new Color(255,0,0));
		g.drawLine(mx0, my0, mx, my);
		
		g.setColor(Color.black);
		g.fillOval(px-5, py-5, 10, 10);
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
	}
	
	
}