/*
 * UWGraph.java
 * Author: Nicholas Kawwas
 * Completed: November, 2018
 * Purpose: Unweighted Graph Implementation
*/

import java.util.Stack;

public class UWGraph {
	protected int nVerts;
	protected int[][] adjMat;
	protected Vertex[] vertexList;
	protected Stack<Integer> stacked;
	protected final int MAX_VERTS = 10;
	
	//Constructor: Instantiates vertexList and adjMat
	public UWGraph() {
		nVerts = 0;
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
	}
	
	//AddVertex: Method adds char to vertexList
	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab); 
	}
	
	//AddEdge: Connects two vertices together (Using 2D Array)
	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}
	
	//Prints out the character label for that vertex
	public void displayVertex(int vertex) {
		System.out.print(vertexList[vertex].label);
	}
	
	//Minimum Spanning Tree: Prints out n - 1 links (n being the number of towns)
	public void mst(int start) {
		String toPrint = "";
		stacked = new Stack<Integer>();
	
		stacked.push(start);
		vertexList[start].visited = true;
		
		//While loop for DFS
		while(!stacked.isEmpty()) {
			boolean found = false;
			
			//Adds vertex to mst 
			for(int v = 0; v < nVerts; v++)
				if(adjMat[stacked.peek()][v] == 1 && vertexList[v].visited == false){
					toPrint += Character.toString(vertexList[stacked.peek()].label) + Character.toString(vertexList[v].label) + " ";
					
					found = true;	
					vertexList[v].visited = true;
					stacked.push(v);
				} 
			
			if(!found)
				stacked.pop();
		}
		
		System.out.println(toPrint);
	}

	//Vertex Class
	public class Vertex {
		public char label;
		public boolean visited;
		
		//Constructor: Vertex Character and State
		public Vertex(char labeled) {
			label = labeled;
			visited = false;
		}
		
		//toString: Prints out char
		public String toString() {
			return "Character: " + label + "\tVisited: " + visited;
		}
	}
}
