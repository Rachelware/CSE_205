import java.text.DecimalFormat;

// Assignment #: 5
//         Name: Rachel Ware
//    StudentID: 1213096974
//      Lecture: T TH 1:30
//  Description: A sub-class of BankAccount that creates a checking account with an overdraft fee.

public class CheckingAccount extends BankAccount
{
	private int overdraftFeePennies;	//the overdraft fee of the checking account
	
	public CheckingAccount(int balance, double interestRate, String accountNum, int overdraftFeeInPennies)
	{
		super(balance, interestRate,accountNum);	//instance variables from BankAccount
		overdraftFeePennies = overdraftFeeInPennies;	//set over draft fee
	}
	
	public boolean debit(int amountInPennies)	//applies debit, and charges overdraft fees of balance goes below 0
	{
		balanceInPennies -= amountInPennies;
		if (balanceInPennies < 0)
		{
			balanceInPennies -= overdraftFeePennies;
			return false;
		}
		else
		{
			return true;
		}
	}
	
	public void applyInterest()		//applies interest
	{
		if (balanceInPennies > 0)
		{
			double interest = balanceInPennies * interestRate;
			balanceInPennies += interest;
		}
	}
	
	public String toString()	//overrides BankAccount toString to include account type and overdraft fee
	{
		DecimalFormat form = new DecimalFormat("0.00");
		return "\nAccount type\t:\tChecking" + super.toString() + "Overdraft fee\t:\t" + form.format((double)overdraftFeePennies/100.00) + "\n\n";
	}
}




