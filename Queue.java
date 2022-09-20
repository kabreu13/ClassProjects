//Kyle Abreu
//4.4 Queue
//Queue of sales orders
//GUI to add, remove and display order
import java.util.Scanner;

public class Queue
{
    int[] arr;
    int tail, head, size;
//Queue Constructor
    public Queue(int s)
    {
        tail = head = -1;
        size = s;
        arr = new int[size];
    } 
//if queue not full
//add new tail element
    public void enqueue(int x)
    {
        if (isFull()) 
        {
            System.out.println("**Queue is full!**");
        } 
        else 
        {
            if (head == -1)
            {
                head = 0;
            }
            tail++;
            arr[tail] = x;
        }
    }
//if queue not empty
//remove head element
    public int dequeue()
    {
        int x;
        if (isEmpty()) 
        {
            System.out.println("**Queue is empty**");
            return (-1);
        } 
        else 
        {
            x = arr[head];
            if (head >= tail) 
            {
                head = -1;
                tail = -1;
            }
            else 
            {
                head++;
            }
            return (x);
        }
    }
//prints queue
//head -> tail
    public void display()
    {
        System.out.println();
        if (isEmpty()) 
        {
            System.out.println("**Queue is empty!**");
            return;
        }
 
        for (int i = head; i < tail + 1; i++) 
        {
            System.out.println(arr[i]);
        }
    }
//check if full
    public boolean isFull() 
    {
        if (head == 0 && tail == size - 1) 
        {
            return true;
        }
        return false;
    }
//check if empty
    public boolean isEmpty() 
    {
        if (head == -1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
//GUI
    public void runTerminal()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the sales order number terminal.");

        boolean x = true;
        while(x)
        {
            System.out.println("\nOptions:\n1): Enter a new order number." +
                "\n2): Remove a completed order.\n3): Display Orders\n4): Exit terminal." +
                "\nPlease enter an option:");
            int option = input.nextInt();

            switch(option)
            {
                case 1:
                {
                    System.out.println("Please enter the order number: ");
                    int orderNum = input.nextInt();
                    enqueue(orderNum);
                    break;
                }

                case 2:
                {
                    if(isEmpty())
                    {
                        System.out.println("**There are no more orders!**");

                    }
                    else
                    {
                        System.out.println("Order number " + 
                            dequeue() + " has been removed");
                    }
                    break;
                }
                case 3:
                {
                    display();
                    break;
                }

                case 4:
                {
                    x = false;
                    break;
                }
                default:
                    
            }
        }
    }

    public static void main(String[] args)
    {
        Queue q = new Queue(10);
        q.runTerminal();        
    }
}