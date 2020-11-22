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


public class rough_sketch_deposit extends JFrame {

	private JPanel contentPane;
	private JTextField txtAmountOfMoney;
	private JTextField txtDateOfTranaction;
	private JTextField txtPinCode;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rough_sketch_deposit frame = new rough_sketch_deposit();
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
	public rough_sketch_deposit() {
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
		
		JLabel lblLogIn = new JLabel("Deposit");
		lblLogIn.setBounds(12, 24, 216, 50);
		panel_1.add(lblLogIn);
		lblLogIn.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogIn.setForeground(new Color(0, 0, 0));
		lblLogIn.setFont(new Font("Square721 BT", Font.PLAIN, 40));
		
		JTextArea txtrANewUser = new JTextArea();
		txtrANewUser.setWrapStyleWord(true);
		txtrANewUser.setBounds(12, 136, 713, 50);
		txtrANewUser.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtrANewUser.setText("We value our costumers as much as you value your hard earned cash. That's why we provide our state of the art protection and encryption to every transaction made through our platform.");
		txtrANewUser.setOpaque(false);
		txtrANewUser.setLineWrap(true);
		txtrANewUser.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		txtrANewUser.setEnabled(false);
		txtrANewUser.setDisabledTextColor(new Color(0, 0, 0));
		panel_1.add(txtrANewUser);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 85, 350, 2);
		separator_1.setBackground(Color.BLACK);
		panel_1.add(separator_1);
		
		JPanel transfercard = new JPanel();
		transfercard.setLayout(null);
		transfercard.setOpaque(false);
		transfercard.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		transfercard.setBounds(12, 188, 713, 509);
		panel_1.add(transfercard);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(12, 13, 378, 483);
		transfercard.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblLeonScottKennedy = new JLabel("Deposit Check");
		lblLeonScottKennedy.setBounds(12, 13, 288, 73);
		panel_5.add(lblLeonScottKennedy);
		lblLeonScottKennedy.setHorizontalAlignment(SwingConstants.LEFT);
		lblLeonScottKennedy.setForeground(Color.BLACK);
		lblLeonScottKennedy.setFont(new Font("Square721 BT", Font.PLAIN, 40));
		
		txtAmountOfMoney = new JTextField();
		txtAmountOfMoney.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		txtAmountOfMoney.setText("Amount of Money");
		txtAmountOfMoney.setBounds(12, 99, 354, 35);
		panel_5.add(txtAmountOfMoney);
		txtAmountOfMoney.setColumns(10);
		
		txtDateOfTranaction = new JTextField();
		txtDateOfTranaction.setText("Enter Password for Verification");
		txtDateOfTranaction.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		txtDateOfTranaction.setColumns(10);
		txtDateOfTranaction.setBounds(12, 147, 354, 35);
		panel_5.add(txtDateOfTranaction);
		
		txtPinCode = new JTextField();
		txtPinCode.setEnabled(false);
		txtPinCode.setText("Pin Code");
		txtPinCode.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		txtPinCode.setColumns(10);
		txtPinCode.setBounds(12, 292, 354, 35);
		panel_5.add(txtPinCode);
		
		JLabel lblConfirm_1 = new JLabel("Confirm");
		lblConfirm_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirm_1.setForeground(Color.BLACK);
		lblConfirm_1.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		lblConfirm_1.setBorder(new LineBorder(Color.BLACK));
		lblConfirm_1.setBounds(159, 212, 207, 42);
		panel_5.add(lblConfirm_1);
		
		JLabel lblConfirm = new JLabel("Authenticate");
		lblConfirm.setEnabled(false);
		lblConfirm.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirm.setForeground(Color.BLACK);
		lblConfirm.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		lblConfirm.setBorder(new LineBorder(Color.BLACK));
		lblConfirm.setBounds(159, 417, 207, 42);
		panel_5.add(lblConfirm);
		
		JTextArea txtrYouWillReceive = new JTextArea();
		txtrYouWillReceive.setWrapStyleWord(true);
		txtrYouWillReceive.setText("You will receive a confirmation code through your validated phone, remember this code as this will be asked by our tender before proceeding on transaction.");
		txtrYouWillReceive.setOpaque(false);
		txtrYouWillReceive.setLineWrap(true);
		txtrYouWillReceive.setFont(new Font("Square721 BT", Font.PLAIN, 13));
		txtrYouWillReceive.setEnabled(false);
		txtrYouWillReceive.setDisabledTextColor(Color.BLACK);
		txtrYouWillReceive.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtrYouWillReceive.setBounds(12, 340, 354, 61);
		panel_5.add(txtrYouWillReceive);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(402, 13, 299, 483);
		transfercard.add(panel_3);
		
		JLabel lblSlip = new JLabel("SLIP");
		lblSlip.setHorizontalAlignment(SwingConstants.LEFT);
		lblSlip.setForeground(Color.BLACK);
		lblSlip.setFont(new Font("Square721 BT", Font.PLAIN, 40));
		lblSlip.setBounds(12, 13, 98, 73);
		panel_3.add(lblSlip);
		
		JLabel lblPrintSlip = new JLabel("Print Slip");
		lblPrintSlip.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrintSlip.setForeground(Color.BLACK);
		lblPrintSlip.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		lblPrintSlip.setBorder(new LineBorder(Color.BLACK));
		lblPrintSlip.setBounds(162, 443, 125, 27);
		panel_3.add(lblPrintSlip);
		
		JTextArea txtrPresentThisSlip = new JTextArea();
		txtrPresentThisSlip.setWrapStyleWord(true);
		txtrPresentThisSlip.setText("Present this slip to our counter and let us handle from this.");
		txtrPresentThisSlip.setOpaque(false);
		txtrPresentThisSlip.setLineWrap(true);
		txtrPresentThisSlip.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		txtrPresentThisSlip.setEnabled(false);
		txtrPresentThisSlip.setDisabledTextColor(Color.BLACK);
		txtrPresentThisSlip.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtrPresentThisSlip.setBounds(12, 78, 275, 42);
		panel_3.add(txtrPresentThisSlip);
		
		JTextArea textArea = new JTextArea();
		textArea.setWrapStyleWord(true);
		textArea.setText("Date of Receipt:");
		textArea.setOpaque(false);
		textArea.setLineWrap(true);
		textArea.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		textArea.setEnabled(false);
		textArea.setDisabledTextColor(Color.BLACK);
		textArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textArea.setBounds(12, 133, 275, 23);
		panel_3.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setWrapStyleWord(true);
		textArea_1.setText("March 26, 2000");
		textArea_1.setOpaque(false);
		textArea_1.setLineWrap(true);
		textArea_1.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		textArea_1.setEnabled(false);
		textArea_1.setDisabledTextColor(Color.BLACK);
		textArea_1.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textArea_1.setBounds(22, 156, 265, 23);
		panel_3.add(textArea_1);
		
		JTextArea textArea_2 = new JTextArea();
		textArea_2.setWrapStyleWord(true);
		textArea_2.setText("Transaction No:");
		textArea_2.setOpaque(false);
		textArea_2.setLineWrap(true);
		textArea_2.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		textArea_2.setEnabled(false);
		textArea_2.setDisabledTextColor(Color.BLACK);
		textArea_2.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textArea_2.setBounds(12, 192, 275, 23);
		panel_3.add(textArea_2);
		
		JTextArea textArea_3 = new JTextArea();
		textArea_3.setWrapStyleWord(true);
		textArea_3.setText("ABC-123987456A");
		textArea_3.setOpaque(false);
		textArea_3.setLineWrap(true);
		textArea_3.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		textArea_3.setEnabled(false);
		textArea_3.setDisabledTextColor(Color.BLACK);
		textArea_3.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textArea_3.setBounds(22, 215, 265, 23);
		panel_3.add(textArea_3);
		
		JTextArea textArea_4 = new JTextArea();
		textArea_4.setWrapStyleWord(true);
		textArea_4.setText("Input Actor:");
		textArea_4.setOpaque(false);
		textArea_4.setLineWrap(true);
		textArea_4.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		textArea_4.setEnabled(false);
		textArea_4.setDisabledTextColor(Color.BLACK);
		textArea_4.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textArea_4.setBounds(12, 251, 275, 23);
		panel_3.add(textArea_4);
		
		JTextArea textArea_5 = new JTextArea();
		textArea_5.setWrapStyleWord(true);
		textArea_5.setText("Leo Mark DC Castro");
		textArea_5.setOpaque(false);
		textArea_5.setLineWrap(true);
		textArea_5.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		textArea_5.setEnabled(false);
		textArea_5.setDisabledTextColor(Color.BLACK);
		textArea_5.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textArea_5.setBounds(22, 274, 265, 23);
		panel_3.add(textArea_5);
		
		JTextArea textArea_6 = new JTextArea();
		textArea_6.setWrapStyleWord(true);
		textArea_6.setText("Output Actor:");
		textArea_6.setOpaque(false);
		textArea_6.setLineWrap(true);
		textArea_6.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		textArea_6.setEnabled(false);
		textArea_6.setDisabledTextColor(Color.BLACK);
		textArea_6.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textArea_6.setBounds(12, 310, 275, 23);
		panel_3.add(textArea_6);
		
		JTextArea textArea_7 = new JTextArea();
		textArea_7.setWrapStyleWord(true);
		textArea_7.setText("CHOK'S Integrated");
		textArea_7.setOpaque(false);
		textArea_7.setLineWrap(true);
		textArea_7.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		textArea_7.setEnabled(false);
		textArea_7.setDisabledTextColor(Color.BLACK);
		textArea_7.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textArea_7.setBounds(22, 333, 265, 23);
		panel_3.add(textArea_7);
		
		JTextArea textArea_8 = new JTextArea();
		textArea_8.setWrapStyleWord(true);
		textArea_8.setText("Payment Cash:");
		textArea_8.setOpaque(false);
		textArea_8.setLineWrap(true);
		textArea_8.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		textArea_8.setEnabled(false);
		textArea_8.setDisabledTextColor(Color.BLACK);
		textArea_8.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textArea_8.setBounds(12, 369, 275, 23);
		panel_3.add(textArea_8);
		
		JTextArea textArea_9 = new JTextArea();
		textArea_9.setWrapStyleWord(true);
		textArea_9.setText("$1,234.56");
		textArea_9.setOpaque(false);
		textArea_9.setLineWrap(true);
		textArea_9.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		textArea_9.setEnabled(false);
		textArea_9.setDisabledTextColor(Color.BLACK);
		textArea_9.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		textArea_9.setBounds(22, 392, 265, 23);
		panel_3.add(textArea_9);
		
		JLabel lblWelcomeBackUsername = new JLabel("Security is our Mission");
		lblWelcomeBackUsername.setHorizontalAlignment(SwingConstants.LEFT);
		lblWelcomeBackUsername.setForeground(Color.BLACK);
		lblWelcomeBackUsername.setFont(new Font("Square721 BT", Font.PLAIN, 30));
		lblWelcomeBackUsername.setBounds(12, 96, 350, 38);
		panel_1.add(lblWelcomeBackUsername);
	}
}
