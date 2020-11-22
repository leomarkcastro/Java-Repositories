package java_swing_review;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

class program_runner {
	
	public static void main(String args[]) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				main_window main = new main_window("Testaaaaaa", 800, 600);
				main.setUndecorated(true);
				main.setBackground(new Color(0,0,0,0));
				
				special_panel pan1 = new special_panel(800,600);
				pan1.setOpaque(false);
				
				
				
				main.add(pan1);
				
				main.setLocationRelativeTo(null);
				main.setVisible(true);
				
				
			}
			
			
		});
		
	}
	
}
