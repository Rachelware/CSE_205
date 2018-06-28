import java.util.Comparator;

// Assignment #: 8
//         Name: Rachel Ware
//    StudentID: 1213096974
//      Lecture: TTH 1:30
//  Description: Compares managers using first department number, otherwise first name,
// 				 and lastly last name.

public class ManagerComparator implements Comparator<Project>
{
	//returns a number comparing two managers of the projects
	public int compare(Project first, Project second)
	{
		//compare deptnums
		if (first.getProjManager().getDeptNum() != second.getProjManager().getDeptNum())
		{
			return first.getProjManager().getDeptNum() - second.getProjManager().getDeptNum();
		}
		else //compare first names
		{
			if (first.getProjManager().getFirstName().compareTo(second.getProjManager().getFirstName()) != 0)
			{
				return first.getProjManager().getFirstName().compareTo(second.getProjManager().getFirstName());
			}
			else //compare last names
			{
				if (first.getProjManager().getLastName().compareTo(second.getProjManager().getLastName()) != 0)
				{
					return first.getProjManager().getLastName().compareTo(second.getProjManager().getLastName());
				}
				else
				{
					return 0;
				}
			}
		}
	}
}
