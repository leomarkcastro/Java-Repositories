package modern_form_roughsketches;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.border.LineBorder;


public class rough_sketch_login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rough_sketch_login frame = new rough_sketch_login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public rough_sketch_login() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 965, 710);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 334, 710);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblStagInit = new JLabel("BANK CO.");
		lblStagInit.setForeground(new Color(255, 255, 255));
		lblStagInit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStagInit.setFont(new Font("Square721 BT", Font.PLAIN, 40));
		lblStagInit.setBounds(0, 279, 310, 56);
		panel.add(lblStagInit);
		
		JTextArea txtrWhereYouPay = new JTextArea();
		txtrWhereYouPay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		txtrWhereYouPay.setLineWrap(true);
		txtrWhereYouPay.setDisabledTextColor(new Color(255, 255, 255));
		txtrWhereYouPay.setEnabled(false);
		txtrWhereYouPay.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		txtrWhereYouPay.setOpaque(false);
		txtrWhereYouPay.setText("where you pay more, with less hassle");
		txtrWhereYouPay.setBounds(125, 348, 185, 61);
		panel.add(txtrWhereYouPay);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(101, 340, 209, 2);
		panel.add(separator);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(333, 0, 632, 710);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLogIn = new JLabel("WELCOME BACK!");
		lblLogIn.setBounds(12, 163, 543, 50);
		panel_1.add(lblLogIn);
		lblLogIn.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogIn.setForeground(new Color(0, 0, 0));
		lblLogIn.setFont(new Font("Square721 BT", Font.PLAIN, 40));
		
		txtUsername = new JTextField();
		txtUsername.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtUsername.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		txtUsername.setText("username");
		txtUsername.setBounds(12, 300, 543, 40);
		panel_1.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setText("password");
		txtPassword.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		txtPassword.setColumns(10);
		txtPassword.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		txtPassword.setBounds(12, 346, 543, 40);
		panel_1.add(txtPassword);
		
		JButton btnNewButton = new JButton("LOG IN");
		btnNewButton.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(362, 466, 193, 50);
		panel_1.add(btnNewButton);
		
		JTextArea txtrANewUser = new JTextArea();
		txtrANewUser.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		txtrANewUser.setWrapStyleWord(true);
		txtrANewUser.setText("A new user? Create an account here");
		txtrANewUser.setOpaque(false);
		txtrANewUser.setLineWrap(true);
		txtrANewUser.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		txtrANewUser.setEnabled(false);
		txtrANewUser.setDisabledTextColor(new Color(0, 0, 0));
		txtrANewUser.setBounds(362, 519, 193, 61);
		panel_1.add(txtrANewUser);
	}
}
