//Kyle Abreu
//7.2b Graph Implementation

public class Graph 
{
    private int numOfVertices;
    private int matrix[][];

// Constructor to create adjacency matrix[x][x]
    Graph(int x) 
    {
        this.numOfVertices = x;
        matrix = new int[x][x];
    }

// Method to add an edge from source to destination
    public void addEdge(int source, int destination) 
    {
        matrix[source][destination] = 1;
        matrix[destination][source] = 1;
    }

// Method to delete an edge from source to destination
    public void deleteEdge(int source, int destination)
    {
    	System.out.println("\nDeleting edge 3 <---> 4");
        matrix[source][destination] = 0;
        matrix[destination][source] = 0;
    }

// Method to check weather 2 vertices are adjacent
    public void checkAdjacency(int source, int destination)
    {
    	if(matrix[source][destination] == 1 && 
    		matrix[destination][source] == 1)
    	{
    		System.out.println(source + " and " + destination + " are adjacent.");
    	}
    	else
    	{
    		System.out.println(source + " and " + destination + " are NOT adjacent.");
    	}
    }

// Method to print a matix and edge list
    public void printGraph() 
    {
        System.out.println("Adjacency Matrix: ");
        System.out.print("    " + 0);

        for(int i = 1; i < matrix.length; i++)
        {
        	System.out.printf("  " + i);
        }
        System.out.println();
        System.out.println("______________________");

        for (int i = 0; i < numOfVertices; i++) 
        {
        	System.out.print(i + " | ");
            for (int j = 0; j < numOfVertices; j++) 
            {
            	System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }

        for (int i = 0; i < numOfVertices; i++) 
        {
            System.out.print("Vertex " + i + " is connected to: ");

            for (int j = 0; j < numOfVertices; j++) 
            {
                if (matrix[i][j] == 1) 
                {
                    System.out.print(j + " ");
                }
            }
            System.out.println();
        }
    }

//Main
    public static void main(String[] args) 
    {
        Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.printGraph();

        graph.deleteEdge(3, 4);
        graph.printGraph();

		graph.checkAdjacency(3, 4);
		graph.checkAdjacency(4, 3);
        graph.checkAdjacency(1, 2);
        graph.checkAdjacency(0, 2);
    }
}