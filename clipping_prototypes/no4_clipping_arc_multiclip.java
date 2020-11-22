package clipping_prototypes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;

import javax.swing.JPanel;

class no4_clipping_arc_multiclip extends JPanel implements Runnable, MouseMotionListener, MouseWheelListener{

	Thread thread;
	boolean running;
	
	int px = 400, py = 400;
	int mx = 0, my = 0;
	
	no4_clipping_arc_multiclip(){
		this.setBounds(0, 0, 800, 800);
		this.setFocusable(true);
		addMouseMotionListener(this);
		addMouseWheelListener(this);
		
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
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g.create();
		g2.setColor(Color.white);
		g2.fillRect(0, 0, 800, 800);
		
		
		
		g2.setColor(Color.yellow);
		g2.fillOval(px-5, py-5, 10, 10);
		
		
		double angle = Math.atan2(py-my,mx-px);
		angle *= 180/Math.PI;
		
		g2.setColor(Color.black);
		g2.setFont(new Font("Calibri", Font.PLAIN, 25));
		g2.drawString("Angle" + angle, 0, 50);
		
		int angle_start = (int) ((angle - 20));
		int angle_end = (int) ((angle + 45));
		
		Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);
		arc.setFrame(px-200, py-200, 400, 400);
		arc.setAngleStart(angle_start);
		arc.setAngleExtent(40);
		
		Arc2D.Float arc2 = new Arc2D.Float(Arc2D.PIE);
		arc2.setFrame(px-200, py-200, 400, 400);
		arc2.setAngleStart(angle_start+40);
		arc2.setAngleExtent(40);
		
		Area shape = new Area();
		shape.add(new Area(arc));
		shape.add(new Area(arc2));
		
		g2.setClip(shape);
		//g2.setClip(arc2);
		
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


	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		if(e.getWheelRotation() < 0) {
			if(px > e.getX()) px-=3;
			else px+=3;
			if(py > e.getY()) py-=3;
			else py+=3;
		}
		else {
			if(px > e.getX()) px+=3;
			else px-=3;
			if(py > e.getY()) py+=3;
			else py-=3;
			}
		
	}

	
	

}
