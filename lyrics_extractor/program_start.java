package lyrics_extractor;

import java.awt.EventQueue;
import javax.swing.JFrame;

class program_start {
	
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				JFrame main = new JFrame("Lyrics Extractor");
				main.setSize(800, 600);
				main.setLocationRelativeTo(null);
				main.setResizable(false);
				main.setDefaultCloseOperation(main.EXIT_ON_CLOSE);
				
				pane_extractor pan = new pane_extractor(800,600);
				
				main.getContentPane().add(pan);
				
				pan.update_text();
				
				main.setVisible(true);
			}
			
		});
	}
	
}
