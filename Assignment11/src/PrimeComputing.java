// Assignment #: 11
// Name: Rachel Ware
// StudentID: 1213096974
// Lecture: TTH 1:30
// Description: Creates a queue of prime numbers from 2 to n and keeps track of last prime with multiples
//				and the number of prime numbers.


//We will be using LinkedList as a Queue
import java.util.LinkedList;

public class PrimeComputing
 {
  private int n, lastPrime, primeCount;
  private LinkedList<Integer> originalQueue;
  private LinkedList<Integer> primeQueue;
  private LinkedList<Integer> backupQueue;

  //Constructor to initialize all queues
  public PrimeComputing(int enteredNum)
   {
      n = enteredNum;
      lastPrime = 2;	//first prime is always 2
      primeCount = 0;	
      originalQueue = new LinkedList<Integer>();
      //initialize with values
      	for (int i = 2; i <=n; i++)
      	{
      		originalQueue.add(i);
      	}
      primeQueue = new LinkedList<Integer>();
      backupQueue = new LinkedList<Integer>();
   }

  // computes all prime numbers up to some n
  public void computePrimesUpToN()
   {
       int nextPrime = 2;
       lastPrime = 2;
       
       System.out.println("\nProcessing......");
       
       do {
           //1. Remove the first element in the original queue of integers
           //and set the next prime "nextPrime" to be the number
           nextPrime = originalQueue.removeFirst();          
           
           System.out.println("The next prime to divide: " + nextPrime);         

           //2. Enqueue the next Prime into the primeQueue.
           primeQueue.add(nextPrime);
           
           //3. Go through the integers in the original queue,
           //and eliminate any number that is divisible by the next prime
           //HINT: you will need to remove each integer from the original queue
           //to examine them, and put back the integers that are NOT
           //divisible by the next prime.
           //This is where you will need a back up queue.
           //Also, you will need to keep track of the last such prime
           //that is used to divide other integers in the original queue.
           int currentElement = 2;	//keep track to compare
           while (originalQueue.size() > 0) 
           {
        	   currentElement = originalQueue.removeFirst();	//store next element
        	   if (currentElement % nextPrime != 0)		//if relatively prime to nextPrime
        	   {
        		   backupQueue.add(currentElement);
        	   }
        	   lastPrime = nextPrime;	//finds primes that divide other elements
        	   
           }
           //put backupQueue prime information back into the original queue
           while (backupQueue.size() > 0)
           {
        	   originalQueue.add(backupQueue.removeFirst());
           }
           
       } while (nextPrime <= Math.sqrt(n));
    
       
       //4. Transfer all remaining integers in the original queue
       //to the prime queue.
       while (originalQueue.size() > 0)
       {
    	   primeQueue.add(originalQueue.removeFirst()); 
       }
   }

  //It prints out all primes up to N, by displaying 10 prime numbers
  //in each line.
  public void printResults()
     {
         System.out.println("\n-----------------------");
         System.out.println("The prime(s) up to " + n);
         System.out.println("-----------------------");
         
         int count = 0;
         primeCount = 0;
         
         while (primeQueue.isEmpty() == false)
         {
             int primeNum = primeQueue.remove();
             System.out.print(primeNum + "\t");
             
             count++;
             //displaying 10 primes in each line
             if (count%10 == 0)
                 System.out.print("\n");
         }
         System.out.println("\n-----------------------");
         primeCount = count;
     }
     
  // It returns the largest prime that was used to divide other integers
  // in the original queue. Note that this is not the largest prime found.
  public int getMaxPrime()
     {
         return lastPrime;
     }
    
  // It return the count of prime numbers up to n
  public int getCount()
     {
         return primeCount;
     }
}

