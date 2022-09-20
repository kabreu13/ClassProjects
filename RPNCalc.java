//Kyle Abreu
//4.1b
//RPN Calculator
import java.io.*;
import java.util.*;
 
public class RPNCalc {
    public int CalculateRPN(Stack<String> stack, String[] cArray)
    {
        
        int x = 0;
        int y = 0;
        String total = "";
        int get = 0;
        String choice;
        int case_total = 0;
        String temp_total = "";

        for (int i = 0; i < cArray.length; i++) 
        {
            if (cArray[i] != "+" && cArray[i] != "-"
                && cArray[i] != "*" && cArray[i] != "/") 
            {
                stack.push(cArray[i]);
            }
            
            switch (cArray[i]) 
            {
            case "+": 
                x = Integer.parseInt(stack.pop());
                y = Integer.parseInt(stack.pop());
                case_total = x + y;
                total = temp_total + case_total;
                stack.push(total);
                break;
 
            case "-":
                x = Integer.parseInt(stack.pop());
                y = Integer.parseInt(stack.pop());
                case_total = y - x;
                total = temp_total + case_total;
                stack.push(total);
                break;
 
            case "*": 
                x = Integer.parseInt(stack.pop());
                y = Integer.parseInt(stack.pop());
                case_total = x * y;
                total = temp_total + case_total;
                stack.push(total);
                break;
 
            case "/": 
                x = Integer.parseInt(stack.pop());
                y = Integer.parseInt(stack.pop());
                case_total = y / x;
                total = temp_total + case_total;
                stack.push(total);
                break;
 
            default:
                continue;
            }
        }
        return Integer.parseInt(stack.pop());
    }

    public void checkIfEmpty(Stack<String> stack)
    {
		if(!stack.empty())
	    {
        	System.out.println("ERROR!! Please fix notation!");
        }
    }

	public static void main(String[] args)
    {
    	Stack<String> stack = new Stack<String>();
        String[] input
            = {"3", "5", "+", "1", "-"};
 
        RPNCalc obj = new RPNCalc();
        int total = obj.CalculateRPN(stack, input);
        System.out.println(total);

        obj.checkIfEmpty(stack);
    }
}