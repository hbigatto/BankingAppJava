import java.util.ArrayList;
import java.util.Calendar;

/**
 * Program name:SavingAccount.java
 * Purpose : Saving Account inherit Bank account and implement Interest Payable
 * Coder: Hugo 
 * Date: Jun 12, 2020
 */

public class SavingAccount extends BankAccount implements InterestPayable
{
	 private String accountNumber;
   private int numberWithdrawals;
   private int numberDeposits;
   private double balance;
   private boolean accountActive;
   private final double INT_RATE = 0.03;

   private ArrayList<Transaction> record;
   
   //constructor method with no parameters
   public SavingAccount() {
  	 
  	 this.setCustomerName(null);
  	 this.setAccountType(null);
  	 this.accountNumber  = null;
  	 this.accountActive = false;
  	 this.numberWithdrawals = 0;
  	 this.numberDeposits = 0;
  	 this.balance = 0.0;
   }
   
   //constructor method with parameters
   public SavingAccount(String customerName, String month, double balance){
  	 
     this.setCustomerName(customerName);
     this.setMonth(month);
     this.balance = balance;
     this.setAccountType("Saving");
     this.accountNumber = generateAccountNumber();
     this.accountActive = isAccountActive();
 }
   
 //getters and setter methods

	public String getAccountNumber()
	{
		return accountNumber;
	}


	public int getNumberWithdrawals()
	{
		return numberWithdrawals;
	}

	public int getNumberDeposits()
	{
		return numberDeposits;
	}

	
	public double getBalance()
	{
		return balance;
	}


	public boolean isAccountActive()
	{
		if(this.getBalance() < 25.0){
      this.accountActive = false;
  }
      return this.accountActive = true;
	}

	public double getInterestRate()
	{
		return INT_RATE;
	}
	
	//utility methods
	public String generateAccountNumber() {
		int[] number = new int [6];
    for(int i =0; i < number.length; i++)
    {
        number[i] = (int)(Math.random() * 10);

    }
    return "002-623490-" + number[0] + number[1] + number[2]+ number[3] + number[4] + number[5] + "575";
	}
   
	public void deposit(double depositAmount, int day) {
		this.balance += depositAmount;
		this.numberDeposits++;
		this.isAccountActive();
		//call the method recordTransactions()
		this.recordTransaction(getMonth(), day, "deposit", depositAmount, day);
		
	}
	
	public void withdrawal(double withdrawalAmount, int day) {
		 String transactionMessage;
     if(this.getBalance() - withdrawalAmount > 25.0 &&  this.isAccountActive()){
         this. balance = getBalance();
         transactionMessage = "Withdrawal";
         this.numberWithdrawals++;
     }
     else if(this.getBalance() - withdrawalAmount < 0.0 && this.isAccountActive()){
         transactionMessage = "Transaction cancelled. Insufficient funds.";
     }
     else if(this.getBalance() - withdrawalAmount < 25.0 && this.isAccountActive()){
         transactionMessage = "Transaction cancelled. Account is inactive.";
     }
     //call the method recordTransactions()
     this.recordTransaction(getMonth(), day, "withdrawal", withdrawalAmount, day);
		
	}
	
	public void calcInterest() {
		  //determine the last day of the current month
		
	    //Calendar object gives the maximum number of days in the month
			Calendar cal = Calendar.getInstance();
			
		  // integer lastDay will hold the last day of the month
			int lastDay = cal.getMaximum(Calendar.DAY_OF_MONTH);
			
			//interest variable will hold the interest value
			double interest= 0.0;
		
			//if last day of the month is 31 or 28
			if(lastDay == 31 || lastDay == 28) 
			{
				//traverse the array to sum the amount of each transaction
				double totalAmount = 0.0;
				for(int i = 0; i < record.size(); i++) 
				{
					totalAmount += record.get(i).getAmount();
				}
				//
				if(totalAmount >= 2000.00) 
				{
					interest += (((this.getInterestRate()/12) + 0.0075) * this.balance);
					this.balance += interest;
					
				}
				if(this.getBalance() >= 25.00) 
				{
				interest += ((this.getInterestRate()/12) * this.balance);
				this.balance += interest;
		    }
		  }
		  //call method recordTransaction()
			this.recordTransaction(getMonth(), lastDay,"Interest", interest, balance);
		}
	
	public void recordTransaction(String month,int day, String transaction, double amount, double balance) {
		 Transaction t1 = new Transaction();
     t1.set(month, day, transaction, amount, balance);
     record.add(t1);
	
	}
	
	public void printTransactions() {
		 System.out.println("Trasaction Record for the Month of" + this.getMonth());
     for(Transaction t1 : record){
         System.out.println(t1);
     }
		
	}
	
	public void monthlyProcess() {
		//call the calcInterest() method
		this.calcInterest();
		//call the printTransactions() method
		this.printTransactions();
		//call isActiveAccount() method
		this.isAccountActive();
		
	}


	public String toString()
	{
		return "SavingAccount [accountNumber=" + accountNumber + ", numberWithdrawals=" + numberWithdrawals
				+ ", numberDeposits=" + numberDeposits + ", balance=" + balance + ", accountActive=" + accountActive
				+ ", INT_RATE=" + INT_RATE + "]";
	}
	
	
   
   
}
 //end class