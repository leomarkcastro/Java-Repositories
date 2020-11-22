package modern_form_roughsketches;

import java.awt.EventQueue;
import java.awt.Rectangle;
import java.util.Comparator;

import javax.swing.JFrame;
import javax.swing.JPanel;

class runner_func {
	
	public static void main(String args[]) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				Sidepane sidepane = new Sidepane();
				
				JFrame mainframe = new JFrame();
				mainframe.setSize(800, 800);
				//mainframe.setLocationRelativeTo(null);
				mainframe.setDefaultCloseOperation(mainframe.EXIT_ON_CLOSE);
				mainframe.setAlwaysOnTop(true);
				
				mainframe.setUndecorated(true);
				
				mainframe.add(sidepane);
				
				mainframe.setVisible(true);
				
				
			}
			
		});
		
	}
	
}

class Sidepane extends JPanel{
	
	
	
}








