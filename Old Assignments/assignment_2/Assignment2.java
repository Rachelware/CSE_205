// Assignment #: 2
// Arizona State University - CSE205
//         Name: Rachel Ware 
//    StudentID: 1213096974
//      Lecture: TTH 1:30 
//  Description: Programs reads an unspecified number of integers as input, calculates the minimum integer, 
//               largest integer divisible by 2, the count of even integers, and the sum of positive integers, 
//               and outputs those values.

import java.util.Scanner;

public class Assignment2 {
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in); 
		int input = in.nextInt();		//reads input
		int minimum = input;    	//minimum input
		int largeDiv = 0;		//largest input divisible by 2
		int countEven = 0;		//count of even inputs
		int sumPos = 0;		//sum of positive inputs greater than 0
		
		//checks for first input
		if (input % 2 == 0)		//checks if input is even
		{
			largeDiv = input;	//assigns largeDiv since this is the first input
			countEven++;
		}
		
		if (input > 0)
		{
			sumPos+= input;
		}
		
		//checks for next inputs
		while (input != 0)
		{
			input = in.nextInt();	//gets next input
			
			if (minimum > input)	//if input is smaller than current minimum, reassign
			{
				minimum = input;
			}
			if (input % 2 == 0)
			{
				if (input > largeDiv)	//if input is even and larger than current largeDiv, reassign
				{
					largeDiv = input;
				}
				countEven++;
			}
			if (input > 0)
			{
				sumPos+= input;
			}
			
		} 
		
		//print calculations
		System.out.print("The minimum integer is " + minimum
							+ "\nThe largest integer that is divisible by 2 is " + largeDiv
							+ "\nThe count of even integers in the sequence is " + countEven
							+ "\nThe sum of positive integers is " + sumPos);
	}
}




