// Assignment #: 9
//         Name: Rachel Ware
//    StudentID: 1213096974
//      Lecture: TTH 1:30
//  Description: Takes an array of integers and finds the minimum, maximum number divisible by 2,
//					the count of even numbers, and the sum of numbers at indexes divisible by 3 recursively.

import java.io.*;
import java.util.ArrayList;

public class Assignment9 
{
	private static int[] array;
	private static int arrayLength;		//number of elements in array
	
	public static void main(String[] args)
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	//for input
		array = new int[100];	//maximum possible array length is 100
		arrayLength = 0;		//array starts empty
		int input = 0;			//initialize input so it can be use throughout main
		
		//get first input value and catch exceptions
		try {
			input = Integer.parseInt(br.readLine());	//parse input to an int
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//get next input values until 0
		while(input != 0)
		{
			array[arrayLength] = input;	//put input in next empty space
			arrayLength++;	//increment after use works!
			
			//get next input, catch exceptions
			try {
				input = Integer.parseInt(br.readLine());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		 }
		array[arrayLength] = 0;	//set last element in array to 0
		arrayLength++;
		
		//call methods and print results
		System.out.println("The minimum number is " + findMin(array, 0, arrayLength-1));
		System.out.println("The largest integer that is divisible by 2 is " + computeMaxDivisibleBy2(array, 0, arrayLength-1));
		System.out.println("The count of even numbers in the sequence is " + countEvenNumbers(array, 0, arrayLength-1));
		System.out.println("The sum of numbers at indexes divisible by 3 is " + computeSumOfNumbersAtIndexDivisibleBy3(array, 0, arrayLength-1));
		
	}
	
	//finds minimum value of numbers in the array
	public static int findMin(int[] numbers, int startIndex, int endIndex)
	{
		//base case
		if(startIndex == endIndex)	//went through whole array
			return numbers[startIndex];
		else if (numbers[startIndex] >= numbers[endIndex])	//first is larger than last
		{
			return findMin(numbers, startIndex + 1, endIndex);
		}
		else	//last is larger than first or even
		{
			return findMin(numbers, startIndex, endIndex -1);
		}
	}
	
	//finds maximum value divisible by 2 in the array
	public static int computeMaxDivisibleBy2(int[] elements, int startIndex, int endIndex)
	{
		if (startIndex == endIndex)	//base case
			return elements[startIndex];
		else if (elements[startIndex] % 2 != 0 && elements[endIndex] % 2 == 0) //first element is not divisible by 2
		{
			return computeMaxDivisibleBy2(elements, startIndex + 1, endIndex);
		}
		else if (elements[startIndex] % 2 == 0 && elements[endIndex] % 2 != 0) //last element is not divisible by 2
		{
			return computeMaxDivisibleBy2(elements, startIndex, endIndex - 1);
		}
		else if ((elements[startIndex] % 2 == 0 && elements[endIndex] % 2 == 0) && (elements[startIndex] > elements[endIndex])) //both divisible by 2 and first value is larger than last
		{
			return computeMaxDivisibleBy2(elements, startIndex, endIndex - 1);
		}
		else //if both are divisible by 2 and last element is larger OR neither element is divisible by 2
		{
			return computeMaxDivisibleBy2(elements, startIndex + 1, endIndex);
		}
			
	}
	
	//finds the count of even numbers in the array
	public static int countEvenNumbers(int[] elements, int startIndex, int endIndex)
	{
		if (startIndex == endIndex) //base case
			return 1;	//add 1 because zero is even
		else if (elements[startIndex] % 2 != 0)	//first element is not even
		{
			return countEvenNumbers(elements, startIndex + 1, endIndex);
		}
		else //if (elements[startIndex] % 2 == 0)
		{
			return 1 + countEvenNumbers(elements, startIndex + 1, endIndex); //add 1 to count and call again
		}
	}
	
	//finds the sum of numbers at indexes divisible by 3 in the array
	public static int computeSumOfNumbersAtIndexDivisibleBy3(int[] elements, int startIndex, int endIndex)
	{
		if (startIndex == endIndex)	//base case
		{
			if (startIndex % 3 == 0)	//if remaining index is divisible by 3
				return elements[startIndex];	//add to sum
			else	//remaining index not divisible by 3
				return 0;
		}
		else if (startIndex % 3 == 0) //if divisible by 3 add element to sum
		{
			return elements[startIndex] + computeSumOfNumbersAtIndexDivisibleBy3(elements, startIndex + 1, endIndex);
			
		}
		else	//not divisible by 3
		{
			return computeSumOfNumbersAtIndexDivisibleBy3(elements, startIndex + 1, endIndex);
		}
	}
	
}
