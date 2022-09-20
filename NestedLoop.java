//Kyle Abreu
//0.4b Nested Loop Exercise
//Checks for duplicates

import java.util.Scanner;

public class NestedLoop
{
	public static void main(String args[])
	{
		Scanner input = new Scanner(System.in);
		NestedLoop testObj = new NestedLoop();
//Get array size

		System.out.println("What is the array size?");
		int size = input.nextInt();

		int[] array = new int[size];
//Get array elements and fill array

		System.out.println("Please enter " + size + " integers.");

		for (int i = 0; i < size; i++)
		{
			array[i] = input.nextInt();
		}

		if (testObj.hasDuplicates(array))
		{
			System.out.println("Duplicates!");
		}
		else
		{
			System.out.println("Unique array!");
		}
	}
/* hasDuplicates() will cross referance 
 *	an array with itself to check for duplicates
 */
	public boolean hasDuplicates(int arr[])
	{
		for(int i = 0; i < arr.length; i++)
		{
			for (int j = i + 1; j < arr.length; j++)
			{
				if(arr[i] == arr[j])
				{
					return true;
				}
			}
		}
		return false;
	}
}