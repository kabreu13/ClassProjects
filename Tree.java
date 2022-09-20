/*Kyle Abreu
  2.3d Implement a Tree
  m-ary
  Input;
  preorder[] = {3, 6, 8, 9, 2, 
                8, 7, 10, 6, 1}
*/

class Tree
{
	class Node
	{
		int value;
		Node left;
		Node right;

		Node()
		{
			value = 0;
			left = null;
			right = null;
		}
		Node(int v)
		{
			value = v;
			left = null;
			right = null;
		}

		void setLeft(Node x)
		{
			left = x;
		}

		void setRight(Node x)
		{
			right = x;
		}

    void insert(Node node, int value) 
    {
        if (value < node.value) 
    	{ 
    		if (node.left != null) 
    		{ 
    			insert(node.left, value); 
    		} 
    		else
    		{ 
    			System.out.println(" Inserted " + value + " to left of " + node.value); 
    			node.left = new Node(value);
    		} 
    	} 
        else if (value > node.value) 
        {
        	if (node.right != null) 
         	{
            	insert(node.right, value);
         	} 
         	else 
         	{
            	System.out.println("  Inserted " + value + " to right of "
                					+ node.value);
            	node.right = new Node(value);
          	}
        }
	}

	Node root; 

	Tree() 
	{ 
		root = null;   
	} 

	void addNode(int x)  
	{ 
		Node leaf = new Node(x); 
		if (root == null)
		{
			root = leaf; 
		}
		else
		{
			root.addLeaf(leaf); 
		}
	} 

	void displayTree(Node x) 
	{ 
		if (x == null) 
		{
      		return;
   		}
   		if (x.left == null && x.right == null)
   		{
   			System.out.printf("%s ", x.value);
   		}
	    displayTree(x.left);
	    displayTree(x.right);
	}

	public static void main(String[] args) 
	{ 
		Tree t = new Tree(); 
		t.addNode(1); 
		t.addNode(2); 
		t.addNode(5); 
		t.addNode(10); 
		t.addNode(4);

		t.displayTree(t.root); 
	} 
}