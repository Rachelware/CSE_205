// Assignment #: 4
// Name: Rachel Ware
// StudentID: 1213096974
// Lecture: T TH 1:30
// Description: Assignment 4 class displays a menu of choices to a user
//        and performs the chosen task. It will keep asking a user to
//        enter the next choice until the choice of 'Q' (Quit) is entered.

public class Manager 
{
	private String firstName;
	private String lastName;
	private int deptNum;
	
	public Manager()
	{
		firstName = "?";	//first name of the manager
		lastName = "?";		//last name of the manager
		deptNum = 0;	//department number of the manager
	}
	
	public String getFirstName()
	{
		return firstName;
	}
	
	public String getLastName()
	{
		return lastName;
	}
	
	public int getDeptNum()
	{
		return deptNum;
	}
	
	public void setFirstName(String someFirstName)
	{
		firstName = someFirstName;
	}
	
	public void setLastName(String someLastName)
	{
		lastName = someLastName;
	}
	
	public void setDeptNum(int someDeptNum)
	{
		deptNum = someDeptNum;
	}
	
	public String toString() //creates a String containing first name, last name, and department number
	{
		return firstName + " " + lastName + ", " + "Dept Num:" + deptNum;
	}

}






