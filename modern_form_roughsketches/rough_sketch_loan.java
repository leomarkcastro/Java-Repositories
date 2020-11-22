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
import javax.swing.UIManager;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.BevelBorder;
import javax.swing.JSlider;


public class rough_sketch_loan extends JFrame {

	private JPanel contentPane;
	private JTextField txtDateOfTranaction;
	private JTextField txtPinCode;
	private JTextField txtAmountNeeded;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rough_sketch_loan frame = new rough_sketch_loan();
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
	public rough_sketch_loan() {

		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 965, 710);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		panel.setBounds(0, 0, 231, 710);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblStagInit = new JLabel("BANK CO.");
		lblStagInit.setForeground(new Color(255, 255, 255));
		lblStagInit.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStagInit.setFont(new Font("Square721 BT", Font.PLAIN, 40));
		lblStagInit.setBounds(12, 24, 207, 56);
		panel.add(lblStagInit);
		
		JTextArea txtrWhereYouPay = new JTextArea();
		txtrWhereYouPay.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtrWhereYouPay.setLineWrap(true);
		txtrWhereYouPay.setDisabledTextColor(new Color(255, 255, 255));
		txtrWhereYouPay.setEnabled(false);
		txtrWhereYouPay.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		txtrWhereYouPay.setOpaque(false);
		txtrWhereYouPay.setText("UserName");
		txtrWhereYouPay.setBounds(80, 118, 139, 28);
		panel.add(txtrWhereYouPay);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 85, 207, 2);
		panel.add(separator);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 98, 63, 63);
		panel.add(panel_2);
		
		JTextArea txtrHi = new JTextArea();
		txtrHi.setText("Hi,");
		txtrHi.setOpaque(false);
		txtrHi.setLineWrap(true);
		txtrHi.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		txtrHi.setEnabled(false);
		txtrHi.setDisabledTextColor(Color.WHITE);
		txtrHi.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtrHi.setBounds(80, 97, 139, 28);
		panel.add(txtrHi);
		
		JLabel lblLogout = new JLabel("Logout");
		lblLogout.setBorder(null);
		lblLogout.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogout.setForeground(Color.WHITE);
		lblLogout.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		lblLogout.setBounds(125, 669, 94, 28);
		panel.add(lblLogout);
		
		JLabel lblSettings = new JLabel("Settings");
		lblSettings.setHorizontalAlignment(SwingConstants.CENTER);
		lblSettings.setForeground(Color.WHITE);
		lblSettings.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		lblSettings.setBorder(null);
		lblSettings.setBounds(12, 669, 101, 28);
		panel.add(lblSettings);
		
		JLabel label = new JLabel("Dashboard");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		label.setBorder(new LineBorder(new Color(255, 255, 255)));
		label.setBounds(12, 200, 207, 35);
		panel.add(label);
		
		JLabel label_1 = new JLabel("Transactions");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		label_1.setBorder(new LineBorder(new Color(255, 255, 255)));
		label_1.setBounds(12, 296, 207, 35);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Deposit");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		label_2.setBorder(new LineBorder(new Color(255, 255, 255)));
		label_2.setBounds(12, 392, 207, 35);
		panel.add(label_2);
		
		JLabel label_3 = new JLabel("Withdraw");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		label_3.setBorder(new LineBorder(new Color(255, 255, 255)));
		label_3.setBounds(12, 440, 207, 35);
		panel.add(label_3);
		
		JLabel label_4 = new JLabel("Plan");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		label_4.setBorder(new LineBorder(new Color(255, 255, 255)));
		label_4.setBounds(12, 248, 207, 35);
		panel.add(label_4);
		
		JLabel label_5 = new JLabel("Payments");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		label_5.setBorder(new LineBorder(new Color(255, 255, 255)));
		label_5.setBounds(12, 488, 207, 35);
		panel.add(label_5);
		
		JLabel label_6 = new JLabel("Transfer");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setForeground(Color.WHITE);
		label_6.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		label_6.setBorder(new LineBorder(new Color(255, 255, 255)));
		label_6.setBounds(12, 536, 207, 35);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("Loans");
		label_7.setHorizontalAlignment(SwingConstants.CENTER);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		label_7.setBorder(new LineBorder(new Color(255, 255, 255)));
		label_7.setBounds(12, 584, 207, 35);
		panel.add(label_7);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(228, 0, 737, 710);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLogIn = new JLabel("Loans");
		lblLogIn.setBounds(12, 24, 216, 50);
		panel_1.add(lblLogIn);
		lblLogIn.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogIn.setForeground(new Color(0, 0, 0));
		lblLogIn.setFont(new Font("Square721 BT", Font.PLAIN, 40));
		
		JTextArea txtrANewUser = new JTextArea();
		txtrANewUser.setWrapStyleWord(true);
		txtrANewUser.setBounds(12, 136, 713, 50);
		txtrANewUser.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtrANewUser.setText("We can help you live your dream. Through our carefully curated loan deals, we can help you attain the needs to push you forward in your life.");
		txtrANewUser.setOpaque(false);
		txtrANewUser.setLineWrap(true);
		txtrANewUser.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		txtrANewUser.setEnabled(false);
		txtrANewUser.setDisabledTextColor(new Color(0, 0, 0));
		panel_1.add(txtrANewUser);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(12, 199, 181, 42);
		panel_1.add(panel_3);
		
		JTextArea txtrCebuanaLilier = new JTextArea();
		txtrCebuanaLilier.setWrapStyleWord(true);
		txtrCebuanaLilier.setText("Cebuana Lil-ier");
		txtrCebuanaLilier.setOpaque(false);
		txtrCebuanaLilier.setLineWrap(true);
		txtrCebuanaLilier.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		txtrCebuanaLilier.setEnabled(false);
		txtrCebuanaLilier.setDisabledTextColor(Color.BLACK);
		txtrCebuanaLilier.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtrCebuanaLilier.setBounds(30, 10, 116, 29);
		panel_3.add(txtrCebuanaLilier);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 85, 350, 2);
		separator_1.setBackground(Color.BLACK);
		panel_1.add(separator_1);
		
		JPanel transfercard = new JPanel();
		transfercard.setLayout(null);
		transfercard.setOpaque(false);
		transfercard.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		transfercard.setBounds(12, 240, 713, 445);
		panel_1.add(transfercard);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(12, 13, 689, 419);
		transfercard.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblLeonScottKennedy = new JLabel("CEBUANA LIL'IER");
		lblLeonScottKennedy.setBounds(12, 13, 463, 73);
		panel_5.add(lblLeonScottKennedy);
		lblLeonScottKennedy.setHorizontalAlignment(SwingConstants.LEFT);
		lblLeonScottKennedy.setForeground(Color.BLACK);
		lblLeonScottKennedy.setFont(new Font("Square721 BT", Font.PLAIN, 40));
		
		txtDateOfTranaction = new JTextField();
		txtDateOfTranaction.setText("Receiver Card ID#");
		txtDateOfTranaction.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		txtDateOfTranaction.setColumns(10);
		txtDateOfTranaction.setBounds(12, 206, 665, 35);
		panel_5.add(txtDateOfTranaction);
		
		txtPinCode = new JTextField();
		txtPinCode.setEnabled(false);
		txtPinCode.setText("Pin Code");
		txtPinCode.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		txtPinCode.setColumns(10);
		txtPinCode.setBounds(12, 309, 665, 35);
		panel_5.add(txtPinCode);
		
		JLabel lblConfirm_1 = new JLabel("Confirm");
		lblConfirm_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirm_1.setForeground(Color.BLACK);
		lblConfirm_1.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		lblConfirm_1.setBorder(new LineBorder(Color.BLACK));
		lblConfirm_1.setBounds(470, 254, 207, 42);
		panel_5.add(lblConfirm_1);
		
		JLabel lblConfirm = new JLabel("Authenticate");
		lblConfirm.setEnabled(false);
		lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirm.setForeground(Color.BLACK);
		lblConfirm.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		lblConfirm.setBorder(new LineBorder(Color.BLACK));
		lblConfirm.setBounds(470, 357, 207, 42);
		panel_5.add(lblConfirm);
		
		JTextArea txtrYouWillReceive = new JTextArea();
		txtrYouWillReceive.setWrapStyleWord(true);
		txtrYouWillReceive.setText("You will receive a confirmation code through your validated phone or cashier.");
		txtrYouWillReceive.setOpaque(false);
		txtrYouWillReceive.setLineWrap(true);
		txtrYouWillReceive.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		txtrYouWillReceive.setEnabled(false);
		txtrYouWillReceive.setDisabledTextColor(Color.BLACK);
		txtrYouWillReceive.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtrYouWillReceive.setBounds(12, 357, 446, 49);
		panel_5.add(txtrYouWillReceive);
		
		JTextArea txtrCebuanaLilierIs = new JTextArea();
		txtrCebuanaLilierIs.setWrapStyleWord(true);
		txtrCebuanaLilierIs.setText("Cebuana Lil'ier is a loan shark known for their state of the art neck cutting deals that will sure blow up your mind. They can loan money, rent assets or even find you a wife, considering you pay them first before their redeemer came to your house with a shotgun.");
		txtrCebuanaLilierIs.setOpaque(false);
		txtrCebuanaLilierIs.setLineWrap(true);
		txtrCebuanaLilierIs.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		txtrCebuanaLilierIs.setEnabled(false);
		txtrCebuanaLilierIs.setDisabledTextColor(Color.BLACK);
		txtrCebuanaLilierIs.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtrCebuanaLilierIs.setBounds(12, 78, 665, 67);
		panel_5.add(txtrCebuanaLilierIs);
		
		txtAmountNeeded = new JTextField();
		txtAmountNeeded.setText("Amount Needed");
		txtAmountNeeded.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		txtAmountNeeded.setColumns(10);
		txtAmountNeeded.setBounds(12, 158, 665, 35);
		panel_5.add(txtAmountNeeded);
		
		JLabel lblWelcomeBackUsername = new JLabel("Security is our Mission");
		lblWelcomeBackUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcomeBackUsername.setForeground(Color.BLACK);
		lblWelcomeBackUsername.setFont(new Font("Square721 BT", Font.PLAIN, 30));
		lblWelcomeBackUsername.setBounds(12, 96, 350, 38);
		panel_1.add(lblWelcomeBackUsername);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new MatteBorder(1, 1, 0, 1, (Color) new Color(0, 0, 0)));
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(193, 199, 181, 42);
		panel_1.add(panel_4);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setText("Cebuana Lil-ier");
		textArea.setOpaque(false);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		textArea.setEnabled(false);
		textArea.setDisabledTextColor(Color.BLACK);
		textArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textArea.setBounds(30, 10, 116, 29);
		panel_4.add(textArea);
	}
}
