package bank_co_ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Point2D;

import javax.swing.JButton;
import javax.swing.JLabel;

public class FButton extends JLabel implements MouseListener, MouseMotionListener, Runnable{

	int m_x = 0, m_y = 0;
	int click_size = 2;
	boolean in_box = false;
	boolean active = true;
	
	boolean running = false;
	Thread thread;
	
	Color BgColor1 = Color.LIGHT_GRAY;
	Color BgColor2 = Color.white;
	Color BgColorBase = Color.black;
	
	Color BdColor1 = Color.black; 
	Color BdColor2 = Color.white;
	Color BdColorBase = Color.white;
	
	Color DisabledBg = Color.lightGray;
	Color DisabledBd = Color.black;
	
	int timepaint;
	
	
	FButton(){
		initiate();
	}

	FButton(String title){
		super(title);
		initiate();
	}
	
	void initiate() {
		this.setFocusable(true);
		this.setHorizontalAlignment(CENTER);
		this.setVerticalAlignment(CENTER);
		addMouseListener(this);
		addMouseMotionListener(this);
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		int time;
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
	
	void gradientbackground(Color color1, Color color2) {
		this.BgColor1 = color1;
		this.BgColor2 = color2;
	}
	
	void gradientborder(Color color1, Color color2) {
		this.BdColor1 = color1;
		this.BdColor2 = color2;
	}
	
	public void paintComponent(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g.create();

		if(active) {
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
				
			}
			else {
				g2.setColor(BgColorBase);
				g2.fillRect(0, 0, super.getWidth(), super.getHeight());
				
				g2.setColor(BdColorBase);
				g2.drawRect(0, 0, super.getWidth()-1, super.getHeight()-1);
			}
		}
		else {
			g2.setColor(DisabledBg);
			g2.fillRect(0, 0, super.getWidth(), super.getHeight());
			g2.setColor(DisabledBd);
			g2.drawRect(0, 0, super.getWidth()-1, super.getHeight()-1);
		}
		

		
		
		super.paintComponent(g);
		
		try {
			Thread.sleep(1);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
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
		//this.setBackground(BgColorBase);
		//this.setForeground(BdColorBase);
		//in_box = false;
		
		//this.setBounds(super.getX()+click_size, super.getY()+click_size, super.getWidth()-(click_size*2), super.getHeight()-(click_size*2));
		//this.setFont(super.getFont());
		/*
		if(!active) {
			active = true;
			this.setForeground(Color.white);
		}
		else{
			active = false;
			this.setForeground(Color.white);
		}
		*/
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		//in_box = true;
		//this.setBounds(super.getX()-click_size, super.getY()-click_size, super.getWidth()+(click_size*2), super.getHeight()+(click_size*2));
	}

	

}
