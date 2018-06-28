// Assignment #: 4
// Name: Rachel Ware
// StudentID: 1213096974
// Lecture: T TH 1:30
// Description: Assignment 4 class displays a menu of choices to a user
//        and performs the chosen task. It will keep asking a user to
//        enter the next choice until the choice of 'Q' (Quit) is entered.

public class Project 
{
	private String projTitle;
	private int projNumber;
	private String projLocation;
	private Manager projManager;
	
	public Project()
	{
		projTitle = "?";	//title of the project
		projNumber = 0;		//project number
		projLocation = "?";		//location of the project
		projManager = new Manager();	//manager of the project
	}
	
	public String getProjTitle()
	{
		return projTitle;
	}
	
	public int getProjNumber()
	{
		return projNumber;
	}
	
	public String getProjLocation()
	{
		return projLocation;
	}
	
	public Manager getProjManager()
	{
		return projManager;
	}
	
	public void setProjTitle(String title)
	{
		projTitle = title;
	}
	
	public void setProjNumber(int number)
	{
		projNumber = number;
	}
	
	public void setProjLocation(String location)
	{
		projLocation = location;
	}
	
	public void setProjManager(String firstName, String lastName, int deptNum) //creates content of a Manager object
	{
		projManager = new Manager();
		projManager.setFirstName(firstName);
		projManager.setLastName(lastName);
		projManager.setDeptNum(deptNum);
	}
	
	public String toString()	//creates a String including project title, number, location, and manager information
	{
		return "\nProject Title:\t\t" + projTitle + "\nProject Number:\t\t" + projNumber
				+ "\nProject Location:\t" + projLocation + "\nProject Manager:\t" 
				+projManager.toString() + "\n\n";
	}
	
}









