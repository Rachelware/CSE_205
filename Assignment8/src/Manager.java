import java.io.Serializable;

// Assignment #: 8
//         Name: Rachel Ware
//    StudentID: 1213096974
//      Lecture: TTH 1:30
//  Description: The Manager class describes a manager.
//               It also provides their accessor methods, mutator methods,
//               and toString method.


public class Manager implements Serializable
{

 private String firstName;
 private String lastName;
 private int deptNum;

 /************************************************************************
 Constructor method to initialize instance variables.
 ************************************************************************/
 public Manager()
  {
      firstName = new String("?");
      lastName= new String("?");
      deptNum = 0;
  }

 /************************************************************************
 Accessor methods
 ************************************************************************/
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

 /************************************************************************
  Modifier methods
 ************************************************************************/
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

 //copy method sets this Manager to have the same instance variable values as other Manager
 public void copy(Manager other)
 {
	 this.firstName = other.getFirstName();
	 this.lastName = other.getLastName();
	 this.deptNum = other.getDeptNum();
 }
 
 /*****************************************************************************
 This method return a string containing the attribute information of a manager
 *****************************************************************************/
 public String toString()
  {
   String result;

      result = firstName + " " + lastName + ", Dept Num:" + deptNum;

   return result;
  }

} 

