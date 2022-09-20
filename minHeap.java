//Kyle Abreu
//5.2b Heap Implementation
public class minHeap 
{
    private int[] Heap;
    private int size;
    private int maxsize;
    private int front = 1;
//Constructor 
    public minHeap(int x)
    {
        maxsize = x;
        size = 0;
        Heap = new int[maxsize + 1];
        Heap[0] = Integer.MIN_VALUE;
    }
//parent node constructor  
    private int parent(int pos) { return pos / 2; }

//leftChild node constructor 
    private int leftChild(int pos) { return (2 * pos); }

//rightChild nodeconstructor 
    private int rightChild(int pos) { return (2 * pos) + 1; }

//Check if node has no children
    private boolean isLeaf(int pos)
    {
		if (pos > (size / 2)) 
		{
		return true;
		}
		return false;
	}

//Swap nodes
    private void swap(int x, int y)
    {
        int tmp;
        tmp = Heap[x];
        Heap[x] = Heap[y];
        Heap[y] = tmp;
    }

//After removing a node
//Correct heap property
    private void minHeapify(int pos)
    {     
		if(!isLeaf(pos))
		{
			int swapPos= pos;

			if(rightChild(pos) <= size)
			{
				if(Heap[leftChild(pos)] < Heap[rightChild(pos)])
				{
					swapPos = leftChild(pos);
				}
				else
				{
					swapPos = rightChild(pos);
				}
			}
			else
			{
				swapPos = Heap[leftChild(pos)];
			}

			if(Heap[pos] > Heap[leftChild(pos)] || 
				Heap[pos] > Heap[rightChild(pos)])
			{
				swap(pos,swapPos);
				minHeapify(swapPos);
			}
		}      
    }

//Insert new node
//Maintain heap property 
    public int insert(int x)
    {
 
        if (size >= maxsize) 
        {
            System.out.println("Heap is full"); 
            return x;
        }
 
        Heap[++size] = x;
        int current = size;
 
        while (Heap[current] < Heap[parent(current)]) 
        {
            swap(current, parent(current));
            current = parent(current);
        }
        return x;
    }

//Prints nodes 
    public void print()
    {
        for (int i = 1; i <= size / 2; i++) 
        {
			System.out.print(" PARENT : " 
				+ Heap[i] + " LEFT CHILD : " 
				+ Heap[2 * i] + " RIGHT CHILD :" 
				+ Heap[2 * i + 1]);
			System.out.println();
        }
    }

//Remove a node
//Maintain heap property
    public int remove()
    {
	    int popped = Heap[front];
	    Heap[front] = Heap[size--];
	    minHeapify(front);
	    return popped;
    }
    
//Main 
    public static void main(String[] arg)
    { 
        minHeap minHeap = new minHeap(15);

        System.out.println("Inserting " + minHeap.insert(5));
        System.out.println("Inserting " + minHeap.insert(3));
        System.out.println("Inserting " + minHeap.insert(17));
        System.out.println("Inserting " + minHeap.insert(10));
        System.out.println("Inserting " + minHeap.insert(84));
        System.out.println("Inserting " + minHeap.insert(19));
        System.out.println("Inserting " + minHeap.insert(6));
        System.out.println("Inserting " + minHeap.insert(22));
        System.out.println("Inserting " + minHeap.insert(9));
 
        minHeap.print();
 
        System.out.println("Removing top value " + minHeap.remove());
        System.out.println("Removing top value " + minHeap.remove());
        System.out.println("Removing top value " + minHeap.remove());                
        System.out.println("Removing top value " + minHeap.remove());        
        System.out.println("Removing top value " + minHeap.remove());

        minHeap.print();

        System.out.println("Inserting " + minHeap.insert(91));
        System.out.println("Inserting " + minHeap.insert(30));
        System.out.println("Inserting " + minHeap.insert(107));
        System.out.println("Inserting " + minHeap.insert(16));
        System.out.println("Inserting " + minHeap.insert(8));
        System.out.println("Inserting " + minHeap.insert(29));
        System.out.println("Inserting " + minHeap.insert(62));
        System.out.println("Inserting " + minHeap.insert(35));
        System.out.println("Inserting " + minHeap.insert(44));       

        minHeap.print();
    }
}