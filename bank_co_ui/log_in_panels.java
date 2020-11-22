package bank_co_ui;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

class login_ui extends JPanel {

	Log_In loginui;
	Register_UI registui;
	AccountClass act;
	ArrayList<AccountClass> actlist;
	login_ui loginhandle;
	dashboard_ui dashboardhandle;
	
	login_ui(ArrayList<AccountClass> aclist){
		this.setBounds(0,0,965,710);
		this.setBackground(Color.white);
		this.setLayout(null);
		this.actlist = aclist;
		
		BCBan_initiate();
		
		loginui = new Log_In();
		loginui.setVisible(true);
		registui = new Register_UI();
		registui.setVisible(false);
		
		this.add(loginui);
		this.add(registui);
		
		this.setVisible(true);
		
		Collections.copy(actlist, aclist);
		
	}

	void BCBan_initiate() {
		FPanel_BCBAN bcban = new FPanel_BCBAN();
		bcban.setBounds(0, 0, 334, 710);
		bcban.setLayout(null);
		bcban.gradientbackground(Color.black, Color.black);
		bcban.use = false;
		
		JLabel lblbankco = new JLabel("BANK CO.");
		lblbankco.setForeground(new Color(255, 255, 255));
		lblbankco.setHorizontalAlignment(SwingConstants.RIGHT);
		lblbankco.setFont(new Font("Square721 BT", Font.PLAIN, 40));
		lblbankco.setBounds(0, 279, 310, 56);
		bcban.add(lblbankco);
		
		JTextArea txttagline = new JTextArea();
		txttagline.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		txttagline.setLineWrap(true);
		txttagline.setDisabledTextColor(new Color(255, 255, 255));
		txttagline.setEnabled(false);
		txttagline.setFont(new Font("Square721 BT", Font.PLAIN, 15));
		txttagline.setOpaque(false);
		txttagline.setText("where you pay more, with less hassle");
		txttagline.setBounds(125, 348, 185, 61);
		bcban.add(txttagline);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(101, 340, 209, 2);
		bcban.add(separator);
		
		this.add(bcban);
	}
	
	class Log_In extends JPanel{
		
		JTextField txtUsername, txtPassword;
		
		Log_In(){
			
			this.setBackground(Color.white);
			this.setBounds(333, 0, 632, 710);
			this.setLayout(null);
			this.addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent e) {
					if(loginui.txtUsername.getText().equals("")) {
					loginui.txtUsername.setText("username");}
					
					if(loginui.txtPassword.getText().equals("")) {
					loginui.txtPassword.setText("password");}
				}
			});
			
			Log_In_initiate();
			
		}
		
		void Log_In_initiate(){
			JLabel lblLogIn = new JLabel("WELCOME BACK!");
			lblLogIn.setBounds(12, 163, 543, 50);
			this.add(lblLogIn);
			lblLogIn.setHorizontalAlignment(SwingConstants.LEFT);
			lblLogIn.setForeground(new Color(0, 0, 0));
			lblLogIn.setFont(new Font("Square721 BT", Font.PLAIN, 40));
			
			txtUsername = new JTextField();
			txtUsername.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			txtUsername.setFont(new Font("Square721 BT", Font.PLAIN, 20));
			txtUsername.setText("username");
			txtUsername.setBounds(12, 300, 543, 40);
			txtUsername.setFocusable(true);
			txtUsername.setCaretColor(Color.white);
			txtUsername.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(txtUsername.getText().equals("username")) {
						txtUsername.setText(null);
					}
				}
			});
			this.add(txtUsername);
			txtUsername.setColumns(10);
			
			txtPassword = new JTextField();
			txtPassword.setText("password");
			txtPassword.setFont(new Font("Square721 BT", Font.PLAIN, 20));
			txtPassword.setColumns(10);
			txtPassword.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			txtPassword.setBounds(12, 346, 543, 40);
			txtPassword.setCaretColor(Color.white);
			txtPassword.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(txtPassword.getText().equals("password")) {
						txtPassword.setText(null);
					}
				}
			});
			this.add(txtPassword);
			
			FButton btnlogin = new FButton("Log In");
			btnlogin.setFont(new Font("Square721 BT", Font.PLAIN, 20));
			btnlogin.BgColorBase = Color.white;
			btnlogin.BdColorBase = Color.black;
			btnlogin.gradientbackground(Color.white, new Color(220,220,220));
			btnlogin.gradientborder(Color.black, Color.white);
			btnlogin.setBounds(362, 466, 193, 50);
			btnlogin.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mousePressed(MouseEvent e) {
					btnlogin.in_box = false;
					btnlogin.BdColorBase = Color.white;
					//btnlogin.BgColorBase = Color.white;
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					btnlogin.in_box = true;
					btnlogin.BdColorBase = Color.black;
					Log_In_check();
				}
				
			
			});
			this.add(btnlogin);
			
			FButton btnRegister = new FButton("Register a new account");
			btnRegister.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			btnRegister.BgColorBase = Color.white;
			btnRegister.BdColorBase = Color.white;
			btnRegister.gradientbackground(Color.white, new Color(220,220,220));
			btnRegister.gradientborder(Color.black, Color.white);
			btnRegister.setBounds(362, 519, 193, 61);
			btnRegister.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mousePressed(MouseEvent e) {
					btnRegister.in_box = false;
					//btnlogin.BgColorBase = Color.white;
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					btnRegister.in_box = true;
					loginui.setVisible(false);
					loginui.txtUsername.setText("username");
					loginui.txtPassword.setText("password");
					registui.setVisible(true);
				}
				
			
			});
			this.add(btnRegister);
		}
		
		void Log_In_check() {
			
			boolean failed_to_fetch = true;
			
			if(txtUsername.getText().equals("") || txtPassword.getText().equals("") || txtUsername.getText().equals("username") || txtPassword.getText().equals("password")) {
				JOptionPane.showMessageDialog(loginui, "Please input the missing username/password to proceed", "Log-in", JOptionPane.ERROR_MESSAGE);
			}
				
			else{
				for(AccountClass acpart: actlist) {
					if(acpart.login(txtUsername.getText(), txtPassword.getText())) {
						JOptionPane.showMessageDialog(loginui, "Log-in Successful!", "Log-in", JOptionPane.INFORMATION_MESSAGE);
						failed_to_fetch = false;
						act = new AccountClass();
						acpart.copyto(act);
						gotoDashpane();
					}
				}
					if (failed_to_fetch) {
						JOptionPane.showMessageDialog(loginui, "Wrong username/password input", "Log-in", JOptionPane.ERROR_MESSAGE);
					}
				}
			
			}
	
		void gotoDashpane() {
			loginhandle.setVisible(false);
			
			dashboardhandle.getaccount(act);
			
			dashboardhandle.setVisible(true);
			//mainpanel.remove(this);
			//System.out.println(act);
			
			
		}
		
	}
	
	class Register_UI extends JPanel{
		
		JTextField txtFullname, txtPassword, txtUserName, txtPassword_1, txtConfirmPassword;
		
		Register_UI(){
			this.setBackground(Color.white);
			this.setBounds(333, 0, 632, 710);
			this.setLayout(null);
			this.addMouseListener(new MouseAdapter() {
				
				public void mouseClicked(MouseEvent e) {
					if(registui.txtFullname.getText().equals("")) {
					registui.txtFullname.setText("Full Name");}
					
					if(registui.txtPassword.getText().equals("")) {
					registui.txtPassword.setText("Password");}
					
					if(registui.txtUserName.getText().equals("")) {
					registui.txtUserName.setText("User Name");}
					
					if(registui.txtPassword_1.getText().equals("")) {
					registui.txtPassword_1.setText("Password");}
					
					if(registui.txtConfirmPassword.getText().equals("")) {
					registui.txtConfirmPassword.setText("Confirm Password");}
				}
				
			});
			
			Register_initiate();
		}
		
		void Register_initiate(){
			
			JLabel lblLogIn = new JLabel("Sign Up a new Bank Acct.");
			lblLogIn.setBounds(12, 108, 543, 50);
			this.add(lblLogIn);
			lblLogIn.setHorizontalAlignment(SwingConstants.LEFT);
			lblLogIn.setForeground(new Color(0, 0, 0));
			lblLogIn.setFont(new Font("Square721 BT", Font.PLAIN, 40));
			
			txtFullname = new JTextField();
			txtFullname.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			txtFullname.setFont(new Font("Square721 BT", Font.PLAIN, 20));
			txtFullname.setText("Full Name");
			txtFullname.setBounds(12, 203, 543, 40);
			txtFullname.setCaretColor(Color.white);
			txtFullname.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(txtFullname.getText().equals("Full Name")) {
						txtFullname.setText(null);
					}
				}
			});
			this.add(txtFullname);
			txtFullname.setColumns(10);
			
			txtPassword = new JTextField();
			txtPassword.setText("Email Address");
			txtPassword.setFont(new Font("Square721 BT", Font.PLAIN, 20));
			txtPassword.setColumns(10);
			txtPassword.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			txtPassword.setBounds(12, 263, 543, 40);
			txtPassword.setCaretColor(Color.white);
			txtPassword.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(txtPassword.getText().equals("Email Address")) {
						txtPassword.setText(null);
					}
				}
			});
			this.add(txtPassword);
			
			txtUserName = new JTextField();
			txtUserName.setText("User Name");
			txtUserName.setFont(new Font("Square721 BT", Font.PLAIN, 20));
			txtUserName.setColumns(10);
			txtUserName.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			txtUserName.setBounds(12, 323, 543, 40);
			txtUserName.setCaretColor(Color.white);
			txtUserName.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(txtUserName.getText().equals("User Name")) {
						txtUserName.setText(null);
					}
				}
			});
			this.add(txtUserName);
			
			txtPassword_1 = new JTextField();
			txtPassword_1.setText("Password");
			txtPassword_1.setFont(new Font("Square721 BT", Font.PLAIN, 20));
			txtPassword_1.setColumns(10);
			txtPassword_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			txtPassword_1.setBounds(12, 383, 543, 40);
			txtPassword_1.setCaretColor(Color.white);
			txtPassword_1.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(txtPassword_1.getText().equals("Password")) {
						txtPassword_1.setText(null);
					}
				}
			});
			this.add(txtPassword_1);
			
			txtConfirmPassword = new JTextField();
			txtConfirmPassword.setText("Confirm Password");
			txtConfirmPassword.setFont(new Font("Square721 BT", Font.PLAIN, 20));
			txtConfirmPassword.setColumns(10);
			txtConfirmPassword.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
			txtConfirmPassword.setBounds(12, 443, 543, 40);
			txtConfirmPassword.setCaretColor(Color.white);
			txtConfirmPassword.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					if(txtConfirmPassword.getText().equals("Confirm Password")) {
						txtConfirmPassword.setText(null);
					}
				}
			});
			this.add(txtConfirmPassword);
			
			FButton btnlogin = new FButton("Register");
			btnlogin.setFont(new Font("Square721 BT", Font.PLAIN, 20));
			btnlogin.BgColorBase = Color.white;
			btnlogin.BdColorBase = Color.black;
			btnlogin.gradientbackground(Color.white, new Color(220,220,220));
			btnlogin.gradientborder(Color.black, Color.white);
			btnlogin.setBounds(362, 541, 193, 50);
			btnlogin.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mousePressed(MouseEvent e) {
					btnlogin.in_box = false;
					btnlogin.BdColorBase = Color.white;
					//btnlogin.BgColorBase = Color.white;
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					btnlogin.in_box = true;
					btnlogin.BdColorBase = Color.black;
					Register_UI_check();
				}
				
			
			});
			this.add(btnlogin);
			
			FButton btnRegister = new FButton("Already have an account?");
			btnRegister.setFont(new Font("Square721 BT", Font.PLAIN, 15));
			btnRegister.BgColorBase = Color.white;
			btnRegister.BdColorBase = Color.white;
			btnRegister.gradientbackground(Color.white, new Color(220,220,220));
			btnRegister.gradientborder(Color.black, Color.white);
			btnRegister.setBounds(362, 594, 193, 61);
			btnRegister.addMouseListener(new MouseAdapter() {
				
				@Override
				public void mousePressed(MouseEvent e) {
					btnRegister.in_box = false;
					//btnlogin.BgColorBase = Color.white;
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					btnRegister.in_box = true;
					loginui.setVisible(true);
					registui.setVisible(false);
					registui.txtFullname.setText("Full Name");
					registui.txtPassword.setText("Password");
					registui.txtUserName.setText("User Name");
					registui.txtPassword_1.setText("Password");
					registui.txtConfirmPassword.setText("Confirm Password");
				}
				
			
			});
			this.add(btnRegister);
		}
		
		void Register_UI_check() {
			if(txtFullname.getText().equals("") || txtPassword.getText().equals("") ||  txtUserName.getText().equals("") || txtPassword_1.getText().equals("") || txtConfirmPassword.getText().equals("") || txtFullname.getText().equals("Full Name") || txtPassword.getText().equals("Email Address") ||  txtUserName.getText().equals("User Name") || txtPassword_1.getText().equals("Password") || txtConfirmPassword.getText().equals("Confirm Password"))
				JOptionPane.showMessageDialog(registui, "Please complete all the fields to proceed", "Register", JOptionPane.ERROR_MESSAGE);;
		}
	}
	
	void getmainpanel(login_ui login, dashboard_ui dashboard) {
		this.loginhandle = login;
		this.dashboardhandle = dashboard;
	}
}
