/*
 * SolveMazeDFS.java
 * Author: Nicholas Kawwas
 * Completed: September, 2018
 * Purpose: Solving a Maze W/ Depth First Search Algorithm
*/

import java.util.Scanner;
import java.io.File;

public class SolveMazeDFS{
	private static int numRow, numCol; //Size of the Maze
	private static int [][]maze; //2D Array Storing the Maze
	
	public static class Cell{
		private int r;
		private int c;
		//Constructor for Cell Class
		public Cell(int rI, int cI){
			r = rI;
			c = cI;
		}
		//Get Row of the Cell
		public int getRow(){
			return r;
		}
		//Get Col of the Cell
		public int getCol(){
			return c;
		}
		
		public String toString(){
			return "(" + r + " ," + c +")";
		}
	} 
	
	public static int[][] readMaze()throws Exception{
			Scanner fs = new Scanner(new File("src/maze.txt"));
			//Scans for the size of the maze
			numRow = fs.nextInt();
			numCol = fs.nextInt();
			
			maze = new int[numRow][numCol];
			//Scans for the next int and adds it to 2D Array
			for(int r = 0; r < numRow; r++)
				for (int c = 0; c < numCol; c++)
					maze[r][c] = fs.nextInt();
			return maze;
	}
	
	public static void printMaze(){
		//Prints the maze
		for(int rR = 0; rR < numRow; rR++){
			for(int cC = 0; cC < numCol; cC++){
			    System.out.print(maze[rR][cC] + " ");
			}
		    System.out.println();			
		}
		System.out.println();	
	}
	
	public static boolean isValid(int rI, int cI){
		//Checks whether the cell is a wall or has previously visited
		if(rI >= 0 && rI < maze.length)
			if(cI >= 0 && cI < maze[0].length)
				if(maze[rI][cI] != 0 && maze[rI][cI] != 7)
					return true;	
		return false;
	}
	
	public static void solveMaze() {
		//Creates a stack and sets current cell to 0,0
		int currentR = 0, currentC = 0;
		AdvCSStack<Cell> cellsVisited = new AdvCSStack<Cell>();
		cellsVisited.push(new Cell(currentR,currentC));

		while(maze[currentR][currentC] != 2){
			maze[currentR][currentC] = 7;
		
			//Moves up if isValid and in bounds
			if(isValid(currentR - 1,currentC)) //Up
				cellsVisited.push(new Cell(--currentR, currentC));
			//Moves right if isValid and in bounds
			else if(isValid(currentR,currentC + 1)) //Right
				cellsVisited.push(new Cell(currentR, ++currentC));
			//Moves down if isValid and in bounds
			else if(isValid(currentR + 1, currentC)) //Down
				cellsVisited.push(new Cell(++currentR, currentC));
			//Moves left if isValid and in bounds
			else if(isValid(currentR, currentC - 1))//Left
				cellsVisited.push(new Cell(currentR, --currentC));
			else {
				cellsVisited.pop();
				currentR = cellsVisited.peek().getRow();
				currentC = cellsVisited.peek().getCol();	
			}
		}	
		printMaze();
		//Prints the coordinates used to solve the maze by getting the value for the row and column 	    	
		String strCo = "";
		
		while(!cellsVisited.isEmpty()){
			strCo = "(" + cellsVisited.peek().getRow() + ", " + cellsVisited.peek().getCol() + ") " + strCo; 
			cellsVisited.pop();
		}
		System.out.println(strCo);
	}
	
	public static void main(String[] args) throws Exception {		
		readMaze();
		printMaze();
		solveMaze();
	}	
}
