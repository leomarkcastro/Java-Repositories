package modify_panel_layers;

import java.awt.Color;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

class no_01_test_remove_component {

	public static void main(String args[]) {
		
		JFrame frame = new JFrame();
		frame.setBounds(100,100,800,800);
		frame.setLayout(null);
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setAlwaysOnTop(true);

		frame.setVisible(true);
		
		
		Scanner pause = new Scanner(System.in);
		pause.nextInt();
		
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(100,100,100,100);
		panel1.setBackground(Color.blue);
		frame.add(panel1);
		
		frame.repaint();
		
		pause.nextInt();
		
		frame.remove(panel1);
		
		frame.repaint();
		
	}
	
}
