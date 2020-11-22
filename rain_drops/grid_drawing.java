package rain_drops;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.io.IOException;
import java.io.InputStreamReader;

class globalvar{
	
	static String boxmap[] = {
			"AAAAAAAAAAAAAAAAAAAA",
			"A  A      AAAAA    A",
			"A  A      A        A",
			"A  A      AAAAA    A",
			"A  A      A        A",
			"A  AAAA   AAAAA    A",
			"A                  A",
			"A                  A",
			"A                  A",
			"A                  A",
			"A                  A",
			"A                  A",
			"A                  A",
			"A      AAAAAA      A",
			"A      A    A      A",
			"A      A    A      A",
			"A      A    A      A",
			"A      A    A      A",
			"A      AAAAAA      A",
			"AAAAAAAAAAAAAAAAAAAA",
			};
	
	static int keystate = 0;
	
}

class grid_drawing {

	public static void main(String args[]) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				grideditor g = new grideditor();
				JFrame frame = new JFrame();
				frame.setSize(800, 800);
				
				frame.add(new gridcontent(800,800));
				frame.add(new gridframe(800,800, frame));
				
				frame.setLocationRelativeTo(null);
				frame.setUndecorated(true);
				
				frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
				frame.setVisible(true);
				
					
			}
		});
	}
	
}


class gridframe extends JPanel implements MouseListener, MouseMotionListener, KeyListener{
	
	int Pwidth;
	int Pheight;
	int mx, my;
	JFrame framedummy;
	globalvar gv;
	
	gridframe(int width, int height, JFrame frame){
		Pwidth = width;
		Pheight = height;
		this.setBounds(0,0,width,height);
		setFocusable(true);
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);
		framedummy = frame;
		gv = new globalvar();
	}
	
	public void paint(Graphics g) {
		
		//g.setColor(Color.white);
		//g.fillRect(0, 0, Pwidth, Pheight);
		
		g.setColor(new Color(0,0,0,16));
		for(int i = 0; i < Pwidth; i += 10) g.drawLine(i, 0, i, Pheight);
		for(int i = 0; i < Pheight; i += 10) g.drawLine(0, i, Pwidth, i);
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
	public void mousePressed(MouseEvent e) {
		mx = e.getX();
		my = e.getY();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		int x = e.getXOnScreen();
		int y = e.getYOnScreen();
		framedummy.setLocation(x - mx, y - my);
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
	}
	@Override
	public void keyPressed(KeyEvent e) {
		int keyinp = e.getKeyCode();
		if(keyinp == KeyEvent.VK_D) {globalvar.keystate = 2;}
		else if(keyinp == KeyEvent.VK_A) {globalvar.keystate = 4;}
		else if(keyinp == KeyEvent.VK_W) {globalvar.keystate = 1;}
		else if(keyinp == KeyEvent.VK_S) {globalvar.keystate = 3;}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}


class gridcontent extends JPanel implements Runnable{
	
	Thread thread;
	boolean running;
	
	int Pwidth;
	int Pheight;
	
	int mx = 50, my = 50;
	
	JFrame framedummy;
	
	globalvar gv = new globalvar();
	
	gridcontent(int width, int height){
		Pwidth = width;
		Pheight = height;
		this.setBounds(0,0,width,height);
				
		start();
	}
	
	void start() {
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	
	@Override
	public void run() {
		while(running) {
			repaint();
		}
		
	}
	
	public void paint(Graphics g) {
		
		//g.setColor(Color.white);
		
		g.clearRect(0, 0, Pwidth, Pheight);
		
		g.setColor(new Color(0,0,0,64));
		for(int i = 0; i < Pwidth; i += 10) g.drawLine(i, 0, i, Pheight);
		for(int i = 0; i < Pheight; i += 10) g.drawLine(0, i, Pwidth, i);
		
		g.setColor(Color.red);
		
		
		for(int y = 0; y < globalvar.boxmap.length; y++) {
			for(int x = 0; x < globalvar.boxmap[y].length(); x++) {
				if (globalvar.boxmap[y].charAt(x) == 'A') {
					g.setColor(Color.red);
					g.fillRect(x*40, y*40, 40, 40);
				}
				if (globalvar.boxmap[y].charAt(x) == 'B') {
					g.setColor(Color.blue);
					g.fillRect(x*40, y*40, 40, 40);
				}
			}
		}
		
	}

	
}

class grideditor implements Runnable{

	Thread thread;
	boolean running;
	globalvar gv = new globalvar();
	int parti = 0;
	int xmove = 0;
	int ymove = 0;
	int ylevel = 10;
	
	grideditor(){
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	@Override
	public void run() {
		
		while(running) {

			globalvar.boxmap[ylevel] = globalvar.boxmap[ylevel].substring(0, parti+1) + ' ' + globalvar.boxmap[ylevel].substring(parti+2, 20);
			
			if (globalvar.keystate != 0) {
				switch (globalvar.keystate){
					case 2:
						if (parti < 17)
						xmove = 1;
						break;
					case 4:
						if (parti > 0)
						xmove = -1;
						break;
					case 1:
						if(ylevel > 1)
						ymove = -1;
						break;
					case 3:
						if(ylevel < 18)
						ymove = 1;
						break;
				}
			}
			
			parti += xmove;
			ylevel += ymove;
			
			
			
			globalvar.boxmap[ylevel] = globalvar.boxmap[ylevel].substring(0, parti+1) + 'B' + globalvar.boxmap[ylevel].substring(parti+2, 20);
			
			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if ((xmove != 0 || ymove != 0)&& globalvar.keystate != 0) {
				xmove = ymove = globalvar.keystate = 0;
			}
			
			
			
		}
		
	}
	
	
	
	
}





