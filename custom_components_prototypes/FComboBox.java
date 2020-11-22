package custom_components_prototypes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

class FComboBox extends JLabel implements Runnable, MouseListener, MouseMotionListener{

	Thread thread;
	boolean running = false;
	
	int contentsToDisplay = 5;
	ArrayList<String> contents;
	
	int m_x = 0, m_y = 0;
	int click_size = 2;
	boolean in_box = false;
	boolean click = false;
	boolean active = true;
	
	Color BgColor1 = Color.LIGHT_GRAY;
	Color BgColor2 = Color.white;
	Color BgColorBase = Color.black;
	Color BgClick = Color.DARK_GRAY;
	
	Color BdColor1 = Color.black; 
	Color BdColor2 = Color.white;
	Color BdColorBase = Color.white;
	Color BdClick = Color.white;
	
	Color DisabledBg = Color.lightGray;
	Color DisabledBd = Color.black;
	
	int timepaint;
	
	FComboBox(){
		initiate();
	}
	
	FComboBox(String title){
		super(title);
		initiate();
	}
	
	void initiate() {
		this.setHorizontalAlignment(LEFT);
		this.setVerticalAlignment(CENTER);
		
		this.setFocusable(true);
		addMouseListener(this);
		addMouseMotionListener(this);
		
		contents = new ArrayList<String>();
		
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		while(running) {
			repaint();
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	void setBgGradient(Color Base, Color gra1, Color gra2, Color disabled, Color click) {
		this.BgColorBase = Base;
		this.BgColor1 = gra1;
		this.BgColor2 = gra2;
		this.DisabledBg = disabled;
		this.BgClick = click;
	}
	
	void setBdGradient(Color Base, Color gra1, Color gra2, Color disabled, Color click) {
		this.BdColorBase = Base;
		this.BdColor1 = gra1;
		this.BdColor2 = gra2;
		this.DisabledBd = disabled;
		this.BdClick = click;
	}
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g.create();
		
		
		
		if(active) {
			if(!click){
				if(in_box) {
					Point2D center = new Point2D.Float(m_x, m_y);	
					float radius = 800;
					float dist[] = {0f, 1.0f};
					Color color[] = {BgColor1, BgColor2};
					RadialGradientPaint p = new RadialGradientPaint(center, radius, dist, color);
					g2.setPaint(p);
					g2.fillRect(0, 0, super.getWidth(), super.getHeight());
					
					Point2D center2 = new Point2D.Float(m_x, m_y);	
					float radius2 = 200;
					float dist2[] = {0f, 1.0f};
					Color color2[] = {BdColor1, BdColor2};
					RadialGradientPaint p2 = new RadialGradientPaint(center2, radius2, dist2, color2);
					g2.setPaint(p2);
					g2.drawRect(0, 0, super.getWidth()-1, super.getHeight()-1);
					
				}else {
					g2.setColor(BgColorBase);
					g2.fillRect(0, 0, super.getWidth(), super.getHeight());
					
					g2.setColor(BdColorBase);
					g2.drawRect(0, 0, super.getWidth()-1, super.getHeight()-1);
				}
			}else {
				g2.setColor(BgClick);
				g2.fillRect(0, 0, super.getWidth(), super.getHeight());
				
				g2.setColor(BdClick);
				g2.drawRect(0, 0, super.getWidth()-1, super.getHeight()-1);
			}
		}else {
			g2.setColor(DisabledBg);
			g2.fillRect(0, 0, super.getWidth(), super.getHeight());
			g2.setColor(DisabledBd);
			g2.drawRect(0, 0, super.getWidth()-1, super.getHeight()-1);
		}
		
		
		
		super.paintComponent(g);
		/*
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		if(in_box && active) {
			m_x = e.getX();
			m_y = e.getY();
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {

	}
	@Override
	public void mouseEntered(MouseEvent e) {
		in_box = true;
	}
	@Override
	public void mouseExited(MouseEvent e) {
		in_box = false;
	}
	@Override
	public void mousePressed(MouseEvent e) {
		click = true;
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		click = false;
	}

	class dropDown extends JPanel implements Runnable, MouseListener, MouseMotionListener{

		dropDown(int width){
			this.setBounds(r);
		}
		
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		@Override
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
		
		
	}
	
}
