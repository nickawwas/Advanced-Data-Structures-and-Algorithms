/*
 * SolveMazeBFS.java
 * Author: Nicholas Kawwas
 * Completed: September, 2018
 * Purpose: Solving a Maze W/ Breadth First Search Algorithm
*/

public class SolveMazeBFS {
	private static int [][]maze; //2D Array Storing the Maze
	public static class Cell{
		private int r; 
		private int c;
		private Cell parent;
		//Constructor for Cell Class (Row, Column and Parent)
		public Cell(int rI, int cI, Cell parentC){
			parent = parentC;
			r = rI;
			c = cI;
		}
		//Returns the row 
		public int getRow(){
			return r;
		}
		//Returns the column
		public int getCol(){
			return c;
		}
		//Returns the parent cell
		public Cell getCell(){
			return parent;
		}
		//toString to print final path
		public String toString(){
			return "(" + r + " , " + c +")";
		} 
	} 
	
	public static boolean isValid(int rI, int cI){
		//Checks whether the cell is a wall or has previously visited
		if(rI >= 0 && rI < maze.length)
			if(cI >= 0 && cI < maze[0].length)
				if(maze[rI][cI] != 0 && maze[rI][cI] != 7)
					return true;	
		return false;
	} 
	
	public static void solveMaze() throws Exception{
		//Creates a Queue setting its current cell to (0,0)
		int r = 0, c = 0; 
		AdvCSQueue<Cell> cellsVisited = new AdvCSQueue<Cell>();
		//Sets the initial parent cell [Adds the (0,0) Cell + Parent]
		cellsVisited.enqueue(new Cell(r,c, null)); 
		
		while(maze[cellsVisited.peek().getRow()][cellsVisited.peek().getCol()] != 2 && !cellsVisited.isEmpty()){
			Cell parentC = cellsVisited.dequeue();
			r = parentC.getRow(); 
			c = parentC.getCol();
			
			maze[r][c] = 7;
			//Moves up if isValid and in bounds (Up)
			if(isValid(r - 1, c))
				cellsVisited.enqueue(new Cell(r - 1, c, parentC));
			//Moves right if isValid and in bounds (Right)
			if(isValid(r, c + 1))
				cellsVisited.enqueue(new Cell(r, c + 1, parentC));
			//Moves down if isValid and in bounds (Down)
			if(isValid(r + 1, c))
				cellsVisited.enqueue(new Cell(r + 1, c, parentC));
			//Moves left if isValid and in bounds (Left)
			if(isValid(r, c - 1))
				cellsVisited.enqueue(new Cell(r, c - 1, parentC));
		}
		SolveMazeDFS.printMaze();
		//Peeks the queue and assigns it to a cell
		Cell finalP = cellsVisited.peek(); 
		String strP = "";
		//Prints out the fastest path to solve maze
		while(finalP != null){
			strP = finalP.toString() + " " + strP;
			finalP = finalP.getCell();
		}	
		System.out.println(strP);
    }

	public static void main(String[] args) throws Exception {		
		maze = SolveMazeDFS.readMaze();
		SolveMazeDFS.printMaze();
		solveMaze();
	}	
}
