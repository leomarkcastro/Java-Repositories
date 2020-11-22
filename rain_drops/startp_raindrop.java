package rain_drops;

import java.awt.Color;
import java.awt.EventQueue;
//import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

class startp_raindrop {
	
	public static void main(String args[]) {
		
		System.out.println("yey");
		
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				
				JFrame frame = new JFrame("Hello");
				frame.setSize(800,600);
				frame.getContentPane().setLayout(null);
				frame.setLocationRelativeTo(null);
				
				frame.setUndecorated(true);
				frame.setBackground(new Color(0,0,0,0));
				
				frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
				
				frame.add(new round_panel(800,600, frame));
				
				frame.setVisible(true);
			}
			
		});
		
		
	}
	
}

class round_panel extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener{

	int Fwidth;
	int Fheight;
	
	Thread rpthread;
	boolean running;
	
	int Fcolorr = 0;
	int Fcolorg = 0;
	int Fcolorb = 0;
	int Fcolort = 255;
	
	JFrame jframedummy;
	
	int mx, my;
	
	round_panel(int width, int height, JFrame jfra){
		this.Fwidth = width;
		this.Fheight = height;
		this.setBounds(0,0,width,height);
		this.setOpaque(false);
		
		setFocusable(true);
		
		addMouseMotionListener(this);
		addMouseListener(this);
		addKeyListener(this);
		
		jframedummy = jfra;
		
		start();
	}
	
	void start() {
		running = true;
		rpthread = new Thread(this);
		rpthread.start();
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
	
	public void paint(Graphics g) {
		
		g.setColor(new Color(this.Fcolorr, this.Fcolorg, this.Fcolorb, this.Fcolort));
		g.fillRoundRect(0, 0, this.Fwidth, this.Fheight, 10, 10);
		/*
		g.setColor(Color.white);
		g.setFont(new Font("Calibri", Font.PLAIN, 50));
		g.drawString((Integer.toString(this.Fcolor)), 50, 100);
		*/
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		if (key == KeyEvent.VK_Q) {if (Fcolorr < 255) this.Fcolorr += 1; }
		if (key == KeyEvent.VK_W) {if (Fcolorg < 255) this.Fcolorg += 1; }
		if (key == KeyEvent.VK_E) {if (Fcolorb < 255) this.Fcolorb += 1; }
		if (key == KeyEvent.VK_R) {if (Fcolort < 255) this.Fcolort += 1; }
		if (key == KeyEvent.VK_A) {if (Fcolorr > 0) this.Fcolorr -= 1; }
		if (key == KeyEvent.VK_S) {if (Fcolorg > 0) this.Fcolorg -= 1; }
		if (key == KeyEvent.VK_D) {if (Fcolorb > 0) this.Fcolorb -= 1; }
		if (key == KeyEvent.VK_F) {if (Fcolort > 0) this.Fcolort -= 1; }
	}
	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("Red: " +this.Fcolorr + " Green: " +this.Fcolorg + " Blue: " +this.Fcolorb + " Transparency: " +this.Fcolort);
	}
	@Override
	public void mousePressed(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getXOnScreen();
		int y = e.getYOnScreen();
		jframedummy.setLocation(x - mx, y - my);
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
