//Kyle Abreu
//2.1b Implement a Linked List
//Problem 3, linked list of a float

import java.util.Scanner;

public class LinkedList 
{
	class Node 
	{
	    int data;
	    Node next;

	    Node()
	    {
	    	data = 0;
	    	next = null;
	    }

	    Node(int d)
	    {
	    	data = d;
	    	next = null;
	    }
	}

    Node head;

//Inserts a new node
    void insert(int data)
    {
    	Node node = new Node();
    	node.data = data;
    	node.next = null;

    	if(head == null)
    	{
    		head = node;
    	}
    	else
    	{
    		Node n = head;
    		while(n.next != null)
    		{
    			n = n.next;
    		}
    		n.next = node;
    	}
    }

    public static void main(String[] args)
	{
		LinkedList list = new LinkedList();
		Scanner input = new Scanner(System.in);

		System.out.println("Please enter a number.");
		String number = String.valueOf(input.nextLine());

		char[] digits = number.toCharArray();

		for(int i : digits)
		{
			list.insert(Character.getNumericValue(i));
		}
	}
}