/**
 * Program name:BankAccountTester.java
 * Purpose : put something descriptive here
 * Coder: Hugo 
 * Date: Jun 12, 2020
 */


public class BankAccountTester
{


	public static void main(String[] args)
	{
		PersonalChequingAccount pca1 = new PersonalChequingAccount("Janice Joplin", "March", 2300);
		
		
		System.out.println(pca1.toString());
		
		pca1.deposit(25.00, 5);
		pca1.withdrawal(1300, 6);
		pca1.withdrawal(1700, 10);
		pca1.deposit(1050,11);
		pca1.withdrawal(1700, 11);
		pca1.withdrawal(5, 11);
		pca1.deposit(25.98, 25);
		pca1.withdrawal(400, 26);
		pca1.withdrawal(27.00, 28);
		pca1.withdrawal(7.50, 28);

		
		pca1.monthlyProcess();
		
		System.out.println(pca1.toString());
		
	}//end main

}
 //end class