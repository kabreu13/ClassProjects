//Kyle Abreu
//1.4b #1 Array Dubugging
//Fixed 4 bugs in example code
//1. By convention array A changed to array a
//2. Always initialize variables
//3. Changed int j = 0 to int j = i + 1
//4. Changed '=' to '=='

import java.util.Scanner;

public class DebugArrays
{
	public static void main(String args[])
	{
		//Original code
		/*int[] A = {1,2,3,4,5,6,7,8,9,10};

		int dups;
		for (int i = 0; i < A.length; i++)
		{
			for(int j = 0; j < A.length; j++)
			{
				if(A[i] = A[j])
				{
					dups++;
				}			
			}
		}
		System.out.println("dups = " + dups);
		*/


//1
		int[] a = {1,1,2,2,3,4,5};
//2
		int dups  = 0;

		for (int i = 0; i < a.length; i++)
		{
//3
			for(int j = i + 1; j < a.length; j++)
			{
//4
				if(a[i] == a[j])
				{
					dups++;
				}			
			}
		}
		System.out.println("dups = " + dups);
	}
}