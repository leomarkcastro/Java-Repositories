package text_swing_prototypes;

import java.awt.EventQueue;
import java.awt.Rectangle;
import java.util.Comparator;

import javax.swing.JFrame;

class initializer {
	
	public static void main(String args[]) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				JFrame mainframe = new JFrame();
				mainframe.setSize(800, 800);
				//mainframe.setLocationRelativeTo(null);
				mainframe.setDefaultCloseOperation(mainframe.EXIT_ON_CLOSE);
				mainframe.setAlwaysOnTop(true);
				
				mainframe.setLayout(null);
				
				//mainframe.setUndecorated(true);
				
				mainframe.add(new no01_textbox_dialogue());
				
				mainframe.setVisible(true);
				
				
			}
			
		});
		
	}
	
}
