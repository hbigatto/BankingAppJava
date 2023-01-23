import java.util.ArrayList;
import java.util.Calendar;

/**
 * Program name:PersonalChequingAccount.java
 * Purpose : Personal Chequing Account inherit Bank account and implement Interest Payable
 * Coder: Hugo 
 * Date: Jun 11, 2020
 */



public class PersonalChequingAccount extends BankAccount implements InterestPayable
{
	//attributes
	private String accountNumber;
	private int numberWithdrawals;
	private int numberDeposits;
	private double balance;
	private boolean accountActive;
	private final double INT_RATE = 0.025;
	private final double SERVICE_FEE = 0.85;
	
	private ArrayList<Transaction> record;
	
	//constructor method with no parameters
	PersonalChequingAccount(){
		this.setCustomerName(null);
		this.setAccountType(null);
		this.accountNumber = null;
		this.numberWithdrawals = 0;
		this.numberDeposits = 0;
		this.balance = 0.0;
	}
	
	//constructor method with parameters
	PersonalChequingAccount(String customerName, String month, double balance){
		this.setCustomerName(customerName);
		this.setMonth(month);
		this.balance = balance;
		this.setAccountType("Chequing");
		this.accountNumber = generateAccountNumber();
		this.accountActive = isAccountActive();	
		
		this.record = new ArrayList<Transaction>();
	}
	
//getters and setters methods
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

	public double getServiceFee()
	{
		return SERVICE_FEE;
	}
	
	//utility methods
	public String generateAccountNumber() {
	  int[] number = new int [6];
    for(int i =0; i < number.length; i++)
    {
        number[i] = (int)(Math.random() * 10);

    }
    return "002-623490-" + number[0] + number[1] + number[2]+ number[3] + number[4] + number[5] + "550";
	}
	
	public void deposit(double depositAmount, int day) {
		this.balance = this.getBalance() +  depositAmount;
		this.numberDeposits++;
		this.isAccountActive();
		this.recordTransaction(getMonth(), day, "deposit", depositAmount, this.getBalance());
		//not sure about record transaction
		
	}
	
	public void withdrawal(double withdrawalAmount, int day) {
		 String transactionMessage;
     if(this.getBalance() - withdrawalAmount > 25.0 &&  this.isAccountActive()){
    	 
         this. balance = getBalance() - withdrawalAmount;
         transactionMessage = "Withdrawal";
         this.numberWithdrawals++;
         this.recordTransaction(getMonth(), day, "withdrawal", withdrawalAmount, this.getBalance());
     }
     else if(this.getBalance() - withdrawalAmount < 0.0 && this.isAccountActive()){
         transactionMessage = "Transaction cancelled. Insufficient funds.";
         this.recordTransaction(getMonth(), day, "cancelled", withdrawalAmount, this.getBalance());
     }
     else if(this.getBalance() - withdrawalAmount < 25.0 && this.isAccountActive()){
         transactionMessage = "Transaction cancelled. Account is inactive.";
         this.recordTransaction(getMonth(), day, "cancelled", withdrawalAmount, this.getBalance());
     }
     
     
   
	}
	
	public void calcInterest() {
		
	  //Calendar object gives the maximum number of days in the month
		Calendar cal = Calendar.getInstance();
		
	  // integer lastDay will hold the last day of the month
		int lastDay = cal.getMaximum(Calendar.DAY_OF_MONTH);
		
		//if the lastDay is equal to 31 or 28 than the user will get the interest rate added to the balance
		if(lastDay == 31 || lastDay == 28) {
			if(this.getBalance() >= 1000.00) {
				this.balance += ((this.getInterestRate()/12) * this.balance);
				
				this.recordTransaction(getMonth(), lastDay, "Interest", ((this.getInterestRate()/12) * this.balance), this.getBalance());
			}
			
		}
		
		
	}
	
	public void recordTransaction(String month, int day, String transaction, double amount, double balance) {
		 Transaction t1 = new Transaction();
     t1.set(month, day, transaction, amount, balance);
     record.add(t1);
	}
	
	public void printTransactions() {
		 System.out.println("Trasaction Record for the Month of " + this.getMonth());
     for(Transaction t1 : record){
         System.out.println(t1);
     }
	}
	
	public void monthlyProcess() {
		
		 //determine the last day of the current month
		 //Calendar object gives the maximum number of days in the month
		Calendar cal = Calendar.getInstance();
		
	  // integer lastDay will hold the last day of the month
		int lastDay = cal.getMaximum(Calendar.DAY_OF_MONTH);
		
		if(lastDay == 31 || lastDay == 28) {
		if(this.numberWithdrawals > 4) {
			this.balance -= (this.numberWithdrawals * this.getServiceFee());		
			}
		
		//call the calcInterest() method
				this.calcInterest();
				
				//call the recordTransaction() method
				this.recordTransaction(getMonth(), lastDay, "Monthly Process", (this.numberWithdrawals * this.getServiceFee()), this.getBalance());
				
				
				//call the printTransactions() method
				this.printTransactions();
				
				//call the isAccountActive() method
				this.isAccountActive();
		
		}
		
		
	}
	
	public String toString() {
    return "Personal Chequing Account: " +
            "\n Account Number: " + accountNumber +
            "\n Number of Withdrawals: " + numberWithdrawals +
            "\n Number of Deposits: " + numberDeposits +
            "\n Balance: " + balance +
            "\n Account Active: " + accountActive +
            "\n Annnual Interest Rate: " + INT_RATE +
            "\n Monthly Service Fee Rate: " + SERVICE_FEE;
	}
	

	
}
 //end class