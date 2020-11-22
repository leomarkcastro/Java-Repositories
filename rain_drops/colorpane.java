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
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

class colorpane {
	
	public static void main(String args[]) {
		
		EventQueue.invokeLater(new Runnable() {

			public void run() {
				
				JFrame frame = new JFrame("Hello");
				frame.setSize(800,600);
				frame.getContentPane().setLayout(null);
				frame.setLocationRelativeTo(null);
				
				frame.setUndecorated(true);
				frame.setBackground(new Color(0,0,0,0));
				frame.setAlwaysOnTop(true);
				frame.setResizable(true);
				
				frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
				
				frame.add(new round_panel2(800,600, frame));
				
				frame.setVisible(true);
			}
			
		});
		
		
	}
	
}

class round_panel2 extends JPanel implements Runnable, MouseListener, MouseMotionListener{

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
	
	round_panel2(int width, int height, JFrame jfra){
		this.Fwidth = width;
		this.Fheight = height;
		this.setBounds(0,0,width,height);
		this.setOpaque(false);
		
		setFocusable(true);
		
		addMouseMotionListener(this);
		addMouseListener(this);
		
		jframedummy = jfra;
		
		start();
	}
	
	void start() {
		running = true;
		rpthread = new Thread(this);
		System.out.println("Red: " +this.Fcolorr + "\t\tGreen: " +this.Fcolorg + "\tBlue: " +this.Fcolorb + "\t\tTransparency: " +this.Fcolort);
		rpthread.start();
	}
	
	@Override
	public void run() {
		while(running) {
			
			Scanner scan = new Scanner(System.in);
			char typecolor =scan.next().charAt(0);
			int colorval = scan.nextInt()%256;
			
			if(Character.toLowerCase(typecolor) == 'r') {Fcolorr = colorval; System.out.println("Red: " +this.Fcolorr + "\t\tGreen: " +this.Fcolorg + "\tBlue: " +this.Fcolorb + "\t\tTransparency: " +this.Fcolort);}
			else if(Character.toLowerCase(typecolor) == 'g') {Fcolorg = colorval; System.out.println("Red: " +this.Fcolorr + "\t\tGreen: " +this.Fcolorg + "\tBlue: " +this.Fcolorb + "\t\tTransparency: " +this.Fcolort);}
			else if(Character.toLowerCase(typecolor) == 'b') {Fcolorb = colorval; System.out.println("Red: " +this.Fcolorr + "\t\tGreen: " +this.Fcolorg + "\tBlue: " +this.Fcolorb + "\t\tTransparency: " +this.Fcolort);}
			else if(Character.toLowerCase(typecolor) == 't') {Fcolort = colorval; System.out.println("Red: " +this.Fcolorr + "\t\tGreen: " +this.Fcolorg + "\tBlue: " +this.Fcolorb + "\t\tTransparency: " +this.Fcolort);}
			
			
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
