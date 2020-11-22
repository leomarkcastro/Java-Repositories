package bank_co_ui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.BiFunction;

import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * 
 * runner function of the app, also contains the log_in_sections
 * 
 * */


class runner_func {
	
	ArrayList<AccountClass> acctlists;
	JFrame mainframe;
	JPanel handlepane;
	login_ui loginui_handle;
	dashboard_ui dashboardui_handle;
	
	runner_func(){
		acctlists = new ArrayList<AccountClass>();
		process_accounts(acctlists);
		
		mainframe = new JFrame();
		mainframe.setBounds(100, 100, 965, 710);
		//mainframe.setLocationRelativeTo(null);
		mainframe.setDefaultCloseOperation(mainframe.EXIT_ON_CLOSE);
		//mainframe.setAlwaysOnTop(true);
		mainframe.setLayout(null);
		
		mainframe.setUndecorated(true);
		
		handlepane = new JPanel();
		handlepane.setBackground(Color.white);
		handlepane.setBounds(0, 0, 965, 710);
		handlepane.setLayout(null);
		
		
		loginui_handle = new login_ui(acctlists);
		handlepane.add(loginui_handle);
		
		dashboardui_handle = new dashboard_ui();
		dashboardui_handle.setVisible(false);
		handlepane.add(dashboardui_handle);
		
		loginui_handle.getmainpanel(loginui_handle, dashboardui_handle);
		
		mainframe.add(handlepane);
		
		mainframe.setVisible(true);
	}
	
	public static void main(String args[]) {
		
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				runner_func runfun = new runner_func();
			}
		});
	}

	
	void process_accounts(ArrayList<AccountClass> acctlists) {
		
		AccountClass leo = new AccountClass();
		leo.register("Leo Mark D.C Castro", "leomark@castro.com", "leomark", "ohdude");
		leo.payments.add(new PaymentsClass("Chooks to Go", 1785, "2003 01 12"));
		leo.payments.add(new PaymentsClass("Reform Inst.", 2457, "2003 02 01"));
		leo.payments.add(new PaymentsClass("Chooks to Go", 3364, "2003 03 01"));
		leo.payments.add(new PaymentsClass("Jethro Man", 5741, "2003 18 02"));
		leo.payment_template.add(new PayTempClass("Chooks to Go", 1785, "2003 01 11"));
		leo.payment_template.add(new PayTempClass("Reform Inst.", 2457, "2003 02 21"));
		leo.payment_template.add(new PayTempClass("Chooks to Go", 3364, "2003 03 10"));
		leo.payment_template.add(new PayTempClass("HBC Banks", 4582, "2003 04 23"));
		leo.payment_template.add(new PayTempClass("Jethro Man", 5741, "2003 05 12"));
		leo.payment_template.add(new PayTempClass("Chooks to Go", 6785, "2003 03 21"));
		leo.payment_template.add(new PayTempClass("Reform Inst.", 7457, "2003 05 11"));
		leo.payment_template.add(new PayTempClass("Chooks to Go", 8364, "2003 09 01"));
		leo.payment_template.add(new PayTempClass("HBD Banks", 9582, "2003 10 23"));
		leo.payment_template.add(new PayTempClass("Jethro Man", 10741, "2003 12 12"));
		leo.transactions.add(new TransactionsClass("2003 01 01", "DJQ8946", "LEO CASTRO", "Chooks to Go", -4598, false));
		leo.transactions.add(new TransactionsClass("2003 02 21", "234BKVJ", "LEO CASTRO", "Chooks to Go", -1238, false));
		leo.transactions.add(new TransactionsClass("2003 01 03", "3244432", "BANK CO INST.", "LEO CASTRO", -3454, true));
		leo.transactions.add(new TransactionsClass("2003 03 14", "SDFDFHS", "BANK CO INST.", "LEO CASTRO", -3463, true));
		leo.transactions.add(new TransactionsClass("2003 02 15", "ER5T45T", "BANK CO INST.", "LEO CASTRO", -6464, true));
		leo.transactions.add(new TransactionsClass("2003 04 06", "DJQ8946", "LEO CASTRO", "Chooks to Go", -4598, false));
		leo.transactions.add(new TransactionsClass("2003 02 07", "234BKVJ", "LEO CASTRO", "Chooks to Go", -1238, false));
		leo.transactions.add(new TransactionsClass("2003 06 28", "3244432", "BANK CO INST.", "LEO CASTRO", -3454, true));
		leo.transactions.add(new TransactionsClass("2003 03 29", "SDFDFHS", "BANK CO INST.", "LEO CASTRO", -3463, true));
		leo.transactions.add(new TransactionsClass("2003 08 30", "ER5T45T", "BANK CO INST.", "LEO CASTRO", -6464, true));
		leo.transactions.add(new TransactionsClass("2003 03 01", "DJQ8946", "LEO CASTRO", "Chooks to Go", -4598, false));
		leo.transactions.add(new TransactionsClass("2003 10 12", "234BKVJ", "LEO CASTRO", "Chooks to Go", -1238, false));
		leo.transactions.add(new TransactionsClass("2003 04 13", "3244432", "BANK CO INST.", "LEO CASTRO", -3454, true));
		leo.transactions.add(new TransactionsClass("2003 05 04", "SDFDFHS", "BANK CO INST.", "LEO CASTRO", -3463, true));
		leo.transactions.add(new TransactionsClass("2003 11 15", "ER5T45T", "BANK CO INST.", "LEO CASTRO", -6464, true));
		leo.saveforthese.add(new SaveClass("Vataan", 123, 456));
		leo.saveforthese.add(new SaveClass("Gla", 789, 910));
		leo.saveforthese.add(new SaveClass("dask", 111, 131));
		leo.balance = 123456;
		leo.set_expense();
		leo.set_maxspend();
		acctlists.add(leo);
		
		
		/*
		for(AccountClass ac: acctlists) {
			System.out.println(ac);
		}
		*/
		
	}
	
}

