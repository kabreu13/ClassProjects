/*
 * Kyle Abreu
 * 1.2a
 * Sorting and Searching Examples
 * Creates rand int arr[10] from 0 to 100
 * Applys and prints an ascending and decending sort
 * Prints min and max
 * Added comment code for optional user input of array elements
 */

import java.util.*;

public class SortingAndSearching
{
	public static void main(String args[])
	{	
		SortingAndSearching test = new SortingAndSearching();

		Scanner input = new Scanner(System.in);
		//Optional code for user input
		/*
		 * System.out.println("What is the array size?");
		 * int size = input.nextInt();
		 * int[] arr = new int[size];
		 * System.out.println("Please enter " + size + " integers.");
		 * for(int i = 0; i < size; i++)
		 * {
		 *     arr[i] = input.nextInt();
		 * }
		 */

		int[] randArr1 = test.getRandArr();
		System.out.println("Rand array 1:\n" + Arrays.toString(randArr1));
		System.out.println("This is rand array 1 in ascending order:\n" + 
			Arrays.toString(test.selectionSortAscending(randArr1)));

		int[] randArr2 = test.getRandArr();
		System.out.println("Rand array 2:\n" + Arrays.toString(randArr2));
		System.out.println("This is rand array 2 in decending order\n" + 
			Arrays.toString(test.selectionSortDecending(randArr2)));

		int[] randArr3 = test.getRandArr();
		System.out.println("Rand array 3:\n" + Arrays.toString(randArr3));
		System.out.println("This is rand array 3 bubble sorted:\n" + 
			Arrays.toString(test.bubbleSort(randArr3)));

		System.out.println("For my next trick, I will create a random array and check if it has a key!");
		System.out.println("What is the integer key (0-10)?");
		int key = input.nextInt();

		int[] randArr4 = test.getRandArr();

		System.out.println("Rand array 4: " + Arrays.toString(randArr4));
		if(test.binarySearch(test.selectionSortAscending(randArr4), key, 0, 10) != -1)
		{
			System.out.println("Your element is in this array!!");
		}
		else
			System.out.println("Your element is not in this array.");
		
		
	}

//Creates/fills rand array
	public int[] getRandArr()
	{
		Random rand = new Random();

		int size = 10;

		int[] arr = new int[size];

		for(int i = 0; i < size; i++)
		{
			arr[i] = rand.nextInt(11);
		}
		return arr;		
	}

//Sorts array in ascending order
	public int[] selectionSortAscending(int[] arr)
	{
		int temp = 0;
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = i + 1; j < arr.length; j++)
			{
				if(arr[i] > arr[j])
				{
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		return arr;
	}

//Sorts array in decending order
	public int[] selectionSortDecending(int[] arr)
	{
		int temp = 0;
		for(int i = 0; i < arr.length; i++)
		{
			for(int j = i + 1; j < arr.length; j++)
			{
				if(arr[i] < arr[j])
				{
					temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		return arr;
	}

//Sorts array with bubblesort
    public int[] bubbleSort(int [] arr)
    {
        for(int i = 0; i < arr.length -  1; ++i)
        {
            for(int j = 0; j < arr.length - i - 1; ++j)
            {
                if(arr[j + 1] < arr[j])
                {
                    int swap = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = swap;
                }
            }
        }
        return arr;
    }

//Binary searches for key
    public int binarySearch(int[] arr, int key, int low, int high)
    {
		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (arr[mid] == key)
			{
				return mid;
			}
			if (arr[mid] < key)
			{
				low = mid + 1;
			}
			else
			{
				high = mid - 1;
			}
		}
		return -1;
	}
}