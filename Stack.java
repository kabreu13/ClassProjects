//Kyle Abreu
//4.2b
//#2 A stack of strings, to reverse a sentence

import java.util.*;
class Stack
{
    private String stackArr[];
    private int stackTop;
    private int capacity;
 
    Stack(int size)
    {
        stackArr = new String[size];
        stackTop = -1;
        capacity = size;
    }
// Push() adds a string to top of array
    public void push(String x)
    {
        if (stackTop == capacity - 1)
        {
            System.out.println("Stack is full");
        }
        stackArr[++stackTop] = x;
    }
// Pop() removes a string from top of array
    public String pop()
    {
        if (stackTop == -1)
        {
            System.out.println("Stack is empty");
        } 
        return stackArr[stackTop--];
    }

    public static void main (String[] args)
    {
        Stack stack = new Stack(10);
 		
 		String input = "Hello world my name is Kyle";

 		String[] inputArr = input.split(" ");

 		System.out.println("Original sentence is;");
 		System.out.println(input + "\n");

 		for (int i = 0; i < inputArr.length; i++)
 		{
 			stack.push(inputArr[i]);
 		}
		
		System.out.println("Reversed sentence is;");
 		for (int i = 0; i < inputArr.length; i++)
 		{
 			System.out.printf(stack.pop() + " ");
 		}
    }
}