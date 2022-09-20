//Kyle Abreu
//1.1a #6 Recursive Loop
//Sums up an array until a key if found

import java.util.Scanner;

public class RecursiveLoop
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		
//Get array size
		System.out.println("What is the array size?");
		int size = input.nextInt();

		int[] arr = new int[size];

//Get array elements
		System.out.println("Please enter " + size + " integers.");
		for (int i = 0; i < size; i++)
		{
			arr[i] = input.nextInt();

		}
//Get key
		System.out.println("Please enter a key to sum up to and include.");
		int key = input.nextInt();

//Print sum
		System.out.println("The sum of the array elements up to and including " 
			+ key + " is " + sum(arr, key, 0) + ".");
	}

//Sums up an array until a key if found
	public static int sum(int[] arr, int key, int index)
	{
		if(arr[index] == key)
			return arr[index];
		else
			return arr[index] + sum(arr, key, index + 1);
	}
}