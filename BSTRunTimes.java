/*
Kyle Abreu
6.2C Evaluation of BST run times

Calculates the best, worst, and avg big O for BST search.

User inputs: numOfTrees, numOfElements in each tree(chosen randomly),
and range for each element for rand() to choose from.

Methods:
public void insert(int data)  
public void deletekey(int data)
public int minValue(Node root)
public int search(int data)
public void inorder()
public int findHeight(Node root) 
public void printBinaryTree(Node root, int space, int height)
public void run()
*/

import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class BSTRunTimes
{
	public class Node
	{
		int data;
		Node left, right;

		Node()
		{ 
			data = 0;
			left = null;
			right = null;
		}

		Node(int data)
		{
			this.data = data; 
			left = null;
			right = null;
		}
	}

	Node root;

	public void BSTRunTimes() 
	{ 
		root = null;   
	} 

    public void insert(int data)  
    { 
        root = insert_Recursive(root, data); 
    } 
   
    Node insert_Recursive(Node root, int data) 
    { 
        if (root == null) 
        { 
            root = new Node(data); 
            return root; 
        } 

        if (data < root.data)
        {
            root.left = insert_Recursive(root.left, data); 
        }
        else if (data > root.data)
        {
            root.right = insert_Recursive(root.right, data); 
        }
        return root; 
    }

    public void deletekey(int data)
    { 
        root = delete_Recursive(root, data); 
    }
  
    Node delete_Recursive(Node root, int data)
    {

        if (root == null)
            return root;
  
        if (data < root.data)
        {
            root.left = delete_Recursive(root.left, data);
        }
        else if (data > root.data)
        {
            root.right = delete_Recursive(root.right, data);
        }
  
        else 
        {
            if (root.left == null)
            {
                return root.right;
            }
            else if (root.right == null)
            {
                return root.left;
            }
  
            root.data = minValue(root.right);

            root.right = delete_Recursive(root.right, root.data);
        }
  
        return root;
    }
  
    public int minValue(Node root)
    {
        int minv = root.data;
        while (root.left != null) 
        {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    public int nodesFromRoot = -1;
    public int search(int data) 
    {
        return search_Recursive(this.root, data, nodesFromRoot);
    }

    private int search_Recursive(Node root, int data, int nodesFromRoot) 
    {
        if (root == null) 
        {
            return -1;
        } 

        else if (root.data == data) 
        {
            return nodesFromRoot;
        } 

        else if (root.data > data) 
        {
            nodesFromRoot++;
            return search_Recursive(root.left, data, nodesFromRoot);

        }
        nodesFromRoot++;
        return search_Recursive(root.right, data, nodesFromRoot);
    } 

    public void inorder() 
    { 
        inorder_Recursive(root); 
    }
  
    public void inorder_Recursive(Node root)
    {
        if (root != null) 
        {
            inorder_Recursive(root.left);
            System.out.print(root.data + " ");
            inorder_Recursive(root.right);
        }
    }

//Calc tree height
    public int findHeight(Node root) 
    {
        if (root == null) 
        {
            return -1;
        }

        int leftH = findHeight(root.left);
        int rightH = findHeight(root.right);

        if (leftH > rightH) 
        {
            return leftH + 1;
        } 
        else 
        {
            return rightH + 1;
        }
    }

    public void printBinaryTree(Node root, int space, int height)
    {
        // Base case
        if (root == null) 
        {
            return;
        }
 
        // increase distance between levels
        space += height;
 
        // print right child first
        printBinaryTree(root.right, space, height);
        System.out.println();
 
        // print the current node after padding with spaces
        for (int i = height; i < space; i++) {
            System.out.print(' ');
        }
 
        System.out.print(root.data);
 
        // print left child
        System.out.println();
        printBinaryTree(root.left, space, height);
    }  

    public void run()
    {
        int count = 0;
        int sumOfnodeDistances = 0;
        double total = 0;
        int sumOfHeight = 0;

        Scanner input = new Scanner(System.in);

        System.out.println("How many BSTs do you want to create?");
        int numOfBST = input.nextInt();

        System.out.println("How many random elements per BST?");
        int numOfElements = input.nextInt();

        System.out.println("Enter the ceiling for the range of elements to be selected from.");
        int range = input.nextInt();

//Create a list to hold each BST
//Initiate each tree and insert each rand element
        BSTRunTimes[] list = new BSTRunTimes[numOfBST];
        for(int i = 0; i < list.length; i++)
        {
            Random rand1 = new Random();
            list[i] = new BSTRunTimes(); 

            for(int j = 0; j < rand1.nextInt(numOfElements + 1); j++)
            {
                Random rand2 = new Random();
                int nodeData = rand2.nextInt(range + 1);
                list[i].insert(nodeData);
            }
        }

//Ask user for integer to search
//Find heights of trees
//Find distance of searched value to root
        System.out.println("Enter the interger I should search each BST for.");
        int searchValue = input.nextInt();

        for(int i = 0; i < list.length; i++)
        {
            sumOfnodeDistances = list[i].search(searchValue);
            if(sumOfnodeDistances != -1)
            {
                total = total + sumOfnodeDistances;
                count++;

                sumOfHeight = sumOfHeight + list[i].findHeight(list[i].root);
            }  
        }
//Print data to console
        System.out.println(searchValue + " was found " + count + " times.");
        System.out.println(searchValue + " was found on average in " + (total / count) + " steps.");
        System.out.println("Avg height of trees containing searched value: " + (sumOfHeight/count));
        System.out.println("BST Search Time Complexity:");
        System.out.println("Best | O(1)        ");  
        System.out.println("Worst| O(" + (sumOfHeight / count) + ")        ");
        System.out.println("Avg  | O(" + String.format("%.5f", Math.log(sumOfHeight / count)) + ")     ");
        }
//Main    
	public static void main(String[] args) 
	{
        BSTRunTimes test = new BSTRunTimes();
        test.run();		
    }
}