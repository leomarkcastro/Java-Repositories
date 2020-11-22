package bank_co_ui;

import java.util.ArrayList;

class AccountClass{
	
	String username = new String();
	String password = new String();
	String fullname = new String();
	String emailad  = new String();
	
	int balance = new Integer(0);
	int expense = new Integer(0);
	int safetospendexpense = new Integer(0);
	int safetospend = new Integer(0);
	int maxspend = new Integer(0);
	
	ArrayList<PaymentsClass> payments = new ArrayList<PaymentsClass>();
	ArrayList<PayTempClass> payment_template = new ArrayList<PayTempClass>();
	ArrayList<TransactionsClass> transactions = new ArrayList<TransactionsClass>();
	ArrayList<SaveClass> saveforthese = new ArrayList<SaveClass>();
	
	int getPaymentTotal() {
		
		int total = 0;
		
		for (PaymentsClass paycla: payments) {
			total += paycla.payment_amount;
		}
		
		return total;
		
	}
	
	int getPaymentPlanTotal() {
		
		int total = 0;
		
		for (PayTempClass paycla: payment_template) {
			total += paycla.payment_amount;
		}
		
		return total;
		
	}
	
	void set_maxspend() {
		int subtract = 0;
		
		for(PayTempClass paytecla: payment_template) {
			subtract += paytecla.payment_amount;
		}
		for(SaveClass savcla: saveforthese) {
			subtract += savcla.project_goal;
		}
		
		maxspend = balance + expense - subtract;
		
		safetospend = maxspend * 3 / 4;
		/*System.out.println(
				"SafetoSpend: " + safetospend + 
				"\nBalance: " + balance + 
				"\nExpense: " + expense + 
				"\nSubtract: " + subtract + 
				"\nMaxspend: " + maxspend);*/
	}
	
	
	void set_expense() {
		int total = 0;
		int totalextra = 0;
		for(TransactionsClass paytecla: transactions) {
			if(paytecla.transact_amount < 0) {
				total -= paytecla.transact_amount;
			}
			if(paytecla.extraexpense) {
				totalextra -= paytecla.transact_amount;
			}
		}
		expense = total;
		safetospendexpense = totalextra;
		
		if(safetospendexpense < 0) {
			//System.out.println(safetospendexpense + " Converted to: " + (safetospendexpense * -1 + 1));
			maxspend += (safetospendexpense * -1);
			safetospendexpense = 0;
		}
	}
	
	
	void register(String fullname, String emailad, String username, String password) {
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.emailad = emailad;
	}
	
	
	boolean login(String username, String password) {
		boolean checkuser = this.username.equals(username);
		boolean checkpass = this.password.equals(password);
		
		return (checkuser && checkpass);
	}
	
	
	void copyto(AccountClass acct) {
		acct.username = this.username;
		acct.password = this.password;
		acct.fullname = this.fullname;
		acct.emailad = this.emailad;
		
		acct.balance = this.balance;
		acct.expense = this.expense;
		acct.safetospendexpense = this.safetospendexpense;
		acct.safetospend = this.safetospend;
		acct.maxspend = this.maxspend;
		
		acct.payments = (ArrayList<PaymentsClass>) this.payments;
		acct.payment_template = (ArrayList<PayTempClass>) this.payment_template;
		acct.transactions = (ArrayList<TransactionsClass>) this.transactions;
		acct.saveforthese = (ArrayList<SaveClass>) this.saveforthese;

	}
	
	
	public String toString() {
		String tobereturned = (
				"==============================================\n" + 
				"User: " + username + "\n" + 
				"Fullname: " + fullname + "\n" + 
				"Email Adress: " + emailad + "\n" +
				"Password: " + password + "\n" + 
				"Balance: " + balance + "\n" + 
				"Expenses: " + expense + "\n" + 
				"Safe to Spend: " + safetospend + "\n" + 
				"Maxspend: " + maxspend + "\n"
				);
		
		tobereturned += "--------------------------\n";
		
		for(PaymentsClass pc: payments) {
			tobereturned += pc;
		}
		
		tobereturned += "--------------------------\n";
		
		for(PayTempClass pc: payment_template) {
			tobereturned += pc;
		}
		
		tobereturned += "--------------------------\n";
		
		for(TransactionsClass pc: transactions) {
			tobereturned += pc;
		}
		
		tobereturned += "--------------------------\n";
		
		for(SaveClass pc: saveforthese) {
			tobereturned += pc;
		}
		
		tobereturned += "--------------------------\n";
		tobereturned += "==============================================\n";
		
		return tobereturned;
		
	}
	

	
	
}

class PaymentsClass{
	
	String payment_name;
	int payment_amount;
	String payment_date;
	
	PaymentsClass(String name, int amount, String duedate){
		this.payment_name = name;
		this.payment_amount = amount;
		this.payment_date = duedate;
	}
	
	
	public String toString() {
		return ("Payment Name: " + payment_name + " || Amount: " + payment_amount + " || Date: " + payment_date + "\n");
	}
	
	
}

class PayTempClass{
	
	String payment_name;
	int payment_amount;
	String payment_duedate;
	
	PayTempClass(String name, int amount, String duedate){
		this.payment_name = name;
		this.payment_amount = amount;
		this.payment_duedate = duedate;
	}
	
	
	public String toString() {
		return ("Payment Name: " + payment_name + " || Amount: " + payment_amount + " || Date: " + payment_duedate + "\n");
	}
	
}

class TransactionsClass{
	
	String transact_date;
	String transact_number;
	String transact_actor;
	String transact_receiver;
	int transact_amount;
	boolean extraexpense;
	
	TransactionsClass(String duedate, String number, String actor, String receiver, int amount){
		this.transact_date = duedate;
		this.transact_number = number;
		this.transact_actor = actor;
		this.transact_receiver = receiver;
		this.transact_amount = amount;
		this.extraexpense = false;
	}
	
	TransactionsClass(String duedate, String number, String actor, String receiver, int amount, boolean extra){
		this.transact_date = duedate;
		this.transact_number = number;
		this.transact_actor = actor;
		this.transact_receiver = receiver;
		this.transact_amount = amount;
		this.extraexpense = extra;
	}
	
	public String toString() {
		return ("Payment Name: " + transact_date + " || Number: " + transact_number + " || Actor: " + transact_actor + " || Receiver: " + transact_receiver + " || Amount: " + transact_amount + "\n");
	}
	
}

class SaveClass{
	
	String project_name;
	int project_save;
	int project_goal;
	
	SaveClass(String name, int save, int goal){
		this.project_name = name;
		this.project_save = save;
		this.project_goal = goal;
	}
	
	public String toString() {
		return ("Project Name: " + project_name + " || Save: " + project_save + " || Goal: " + project_goal + "\n");
	}
	
}