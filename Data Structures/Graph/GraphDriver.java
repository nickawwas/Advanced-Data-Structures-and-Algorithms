/*
 * GraphDriver.java
 * Author: Nicholas Kawwas
 * Completed: November, 2018
 * Purpose: Graph Implementation
*/

public class GraphDriver {
	public static void main(String[] args){
		WGraph graphed = new WGraph();
		
		graphed.addVertex('A'); //0
		graphed.addVertex('B'); //1
		graphed.addVertex('C'); //2
		graphed.addVertex('D'); //3
		graphed.addVertex('E'); //4
		
		graphed.addEdge(0, 1, 50); //AB
		graphed.addEdge(0, 3, 80); //AD
		
		graphed.addEdge(1, 4, 50); //BE
		graphed.addEdge(1, 3, 90); //BD
		graphed.addEdge(1, 2, 60); //BC
		
		graphed.addEdge(2, 4, 40); //CE
		
		graphed.addEdge(3, 4, 70); //DE
		graphed.addEdge(3, 2, 20); //DC
				
		graphed.path(4, 0);
	}
}
