import java.text.DecimalFormat;

// Assignment #: 5
//         Name: Rachel Ware
//    StudentID: 1213096974
//      Lecture: T TH 1:30
//  Description: Abstract class representing the basic attributes of any bank account in a bank, 
//					includes a balance, interestRate, accountNumber, and methods.

public abstract class BankAccount 
{
	protected int balanceInPennies;		//the balance of a bank account in pennies
	protected double interestRate;		//the interest rate of a bank account
	protected String accountNumber;		//the number/ID of a bank account
	
	public BankAccount(int balance, double interest, String acctNum)
	{
		balanceInPennies = balance;
		interestRate = interest;
		accountNumber = acctNum;
	}
	
	public String getAccountNumber()
	{
		return accountNumber;
	}
	
	public void setAccountNumber(String accountNo)
	{
		accountNumber = accountNo;
	}
	
	public int getBalanceInPennies()
	{
		return balanceInPennies;
	}
	
	public boolean credit(int amountPennies)	//calculates credit for bank account if it is positive
	{
		if (amountPennies > 0)
		{
			balanceInPennies += amountPennies;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public abstract boolean debit(int amountPennies);	//abstract method 
	
	public double getInterestRate()
	{
		return interestRate;
	}
	
	public void setInterestRate(double rate)
	{
		interestRate = rate;
	}
	
	public abstract void applyInterest();	//abstract method
	
	public String toString()	//toString for BankAccount information
	{
		DecimalFormat form = new DecimalFormat("0.00");
		
		//add decimal formatting
		return "\nAccount ID\t:\t" + accountNumber + 
				"\nBalance\t\t:\t" + form.format((double)balanceInPennies/100) 
				+ "\nInterest rate\t:\t" + form.format(interestRate) + "\n";
				
	}
	
}







