package bank_co_ui;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


class dashboard_ui extends JPanel{

	
	int current_pane;
	AccountClass user;
	Dashpane_UI dashpane;
	Plan_UI planpane;
	Transaction_UI transactpane;
	Deposit_UI depositpane;
	Withdraw_UI withdrawpane;

	dashboard_ui(){
		this.setBounds(0,0,965,710);
		this.setBackground(Color.white);
		this.setLayout(null);
		
		//this.setVisible(true);
	}
	
	void getaccount(AccountClass input) {
		user = input;
		
		SideTool();
		
		call_dashUI(1);
	}
	
	void clear_dashUI(int whatui) {
		switch (whatui) {
		case 1:
			this.remove(dashpane);
			break;
		case 2:
			this.remove(planpane);
			break;
		case 3:
			this.remove(transactpane);
			break;
		case 4:
			this.remove(depositpane);
			break;
		case 5:
			this.remove(withdrawpane);
			break;
		}
		this.repaint();
	}
	
	void call_dashUI(int whatui) {
		switch (whatui) {
		case 1:
			dashpane = new Dashpane_UI();
			dashpane.setVisible(true);
			this.add(dashpane);
			current_pane = 1;
			break;
		case 2:
			planpane = new Plan_UI();
			planpane.setVisible(true);
			this.add(planpane);
			current_pane = 2;
			break;
		case 3:
			transactpane = new Transaction_UI();
			transactpane.setVisible(true);
			this.add(transactpane);
			current_pane = 3;
			break;
		case 4:
			depositpane = new Deposit_UI();
			depositpane.setVisible(true);
			this.add(depositpane);
			current_pane = 4;
			break;
		case 5:
			withdrawpane = new Withdraw_UI();
			withdrawpane.setVisible(true);
			this.add(withdrawpane);
			current_pane = 5;
			break;
		}
		this.repaint();
	}
	
	void SideTool() {
		JPanel bcban = new JPanel();
		bcban.setBounds(0, 0, 231, 710);
		bcban.setLayout(null);
		bcban.setBackground(Color.black);
		
		JLabel lbltitle = new JLabel("BANK CO.");
		lbltitle.setForeground(new Color(255, 255, 255));
		lbltitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lbltitle.setFont(new Font("Square721 BT", Font.PLAIN, 40));
		lbltitle.setBounds(12, 24, 207, 56);
		this.add(lbltitle);
		
		JTextArea txtHi = new JTextArea();
		txtHi.setText("Hi,");
		txtHi.setOpaque(false);
		txtHi.setLineWrap(true);
		txtHi.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		txtHi.setEnabled(false);
		txtHi.setDisabledTextColor(Color.WHITE);
		txtHi.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtHi.setBounds(80, 97, 139, 28);
		this.add(txtHi);
		
		JTextArea txtName = new JTextArea();
		txtName.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		txtName.setLineWrap(true);
		txtName.setDisabledTextColor(new Color(255, 255, 255));
		txtName.setEnabled(false);
		txtName.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		txtName.setOpaque(false);
		txtName.setText(user.username);
		txtName.setBounds(80, 118, 139, 28);
		this.add(txtName);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 98, 63, 63);
		this.add(panel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 85, 207, 2);
		this.add(separator);
		
		FButton btnDashBord = new FButton("Dashboard");
		btnDashBord.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		btnDashBord.setForeground(Color.white);
		btnDashBord.BgColorBase = Color.black;
		btnDashBord.BdColorBase = Color.white;
		btnDashBord.gradientbackground(Color.black, new Color(25,25,25));
		btnDashBord.gradientborder(Color.white, Color.black);
		btnDashBord.setBounds(12, 200, 207, 35);
		btnDashBord.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnDashBord.in_box = false;
				btnDashBord.BgColorBase = Color.darkGray;
				btnDashBord.BdColorBase = Color.white;
				//btnlogin.BgColorBase = Color.white;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnDashBord.in_box = true;
				btnDashBord.BgColorBase = Color.black;
				//btnDashBord.BdColorBase = Color.black;
				clear_dashUI(current_pane);
				call_dashUI(1);
			}
		});
		this.add(btnDashBord);
		
		FButton btnPlan = new FButton("Plan");
		btnPlan.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		btnPlan.setForeground(Color.white);
		btnPlan.BgColorBase = Color.black;
		btnPlan.BdColorBase = Color.white;
		btnPlan.gradientbackground(Color.black, new Color(25,25,25));
		btnPlan.gradientborder(Color.white, Color.black);
		btnPlan.setBounds(12, 248, 207, 35);
		btnPlan.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnPlan.in_box = false;
				btnPlan.BgColorBase = Color.darkGray;
				btnPlan.BdColorBase = Color.white;
				//btnlogin.BgColorBase = Color.white;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnPlan.in_box = true;
				btnPlan.BgColorBase = Color.black;
				//btnPlan.BdColorBase = Color.black;
				clear_dashUI(current_pane);
				call_dashUI(2);
			}
		});
		this.add(btnPlan);
		
		FButton btnTransact = new FButton("Transactions");
		btnTransact.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		btnTransact.setForeground(Color.white);
		btnTransact.BgColorBase = Color.black;
		btnTransact.BdColorBase = Color.white;
		btnTransact.gradientbackground(Color.black, new Color(25,25,25));
		btnTransact.gradientborder(Color.white, Color.black);
		btnTransact.setBounds(12, 296, 207, 35);
		btnTransact.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnTransact.in_box = false;
				btnTransact.BgColorBase = Color.darkGray;
				btnTransact.BdColorBase = Color.white;
				//btnlogin.BgColorBase = Color.white;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnTransact.in_box = true;
				btnTransact.BgColorBase = Color.black;
				//btnTransact.BdColorBase = Color.black;
				clear_dashUI(current_pane);
				call_dashUI(3);
			}
		});
		this.add(btnTransact);
		
		FButton btnDepos = new FButton("Deposit");
		btnDepos.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		btnDepos.setForeground(Color.white);
		btnDepos.BgColorBase = Color.black;
		btnDepos.BdColorBase = Color.white;
		btnDepos.gradientbackground(Color.black, new Color(25,25,25));
		btnDepos.gradientborder(Color.white, Color.black);
		btnDepos.setBounds(12, 392, 207, 35);
		btnDepos.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnDepos.in_box = false;
				btnDepos.BgColorBase = Color.darkGray;
				btnDepos.BdColorBase = Color.white;
				//btnlogin.BgColorBase = Color.white;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnDepos.in_box = true;
				btnDepos.BgColorBase = Color.black;
				//btnDepos.BdColorBase = Color.black;
				clear_dashUI(current_pane);
				call_dashUI(4);
			}
		});
		this.add(btnDepos);
		
		FButton btnWithdr = new FButton("Withdraw");
		btnWithdr.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		btnWithdr.setForeground(Color.white);
		btnWithdr.BgColorBase = Color.black;
		btnWithdr.BdColorBase = Color.white;
		btnWithdr.gradientbackground(Color.black, new Color(25,25,25));
		btnWithdr.gradientborder(Color.white, Color.black);
		btnWithdr.setBounds(12, 440, 207, 35);
		btnWithdr.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnWithdr.in_box = false;
				btnWithdr.BgColorBase = Color.darkGray;
				btnWithdr.BdColorBase = Color.white;
				//btnlogin.BgColorBase = Color.white;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnWithdr.in_box = true;
				btnWithdr.BgColorBase = Color.black;
				//btnWithdr.BdColorBase = Color.black;
				clear_dashUI(current_pane);
				call_dashUI(5);
			}
		});
		this.add(btnWithdr);
		
		FButton btnPaym = new FButton("Payment");
		btnPaym.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		btnPaym.setForeground(Color.white);
		btnPaym.BgColorBase = Color.black;
		btnPaym.BdColorBase = Color.white;
		btnPaym.gradientbackground(Color.black, new Color(25,25,25));
		btnPaym.gradientborder(Color.white, Color.black);
		btnPaym.setBounds(12, 488, 207, 35);
		btnPaym.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnPaym.in_box = false;
				btnPaym.BgColorBase = Color.darkGray;
				btnPaym.BdColorBase = Color.white;
				//btnlogin.BgColorBase = Color.white;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnPaym.in_box = true;
				btnPaym.BgColorBase = Color.black;
				//btnPaym.BdColorBase = Color.black;
			}
		});
		this.add(btnPaym);
		
		FButton btnTransf = new FButton("Transfer");
		btnTransf.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		btnTransf.setForeground(Color.white);
		btnTransf.BgColorBase = Color.black;
		btnTransf.BdColorBase = Color.white;
		btnTransf.gradientbackground(Color.black, new Color(25,25,25));
		btnTransf.gradientborder(Color.white, Color.black);
		btnTransf.setBounds(12, 536, 207, 35);
		btnTransf.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnTransf.in_box = false;
				btnTransf.BgColorBase = Color.darkGray;
				btnTransf.BdColorBase = Color.white;
				//btnlogin.BgColorBase = Color.white;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnTransf.in_box = true;
				btnTransf.BgColorBase = Color.black;
				//btnTransf.BdColorBase = Color.black;
			}
		});
		this.add(btnTransf);
		
		FButton btnLoan = new FButton("Loans");
		btnLoan.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		btnLoan.setForeground(Color.white);
		btnLoan.BgColorBase = Color.black;
		btnLoan.BdColorBase = Color.white;
		btnLoan.gradientbackground(Color.black, new Color(25,25,25));
		btnLoan.gradientborder(Color.white, Color.black);
		btnLoan.setBounds(12, 584, 207, 35);
		btnLoan.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnLoan.in_box = false;
				btnLoan.BgColorBase = Color.darkGray;
				btnLoan.BdColorBase = Color.white;
				//btnlogin.BgColorBase = Color.white;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnLoan.in_box = true;
				btnLoan.BgColorBase = Color.black;
				//btnLoan.BdColorBase = Color.black;
			}
		});
		this.add(btnLoan);
		
		FButton btnSettings = new FButton("Settings");
		btnSettings.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		btnSettings.setForeground(Color.white);
		btnSettings.BgColorBase = Color.black;
		btnSettings.BdColorBase = Color.black;
		btnSettings.gradientbackground(Color.black, new Color(25,25,25));
		btnSettings.gradientborder(Color.darkGray, Color.black);
		btnSettings.setBounds(12, 669, 101, 28);
		btnSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnSettings.in_box = false;
				btnSettings.BgColorBase = Color.darkGray;
				//btnSettings.BdColorBase = Color.white;
				//btnlogin.BgColorBase = Color.white;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnSettings.in_box = true;
				btnSettings.BgColorBase = Color.black;
				//btnLoan.BdColorBase = Color.black;
			}
		});
		this.add(btnSettings);
		
		FButton btnlogout = new FButton("Log Out");
		btnlogout.setFont(new Font("Square721 BT", Font.PLAIN, 20));
		btnlogout.setForeground(Color.white);
		btnlogout.BgColorBase = Color.black;
		btnlogout.BdColorBase = Color.black;
		btnlogout.gradientbackground(Color.black, new Color(25,25,25));
		btnlogout.gradientborder(Color.darkGray, Color.black);
		btnlogout.setBounds(125, 669, 94, 28);
		btnlogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnlogout.in_box = false;
				btnlogout.BgColorBase = Color.darkGray;
				//btnlogout.BdColorBase = Color.white;
				//btnlogin.BgColorBase = Color.white;
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnlogout.in_box = true;
				btnlogout.BgColorBase = Color.black;
				//btnLoan.BdColorBase = Color.black;
			}
		});
		this.add(btnlogout);
		
		this.add(bcban);
		
		
	}
	
	class Dashpane_UI extends JPanel{
		
		ArrayList<FPanel> TransactArray;
		
		JPanel dash_transactpanelContainer;
		int dash_trans_yslide = 0;
		int dash_trans_y;
		
		ArrayList<FPanel> PaymentArray;
		
		JPanel dash_paymentspanelContainer;
		int dash_paym_yslide = 0;
		int dash_paym_y;
		
		Dashpane_UI(){
			
			this.setBackground(Color.white);
			this.setBounds(228, 0, 737, 710);
			this.setLayout(null);
			
			initiateDashpane();
			
		}
		
		void initiateDashpane() {
			
			JLabel lblDPTitle = new JLabel("Dashboard");
			lblDPTitle.setBounds(12, 24, 216, 50);
			lblDPTitle.setForeground(new Color(0, 0, 0));
			lblDPTitle.setFont(new Font("Square721 BT", Font.PLAIN, 40));
			this.add(lblDPTitle);
			
			JSeparator titlesperator = new JSeparator();
			titlesperator.setBounds(12, 85, 350, 2);
			titlesperator.setBackground(Color.BLACK);
			this.add(titlesperator);
			
			JLabel lblWelcomeBack = new JLabel("Welcome back,");
			lblWelcomeBack.setHorizontalAlignment(SwingConstants.LEFT);
			lblWelcomeBack.setForeground(Color.BLACK);
			lblWelcomeBack.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			lblWelcomeBack.setBounds(374, 117, 350, 26);
			this.add(lblWelcomeBack);
			
			JLabel lblUsername = new JLabel(user.username + "!");
			lblUsername.setHorizontalAlignment(SwingConstants.LEFT);
			lblUsername.setForeground(Color.BLACK);
			lblUsername.setFont(new Font("Square721 BT", Font.PLAIN, 30));
			lblUsername.setBounds(374, 140, 350, 38);
			this.add(lblUsername);

			JTextArea txtrANewUser = new JTextArea();
			txtrANewUser.setWrapStyleWord(true);
			txtrANewUser.setBounds(374, 205, 351, 105);
			txtrANewUser.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtrANewUser.setText("Do you know that you can earn money by working hard at you job! You can also steal some money from your company, nobody would notice if they are already dead, right?");
			txtrANewUser.setOpaque(false);
			txtrANewUser.setLineWrap(true);
			txtrANewUser.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtrANewUser.setEnabled(false);
			txtrANewUser.setDisabledTextColor(new Color(0, 0, 0));
			this.add(txtrANewUser);
			
			JLabel lblMakePayments = new JLabel("Make Payments");
			lblMakePayments.setBounds(12, 366, 247, 50);
			lblMakePayments.setHorizontalAlignment(SwingConstants.LEFT);
			lblMakePayments.setForeground(Color.BLACK);
			lblMakePayments.setFont(new Font("Square721 BT", Font.PLAIN, 30));
			this.add(lblMakePayments);
			
			JLabel lblSendCash = new JLabel("Latest Transactions");
			lblSendCash.setHorizontalAlignment(SwingConstants.LEFT);
			lblSendCash.setForeground(Color.BLACK);
			lblSendCash.setFont(new Font("Square721 BT", Font.PLAIN, 30));
			lblSendCash.setBounds(375, 366, 350, 50);
			this.add(lblSendCash);
			
			BalanceCard();
			TransactionCard();
			PaymentCard();
		}
		
		void BalanceCard() {
			
			JPanel balancecard = new JPanel();
			balancecard.setBounds(12, 100, 350, 256);
			balancecard.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			balancecard.setOpaque(false);
			this.add(balancecard);
			balancecard.setLayout(null);
			
			JLabel lblBalanceTitle = new JLabel("Balance");
			lblBalanceTitle.setHorizontalAlignment(SwingConstants.LEFT);
			lblBalanceTitle.setForeground(Color.BLACK);
			lblBalanceTitle.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			lblBalanceTitle.setBounds(12, 13, 326, 26);
			balancecard.add(lblBalanceTitle);
			
			JLabel lblBalance = new JLabel("$" + user.balance);
			lblBalance.setHorizontalAlignment(SwingConstants.LEFT);
			lblBalance.setForeground(Color.BLACK);
			lblBalance.setFont(new Font("Square721 BT", Font.PLAIN, 30));
			lblBalance.setBounds(12, 36, 326, 38);
			balancecard.add(lblBalance);
			
			JLabel lblThisMonthsExpense = new JLabel("Your extra expense: ");
			lblThisMonthsExpense.setHorizontalAlignment(SwingConstants.RIGHT);
			lblThisMonthsExpense.setForeground(Color.BLACK);
			lblThisMonthsExpense.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			lblThisMonthsExpense.setBounds(168, 92, 170, 26);
			balancecard.add(lblThisMonthsExpense);
			
			JLabel lblExpense = new JLabel("$" +  ((user.safetospendexpense > 0) ? user.safetospendexpense : 0));
			lblExpense.setHorizontalAlignment(SwingConstants.RIGHT);
			lblExpense.setForeground(Color.LIGHT_GRAY);
			lblExpense.setFont(new Font("Square721 BT", Font.PLAIN, 25));
			lblExpense.setBounds(168, 114, 170, 38);
			balancecard.add(lblExpense);
			
			JLabel lblThisMonthsDue = new JLabel("This Month's Due");
			lblThisMonthsDue.setHorizontalAlignment(SwingConstants.RIGHT);
			lblThisMonthsDue.setForeground(Color.BLACK);
			lblThisMonthsDue.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			lblThisMonthsDue.setBounds(212, 165, 126, 26);
			balancecard.add(lblThisMonthsDue);
	
			JLabel lblTotalPayment = new JLabel("$" + user.getPaymentTotal());
			lblTotalPayment.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTotalPayment.setForeground(Color.GRAY);
			lblTotalPayment.setFont(new Font("Square721 BT", Font.PLAIN, 25));
			lblTotalPayment.setBounds(168, 189, 170, 38);
			balancecard.add(lblTotalPayment);
			
			JLabel lblBudget = new JLabel("Budget Meter");
			lblBudget.setHorizontalAlignment(SwingConstants.LEFT);
			lblBudget.setForeground(Color.BLACK);
			lblBudget.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			lblBudget.setBounds(12, 119, 126, 26);
			balancecard.add(lblBudget);
			
			ProgressBar budgetBar = new ProgressBar(user.safetospendexpense, user.safetospend, Color.lightGray, Color.black, Color.darkGray);
			budgetBar.setBounds(12, 104, 144, 17);
			budgetBar.setVisible(true);
			balancecard.add(budgetBar);
			
			JLabel lblPaymentFill = new JLabel("Payment Fill");
			lblPaymentFill.setHorizontalAlignment(SwingConstants.LEFT);
			lblPaymentFill.setForeground(Color.BLACK);
			lblPaymentFill.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			lblPaymentFill.setBounds(12, 195, 126, 26);
			balancecard.add(lblPaymentFill);
			
			ProgressBar paymentBar = new ProgressBar(user.getPaymentPlanTotal() - user.getPaymentTotal(), user.getPaymentPlanTotal(), Color.lightGray, Color.black, Color.darkGray);
			paymentBar.setBounds(12, 180, 144, 17);
			paymentBar.setVisible(true);
			balancecard.add(paymentBar);
			
			
			
		}
		
		class ProgressBar extends JPanel{
					
					int getval, getmax;
					Color BgColor, BdColor, FillColor;
					
					ProgressBar(int val, int max, Color Bg, Color Bd, Color Fill){
						this.getval = val;
						this.getmax = max;
						this.BgColor = Bg;
						this.BdColor = Bd;
						this.FillColor = Fill;
						//System.out.println("Working");
					}
					
					public void paint (Graphics g) {
						
						
						g.setColor(BgColor);
						g.fillRoundRect(0, 0, super.getWidth(), super.getHeight(), 10, 10);
						g.setColor(FillColor);
						//System.out.println((int) (super.getWidth()*((float)getval / (float)getmax)));
						g.fillRoundRect(0, 0, (int) (super.getWidth()*((float)getval / (float)getmax)), super.getHeight(), 10, 10);
						g.setColor(BdColor);
						g.drawRoundRect(0, 0, super.getWidth(), super.getHeight(), 10, 10);
						
					}
					
		}
		
		void TransactionCard() {
			
			JPanel transfercard = new JPanel();
			transfercard.setLayout(null);
			transfercard.setOpaque(false);
			transfercard.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			transfercard.setBounds(375, 429, 350, 256);
			this.add(transfercard);
			
			dash_transactpanelContainer = new JPanel();
			dash_transactpanelContainer.setBackground(Color.WHITE);
			dash_transactpanelContainer.setBounds(12, 13, 300, 230);
			dash_transactpanelContainer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			dash_transactpanelContainer.setLayout(null);
			transfercard.add(dash_transactpanelContainer);
			
			TransactArray = new ArrayList<FPanel>(); 
			
			dash_trans_y = 13 - dash_trans_yslide;
			
			for(TransactionsClass tracla: user.transactions) {
								
				FPanel TransCard = new FPanel();
				TransCard.setBounds(12, dash_trans_y, 276, 100);
				TransCard.setLayout(null);
				TransCard.BgColorBase = Color.white;
				TransCard.BdColorBase = Color.BLACK;
				TransCard.BgColor1 = Color.white;
				TransCard.BgColor2 = new Color(225,225,225);
				TransCard.BdColor1 = Color.BLACK;
				TransCard.BdColor2 = Color.WHITE;		
				TransCard.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						TransCard.BgColorBase = new Color(220,220,220);
						TransCard.BdColorBase = Color.lightGray;
						//btnlogin.BgColorBase = Color.white;
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						TransCard.BgColorBase = Color.white;
						//btnDashBord.BdColorBase = Color.black;
					}
				});
				
				JPanel poto_transact = new JPanel();
				poto_transact.setBackground(Color.DARK_GRAY);
				poto_transact.setBounds(12, 30, 39, 39);
				TransCard.add(poto_transact);
				
				JLabel lbltra_receiver = new JLabel(tracla.transact_receiver);
				lbltra_receiver.setHorizontalAlignment(SwingConstants.LEFT);
				lbltra_receiver.setForeground(Color.BLACK);
				lbltra_receiver.setFont(new Font("Square721 BT", Font.PLAIN, 15));
				lbltra_receiver.setBounds(63, 13, 201, 19);
				TransCard.add(lbltra_receiver);
				
				String TraAmountContain = new String();
				if(tracla.transact_amount > 0) {TraAmountContain = "Deposit: $" + tracla.transact_amount;}
				else {{TraAmountContain = "Withdraw: $" + tracla.transact_amount * -1;}}
				
				JLabel lblTraAmount = new JLabel(TraAmountContain);
				lblTraAmount.setHorizontalAlignment(SwingConstants.LEFT);
				lblTraAmount.setForeground(Color.BLACK);
				lblTraAmount.setFont(new Font("Square721 BT", Font.PLAIN, 15));
				lblTraAmount.setBounds(63, 38, 201, 19);
				TransCard.add(lblTraAmount);
				
				JLabel lblDate = new JLabel("Date: " + tracla.transact_date.replace(' ', '/'));
				lblDate.setHorizontalAlignment(SwingConstants.LEFT);
				lblDate.setForeground(Color.BLACK);
				lblDate.setFont(new Font("Square721 BT", Font.PLAIN, 15));
				lblDate.setBounds(63, 63, 201, 19);
				TransCard.add(lblDate);
				
				TransactArray.add(TransCard);
				
				dash_trans_y += 113;
			}
			
			for(FPanel panelcards: TransactArray) {
				
				dash_transactpanelContainer.add(panelcards);
				
			}
			
			JScrollBar scrollBar = new JScrollBar();
			scrollBar.setBounds(317, 13, 21, 230);
			scrollBar.setValue(dash_trans_yslide);
			scrollBar.setMaximum(dash_trans_y-(2*113));
			scrollBar.addAdjustmentListener(new AdjustmentListener() {

				@Override
				public void adjustmentValueChanged(AdjustmentEvent e) {
					dash_trans_yslide = scrollBar.getValue();

					dash_trans_y = 13 - dash_trans_yslide;
					
					for(FPanel panelcards: TransactArray) {
						panelcards.setBounds(12, dash_trans_y, 276, 100);
						dash_trans_y += 113;
					}
				}
			});
			transfercard.add(scrollBar);
			
		}

		void PaymentCard() {
			
			JPanel paymentscard = new JPanel();
			paymentscard.setLayout(null);
			paymentscard.setOpaque(false);
			paymentscard.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			paymentscard.setBounds(12, 429, 350, 256);
			this.add(paymentscard);
			
			dash_paymentspanelContainer = new JPanel();
			dash_paymentspanelContainer.setBackground(Color.WHITE);
			dash_paymentspanelContainer.setBounds(12, 13, 300, 168);
			dash_paymentspanelContainer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			dash_paymentspanelContainer.setLayout(null);
			paymentscard.add(dash_paymentspanelContainer);
			
			FButton btnPayAll = new FButton("PAY ALL");
			btnPayAll.setFont(new Font("Square721 BT", Font.PLAIN, 20));
			btnPayAll.setForeground(Color.black);
			btnPayAll.BgColorBase = Color.white;
			btnPayAll.BdColorBase = Color.black;
			btnPayAll.gradientbackground(Color.white, new Color(225,225,225));
			btnPayAll.gradientborder(Color.black, Color.darkGray);
			btnPayAll.setBounds(12, 194, 326, 49);
			btnPayAll.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					btnPayAll.in_box = false;
					btnPayAll.BgColorBase = new Color(225,225,225);
					btnPayAll.BdColorBase = Color.darkGray;
					//btnlogin.BgColorBase = Color.white;
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					btnPayAll.in_box = true;
					btnPayAll.BgColorBase = Color.white;
					//btnDashBord.BdColorBase = Color.black;
				}
			});
			paymentscard.add(btnPayAll);
			
			PaymentArray = new ArrayList<FPanel>(); 
			
			dash_paym_y = 13 - dash_paym_yslide;
			
			for(PaymentsClass tracla: user.payments) {
								
				FPanel TransCard = new FPanel();
				TransCard.setBounds(12, dash_paym_y, 276, 100);
				TransCard.setLayout(null);
				TransCard.BgColorBase = Color.white;
				TransCard.BdColorBase = Color.BLACK;
				TransCard.BgColor1 = Color.white;
				TransCard.BgColor2 = new Color(225,225,225);
				TransCard.BdColor1 = Color.BLACK;
				TransCard.BdColor2 = Color.WHITE;	
				TransCard.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						TransCard.BgColorBase = new Color(220,220,220);
						TransCard.BdColorBase = Color.lightGray;
						//btnlogin.BgColorBase = Color.white;
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						TransCard.BgColorBase = Color.white;
						//btnDashBord.BdColorBase = Color.black;
					}
				});
				
				JPanel poto_transact = new JPanel();
				poto_transact.setBackground(Color.DARK_GRAY);
				poto_transact.setBounds(12, 30, 39, 39);
				TransCard.add(poto_transact);
				
				JLabel lbltra_receiver = new JLabel(tracla.payment_name);
				lbltra_receiver.setHorizontalAlignment(SwingConstants.LEFT);
				lbltra_receiver.setForeground(Color.BLACK);
				lbltra_receiver.setFont(new Font("Square721 BT", Font.PLAIN, 15));
				lbltra_receiver.setBounds(63, 13, 201, 19);
				TransCard.add(lbltra_receiver);
				
				JLabel lblTraAmount = new JLabel("Amount $" + tracla.payment_amount);
				lblTraAmount.setHorizontalAlignment(SwingConstants.LEFT);
				lblTraAmount.setForeground(Color.BLACK);
				lblTraAmount.setFont(new Font("Square721 BT", Font.PLAIN, 15));
				lblTraAmount.setBounds(63, 38, 201, 19);
				TransCard.add(lblTraAmount);
				
				JLabel lblDate = new JLabel("Date: " + tracla.payment_date.replace(' ', '/'));
				lblDate.setHorizontalAlignment(SwingConstants.LEFT);
				lblDate.setForeground(Color.BLACK);
				lblDate.setFont(new Font("Square721 BT", Font.PLAIN, 15));
				lblDate.setBounds(63, 63, 201, 19);
				TransCard.add(lblDate);
				
				PaymentArray.add(TransCard);
				
				dash_paym_y += 113;
			}
			
			for(FPanel panelcards: PaymentArray) {
				
				dash_paymentspanelContainer.add(panelcards);
				
			}
			
			JScrollBar scrollBar = new JScrollBar();
			scrollBar.setBounds(317, 13, 21, 168);
			scrollBar.setValue(dash_paym_yslide);
			scrollBar.setMaximum(dash_paym_y-(113 + 100/2));
			scrollBar.addAdjustmentListener(new AdjustmentListener() {

				@Override
				public void adjustmentValueChanged(AdjustmentEvent e) {
					dash_paym_yslide = scrollBar.getValue();

					dash_paym_y = 13 - dash_paym_yslide;
					
					for(FPanel panelcards: PaymentArray) {
						panelcards.setBounds(12, dash_paym_y, 276, 100);
						dash_paym_y += 113;
					}
				}
			});
			paymentscard.add(scrollBar);
			
		}

	}
	
	class Plan_UI extends JPanel{
		
		ArrayList<FPanel> PayPlanArray;
		
		JPanel plan_payplanpanelContainer;
		int plan_payplan_yslide = 0;
		int plan_payplan_y;
		
		ArrayList<FPanel> GoalPlanArray;
		
		JPanel plan_goalplanpanelContainer;
		int plan_goalplan_xslide = 0;
		int plan_goalplan_x;
		
		Plan_UI(){
			this.setBackground(Color.white);
			this.setBounds(228, 0, 737, 710);
			this.setLayout(null);
			
			initiatePlanPane();
		}
		
		void initiatePlanPane() {
			
			JLabel lblDPTitle = new JLabel("Plan");
			lblDPTitle.setBounds(12, 24, 216, 50);
			lblDPTitle.setForeground(new Color(0, 0, 0));
			lblDPTitle.setFont(new Font("Square721 BT", Font.PLAIN, 40));
			this.add(lblDPTitle);
			
			JSeparator titlesperator = new JSeparator();
			titlesperator.setBounds(12, 85, 350, 2);
			titlesperator.setBackground(Color.BLACK);
			this.add(titlesperator);
			
			PlanBalanceCard();
			PaymentPlanCard();
			GoalPlanCard();
		}
		
		void PlanBalanceCard() {
			
			JPanel balancecard = new JPanel();
			balancecard.setBounds(12, 100, 350, 270);
			balancecard.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			balancecard.setOpaque(false);
			this.add(balancecard);
			balancecard.setLayout(null);
			
			JLabel lblBalanceTitle = new JLabel("Balance");
			lblBalanceTitle.setHorizontalAlignment(SwingConstants.LEFT);
			lblBalanceTitle.setForeground(Color.BLACK);
			lblBalanceTitle.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			lblBalanceTitle.setBounds(12, 13, 326, 26);
			balancecard.add(lblBalanceTitle);
			
			JLabel lblBalance = new JLabel("$" + user.balance);
			lblBalance.setHorizontalAlignment(SwingConstants.LEFT);
			lblBalance.setForeground(Color.BLACK);
			lblBalance.setFont(new Font("Square721 BT", Font.PLAIN, 30));
			lblBalance.setBounds(12, 36, 326, 38);
			balancecard.add(lblBalance);
			
			JLabel lblThisMonthsExpense = new JLabel("Your extra expense: ");
			lblThisMonthsExpense.setHorizontalAlignment(SwingConstants.RIGHT);
			lblThisMonthsExpense.setForeground(Color.BLACK);
			lblThisMonthsExpense.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			lblThisMonthsExpense.setBounds(168, 92, 170, 26);
			balancecard.add(lblThisMonthsExpense);
			
			JLabel lblExpense = new JLabel("$" + ((user.safetospendexpense > 0) ? user.safetospendexpense : 0));
			lblExpense.setHorizontalAlignment(SwingConstants.RIGHT);
			lblExpense.setForeground(Color.LIGHT_GRAY);
			lblExpense.setFont(new Font("Square721 BT", Font.PLAIN, 25));
			lblExpense.setBounds(168, 114, 170, 38);
			balancecard.add(lblExpense);
			
			JLabel lblSafetoSpend = new JLabel("Safe to Spend Money");
			lblSafetoSpend.setHorizontalAlignment(SwingConstants.RIGHT);
			lblSafetoSpend.setForeground(Color.BLACK);
			lblSafetoSpend.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			lblSafetoSpend.setBounds(212, 165, 126, 26);
			balancecard.add(lblSafetoSpend);
			
			JLabel lblTotalPayment = new JLabel("$" + user.safetospend);
			lblTotalPayment.setHorizontalAlignment(SwingConstants.RIGHT);
			lblTotalPayment.setForeground(Color.GRAY);
			lblTotalPayment.setFont(new Font("Square721 BT", Font.PLAIN, 25));
			lblTotalPayment.setBounds(168, 189, 170, 38);
			balancecard.add(lblTotalPayment);
			
			JLabel lblBudget = new JLabel("Budget Meter");
			lblBudget.setHorizontalAlignment(SwingConstants.LEFT);
			lblBudget.setForeground(Color.BLACK);
			lblBudget.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			lblBudget.setBounds(12, 119, 126, 26);
			balancecard.add(lblBudget);
			
			ProgressBar budgetBar = new ProgressBar(user.safetospendexpense, user.safetospend, Color.lightGray, Color.black, Color.darkGray);
			budgetBar.setBounds(12, 104, 144, 17);
			budgetBar.setVisible(true);
			balancecard.add(budgetBar);
			
			JLabel lblMaxSafetoSpend = new JLabel("Max safe-to-spend: $" + user.maxspend);
			lblMaxSafetoSpend.setHorizontalAlignment(SwingConstants.LEFT);
			lblMaxSafetoSpend.setForeground(Color.BLACK);
			lblMaxSafetoSpend.setFont(new Font("Square721 BT", Font.PLAIN, 12));
			lblMaxSafetoSpend.setBounds(12, 231, 326, 26);
			balancecard.add(lblMaxSafetoSpend);
			
			JSlider SliderSafetoSpend = new JSlider();
			SliderSafetoSpend.setBounds(12, 184, 161, 17);
			SliderSafetoSpend.setMaximum(user.maxspend);
			SliderSafetoSpend.setValue(user.safetospend);
			SliderSafetoSpend.repaint();
			SliderSafetoSpend.addChangeListener(new ChangeListener() {
				@Override
				public void stateChanged(ChangeEvent e) {
					user.safetospend = SliderSafetoSpend.getValue();
					lblTotalPayment.setText("$" + user.safetospend);
					budgetBar.getmax = user.safetospend;
					budgetBar.repaint();
				}
			});
			balancecard.add(SliderSafetoSpend);
			
		}
		
		class ProgressBar extends JPanel{
					
					int getval, getmax;
					Color BgColor, BdColor, FillColor;
					
					ProgressBar(int val, int max, Color Bg, Color Bd, Color Fill){
						this.getval = val;
						this.getmax = max;
						this.BgColor = Bg;
						this.BdColor = Bd;
						this.FillColor = Fill;
						//System.out.println("Working");
					}
					
					public void paint (Graphics g) {
						
						
						g.setColor(BgColor);
						g.fillRoundRect(0, 0, super.getWidth(), super.getHeight(), 10, 10);
						g.setColor(FillColor);
						//System.out.println((int) (super.getWidth()*((float)getval / (float)getmax)));
						g.fillRoundRect(0, 0, (int) (super.getWidth()*((float)getval / (float)getmax)), super.getHeight(), 10, 10);
						g.setColor(BdColor);
						g.drawRoundRect(0, 0, super.getWidth(), super.getHeight(), 10, 10);
						
					}
					
		}
		
		void PaymentPlanCard() {
			
			JPanel paymentplancard = new JPanel();
			paymentplancard.setLayout(null);
			paymentplancard.setOpaque(false);
			paymentplancard.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			paymentplancard.setBounds(375, 100, 350, 585);
			this.add(paymentplancard);
			
			plan_payplanpanelContainer = new JPanel();
			plan_payplanpanelContainer.setBackground(Color.WHITE);
			plan_payplanpanelContainer.setBounds(12, 13, 300, 430);
			plan_payplanpanelContainer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			plan_payplanpanelContainer.setLayout(null);
			paymentplancard.add(plan_payplanpanelContainer);
			
			JLabel lblDescription = new JLabel("One click to view detal. Double click to pay");
			lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
			lblDescription.setForeground(Color.BLACK);
			lblDescription.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			lblDescription.setBounds(12, 447, 326, 35);
			paymentplancard.add(lblDescription);
			
			FButton btnNewPayment = new FButton("Create A New Payment Plan");
			btnNewPayment.setFont(new Font("Square721 BT", Font.PLAIN, 20));
			btnNewPayment.setForeground(Color.black);
			btnNewPayment.BgColorBase = Color.white;
			btnNewPayment.BdColorBase = Color.black;
			btnNewPayment.gradientbackground(Color.white, new Color(225,225,225));
			btnNewPayment.gradientborder(Color.black, Color.darkGray);
			btnNewPayment.setBounds(12, 486, 326, 86);
			btnNewPayment.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					btnNewPayment.in_box = false;
					btnNewPayment.BgColorBase = new Color(225,225,225);
					btnNewPayment.BdColorBase = Color.darkGray;
					//btnlogin.BgColorBase = Color.white;
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					btnNewPayment.in_box = true;
					btnNewPayment.BgColorBase = Color.white;
					//btnDashBord.BdColorBase = Color.black;
				}
			});
			paymentplancard.add(btnNewPayment);
			
			PayPlanArray = new ArrayList<FPanel>(); 
			
			plan_payplan_y = 13 - plan_payplan_yslide;
			
			for(PayTempClass ptcla: user.payment_template) {
								
				FPanel TransCard = new FPanel();
				TransCard.setBounds(12, plan_payplan_y, 276, 100);
				TransCard.setLayout(null);
				TransCard.BgColorBase = Color.white;
				TransCard.BdColorBase = Color.BLACK;
				TransCard.BgColor1 = Color.white;
				TransCard.BgColor2 = new Color(225,225,225);
				TransCard.BdColor1 = Color.BLACK;
				TransCard.BdColor2 = Color.WHITE;	
				TransCard.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						TransCard.BgColorBase = new Color(220,220,220);
						TransCard.BdColorBase = Color.lightGray;
						//btnlogin.BgColorBase = Color.white;
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						TransCard.BgColorBase = Color.white;
						//btnDashBord.BdColorBase = Color.black;
					}
				});
				
				JPanel poto_transact = new JPanel();
				poto_transact.setBackground(Color.DARK_GRAY);
				poto_transact.setBounds(12, 30, 39, 39);
				TransCard.add(poto_transact);
				
				JLabel lbltra_receiver = new JLabel(ptcla.payment_name);
				lbltra_receiver.setHorizontalAlignment(SwingConstants.LEFT);
				lbltra_receiver.setForeground(Color.BLACK);
				lbltra_receiver.setFont(new Font("Square721 BT", Font.PLAIN, 15));
				lbltra_receiver.setBounds(63, 13, 201, 19);
				TransCard.add(lbltra_receiver);
				
				JLabel lblTraAmount = new JLabel("Withdraw $" + ptcla.payment_amount);
				lblTraAmount.setHorizontalAlignment(SwingConstants.LEFT);
				lblTraAmount.setForeground(Color.BLACK);
				lblTraAmount.setFont(new Font("Square721 BT", Font.PLAIN, 15));
				lblTraAmount.setBounds(63, 38, 201, 19);
				TransCard.add(lblTraAmount);
				
				JLabel lblDate = new JLabel("Date: " + ptcla.payment_duedate.replace(' ', '/'));
				lblDate.setHorizontalAlignment(SwingConstants.LEFT);
				lblDate.setForeground(Color.BLACK);
				lblDate.setFont(new Font("Square721 BT", Font.PLAIN, 15));
				lblDate.setBounds(63, 63, 201, 19);
				TransCard.add(lblDate);
				
				PayPlanArray.add(TransCard);
				
				plan_payplan_y += 113;
			}
			
			for(FPanel panelcards: PayPlanArray) {
				
				plan_payplanpanelContainer.add(panelcards);
				
			}
			
			JScrollBar scrollBar = new JScrollBar();
			scrollBar.setBounds(317, 13, 21, 430);
			scrollBar.setValue(plan_payplan_yslide);
			scrollBar.setMaximum(plan_payplan_y-(int)(3.8*113));
			scrollBar.addAdjustmentListener(new AdjustmentListener() {

				@Override
				public void adjustmentValueChanged(AdjustmentEvent e) {
					plan_payplan_yslide = scrollBar.getValue();

					plan_payplan_y = 13 - plan_payplan_yslide;
					
					for(FPanel panelcards: PayPlanArray) {
						panelcards.setBounds(12, plan_payplan_y, 276, 100);
						plan_payplan_y += 113;
					}
				}
			});
			paymentplancard.add(scrollBar);
			
		}
		
		void GoalPlanCard() {
			
			JPanel goalplancard = new JPanel();
			goalplancard.setLayout(null);
			goalplancard.setOpaque(false);
			goalplancard.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			goalplancard.setBounds(12, 383, 350, 302);
			this.add(goalplancard);
			
			plan_goalplanpanelContainer = new JPanel();
			plan_goalplanpanelContainer.setBackground(Color.WHITE);
			plan_goalplanpanelContainer.setBounds(12, 13, 326, 129);
			plan_goalplanpanelContainer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			plan_goalplanpanelContainer.setLayout(null);
			goalplancard.add(plan_goalplanpanelContainer);
			
			JLabel lblCreateGoalsAnd = new JLabel("Create goals and automatically save for it");
			lblCreateGoalsAnd.setHorizontalAlignment(SwingConstants.CENTER);
			lblCreateGoalsAnd.setForeground(Color.BLACK);
			lblCreateGoalsAnd.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			lblCreateGoalsAnd.setBounds(12, 175, 326, 20);
			goalplancard.add(lblCreateGoalsAnd);
			
			FButton btnPayAll = new FButton("Create A New Goal Plan");
			btnPayAll.setFont(new Font("Square721 BT", Font.PLAIN, 20));
			btnPayAll.setForeground(Color.black);
			btnPayAll.BgColorBase = Color.white;
			btnPayAll.BdColorBase = Color.black;
			btnPayAll.gradientbackground(Color.white, new Color(225,225,225));
			btnPayAll.gradientborder(Color.black, Color.darkGray);
			btnPayAll.setBounds(12, 203, 326, 86);
			btnPayAll.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					btnPayAll.in_box = false;
					btnPayAll.BgColorBase = new Color(225,225,225);
					btnPayAll.BdColorBase = Color.darkGray;
					//btnlogin.BgColorBase = Color.white;
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					btnPayAll.in_box = true;
					btnPayAll.BgColorBase = Color.white;
					//btnDashBord.BdColorBase = Color.black;
				}
			});
			goalplancard.add(btnPayAll);
			
			GoalPlanArray = new ArrayList<FPanel>(); 
			
			plan_goalplan_x = 12 - plan_goalplan_xslide;
			
			for(SaveClass sacla: user.saveforthese) {
								
				FPanel TransCard = new FPanel();
				TransCard.setBounds(plan_goalplan_x, 13, 276, 100);
				TransCard.setLayout(null);
				TransCard.BgColorBase = Color.white;
				TransCard.BdColorBase = Color.BLACK;
				TransCard.BgColor1 = Color.white;
				TransCard.BgColor2 = new Color(225,225,225);
				TransCard.BdColor1 = Color.BLACK;
				TransCard.BdColor2 = Color.WHITE;	
				TransCard.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						TransCard.BgColorBase = new Color(220,220,220);
						TransCard.BdColorBase = Color.lightGray;
						//btnlogin.BgColorBase = Color.white;
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						TransCard.BgColorBase = Color.white;
						//btnDashBord.BdColorBase = Color.black;
					}
				});
				
				JPanel poto_transact = new JPanel();
				poto_transact.setBackground(Color.DARK_GRAY);
				poto_transact.setBounds(12, 30, 39, 39);
				TransCard.add(poto_transact);
				
				JLabel lbltra_receiver = new JLabel(sacla.project_name);
				lbltra_receiver.setHorizontalAlignment(SwingConstants.LEFT);
				lbltra_receiver.setForeground(Color.BLACK);
				lbltra_receiver.setFont(new Font("Square721 BT", Font.PLAIN, 15));
				lbltra_receiver.setBounds(63, 13, 201, 19);
				TransCard.add(lbltra_receiver);
				
				JLabel lblTraAmount = new JLabel("Saved: $" + sacla.project_goal);
				lblTraAmount.setHorizontalAlignment(SwingConstants.LEFT);
				lblTraAmount.setForeground(Color.BLACK);
				lblTraAmount.setFont(new Font("Square721 BT", Font.PLAIN, 15));
				lblTraAmount.setBounds(63, 38, 201, 19);
				TransCard.add(lblTraAmount);
				
				JLabel lblDate = new JLabel("Goal: " + sacla.project_save);
				lblDate.setHorizontalAlignment(SwingConstants.LEFT);
				lblDate.setForeground(Color.BLACK);
				lblDate.setFont(new Font("Square721 BT", Font.PLAIN, 15));
				lblDate.setBounds(63, 63, 201, 19);
				TransCard.add(lblDate);
				
				GoalPlanArray.add(TransCard);
				
				plan_goalplan_x += 290;
			}
			
			for(FPanel panelcards: GoalPlanArray) {
				
				plan_goalplanpanelContainer.add(panelcards);
				
			}
			
			JScrollBar scrollBar = new JScrollBar();
			scrollBar.setBounds(12, 146, 326, 20);
			scrollBar.setOrientation(JScrollBar.HORIZONTAL);
			scrollBar.setValue(plan_goalplan_xslide);
			scrollBar.setMaximum(plan_goalplan_x-(int)(1.1*290));
			scrollBar.addAdjustmentListener(new AdjustmentListener() {

				@Override
				public void adjustmentValueChanged(AdjustmentEvent e) {

					plan_goalplan_xslide = scrollBar.getValue();

					plan_goalplan_x = 12 - plan_goalplan_xslide;
					
					for(FPanel panelcards: GoalPlanArray) {
						panelcards.setBounds(plan_goalplan_x, 13, 276, 100);
						plan_goalplan_x += 290;
					}
				}
			});
			goalplancard.add(scrollBar);
			
		}
		
	}

	class Transaction_UI extends JPanel{
		
		ArrayList<FPanel> TransactArray;
		
		JPanel transact_listpanelContainer;
		int transact_list_yslide = 0;
		int transact_list_y;
		
		JPanel transact_detailpanelContainer;
		JLabel lblTitle;
		JTextArea txtDateTitle, txtTNoTitle, txtInputTitle, txtOutputTitle, txtAmountTitle;
		JTextArea txtDate, txtTNo, txtInput, txtOutput, txtAmount;
		
		Transaction_UI(){
			this.setBackground(Color.white);
			this.setBounds(228, 0, 737, 710);
			this.setLayout(null);
			
			initiateTransactPane();
		}
		
		void initiateTransactPane(){
			
			JLabel lblTitle = new JLabel("Transactions");
			lblTitle.setBounds(12, 24, 350, 50);
			lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
			lblTitle.setForeground(new Color(0, 0, 0));
			lblTitle.setFont(new Font("Square721 BT", Font.PLAIN, 40));
			this.add(lblTitle);
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(12, 85, 350, 2);
			separator_1.setBackground(Color.BLACK);
			this.add(separator_1);
			
			JTextArea txtrANewUser = new JTextArea();
			txtrANewUser.setWrapStyleWord(true);
			txtrANewUser.setBounds(12, 136, 713, 50);
			txtrANewUser.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtrANewUser.setText("Take the daily mundane tasks away from your life and let us handle your goals and trust. Payment is just a system that should be handled by another trustworthy system.");
			txtrANewUser.setOpaque(false);
			txtrANewUser.setLineWrap(true);
			txtrANewUser.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtrANewUser.setEnabled(false);
			txtrANewUser.setDisabledTextColor(new Color(0, 0, 0));
			this.add(txtrANewUser);
			
			JLabel lblBanner = new JLabel("Security is our Mission");
			lblBanner.setHorizontalAlignment(SwingConstants.LEFT);
			lblBanner.setForeground(Color.BLACK);
			lblBanner.setFont(new Font("Square721 BT", Font.PLAIN, 30));
			lblBanner.setBounds(12, 96, 350, 38);
			this.add(lblBanner);
			
			TransActList_Details();
			
		}
		
		void TransActList_Details() {
			
			JPanel maintranspanel = new JPanel();
			maintranspanel.setLayout(null);
			maintranspanel.setOpaque(false);
			maintranspanel.setBorder(new LineBorder(new Color(0, 0, 0)));
			maintranspanel.setBounds(12, 199, 713, 486);
			this.add(maintranspanel);
			
			//DetailsSection///////////////////////////////////////////////////////////////////////////
			
			transact_detailpanelContainer = new JPanel();
			transact_detailpanelContainer.setBackground(Color.WHITE);
			transact_detailpanelContainer.setBounds(411, 13, 299, 460);
			transact_detailpanelContainer.setLayout(null);
			maintranspanel.add(transact_detailpanelContainer);
			
			lblTitle = new JLabel("");
			lblTitle.setBounds(12, 13, 275, 55);
			transact_detailpanelContainer.add(lblTitle);
			lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
			lblTitle.setForeground(Color.BLACK);
			lblTitle.setFont(new Font("Square721 BT", Font.PLAIN, 25));
			
			txtDateTitle = new JTextArea();
			txtDateTitle.setWrapStyleWord(true);
			txtDateTitle.setText("Date of Receipt:");
			txtDateTitle.setOpaque(false);
			txtDateTitle.setLineWrap(true);
			txtDateTitle.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtDateTitle.setEnabled(false);
			txtDateTitle.setDisabledTextColor(Color.BLACK);
			txtDateTitle.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtDateTitle.setBounds(12, 69, 275, 23);
			transact_detailpanelContainer.add(txtDateTitle);
			
			txtDate = new JTextArea();
			txtDate.setWrapStyleWord(true);
			txtDate.setText("");
			txtDate.setOpaque(false);
			txtDate.setLineWrap(true);
			txtDate.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtDate.setEnabled(false);
			txtDate.setDisabledTextColor(Color.BLACK);
			txtDate.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtDate.setBounds(22, 92, 265, 23);
			transact_detailpanelContainer.add(txtDate);
			
			txtTNoTitle = new JTextArea();
			txtTNoTitle.setWrapStyleWord(true);
			txtTNoTitle.setText("Transaction No:");
			txtTNoTitle.setOpaque(false);
			txtTNoTitle.setLineWrap(true);
			txtTNoTitle.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtTNoTitle.setEnabled(false);
			txtTNoTitle.setDisabledTextColor(Color.BLACK);
			txtTNoTitle.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtTNoTitle.setBounds(12, 128, 275, 23);
			transact_detailpanelContainer.add(txtTNoTitle);
			
			txtTNo = new JTextArea();
			txtTNo.setWrapStyleWord(true);
			txtTNo.setText("");
			txtTNo.setOpaque(false);
			txtTNo.setLineWrap(true);
			txtTNo.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtTNo.setEnabled(false);
			txtTNo.setDisabledTextColor(Color.BLACK);
			txtTNo.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtTNo.setBounds(22, 151, 265, 23);
			transact_detailpanelContainer.add(txtTNo);
			
			txtInputTitle = new JTextArea();
			txtInputTitle.setWrapStyleWord(true);
			txtInputTitle.setText("Input Actor:");
			txtInputTitle.setOpaque(false);
			txtInputTitle.setLineWrap(true);
			txtInputTitle.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtInputTitle.setEnabled(false);
			txtInputTitle.setDisabledTextColor(Color.BLACK);
			txtInputTitle.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtInputTitle.setBounds(12, 187, 275, 23);
			transact_detailpanelContainer.add(txtInputTitle);
			
			txtInput = new JTextArea();
			txtInput.setWrapStyleWord(true);
			txtInput.setText("");
			txtInput.setOpaque(false);
			txtInput.setLineWrap(true);
			txtInput.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtInput.setEnabled(false);
			txtInput.setDisabledTextColor(Color.BLACK);
			txtInput.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtInput.setBounds(22, 210, 265, 23);
			transact_detailpanelContainer.add(txtInput);
			
			txtOutputTitle = new JTextArea();
			txtOutputTitle.setWrapStyleWord(true);
			txtOutputTitle.setText("Output Actor:");
			txtOutputTitle.setOpaque(false);
			txtOutputTitle.setLineWrap(true);
			txtOutputTitle.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtOutputTitle.setEnabled(false);
			txtOutputTitle.setDisabledTextColor(Color.BLACK);
			txtOutputTitle.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtOutputTitle.setBounds(12, 246, 275, 23);
			transact_detailpanelContainer.add(txtOutputTitle);
			
			txtOutput = new JTextArea();
			txtOutput.setWrapStyleWord(true);
			txtOutput.setText("");
			txtOutput.setOpaque(false);
			txtOutput.setLineWrap(true);
			txtOutput.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtOutput.setEnabled(false);
			txtOutput.setDisabledTextColor(Color.BLACK);
			txtOutput.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtOutput.setBounds(22, 269, 265, 23);
			transact_detailpanelContainer.add(txtOutput);
			
			txtAmountTitle = new JTextArea();
			txtAmountTitle.setWrapStyleWord(true);
			txtAmountTitle.setText("Transaction Cash:");
			txtAmountTitle.setOpaque(false);
			txtAmountTitle.setLineWrap(true);
			txtAmountTitle.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtAmountTitle.setEnabled(false);
			txtAmountTitle.setDisabledTextColor(Color.BLACK);
			txtAmountTitle.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtAmountTitle.setBounds(12, 305, 275, 23);
			transact_detailpanelContainer.add(txtAmountTitle);
			
			txtAmount = new JTextArea();
			txtAmount.setWrapStyleWord(true);
			txtAmount.setText("");
			txtAmount.setOpaque(false);
			txtAmount.setLineWrap(true);
			txtAmount.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtAmount.setEnabled(false);
			txtAmount.setDisabledTextColor(Color.BLACK);
			txtAmount.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtAmount.setBounds(22, 328, 265, 23);
			transact_detailpanelContainer.add(txtAmount);
			
			FButton btnReport = new FButton("Issue with this transaction? Report it");
			btnReport.setFont(new Font("Square721 BT", Font.PLAIN, 13));
			btnReport.setHorizontalAlignment(SwingConstants.RIGHT);
			btnReport.setForeground(Color.black);
			btnReport.BgColorBase = Color.white;
			btnReport.BdColorBase = Color.white;
			btnReport.gradientbackground(Color.white, new Color(225,225,225));
			btnReport.gradientborder(Color.white, new Color(175,175,175));
			btnReport.setBounds(12, 424, 275, 23);
			btnReport.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					btnReport.in_box = false;
					btnReport.BgColorBase = Color.lightGray;
					//btnSettings.BdColorBase = Color.white;
					//btnlogin.BgColorBase = Color.white;
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					btnReport.in_box = true;
					btnReport.BgColorBase = Color.white;
					//btnLoan.BdColorBase = Color.black;
				}
			});
			transact_detailpanelContainer.add(btnReport);
			
			//ListPanel///////////////////////////////////////////////////////////////////////////////////////////
			
			transact_listpanelContainer = new JPanel();
			transact_listpanelContainer.setBackground(Color.WHITE);
			transact_listpanelContainer.setBounds(12, 13, 354, 460);
			//transact_listpanelContainer.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			transact_listpanelContainer.setLayout(null);
			maintranspanel.add(transact_listpanelContainer);
			
			TransactArray = new ArrayList<FPanel>(); 
			
			transact_list_y = 0 - transact_list_yslide;
			
			for(TransactionsClass tacla: user.transactions) {
								
				FPanel TransCard = new FPanel();
				TransCard.setBounds(0, transact_list_y, 354, 63);
				TransCard.setLayout(null);
				TransCard.BgColorBase = Color.white;
				TransCard.BdColorBase = Color.BLACK;
				TransCard.BgColor1 = Color.white;
				TransCard.BgColor2 = new Color(225,225,225);
				TransCard.BdColor1 = Color.BLACK;
				TransCard.BdColor2 = Color.WHITE;	
				TransCard.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						TransCard.in_box = false;
						TransCard.BgColorBase = new Color(200,200,200);
						TransCard.BdColorBase = Color.lightGray;
						//btnlogin.BgColorBase = Color.white;
					}
					@Override
					public void mouseReleased(MouseEvent e) {
						TransCard.in_box = true;
						TransCard.BgColorBase = Color.white;
						TransCard.BdColorBase = Color.black;
						lblTitle.setText(tacla.transact_receiver);
						txtDate.setText(tacla.transact_date.replace(' ', '/'));
						txtTNo.setText(tacla.transact_number);
						txtInput.setText(tacla.transact_actor);
						txtOutput.setText(tacla.transact_receiver);
						txtAmount.setText(Integer.toString(tacla.transact_amount));
						//transact_detailpanelContainer.repaint();
					}
				});
				
				JPanel poto_transact = new JPanel();
				poto_transact.setBackground(Color.DARK_GRAY);
				poto_transact.setBounds(12, 13, 37, 37);
				TransCard.add(poto_transact);
				
				JLabel lbltra_receiver = new JLabel(tacla.transact_receiver + ": " + tacla.transact_amount);
				lbltra_receiver.setHorizontalAlignment(SwingConstants.LEFT);
				lbltra_receiver.setForeground(Color.BLACK);
				lbltra_receiver.setFont(new Font("Square721 BT", Font.PLAIN, 15));
				lbltra_receiver.setBounds(58, 10, 154, 23);
				TransCard.add(lbltra_receiver);
				
				JLabel lblDate = new JLabel("Date: " + tacla.transact_date.replace(' ', '/'));
				lblDate.setHorizontalAlignment(SwingConstants.LEFT);
				lblDate.setForeground(Color.BLACK);
				lblDate.setFont(new Font("Square721 BT", Font.PLAIN, 15));
				lblDate.setBounds(58, 30, 154, 23);
				TransCard.add(lblDate);
				
				TransactArray.add(TransCard);
				
				transact_list_y += 75;
			}
			
			for(FPanel panelcards: TransactArray) {
				
				transact_listpanelContainer.add(panelcards);
				
			}
			
			JScrollBar scrollBar = new JScrollBar();
			scrollBar.setBounds(378, 13, 21, 460);
			scrollBar.setValue(transact_list_yslide);
			scrollBar.setMaximum(transact_list_y-(int)(3.8*113));
			scrollBar.addAdjustmentListener(new AdjustmentListener() {

				@Override
				public void adjustmentValueChanged(AdjustmentEvent e) {
					transact_list_yslide = scrollBar.getValue();

					transact_list_y = 0 - transact_list_yslide;
					
					for(FPanel panelcards: TransactArray) {
						panelcards.setBounds(0, transact_list_y, 354, 63);
						transact_list_y += 75;
					}
				}
			});
			maintranspanel.add(scrollBar);
			
			
		}
		
		
	}
	
	class Deposit_UI extends JPanel {
		
		String pinco;
		int tries;
		int valuedepo;
		
		JPanel withInputPane, depoOutputPane;
		JTextField txtAmount, txtPassword, txtPinCode;
		FButton btnAuthenticate, btnConfirm;
		JTextArea txtDateTitle, txtTNoTitle, txtInputTitle, txtOutputTitle, txtAmountTitle;
		JTextArea txtDate, txtTNo, txtInput, txtOutput, txtOutputAmount;
		
		Deposit_UI(){
			this.setBackground(Color.white);
			this.setBounds(228, 0, 737, 710);
			this.setLayout(null);
			this.addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent e) {
					if(depositpane.txtAmount.getText().equals("")) {
						depositpane.txtAmount.setText("Amount of Money");}
					
					if(depositpane.txtPassword.getText().equals("")) {
					depositpane.txtPassword.setText("Enter Password for Verification");}
					
					if(depositpane.txtPinCode.getText().equals("")) {
						depositpane.txtPinCode.setText("Pin Code");}
				}
			});
			
			initiateDepositPane();
		}
		
		void initiateDepositPane() {
			
			JLabel lblDeposit = new JLabel("Deposit");
			lblDeposit.setBounds(12, 24, 216, 50);
			lblDeposit.setHorizontalAlignment(SwingConstants.LEFT);
			lblDeposit.setForeground(new Color(0, 0, 0));
			lblDeposit.setFont(new Font("Square721 BT", Font.PLAIN, 40));
			this.add(lblDeposit);
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(12, 85, 350, 2);
			separator_1.setBackground(Color.BLACK);
			this.add(separator_1);
			
			JLabel lblTagTitle = new JLabel("Security is our Mission");
			lblTagTitle.setHorizontalAlignment(SwingConstants.LEFT);
			lblTagTitle.setForeground(Color.BLACK);
			lblTagTitle.setFont(new Font("Square721 BT", Font.PLAIN, 30));
			lblTagTitle.setBounds(12, 96, 350, 38);
			this.add(lblTagTitle);
			
			JTextArea txtTagline = new JTextArea();
			txtTagline.setWrapStyleWord(true);
			txtTagline.setBounds(12, 136, 713, 50);
			txtTagline.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtTagline.setText("We value our costumers as much as you value your hard earned cash. That's why we provide our state of the art protection and encryption to every transaction made through our platform.");
			txtTagline.setOpaque(false);
			txtTagline.setLineWrap(true);
			txtTagline.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtTagline.setEnabled(false);
			txtTagline.setDisabledTextColor(new Color(0, 0, 0));
			this.add(txtTagline);
			
			DepositHandlePane();

		}
		
		void DepositHandlePane() {
			
			JPanel maindepopanel = new JPanel();
			maindepopanel.setLayout(null);
			maindepopanel.setOpaque(false);
			maindepopanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			maindepopanel.setBounds(12, 188, 713, 509);
			this.add(maindepopanel);
			
			//////////////DEPO INPUT PANEL////////////////////////////////////////////////
			
			withInputPane = new JPanel();
			withInputPane.setBackground(Color.WHITE);
			withInputPane.setBounds(12, 13, 378, 483);
			withInputPane.setLayout(null);
			withInputPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			maindepopanel.add(withInputPane);
			
			JLabel lblDepoInTitle = new JLabel("Deposit Check");
			lblDepoInTitle.setBounds(12, 13, 288, 73);
			withInputPane.add(lblDepoInTitle);
			lblDepoInTitle.setHorizontalAlignment(SwingConstants.LEFT);
			lblDepoInTitle.setForeground(Color.BLACK);
			lblDepoInTitle.setFont(new Font("Square721 BT", Font.PLAIN, 40));
			
			txtAmount = new JTextField();
			txtAmount.setFont(new Font("Square721 BT", Font.PLAIN, 20));
			txtAmount.setText("Amount of Money");
			txtAmount.setBounds(12, 99, 354, 35);
			txtAmount.setColumns(10);
			txtAmount.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(txtAmount.getText().equals("Amount of Money")) {
						txtAmount.setText(null);
					}
				}
			});
			withInputPane.add(txtAmount);
			
			txtPassword = new JTextField();
			txtPassword.setText("Enter Password for Verification");
			txtPassword.setFont(new Font("Square721 BT", Font.PLAIN, 20));
			txtPassword.setColumns(10);
			txtPassword.setBounds(12, 147, 354, 35);
			txtPassword.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(txtPassword.getText().equals("Enter Password for Verification")) {
						txtPassword.setText(null);
					}
				}
			});
			withInputPane.add(txtPassword);
			
			btnConfirm = new FButton("Confirm");
			btnConfirm.setFont(new Font("Square721 BT", Font.PLAIN, 20));
			btnConfirm.setForeground(Color.black);
			btnConfirm.BgColorBase = Color.white;
			btnConfirm.BdColorBase = Color.black;
			btnConfirm.gradientbackground(Color.white, new Color(225,225,225));
			btnConfirm.gradientborder(Color.black, Color.lightGray);
			btnConfirm.setBounds(159, 212, 207, 42);
			btnConfirm.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (btnConfirm.active) {
					btnConfirm.in_box = false;
					btnConfirm.BgColorBase = new Color(225,225,225);
					btnConfirm.BdColorBase = Color.darkGray;
					//btnlogin.BgColorBase = Color.white;
					}
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					if (btnConfirm.active) {
					btnConfirm.in_box = true;
					btnConfirm.BgColorBase = Color.white;
					//btnDashBord.BdColorBase = Color.black;
					confirmSystem();
					}
				}
			});
			withInputPane.add(btnConfirm);
			
			txtPinCode = new JTextField();
			txtPinCode.setEnabled(false);
			txtPinCode.setText("Pin Code");
			txtPinCode.setFont(new Font("Square721 BT", Font.PLAIN, 20));
			txtPinCode.setColumns(10);
			txtPinCode.setBounds(12, 292, 354, 35);
			txtPinCode.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(txtPinCode.getText().equals("Pin Code") && btnAuthenticate.active) {
						txtPinCode.setText(null);
					}
				}
			});
			withInputPane.add(txtPinCode);
			
			JTextArea txtImportantInfo = new JTextArea();
			txtImportantInfo.setWrapStyleWord(true);
			txtImportantInfo.setText("You will receive a confirmation code through your validated phone, remember this code as this will be asked by our tender before proceeding on transaction.");
			txtImportantInfo.setOpaque(false);
			txtImportantInfo.setLineWrap(true);
			txtImportantInfo.setFont(new Font("Square721 BT", Font.PLAIN, 13));
			txtImportantInfo.setEnabled(false);
			txtImportantInfo.setDisabledTextColor(Color.BLACK);
			txtImportantInfo.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtImportantInfo.setBounds(12, 340, 354, 61);
			withInputPane.add(txtImportantInfo);
			
			btnAuthenticate = new FButton("Authenticate");
			btnAuthenticate.setFont(new Font("Square721 BT", Font.PLAIN, 20));
			btnAuthenticate.setForeground(Color.black);
			btnAuthenticate.BgColorBase = Color.white;
			btnAuthenticate.BdColorBase = Color.black;
			btnAuthenticate.gradientbackground(Color.white, new Color(225,225,225));
			btnAuthenticate.gradientborder(Color.black, Color.lightGray);
			btnAuthenticate.setBounds(159, 417, 207, 42);
			btnAuthenticate.active = false;
			btnAuthenticate.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if(btnAuthenticate.active) {
					btnAuthenticate.in_box = false;
					btnAuthenticate.BgColorBase = new Color(225,225,225);
					btnAuthenticate.BdColorBase = Color.darkGray;
					//btnlogin.BgColorBase = Color.white;
					}
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					if(btnAuthenticate.active) {
					btnAuthenticate.in_box = true;
					btnAuthenticate.BgColorBase = Color.white;
					//btnDashBord.BdColorBase = Color.black;
					authenticateSystem();
					}
				}
			});
			withInputPane.add(btnAuthenticate);
			
			//////////////DEPO OUTPUT PANEL////////////////////////////////////////////////
			
			depoOutputPane = new JPanel();
			depoOutputPane.setLayout(null);
			depoOutputPane.setBackground(Color.WHITE);
			depoOutputPane.setBounds(402, 13, 299, 483);
			depoOutputPane.setVisible(false);
			maindepopanel.add(depoOutputPane);
			
			JLabel lblSlip = new JLabel("SLIP");
			lblSlip.setHorizontalAlignment(SwingConstants.LEFT);
			lblSlip.setForeground(Color.BLACK);
			lblSlip.setFont(new Font("Square721 BT", Font.PLAIN, 40));
			lblSlip.setBounds(12, 13, 98, 73);
			depoOutputPane.add(lblSlip);
			
			JTextArea txtNotify = new JTextArea();
			txtNotify.setWrapStyleWord(true);
			txtNotify.setText("Present this slip to our counter and let us handle from this.");
			txtNotify.setOpaque(false);
			txtNotify.setLineWrap(true);
			txtNotify.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtNotify.setEnabled(false);
			txtNotify.setDisabledTextColor(Color.BLACK);
			txtNotify.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtNotify.setBounds(12, 78, 275, 42);
			depoOutputPane.add(txtNotify);
			
			txtDateTitle = new JTextArea();
			txtDateTitle.setWrapStyleWord(true);
			txtDateTitle.setText("Date of Receipt:");
			txtDateTitle.setOpaque(false);
			txtDateTitle.setLineWrap(true);
			txtDateTitle.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtDateTitle.setEnabled(false);
			txtDateTitle.setDisabledTextColor(Color.BLACK);
			txtDateTitle.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtDateTitle.setBounds(12, 133, 275, 23);
			depoOutputPane.add(txtDateTitle);
			
			txtDate = new JTextArea();
			txtDate.setWrapStyleWord(true);
			txtDate.setText("");
			txtDate.setOpaque(false);
			txtDate.setLineWrap(true);
			txtDate.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtDate.setEnabled(false);
			txtDate.setDisabledTextColor(Color.BLACK);
			txtDate.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtDate.setBounds(22, 156, 265, 23);
			depoOutputPane.add(txtDate);
			
			txtTNoTitle = new JTextArea();
			txtTNoTitle.setWrapStyleWord(true);
			txtTNoTitle.setText("Transaction No:");
			txtTNoTitle.setOpaque(false);
			txtTNoTitle.setLineWrap(true);
			txtTNoTitle.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtTNoTitle.setEnabled(false);
			txtTNoTitle.setDisabledTextColor(Color.BLACK);
			txtTNoTitle.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtTNoTitle.setBounds(12, 192, 275, 23);
			depoOutputPane.add(txtTNoTitle);
			
			txtTNo = new JTextArea();
			txtTNo.setWrapStyleWord(true);
			txtTNo.setText("");
			txtTNo.setOpaque(false);
			txtTNo.setLineWrap(true);
			txtTNo.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtTNo.setEnabled(false);
			txtTNo.setDisabledTextColor(Color.BLACK);
			txtTNo.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtTNo.setBounds(22, 151+64, 265, 23);
			depoOutputPane.add(txtTNo);
			
			txtInputTitle = new JTextArea();
			txtInputTitle.setWrapStyleWord(true);
			txtInputTitle.setText("Input Actor:");
			txtInputTitle.setOpaque(false);
			txtInputTitle.setLineWrap(true);
			txtInputTitle.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtInputTitle.setEnabled(false);
			txtInputTitle.setDisabledTextColor(Color.BLACK);
			txtInputTitle.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtInputTitle.setBounds(12, 187+64, 275, 23);
			depoOutputPane.add(txtInputTitle);
			
			txtInput = new JTextArea();
			txtInput.setWrapStyleWord(true);
			txtInput.setText("");
			txtInput.setOpaque(false);
			txtInput.setLineWrap(true);
			txtInput.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtInput.setEnabled(false);
			txtInput.setDisabledTextColor(Color.BLACK);
			txtInput.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtInput.setBounds(22, 210+64, 265, 23);
			depoOutputPane.add(txtInput);
			
			txtOutputTitle = new JTextArea();
			txtOutputTitle.setWrapStyleWord(true);
			txtOutputTitle.setText("Output Actor:");
			txtOutputTitle.setOpaque(false);
			txtOutputTitle.setLineWrap(true);
			txtOutputTitle.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtOutputTitle.setEnabled(false);
			txtOutputTitle.setDisabledTextColor(Color.BLACK);
			txtOutputTitle.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtOutputTitle.setBounds(12, 246+64, 275, 23);
			depoOutputPane.add(txtOutputTitle);
			
			txtOutput = new JTextArea();
			txtOutput.setWrapStyleWord(true);
			txtOutput.setText("");
			txtOutput.setOpaque(false);
			txtOutput.setLineWrap(true);
			txtOutput.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtOutput.setEnabled(false);
			txtOutput.setDisabledTextColor(Color.BLACK);
			txtOutput.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtOutput.setBounds(22, 269+64, 265, 23);
			depoOutputPane.add(txtOutput);
			
			txtAmountTitle = new JTextArea();
			txtAmountTitle.setWrapStyleWord(true);
			txtAmountTitle.setText("Payment Cash:");
			txtAmountTitle.setOpaque(false);
			txtAmountTitle.setLineWrap(true);
			txtAmountTitle.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtAmountTitle.setEnabled(false);
			txtAmountTitle.setDisabledTextColor(Color.BLACK);
			txtAmountTitle.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtAmountTitle.setBounds(12, 305+64, 275, 23);
			depoOutputPane.add(txtAmountTitle);
			
			txtOutputAmount = new JTextArea();
			txtOutputAmount.setWrapStyleWord(true);
			txtOutputAmount.setText("");
			txtOutputAmount.setOpaque(false);
			txtOutputAmount.setLineWrap(true);
			txtOutputAmount.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtOutputAmount.setEnabled(false);
			txtOutputAmount.setDisabledTextColor(Color.BLACK);
			txtOutputAmount.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtOutputAmount.setBounds(22, 328+64, 265, 23);
			depoOutputPane.add(txtOutputAmount);
			
			FButton btnReport = new FButton("PRINT SLIP");
			btnReport.setFont(new Font("Square721 BT", Font.PLAIN, 13));
			btnReport.setHorizontalAlignment(SwingConstants.CENTER);
			btnReport.setForeground(Color.black);
			btnReport.BgColorBase = Color.white;
			btnReport.BdColorBase = Color.black;
			btnReport.gradientbackground(Color.white, new Color(225,225,225));
			btnReport.gradientborder(Color.black, Color.lightGray);
			btnReport.setBounds(162, 443, 125, 27);
			btnReport.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					btnReport.in_box = false;
					btnReport.BgColorBase = Color.lightGray;
					//btnSettings.BdColorBase = Color.white;
					//btnlogin.BgColorBase = Color.white;
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					btnReport.in_box = true;
					btnReport.BgColorBase = Color.white;
					//btnLoan.BdColorBase = Color.black;
					printSlip();
				}
			});
			depoOutputPane.add(btnReport);
			
		}
	
		void confirmSystem() {
			
			if(txtPassword.getText().equals(user.password)) {
				try {
		
					valuedepo = Integer.parseInt(txtAmount.getText());
					
					if(valuedepo > 0) {
					
						pinco = new String();
						
						pinco = generateCode(6, true);
						
						JOptionPane.showMessageDialog(this, "A confirmation code will be sent to you. Input the Pin Code to field below to continue", "Transaction", JOptionPane.INFORMATION_MESSAGE);
						JOptionPane.showMessageDialog(this, "Bank CO. Message: Your pincode for your transaction is: " + pinco, "Transaction Code", JOptionPane.INFORMATION_MESSAGE);
						
						txtPinCode.setEnabled(true);	
						txtAmount.setEditable(false);
						txtPassword.setEditable(false);
						btnConfirm.active = false;
						btnAuthenticate.active = true;
						tries = 3;
						withInputPane.repaint();
					}
					else {
						JOptionPane.showMessageDialog(this, "Negative values are not accepted by the system", "Transaction Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(this, "Please input value only", "Transaction Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			else {
				JOptionPane.showMessageDialog(this, "Wrong password input", "Transaction Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	
		void authenticateSystem() {
			
			if (tries > 0) {
				if(txtPinCode.getText().equals(pinco)) {
					try {
						
						JOptionPane.showMessageDialog(this, "TRANSACTION SUCCESFUL!", "Transaction", JOptionPane.INFORMATION_MESSAGE);
						JOptionPane.showMessageDialog(this, "Present the generated slip to our own tenders or partner sites", "Transaction Code", JOptionPane.INFORMATION_MESSAGE);
						
						
						txtDate.setText(java.time.LocalDate.now().toString().replace('-', '/'));
						txtTNo.setText(generateCode(7, false));
						txtInput.setText(user.fullname);
						txtOutput.setText("Bank CO. Smart Systems");
						txtOutputAmount.setText(Integer.toString(valuedepo));
						
						depoOutputPane.setVisible(true);
						
						txtPinCode.setEnabled(false);	
						txtAmount.setEditable(false);
						txtPassword.setEditable(false);
						btnConfirm.active = false;
						btnAuthenticate.active = false;
						withInputPane.repaint();
						
					}
					catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(this, "Wrong Pincode input. Please check your pincode before entering", "Transaction Error", JOptionPane.ERROR_MESSAGE);
						tries--;
					}
					
				}
				else {
					JOptionPane.showMessageDialog(this, "Wrong Pincode input. Please check your pincode before entering", "Transaction Error", JOptionPane.ERROR_MESSAGE);
					tries--;
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "You enetered the wrong pincode multiple times. This transaction will be deemed voided", "Transaction Error", JOptionPane.ERROR_MESSAGE);
				pinco = new String();
				valuedepo = 0;
				txtPinCode.setEnabled(false);	
				txtAmount.setEditable(true);
				txtPassword.setEditable(true);
				btnConfirm.active = true;
				btnAuthenticate.active = false;
				depositpane.txtAmount.setText("Amount of Money");
				depositpane.txtPassword.setText("Enter Password for Verification");
				depositpane.txtPinCode.setText("Pin Code");
				withInputPane.repaint();
			}
		}
	
		String generateCode(int length, boolean lowercase) {
			
			String codetoReturn = new String();
			String textRange;
			
			if(lowercase) textRange = "cdeIJ5pUVQR0kLM8STWlmn1qrstuvwxyfghij7NOPDE2FG3H4K6ABCX9YZaboz"; //Basically, it's all A-Z, a-z and 0-9 but I randomized it;
			else textRange = "7FES2TUV1WH6IJK5LGP3QRA94NO8DBCXYM0Z";
			
			for(int i = 0; i < length; i++) {
				codetoReturn += textRange.charAt((int)(Math.round(Math.random() * 100)) % textRange.length());
			}
			
			return codetoReturn;
		}
	
		void printSlip() {
			JOptionPane.showMessageDialog(this, "Slip will now be printed", "Transaction", JOptionPane.INFORMATION_MESSAGE);
			
			user.balance += valuedepo;
			user.transactions.add(new TransactionsClass(txtDate.getText().replace('/', ' '), txtTNo.getText(), txtInput.getText(), txtOutput.getText(), valuedepo, true));
			user.set_expense();
			valuedepo = 0;
			
			JOptionPane.showMessageDialog(this, "Your Transaction had been a success and money is deposited safe onto your account", "Transaction", JOptionPane.INFORMATION_MESSAGE);
			
			depositpane.txtAmount.setText("Amount of Money");
			depositpane.txtPassword.setText("Enter Password for Verification");
			depositpane.txtPinCode.setText("Pin Code");
			
			txtAmount.setEditable(true);
			txtPassword.setEditable(true);
			btnConfirm.active = true;
			withInputPane.repaint();
			
			depoOutputPane.setVisible(false);
		}
	}
	
	class Withdraw_UI extends JPanel {
		
		String pinco;
		int tries;
		int valuewithdraw;
		
		JPanel withInputPane, withOutputPane;
		JTextField txtAmount, txtPassword, txtPinCode;
		FButton btnAuthenticate, btnConfirm;
		JTextArea txtDateTitle, txtTNoTitle, txtInputTitle, txtOutputTitle, txtAmountTitle;
		JTextArea txtDate, txtTNo, txtInput, txtOutput, txtOutputAmount;
		
		Withdraw_UI(){
			this.setBackground(Color.white);
			this.setBounds(228, 0, 737, 710);
			this.setLayout(null);
			this.addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent e) {
					if(withdrawpane.txtAmount.getText().equals("")) {
						withdrawpane.txtAmount.setText("Amount of Money");}
					
					if(withdrawpane.txtPassword.getText().equals("")) {
						withdrawpane.txtPassword.setText("Enter Password for Verification");}
					
					if(withdrawpane.txtPinCode.getText().equals("")) {
						withdrawpane.txtPinCode.setText("Pin Code");}
				}
			});
			
			initiateWithdrawPane();
		}
		
		void initiateWithdrawPane() {
			
			JLabel lblDeposit = new JLabel("Withdraw");
			lblDeposit.setBounds(12, 24, 216, 50);
			lblDeposit.setHorizontalAlignment(SwingConstants.LEFT);
			lblDeposit.setForeground(new Color(0, 0, 0));
			lblDeposit.setFont(new Font("Square721 BT", Font.PLAIN, 40));
			this.add(lblDeposit);
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(12, 85, 350, 2);
			separator_1.setBackground(Color.BLACK);
			this.add(separator_1);
			
			JLabel lblTagTitle = new JLabel("Security is our Mission");
			lblTagTitle.setHorizontalAlignment(SwingConstants.LEFT);
			lblTagTitle.setForeground(Color.BLACK);
			lblTagTitle.setFont(new Font("Square721 BT", Font.PLAIN, 30));
			lblTagTitle.setBounds(12, 96, 350, 38);
			this.add(lblTagTitle);
			
			JTextArea txtTagline = new JTextArea();
			txtTagline.setWrapStyleWord(true);
			txtTagline.setBounds(12, 136, 713, 50);
			txtTagline.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtTagline.setText("We value our costumers as much as you value your hard earned cash. That's why we provide our state of the art protection and encryption to every transaction made through our platform.");
			txtTagline.setOpaque(false);
			txtTagline.setLineWrap(true);
			txtTagline.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtTagline.setEnabled(false);
			txtTagline.setDisabledTextColor(new Color(0, 0, 0));
			this.add(txtTagline);
			
			WithdrawHandlePane();

		}
		
		void WithdrawHandlePane() {
			
			JPanel maindepopanel = new JPanel();
			maindepopanel.setLayout(null);
			maindepopanel.setOpaque(false);
			maindepopanel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
			maindepopanel.setBounds(12, 188, 713, 509);
			this.add(maindepopanel);
			
			//////////////DEPO INPUT PANEL////////////////////////////////////////////////
			
			withInputPane = new JPanel();
			withInputPane.setBackground(Color.WHITE);
			withInputPane.setBounds(12, 13, 378, 483);
			withInputPane.setLayout(null);
			withInputPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
			maindepopanel.add(withInputPane);
			
			JLabel lblDepoInTitle = new JLabel("Withdraw Check");
			lblDepoInTitle.setBounds(12, 13, 348, 73);
			withInputPane.add(lblDepoInTitle);
			lblDepoInTitle.setHorizontalAlignment(SwingConstants.LEFT);
			lblDepoInTitle.setForeground(Color.BLACK);
			lblDepoInTitle.setFont(new Font("Square721 BT", Font.PLAIN, 40));
			
			txtAmount = new JTextField();
			txtAmount.setFont(new Font("Square721 BT", Font.PLAIN, 20));
			txtAmount.setText("Amount of Money");
			txtAmount.setBounds(12, 99, 354, 35);
			txtAmount.setColumns(10);
			txtAmount.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(txtAmount.getText().equals("Amount of Money")) {
						txtAmount.setText(null);
					}
				}
			});
			withInputPane.add(txtAmount);
			
			txtPassword = new JTextField();
			txtPassword.setText("Enter Password for Verification");
			txtPassword.setFont(new Font("Square721 BT", Font.PLAIN, 20));
			txtPassword.setColumns(10);
			txtPassword.setBounds(12, 147, 354, 35);
			txtPassword.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(txtPassword.getText().equals("Enter Password for Verification")) {
						txtPassword.setText(null);
					}
				}
			});
			withInputPane.add(txtPassword);
			
			btnConfirm = new FButton("Confirm");
			btnConfirm.setFont(new Font("Square721 BT", Font.PLAIN, 20));
			btnConfirm.setForeground(Color.black);
			btnConfirm.BgColorBase = Color.white;
			btnConfirm.BdColorBase = Color.black;
			btnConfirm.gradientbackground(Color.white, new Color(225,225,225));
			btnConfirm.gradientborder(Color.black, Color.lightGray);
			btnConfirm.setBounds(159, 212, 207, 42);
			btnConfirm.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if (btnConfirm.active) {
					btnConfirm.in_box = false;
					btnConfirm.BgColorBase = new Color(225,225,225);
					btnConfirm.BdColorBase = Color.darkGray;
					//btnlogin.BgColorBase = Color.white;
					}
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					if (btnConfirm.active) {
					btnConfirm.in_box = true;
					btnConfirm.BgColorBase = Color.white;
					//btnDashBord.BdColorBase = Color.black;
					confirmSystem();
					}
				}
			});
			withInputPane.add(btnConfirm);
			
			txtPinCode = new JTextField();
			txtPinCode.setEnabled(false);
			txtPinCode.setText("Pin Code");
			txtPinCode.setFont(new Font("Square721 BT", Font.PLAIN, 20));
			txtPinCode.setColumns(10);
			txtPinCode.setBounds(12, 292, 354, 35);
			txtPinCode.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(txtPinCode.getText().equals("Pin Code") && btnAuthenticate.active) {
						txtPinCode.setText(null);
					}
				}
			});
			withInputPane.add(txtPinCode);
			
			JTextArea txtImportantInfo = new JTextArea();
			txtImportantInfo.setWrapStyleWord(true);
			txtImportantInfo.setText("You will receive a confirmation code through your validated phone, remember this code as this will be asked by our tender before proceeding on transaction.");
			txtImportantInfo.setOpaque(false);
			txtImportantInfo.setLineWrap(true);
			txtImportantInfo.setFont(new Font("Square721 BT", Font.PLAIN, 13));
			txtImportantInfo.setEnabled(false);
			txtImportantInfo.setDisabledTextColor(Color.BLACK);
			txtImportantInfo.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtImportantInfo.setBounds(12, 340, 354, 61);
			withInputPane.add(txtImportantInfo);
			
			btnAuthenticate = new FButton("Authenticate");
			btnAuthenticate.setFont(new Font("Square721 BT", Font.PLAIN, 20));
			btnAuthenticate.setForeground(Color.black);
			btnAuthenticate.BgColorBase = Color.white;
			btnAuthenticate.BdColorBase = Color.black;
			btnAuthenticate.gradientbackground(Color.white, new Color(225,225,225));
			btnAuthenticate.gradientborder(Color.black, Color.lightGray);
			btnAuthenticate.setBounds(159, 417, 207, 42);
			btnAuthenticate.active = false;
			btnAuthenticate.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					if(btnAuthenticate.active) {
					btnAuthenticate.in_box = false;
					btnAuthenticate.BgColorBase = new Color(225,225,225);
					btnAuthenticate.BdColorBase = Color.darkGray;
					//btnlogin.BgColorBase = Color.white;
					}
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					if(btnAuthenticate.active) {
					btnAuthenticate.in_box = true;
					btnAuthenticate.BgColorBase = Color.white;
					//btnDashBord.BdColorBase = Color.black;
					authenticateSystem();
					}
				}
			});
			withInputPane.add(btnAuthenticate);
			
			//////////////DEPO OUTPUT PANEL////////////////////////////////////////////////
			
			withOutputPane = new JPanel();
			withOutputPane.setLayout(null);
			withOutputPane.setBackground(Color.WHITE);
			withOutputPane.setBounds(402, 13, 299, 483);
			withOutputPane.setVisible(false);
			maindepopanel.add(withOutputPane);
			
			JLabel lblSlip = new JLabel("SLIP");
			lblSlip.setHorizontalAlignment(SwingConstants.LEFT);
			lblSlip.setForeground(Color.BLACK);
			lblSlip.setFont(new Font("Square721 BT", Font.PLAIN, 40));
			lblSlip.setBounds(12, 13, 98, 73);
			withOutputPane.add(lblSlip);
			
			JTextArea txtNotify = new JTextArea();
			txtNotify.setWrapStyleWord(true);
			txtNotify.setText("Present this slip to our counter and let us handle from this.");
			txtNotify.setOpaque(false);
			txtNotify.setLineWrap(true);
			txtNotify.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtNotify.setEnabled(false);
			txtNotify.setDisabledTextColor(Color.BLACK);
			txtNotify.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtNotify.setBounds(12, 78, 275, 42);
			withOutputPane.add(txtNotify);
			
			txtDateTitle = new JTextArea();
			txtDateTitle.setWrapStyleWord(true);
			txtDateTitle.setText("Date of Receipt:");
			txtDateTitle.setOpaque(false);
			txtDateTitle.setLineWrap(true);
			txtDateTitle.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtDateTitle.setEnabled(false);
			txtDateTitle.setDisabledTextColor(Color.BLACK);
			txtDateTitle.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtDateTitle.setBounds(12, 133, 275, 23);
			withOutputPane.add(txtDateTitle);
			
			txtDate = new JTextArea();
			txtDate.setWrapStyleWord(true);
			txtDate.setText("");
			txtDate.setOpaque(false);
			txtDate.setLineWrap(true);
			txtDate.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtDate.setEnabled(false);
			txtDate.setDisabledTextColor(Color.BLACK);
			txtDate.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtDate.setBounds(22, 156, 265, 23);
			withOutputPane.add(txtDate);
			
			txtTNoTitle = new JTextArea();
			txtTNoTitle.setWrapStyleWord(true);
			txtTNoTitle.setText("Transaction No:");
			txtTNoTitle.setOpaque(false);
			txtTNoTitle.setLineWrap(true);
			txtTNoTitle.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtTNoTitle.setEnabled(false);
			txtTNoTitle.setDisabledTextColor(Color.BLACK);
			txtTNoTitle.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtTNoTitle.setBounds(12, 192, 275, 23);
			withOutputPane.add(txtTNoTitle);
			
			txtTNo = new JTextArea();
			txtTNo.setWrapStyleWord(true);
			txtTNo.setText("");
			txtTNo.setOpaque(false);
			txtTNo.setLineWrap(true);
			txtTNo.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtTNo.setEnabled(false);
			txtTNo.setDisabledTextColor(Color.BLACK);
			txtTNo.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtTNo.setBounds(22, 151+64, 265, 23);
			withOutputPane.add(txtTNo);
			
			txtInputTitle = new JTextArea();
			txtInputTitle.setWrapStyleWord(true);
			txtInputTitle.setText("Input Actor:");
			txtInputTitle.setOpaque(false);
			txtInputTitle.setLineWrap(true);
			txtInputTitle.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtInputTitle.setEnabled(false);
			txtInputTitle.setDisabledTextColor(Color.BLACK);
			txtInputTitle.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtInputTitle.setBounds(12, 187+64, 275, 23);
			withOutputPane.add(txtInputTitle);
			
			txtInput = new JTextArea();
			txtInput.setWrapStyleWord(true);
			txtInput.setText("");
			txtInput.setOpaque(false);
			txtInput.setLineWrap(true);
			txtInput.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtInput.setEnabled(false);
			txtInput.setDisabledTextColor(Color.BLACK);
			txtInput.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtInput.setBounds(22, 210+64, 265, 23);
			withOutputPane.add(txtInput);
			
			txtOutputTitle = new JTextArea();
			txtOutputTitle.setWrapStyleWord(true);
			txtOutputTitle.setText("Output Actor:");
			txtOutputTitle.setOpaque(false);
			txtOutputTitle.setLineWrap(true);
			txtOutputTitle.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtOutputTitle.setEnabled(false);
			txtOutputTitle.setDisabledTextColor(Color.BLACK);
			txtOutputTitle.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtOutputTitle.setBounds(12, 246+64, 275, 23);
			withOutputPane.add(txtOutputTitle);
			
			txtOutput = new JTextArea();
			txtOutput.setWrapStyleWord(true);
			txtOutput.setText("");
			txtOutput.setOpaque(false);
			txtOutput.setLineWrap(true);
			txtOutput.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtOutput.setEnabled(false);
			txtOutput.setDisabledTextColor(Color.BLACK);
			txtOutput.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtOutput.setBounds(22, 269+64, 265, 23);
			withOutputPane.add(txtOutput);
			
			txtAmountTitle = new JTextArea();
			txtAmountTitle.setWrapStyleWord(true);
			txtAmountTitle.setText("Payment Cash:");
			txtAmountTitle.setOpaque(false);
			txtAmountTitle.setLineWrap(true);
			txtAmountTitle.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtAmountTitle.setEnabled(false);
			txtAmountTitle.setDisabledTextColor(Color.BLACK);
			txtAmountTitle.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtAmountTitle.setBounds(12, 305+64, 275, 23);
			withOutputPane.add(txtAmountTitle);
			
			txtOutputAmount = new JTextArea();
			txtOutputAmount.setWrapStyleWord(true);
			txtOutputAmount.setText("");
			txtOutputAmount.setOpaque(false);
			txtOutputAmount.setLineWrap(true);
			txtOutputAmount.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			txtOutputAmount.setEnabled(false);
			txtOutputAmount.setDisabledTextColor(Color.BLACK);
			txtOutputAmount.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			txtOutputAmount.setBounds(22, 328+64, 265, 23);
			withOutputPane.add(txtOutputAmount);
			
			FButton btnReport = new FButton("PRINT SLIP");
			btnReport.setFont(new Font("Square721 BT", Font.PLAIN, 13));
			btnReport.setHorizontalAlignment(SwingConstants.CENTER);
			btnReport.setForeground(Color.black);
			btnReport.BgColorBase = Color.white;
			btnReport.BdColorBase = Color.black;
			btnReport.gradientbackground(Color.white, new Color(225,225,225));
			btnReport.gradientborder(Color.black, Color.lightGray);
			btnReport.setBounds(162, 443, 125, 27);
			btnReport.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					btnReport.in_box = false;
					btnReport.BgColorBase = Color.lightGray;
					//btnSettings.BdColorBase = Color.white;
					//btnlogin.BgColorBase = Color.white;
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					btnReport.in_box = true;
					btnReport.BgColorBase = Color.white;
					//btnLoan.BdColorBase = Color.black;
					printSlip();
				}
			});
			withOutputPane.add(btnReport);
			
		}
	
		void confirmSystem() {
			
			if(txtPassword.getText().equals(user.password)) {
				try {
		
					valuewithdraw = Integer.parseInt(txtAmount.getText());
					
					if(valuewithdraw > 0) {
					
						pinco = new String();
						
						pinco = generateCode(6, true);
						
						JOptionPane.showMessageDialog(this, "A confirmation code will be sent to you. Input the Pin Code to field below to continue", "Transaction", JOptionPane.INFORMATION_MESSAGE);
						JOptionPane.showMessageDialog(this, "Bank CO. Message: Your pincode for your transaction is: " + pinco, "Transaction Code", JOptionPane.INFORMATION_MESSAGE);
						
						txtPinCode.setEnabled(true);	
						txtAmount.setEditable(false);
						txtPassword.setEditable(false);
						btnConfirm.active = false;
						btnAuthenticate.active = true;
						tries = 3;
						withInputPane.repaint();
					}
					else {
						JOptionPane.showMessageDialog(this, "Negative values are not accepted by the system", "Transaction Error", JOptionPane.ERROR_MESSAGE);
					}
					
				}
				catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(this, "Please input value only", "Transaction Error", JOptionPane.ERROR_MESSAGE);
				}
				
			}
			else {
				JOptionPane.showMessageDialog(this, "Wrong password input", "Transaction Error", JOptionPane.ERROR_MESSAGE);
			}
		}
	
		void authenticateSystem() {
			
			if (tries > 0) {
				if(txtPinCode.getText().equals(pinco)) {
					try {
						
						JOptionPane.showMessageDialog(this, "TRANSACTION SUCCESFUL!", "Transaction", JOptionPane.INFORMATION_MESSAGE);
						JOptionPane.showMessageDialog(this, "Present the generated slip to our own tenders or partner sites", "Transaction Code", JOptionPane.INFORMATION_MESSAGE);
						
						
						txtDate.setText(java.time.LocalDate.now().toString().replace('-', '/'));
						txtTNo.setText(generateCode(7, false));
						txtInput.setText("Bank CO. Smart Systems");
						txtOutput.setText(user.fullname);
						txtOutputAmount.setText(Integer.toString(valuewithdraw));
						
						withOutputPane.setVisible(true);
						
						txtPinCode.setEnabled(false);	
						txtAmount.setEditable(false);
						txtPassword.setEditable(false);
						btnConfirm.active = false;
						btnAuthenticate.active = false;
						withInputPane.repaint();
						
					}
					catch(NumberFormatException e) {
						JOptionPane.showMessageDialog(this, "Wrong Pincode input. Please check your pincode before entering", "Transaction Error", JOptionPane.ERROR_MESSAGE);
						tries--;
					}
					
				}
				else {
					JOptionPane.showMessageDialog(this, "Wrong Pincode input. Please check your pincode before entering", "Transaction Error", JOptionPane.ERROR_MESSAGE);
					tries--;
				}
			}
			else {
				JOptionPane.showMessageDialog(this, "You enetered the wrong pincode multiple times. This transaction will be deemed voided", "Transaction Error", JOptionPane.ERROR_MESSAGE);
				pinco = new String();
				valuewithdraw = 0;
				txtPinCode.setEnabled(false);	
				txtAmount.setEditable(true);
				txtPassword.setEditable(true);
				btnConfirm.active = true;
				btnAuthenticate.active = false;
				withdrawpane.txtAmount.setText("Amount of Money");
				withdrawpane.txtPassword.setText("Enter Password for Verification");
				withdrawpane.txtPinCode.setText("Pin Code");
				withInputPane.repaint();
			}
		}
	
		String generateCode(int length, boolean lowercase) {
			
			String codetoReturn = new String();
			String textRange;
			
			if(lowercase) textRange = "cdeIJ5pUVQR0kLM8STWlmn1qrstuvwxyfghij7NOPDE2FG3H4K6ABCX9YZaboz"; //Basically, it's all A-Z, a-z and 0-9 but I randomized it;
			else textRange = "7FES2TUV1WH6IJK5LGP3QRA94NO8DBCXYM0Z";
			
			for(int i = 0; i < length; i++) {
				codetoReturn += textRange.charAt((int)(Math.round(Math.random() * 100)) % textRange.length());
			}
			
			return codetoReturn;
		}
	
		void printSlip() {
			JOptionPane.showMessageDialog(this, "Slip will now be printed", "Transaction", JOptionPane.INFORMATION_MESSAGE);
			
			user.balance -= valuewithdraw;
			user.transactions.add(new TransactionsClass(txtDate.getText().replace('/', ' '), txtTNo.getText(), txtInput.getText(), txtOutput.getText(), valuewithdraw * -1, true));
			user.set_expense();
			valuewithdraw = 0;
			
			JOptionPane.showMessageDialog(this, "Your Transaction had been a success and money is deposited safe onto your account", "Transaction", JOptionPane.INFORMATION_MESSAGE);
			
			withdrawpane.txtAmount.setText("Amount of Money");
			withdrawpane.txtPassword.setText("Enter Password for Verification");
			withdrawpane.txtPinCode.setText("Pin Code");
			
			txtAmount.setEditable(true);
			txtPassword.setEditable(true);
			btnConfirm.active = true;
			withInputPane.repaint();
			
			withOutputPane.setVisible(false);
		}
	}
	
	
}











