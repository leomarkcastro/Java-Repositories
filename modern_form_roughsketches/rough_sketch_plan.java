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
import javax.swing.JFormattedTextField;
import javax.swing.JSlider;


public class rough_sketch_plan extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					rough_sketch_plan frame = new rough_sketch_plan();
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
	public rough_sketch_plan() {
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
		
		JLabel lblInfo = new JLabel("Dashboard");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setForeground(Color.WHITE);
		lblInfo.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		lblInfo.setBorder(new LineBorder(new Color(255, 255, 255)));
		lblInfo.setBounds(12, 200, 207, 35);
		panel.add(lblInfo);
		
		JLabel lblDeposit = new JLabel("Deposit");
		lblDeposit.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeposit.setForeground(Color.WHITE);
		lblDeposit.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		lblDeposit.setBorder(new LineBorder(new Color(255, 255, 255)));
		lblDeposit.setBounds(12, 392, 207, 35);
		panel.add(lblDeposit);
		
		JLabel lblWithdraw = new JLabel("Withdraw");
		lblWithdraw.setHorizontalAlignment(SwingConstants.CENTER);
		lblWithdraw.setForeground(Color.WHITE);
		lblWithdraw.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		lblWithdraw.setBorder(new LineBorder(new Color(255, 255, 255)));
		lblWithdraw.setBounds(12, 440, 207, 35);
		panel.add(lblWithdraw);
		
		JLabel lblTransfer = new JLabel("Payments");
		lblTransfer.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransfer.setForeground(Color.WHITE);
		lblTransfer.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		lblTransfer.setBorder(new LineBorder(new Color(255, 255, 255)));
		lblTransfer.setBounds(12, 488, 207, 35);
		panel.add(lblTransfer);
		
		JLabel lblLoans = new JLabel("Transfer");
		lblLoans.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoans.setForeground(Color.WHITE);
		lblLoans.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		lblLoans.setBorder(new LineBorder(new Color(255, 255, 255)));
		lblLoans.setBounds(12, 536, 207, 35);
		panel.add(lblLoans);
		
		JLabel lblTransactions = new JLabel("Transactions");
		lblTransactions.setHorizontalAlignment(SwingConstants.CENTER);
		lblTransactions.setForeground(Color.WHITE);
		lblTransactions.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		lblTransactions.setBorder(new LineBorder(new Color(255, 255, 255)));
		lblTransactions.setBounds(12, 296, 207, 35);
		panel.add(lblTransactions);
		
		JLabel lblLoans_1 = new JLabel("Loans");
		lblLoans_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoans_1.setForeground(Color.WHITE);
		lblLoans_1.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		lblLoans_1.setBorder(new LineBorder(new Color(255, 255, 255)));
		lblLoans_1.setBounds(12, 584, 207, 35);
		panel.add(lblLoans_1);
		
		JLabel lblSettings = new JLabel("Settings");
		lblSettings.setHorizontalAlignment(SwingConstants.CENTER);
		lblSettings.setForeground(Color.WHITE);
		lblSettings.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		lblSettings.setBorder(null);
		lblSettings.setBounds(12, 669, 101, 28);
		panel.add(lblSettings);
		
		JLabel lblPlan = new JLabel("Plan");
		lblPlan.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlan.setForeground(Color.WHITE);
		lblPlan.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		lblPlan.setBorder(new LineBorder(new Color(255, 255, 255)));
		lblPlan.setBounds(12, 248, 207, 35);
		panel.add(lblPlan);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(228, 0, 737, 710);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLogIn = new JLabel("Plan");
		lblLogIn.setBounds(12, 24, 216, 50);
		panel_1.add(lblLogIn);
		lblLogIn.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogIn.setForeground(new Color(0, 0, 0));
		lblLogIn.setFont(new Font("Square721 BT", Font.PLAIN, 40));
		
		JPanel balancecard = new JPanel();
		balancecard.setBounds(12, 100, 350, 270);
		balancecard.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		balancecard.setOpaque(false);
		panel_1.add(balancecard);
		balancecard.setLayout(null);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setHorizontalAlignment(SwingConstants.LEFT);
		lblBalance.setForeground(Color.BLACK);
		lblBalance.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		lblBalance.setBounds(12, 13, 326, 26);
		balancecard.add(lblBalance);
		
		JLabel label_1 = new JLabel("$123,456.78");
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("Square721 BT", Font.PLAIN, 30));
		label_1.setBounds(12, 36, 326, 38);
		balancecard.add(label_1);
		
		JLabel lblThisMonthsExpense = new JLabel("This Month's Expense");
		lblThisMonthsExpense.setHorizontalAlignment(SwingConstants.RIGHT);
		lblThisMonthsExpense.setForeground(Color.BLACK);
		lblThisMonthsExpense.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		lblThisMonthsExpense.setBounds(168, 92, 170, 26);
		balancecard.add(lblThisMonthsExpense);
		
		JLabel label_2 = new JLabel("$567.89");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setForeground(Color.LIGHT_GRAY);
		label_2.setFont(new Font("Square721 BT", Font.PLAIN, 25));
		label_2.setBounds(168, 114, 170, 38);
		balancecard.add(label_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(12, 104, 161, 17);
		balancecard.add(panel_3);
		
		JLabel lblBudget = new JLabel("Budget Meter");
		lblBudget.setHorizontalAlignment(SwingConstants.LEFT);
		lblBudget.setForeground(Color.BLACK);
		lblBudget.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		lblBudget.setBounds(12, 117, 126, 26);
		balancecard.add(lblBudget);
		
		JLabel lblSafeToSpend = new JLabel("Safe to Spend Money");
		lblSafeToSpend.setHorizontalAlignment(SwingConstants.RIGHT);
		lblSafeToSpend.setForeground(Color.BLACK);
		lblSafeToSpend.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		lblSafeToSpend.setBounds(168, 165, 170, 26);
		balancecard.add(lblSafeToSpend);
		
		JLabel label_9 = new JLabel("$567.89");
		label_9.setHorizontalAlignment(SwingConstants.RIGHT);
		label_9.setForeground(Color.BLACK);
		label_9.setFont(new Font("Square721 BT", Font.PLAIN, 25));
		label_9.setBounds(168, 187, 170, 38);
		balancecard.add(label_9);
		
		JSlider slider = new JSlider();
		slider.setMaximum(125);
		slider.setValue(75);
		slider.setBounds(12, 184, 161, 17);
		balancecard.add(slider);
		
		JLabel lblMaxSafetospend = new JLabel("Max safe-to-spend: $45,675.98");
		lblMaxSafetospend.setHorizontalAlignment(SwingConstants.LEFT);
		lblMaxSafetospend.setForeground(Color.BLACK);
		lblMaxSafetospend.setFont(new Font("Square721 BT", Font.PLAIN, 12));
		lblMaxSafetospend.setBounds(12, 231, 326, 26);
		balancecard.add(lblMaxSafetospend);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(12, 85, 350, 2);
		separator_1.setBackground(Color.BLACK);
		panel_1.add(separator_1);
		
		JPanel paymentcard = new JPanel();
		paymentcard.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		paymentcard.setOpaque(false);
		paymentcard.setBounds(12, 383, 350, 302);
		panel_1.add(paymentcard);
		paymentcard.setLayout(null);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBorder(null);
		panel_11.setLayout(null);
		panel_11.setBackground(Color.WHITE);
		panel_11.setBounds(12, 13, 326, 129);
		paymentcard.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBounds(12, 13, 276, 100);
		panel_11.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.DARK_GRAY);
		panel_13.setBounds(12, 30, 39, 39);
		panel_12.add(panel_13);
		
		JLabel label = new JLabel("TELETV MONTHLY SUBSCRIPTION");
		label.setHorizontalAlignment(SwingConstants.LEFT);
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		label.setBounds(63, 13, 201, 19);
		panel_12.add(label);
		
		JLabel label_3 = new JLabel("Withdraw $12,456.78");
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		label_3.setBounds(63, 38, 201, 19);
		panel_12.add(label_3);
		
		JLabel label_4 = new JLabel("Date: 03 / 26 / 00");
		label_4.setHorizontalAlignment(SwingConstants.LEFT);
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		label_4.setBounds(63, 63, 201, 19);
		panel_12.add(label_4);
		
		JPanel panel_16 = new JPanel();
		panel_16.setLayout(null);
		panel_16.setBounds(298, 13, 276, 100);
		panel_11.add(panel_16);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(Color.DARK_GRAY);
		panel_17.setBounds(12, 30, 39, 39);
		panel_16.add(panel_17);
		
		JLabel label_5 = new JLabel("TELETV MONTHLY SUBSCRIPTION");
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		label_5.setBounds(63, 13, 201, 19);
		panel_16.add(label_5);
		
		JLabel label_6 = new JLabel("Withdraw $12,456.78");
		label_6.setHorizontalAlignment(SwingConstants.LEFT);
		label_6.setForeground(Color.BLACK);
		label_6.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		label_6.setBounds(63, 38, 201, 19);
		panel_16.add(label_6);
		
		JLabel label_7 = new JLabel("Date: 03 / 26 / 00");
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setForeground(Color.BLACK);
		label_7.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		label_7.setBounds(63, 63, 201, 19);
		panel_16.add(label_7);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(12, 146, 326, 20);
		paymentcard.add(scrollBar_1);
		scrollBar_1.setOrientation(JScrollBar.HORIZONTAL);
		
		JLabel lblCreateGoalsAnd = new JLabel("Create goals and automatically save for it");
		lblCreateGoalsAnd.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateGoalsAnd.setForeground(Color.BLACK);
		lblCreateGoalsAnd.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		lblCreateGoalsAnd.setBounds(12, 175, 326, 20);
		paymentcard.add(lblCreateGoalsAnd);
		
		JPanel panel_14 = new JPanel();
		panel_14.setLayout(null);
		panel_14.setBounds(12, 203, 326, 86);
		paymentcard.add(panel_14);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(Color.DARK_GRAY);
		panel_15.setBounds(12, 13, 56, 56);
		panel_14.add(panel_15);
		
		JLabel lblCreateANew_1 = new JLabel("Create a new save goal");
		lblCreateANew_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblCreateANew_1.setForeground(Color.BLACK);
		lblCreateANew_1.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		lblCreateANew_1.setBounds(77, 13, 237, 56);
		panel_14.add(lblCreateANew_1);
		
		JPanel transfercard = new JPanel();
		transfercard.setLayout(null);
		transfercard.setOpaque(false);
		transfercard.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		transfercard.setBounds(375, 100, 350, 585);
		panel_1.add(transfercard);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(317, 13, 21, 430);
		transfercard.add(scrollBar);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(null);
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(12, 13, 300, 430);
		transfercard.add(panel_5);
		panel_5.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(12, 13, 276, 100);
		panel_5.add(panel_6);
		panel_6.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.DARK_GRAY);
		panel_7.setBounds(12, 30, 39, 39);
		panel_6.add(panel_7);
		
		JLabel lblLeonScottKennedy = new JLabel("TELETV MONTHLY SUBSCRIPTION");
		lblLeonScottKennedy.setHorizontalAlignment(SwingConstants.LEFT);
		lblLeonScottKennedy.setForeground(Color.BLACK);
		lblLeonScottKennedy.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		lblLeonScottKennedy.setBounds(63, 13, 201, 19);
		panel_6.add(lblLeonScottKennedy);
		
		JLabel lblWithdraw_1 = new JLabel("Withdraw $12,456.78");
		lblWithdraw_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblWithdraw_1.setForeground(Color.BLACK);
		lblWithdraw_1.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		lblWithdraw_1.setBounds(63, 38, 201, 19);
		panel_6.add(lblWithdraw_1);
		
		JLabel lblDate = new JLabel("Date: 03 / 26 / 00");
		lblDate.setHorizontalAlignment(SwingConstants.LEFT);
		lblDate.setForeground(Color.BLACK);
		lblDate.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		lblDate.setBounds(63, 63, 201, 19);
		panel_6.add(lblDate);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBounds(12, 126, 276, 100);
		panel_5.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.DARK_GRAY);
		panel_9.setBounds(12, 30, 39, 39);
		panel_8.add(panel_9);
		
		JLabel lblShopeeOrderdef = new JLabel("SHOPEE ORDER #123DEF789");
		lblShopeeOrderdef.setHorizontalAlignment(SwingConstants.LEFT);
		lblShopeeOrderdef.setForeground(Color.BLACK);
		lblShopeeOrderdef.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		lblShopeeOrderdef.setBounds(63, 13, 201, 19);
		panel_8.add(lblShopeeOrderdef);
		
		JLabel lblWithdraw_2 = new JLabel("Withdraw $45.67");
		lblWithdraw_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblWithdraw_2.setForeground(Color.BLACK);
		lblWithdraw_2.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		lblWithdraw_2.setBounds(63, 38, 201, 19);
		panel_8.add(lblWithdraw_2);
		
		JLabel lblDate_1 = new JLabel("Date: 03 / 14 / 00");
		lblDate_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblDate_1.setForeground(Color.BLACK);
		lblDate_1.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		lblDate_1.setBounds(63, 63, 201, 19);
		panel_8.add(lblDate_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(12, 486, 326, 86);
		transfercard.add(panel_4);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.DARK_GRAY);
		panel_10.setBounds(12, 13, 56, 56);
		panel_4.add(panel_10);
		
		JLabel lblCreateANew = new JLabel("Create a new payment plan");
		lblCreateANew.setHorizontalAlignment(SwingConstants.LEFT);
		lblCreateANew.setForeground(Color.BLACK);
		lblCreateANew.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		lblCreateANew.setBounds(77, 13, 237, 56);
		panel_4.add(lblCreateANew);
		
		JLabel lblOneClickTo = new JLabel("One click to view detal. Double click to pay");
		lblOneClickTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblOneClickTo.setForeground(Color.BLACK);
		lblOneClickTo.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		lblOneClickTo.setBounds(12, 447, 326, 35);
		transfercard.add(lblOneClickTo);
	}
}
