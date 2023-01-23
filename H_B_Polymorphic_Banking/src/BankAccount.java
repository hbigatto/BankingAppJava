/**
 * Program name:BankAccount.java
 * Purpose : Bank account abstract class
 * Coder: Hugo 
 * Date: Jun 11, 2020
 */


public abstract class BankAccount
{
	//attributes
	private String customerName;
	private String accountType;
	private String month;
	
	//constructor method with no parameters
	public BankAccount() {
		
	}
	
	//constructor method with parameters
	public BankAccount(String customerName, String accountType, String month) {
		
	}
	
//methods getter and setter

	public String getCustomerName()
	{
		return customerName;
	}

	
	public void setCustomerName(String customerName)
	{
		this.customerName = customerName;
	}

	
	public String getAccountType()
	{
		return accountType;
	}

	
	public void setAccountType(String accountType)
	{
		this.accountType = accountType;
	}

	
	public String getMonth()
	{
		return month;
	}

	
	public void setMonth(String month)
	{
		this.month = month;
	}
	
	//abstract methods
	
	public abstract String generateAccountNumber();
	
	public abstract void deposit(double depositAmount, int day);
	
	public abstract void withdrawal(double withdrawalAmount, int day);
	
	public abstract void recordTransaction(String month,int day, String transaction, double amount, double balance);
	
	public abstract void monthlyProcess();

	@Override
	public String toString()
	{
		return "BankAccount [customerName=" + customerName + ", accountType=" + accountType + ", month=" + month + "]";
	}
	
	
	
	
	
	
	

}//end class
 