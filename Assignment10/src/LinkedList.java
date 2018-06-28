// Assignment #: 10
//         Name: Rachel Ware
//    StudentID: 1213096974
//  Lab Lecture: TTH 1:30
//  Description: A linked list is a sequence of nodes with efficient
// element insertion and removal.
// This class contains a subset of the methods of the
// standard java.util.LinkedList class.

import java.util.NoSuchElementException;

public class LinkedList
{
   //nested class to represent a node
   private class Node
   {
          public Object data;
          public Node next;
   }

   //only instance variable that points to the first node.
   private Node first;

   // Constructs an empty linked list.
   public LinkedList()
   {
      first = null;
   }


   // Returns the first element in the linked list.
   public Object getFirst()
   {
      if (first == null)
       {
         NoSuchElementException ex
             = new NoSuchElementException();
         throw ex;
       }
      else
         return first.data;
   }

   // Removes the first element in the linked list.
   public Object removeFirst()
   {
      if (first == null)
       {
         NoSuchElementException ex = new NoSuchElementException();
         throw ex;
       }
      else
       {
         Object element = first.data;
         first = first.next;  //change the reference since it's removed.
         return element;
       }
   }

   // Adds an element to the front of the linked list.
   public void addFirst(Object element)
   {
      //create a new node
      Node newNode = new Node();
      newNode.data = element;
      newNode.next = first;
      //change the first reference to the new node.
      first = newNode;
   }

   // Returns an iterator for iterating through this list.
   public ListIterator listIterator()
   {
      return new LinkedListIterator();
   }

   //turns content of linked list into a String
   public String toString()
   {
	   if (first == null)	//list is empty
		   return "{ }\n";
	   else
	   {
		   String output = "{ ";
		   ListIterator iter = listIterator();
		   while (iter.hasNext())	//go through whole list
		   {
			   output += iter.next() + " ";
		   }
		   output += "}\n";
		   return output;
	   }
   }
   
   //returns the number of nodes in the linked list
   public int size()
   {
	   ListIterator iter = listIterator();
	   int counter = 0;
	   while (iter.hasNext())
	   {
		   counter++;
		   iter.next();
	   }
	   return counter;
   }
   
   //inserts an object in its alphabetical position
   public void addElement(Object element)
   {
	   //find location (alphabetical order)
	   ListIterator iter = listIterator();
	   int index = 0;	//position among nodes
	   while (iter.hasNext())
	   {
		   String ele = element.toString();
		   if (((String) iter.next()).compareTo(ele) <= 0)
		   {
			   index++;	//increment while less than element to add
		   }
	   }
	   
	   //insert
	   ListIterator insertIter = listIterator();
	   for (int i = 0; i < index; i++)
	   {
		   insertIter.next();
	   }
	   insertIter.add(element);
   }
   
   //Removes element node that are at odd indices
   public void removeElementsAtOddIndices()
   {
	   if (size() > 1)	//list has more than one element
	   {
		   ListIterator iter = listIterator();
		   int index = 1;	//start at one
		   iter.next();
		   while (iter.hasNext()) 
		   {
			   iter.next();		//because remove uses previous
			   if (index % 2 == 1)	//if index is odd
			   {
				   iter.remove();
			   }
			   index++;
		   }
	   }
   }
   
   //removes all duplicates of given element
   public void removeAdditionalOccurrences(Object element)
   {
	   boolean occurred = false;
	   ListIterator iter = listIterator();
	   while (iter.hasNext())
	   {
		   if (((String) iter.next()).compareTo(element.toString()) == 0)	//is an occurrence
		   {
			   if (occurred == false)	//first occurrence
				   occurred = true;
			   else
				   iter.remove();	//later occurrences
		   }
	   }
   }
   
   //returns object at given index
   public Object searchByIndex(int index)
   {
	   int counter = 0;
	   ListIterator iter = listIterator();
	   if (index > size() -1 || index < 0)	//if index is larger or smaller than those in list
	   {	   
		   throw new IndexOutOfBoundsException("There is no string at the index");
	   }
	   else
	   {
		   if (index == 0)
		   {
			   return iter.next();
		   }
		   else if (index == 1)
		   {
			   iter.next();
			   return iter.next();
		   }
		   else
		   {
		   while (counter < index -1 && iter.hasNext())	//stops before index
		   {
			   iter.next();
		   }
		   return iter.next();	//returns object at index
		   }
	   }

   }
   
   //finds object and adds it to list given number more times
   public void searchAndIncrease(Object element, int howMany)
   {
	   ListIterator iter = listIterator();
	   while (iter.hasNext())
	   {
		   if (((String)iter.next()).compareTo(element.toString()) == 0)	//object found
		   {
			   for (int j = 0; j < howMany; j++)
				   iter.add(element);
		   }
	   }
   }
   
   
   //nested class to define its iterator
   private class LinkedListIterator implements ListIterator
   {
      private Node position; //current position
      private Node previous; //it is used for remove() method

      // Constructs an iterator that points to the front
      // of the linked list.

      public LinkedListIterator()
      {
         position = null;
         previous = null;
      }

     // Tests if there is an element after the iterator position.
     public boolean hasNext()
      {
         if (position == null) //not traversed yet
          {
             if (first != null)
                return true;
             else
                return false;
          }
         else
           {
              if (position.next != null)
                 return true;
              else
                 return false;
           }
      }

      // Moves the iterator past the next element, and returns
      // the traversed element's data.
      public Object next()
      {
         if (!hasNext())
          {
           NoSuchElementException ex = new NoSuchElementException();
           throw ex;
          }
         else
          {
            previous = position; // Remember for remove

            if (position == null)
               position = first;
            else
               position = position.next;

            return position.data;
          }
      }

      // Adds an element after the iterator position
      // and moves the iterator past the inserted element.
      public void add(Object element)
      {
         if (position == null) //never traversed yet
         {
            addFirst(element);
            position = first;
         }
         else
         {
            //making a new node to add
            Node newNode = new Node();
            newNode.data = element;
            newNode.next = position.next;
            //change the link to insert the new node
            position.next = newNode;
            //move the position forward to the new node
            position = newNode;
         }
         //this means that we cannot call remove() right after add()
         previous = position;
      }

      // Removes the last traversed element. This method may
      // only be called after a call to the next() method.
      public void remove()
      {
         if (previous == position)  //not after next() is called
          {
            IllegalStateException ex = new IllegalStateException();
            throw ex;
          }
         else
          {
           if (position == first)
            {
              removeFirst();
            }
           else
            {
              previous.next = position.next; //removing
            }
           //stepping back
           //this also means that remove() cannot be called twice in a row.
           position = previous;
      }
      }

      // Sets the last traversed element to a different value.
      public void set(Object element)
      {
         if (position == null)
          {
            NoSuchElementException ex = new NoSuchElementException();
            throw ex;
          }
         else
          position.data = element;
      }
   } //end of LinkedListIterator class
} //end of LinkedList class
