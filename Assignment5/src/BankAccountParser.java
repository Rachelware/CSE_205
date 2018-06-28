// Assignment #: 5
//         Name: Rachel Ware
//    StudentID: 1213096974
//      Lecture: T TH 1:30
//  Description: Parses input information of a Bank Account set up with delimiter "\".

public class BankAccountParser 
{
	
	public static BankAccount parseStringToBankAccount(String lineToParse)
	{
		String[] array = lineToParse.split("/");	//splits input into an array with \ as a delimiter
		if (array[0].toUpperCase().equals("SA"))	//checks if account type is Savings account, either case
		{
			return new SavingsAccount(Integer.parseInt(array[3]), Double.parseDouble(array[2]), array[1]);	
		}
		else if (array[0].toUpperCase().equals("CH"))	//Checks if account type is Checking account, either case
		{
			return new CheckingAccount(Integer.parseInt(array[3]), Double.parseDouble(array[2]), array[1], Integer.parseInt(array[4]));
		}
		else //if (array[0].toUpperCase().equals("CR"))	//Checks if account type is Creditcard, either case
		{
			return new CreditcardAccount(Integer.parseInt(array[3]), Double.parseDouble(array[2]), array[1], Integer.parseInt(array[4]));
		}
	}
}
