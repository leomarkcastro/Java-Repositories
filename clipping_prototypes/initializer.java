package clipping_prototypes;

import java.awt.EventQueue;
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
				
				mainframe.add(new no4_clipping_arc_multiclip());
				
				mainframe.setVisible(true);
			}
			
		});
		
	}
	
}