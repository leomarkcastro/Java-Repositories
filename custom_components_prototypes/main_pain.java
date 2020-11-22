package custom_components_prototypes;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

class main_pain{
	
	public static void main (String args[]) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				JFrame mainframe = new JFrame("Custom Components");
				mainframe.setSize(800,800);
				//mainframe.setLocationRelativeTo(null);
				mainframe.setDefaultCloseOperation(mainframe.EXIT_ON_CLOSE);
				mainframe.setUndecorated(true);
				//mainframe.setOpacity(0);
				//mainframe.setBackground(new Color(0,0,0,0));
				mainframe.setLayout(null);
				
				FPanel panelhandle = new FPanel();
				panelhandle.setBounds(0,0,800,800);
				panelhandle.setBackground(Color.white);
				panelhandle.setLayout(null);
				
				FButton fb1 = new FButton("Yes");
				fb1.setBounds(10,10,50,50);
				fb1.setBackground(Color.black);
				fb1.setForeground(Color.white);
				fb1.gradientbackground(Color.DARK_GRAY, Color.black);
				fb1.gradientborder(Color.white, Color.darkGray);
				fb1.setFont(new Font("Square721 BT", Font.PLAIN, 20));
				panelhandle.add(fb1);
				
				FComboBox fcb1 = new FComboBox("Yes");
				fcb1.setBounds(100,100,250,25);
				fcb1.setBgGradient(Color.white, Color.white, new Color(200,200,200), new Color(175,175,175), Color.LIGHT_GRAY);
				fcb1.setBdGradient(Color.black, Color.black, Color.LIGHT_GRAY, Color.DARK_GRAY, Color.black);
				fcb1.setFont(new Font("Square721 BT", Font.PLAIN, 20));
				panelhandle.add(fcb1);
				
				mainframe.add(panelhandle);
				mainframe.setVisible(true);
			}
			
		});
		
	}
	
}
