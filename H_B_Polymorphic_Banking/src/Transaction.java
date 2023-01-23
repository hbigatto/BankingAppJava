
/**
 * Program name:Transaction.java
 * Purpose :Transaction class
 * Coder: Hugo 
 * Date: Jun 12, 2020
 */


public class Transaction
{
	
//attributes
  private String month;
  private int day;
  private String transaction;
  private double amount;
  private double balance;
  
//constructor method
  public Transaction(){
      this.month = null;
      this.day = 0;
      this.transaction = null;
      this.amount = 0.0;
      this.balance = 0.0;

  }
  
  
  
//getters and setters method

	public String getMonth()
	{
		return month;
	}

	public int getDay()
	{
		return day;
	}


	public String getTransaction()
	{
		return transaction;
	}

	public double getAmount()
	{
		return amount;
	}

	public double getBalance()
	{
		return balance;
	}
	
	public void set(String month, int day, String transaction, double amount, double balance) {
		this.month = month;
	      this.day = day;
	      this.transaction = transaction;
	      this.amount = amount;
	      this.balance = balance;
		
	}

	public String toString()
	{
		return "Transaction [month=" + month + ", day=" + day + ", transaction=" + transaction + ", amount=" + amount
				+ ", balance=" + balance + "]";
	}
	
	
  
	
  
  
  

}
 //end class