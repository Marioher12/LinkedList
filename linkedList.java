import java.io.*;
import java.util.*;

public class linkedList
{
	public static void main (String[]args) throws IOException
	{
		//reading the data
		File file = new File("primes4.txt");
		Scanner infile = new Scanner(file);
		Node head = new Node(infile.nextInt());
		Node temp;
		while(infile.hasNextInt())
		{
			temp = new Node(infile.nextInt());
			temp.next = head;
			head = temp;
		}
		
		
		/*//traversed the linked list
		temp = head;
		while(temp != null)
		{
			System.out.println(temp.data);
			temp = temp.next;
		}*/  // commeted out because homework didn't call for it, but going to keep it
		     // for future reference.
		
		
		
		//USER INTERFACE
		Scanner in = new Scanner(System.in);
		int Choice = 0;
		
		while(Choice != 4)
		{
			
			System.out.println("---------------------------------");
			System.out.println("Chose one of the following:");
			System.out.println("1 = Search for a Number.");
			System.out.println("2 = Add a new Number.");
			System.out.println("3 = Delete a Number.");
			System.out.println("4 = Exit");
			System.out.println("---------------------------------");
			
			
			Choice = in.nextInt();
			
			//Searching for a number in the file. Will confirm or deny it is found.
			if(Choice == 1)
			{
				System.out.println("What number would you like to search in the file?");
				//search linked list
				int Search;
				Search = in.nextInt();
				temp = head;
				boolean Found = false;
				while(temp != null)
				{
					if(temp.data == Search)
						Found = true;
					temp = temp.next;
				}
				if(Found)
					System.out.println(Search + " was found!");
				else 
					System.out.println(Search + " was NOT found!");
			}
			
			//Adding a new number to the data set.
			if(Choice == 2)
			{
				System.out.println("Enter the number you want to add: ");
				
				int NewNum;
				NewNum = in.nextInt();
				temp = new Node(NewNum);
				temp.next = head;
				head = temp;
				
				System.out.println(NewNum + " has been added!");
			}
			
			//Deleting a numver from the data set.
			if(Choice == 3)
			{
				System.out.println("Enter the number you want to delete: ");
				int DeleteNumber;
				DeleteNumber = in.nextInt();
				
				Node previous = head;
				temp = head;
				while(temp != null)
				{
					if(temp.data == DeleteNumber)
					{
						previous.next = temp.next;
						System.out.println(DeleteNumber +" has been deleted.");
							break;
					}
					previous = temp;
					temp = temp.next;
				}
				
				
			}
			
			
		}
			
		
		
	}
	
}


class Node
	{
		int data;
		Node next;
		
		//consturctor
		Node(int theData)
		{
			data = theData;
		}
		
	}
