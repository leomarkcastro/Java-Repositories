package clipping_prototypes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Arc2D;

import javax.swing.JPanel;

class no2_clipping_customshape_arc_stationary extends JPanel implements Runnable, MouseMotionListener{

	Thread thread;
	boolean running;
	
	int mx = 0, my = 0;
	
	no2_clipping_customshape_arc_stationary(){
		this.setBounds(0, 0, 800, 800);
		this.setFocusable(true);
		addMouseMotionListener(this);
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		
	}
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setColor(Color.white);
		g2.fillRect(0, 0, 800, 800);
		
		double angle = Math.atan2(400-my,mx-400);
		angle *= 180/Math.PI;
		
		g2.setColor(Color.black);
		g2.setFont(new Font("Calibri", Font.PLAIN, 25));
		g2.drawString("Angle" + angle, 0, 50);
		
		int angle_start = (int) ((angle - 20));
		int angle_end = (int) ((angle + 45));
		
		Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);
		arc.setFrame(0, 0, 800, 800);
		arc.setAngleStart(angle_start);
		arc.setAngleExtent(40);
		
		g2.clip(arc);
		
		for(int i = 0; i < 300; i++) {
			g2.setColor(new Color(i%200 , (200/5)%150 , (200/20)%150 ) );
			g2.fillRect(((i%16)*50), ((i/16)*50), 50, 50);
		}
		
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
		repaint();
	}
	

}
