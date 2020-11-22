package text_swing_prototypes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JPanel;

class no01_textbox_dialogue extends JPanel implements MouseListener{

	int txt_level = 0;
	String message[] = new String[3];
	
	Timer text_iter, text_pro;
	
	no01_textbox_dialogue(){
		this.setBounds(0, 0, 600, 200);
		this.setBackground(Color.black);
		setFocusable(true);
		addMouseListener(this);
		
		text_iter = new Timer();
		text_pro = new Timer();
		
		text_iter.scheduleAtFixedRate(new text_iter_task(), 0, 250);
		
	}
	
	public void paint (Graphics g) {
		
		super.paint(g);
		g.setColor(Color.red);
		g.fillRect(0, 0, 100, 100);
		g.setColor(Color.white);
		g.setFont(new Font("Agency FB", Font.PLAIN, 25));
		
		g.drawString("Yey", 25, 25);
		//g.drawString(message[0], 50, 75);
		//g.drawString(message[1], 50, 100);
		//g.drawString(message[2], 50, 125);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//message = new String();
		
		
		
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
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private class text_iter_task extends TimerTask{

		@Override
		public void run() {
			
			
			
			repaint();
		}
	
		
		
	}
	
}
