/*
 * MatrixSolver.java
 * Author: Nicholas Kawwas
 * Completed: September, 2019
 * Purpose: Solve Matrix 
 */


import java.io.File;
import java.util.Scanner;

public class MatrixSolver {
	public static int numD;
	public static double[][] noob, inv;
	
	public static void main(String[] args) throws Exception{
		Scanner scanFC = new Scanner(new File("src/inputMatrix.txt"));

		//Reads Number of Test Cases
		int numC = Integer.parseInt(scanFC.nextLine());
		
		for(int i = 0; i < numC; i++) {
			//Instantiates Matrix of Size NumD
			numD = Integer.parseInt(scanFC.next());
			noob = new double[numD][numD + 1];
			inv = new double[numD][numD + 1];
			
			//Inserts Values into Matrix
			for(int n = 0; n < numD; n++) {
				for(int x = 0; x < numD + 1; x++) {
					String val = scanFC.next();
					noob[n][x] = Double.parseDouble(val);
				}
			}	
			
			//Inv Matrix
			for(int n = 0; n < numD; n++)
				for(int x = 0; x < numD + 1; x++)
					if(x == n)
						inv[n][x] = 1;
					else
						inv[n][x] = 0;
					
			//Solves System
			solve(i);
		}	
	}
	
	public static void solve(int i) {
		//Set Leading Values to 1
		for (int b = 0; b < numD; b++) {
			switchR(b);			
			
			//Set Non-Leading Values to 0s
			for (int r = 0; r < numD; r++) {
				if(r != b) {
					double val = noob[r][b]/noob[b][b];
					
	                	for (int c = 0; c < numD + 1; c++) {
	                    	noob[r][c] -= val * noob[b][c];
	                    	inv[r][c] -= val * inv[b][c];
	                	}
				}    
            	}
			
			if(checker(i))
				break;
		}
	
		toPrint(i);
	}

	//Switches Rows 
	public static void switchR(int c) {	
		for (int r = 0; r < numD; r++) {
			if(noob[r][r] == 0.0){
				if(numD - 1 == r){
					if(noob[r - 1][r] != 0 && noob[r][r - 1] != 0) {
						double mat[] = noob[r];
						noob[r] = noob[r - 1];
						noob[r - 1] = mat;
						
						double matI[] = inv[r];
						inv[r] = inv[r - 1];
						inv[r - 1] = matI;
					}	
				} else {
					if(noob[r + 1][r] != 0 && noob[r + 1][r] != 0) {
						double mat[] = noob[r];
						noob[r] = noob[r + 1];
						noob[r + 1] = mat;
						
						double matI[] = inv[r];
						inv[r] = inv[r + 1];
						inv[r + 1] = matI;
					}	
				}
			}	
		}
	}
		
	//Infinite Solution Checker
	public static boolean checker(int i) {		
		int counter = 0;
		for(int l = 0; l < numD + 1; l++)
			if(noob[numD - 1][l] == 0)
				counter++;
	
		if(counter == numD + 1)
			return true;
		else
			return false;
	}	
	
	//Prints either one, infinite or no solution
	public static void toPrint(int i) {
		System.out.println("SYSTEM " + (i + 1));
		
		if(noob[numD - 1][numD - 1] == 0)
			if(noob[numD - 1][numD] != 0)
				System.out.println("NO SOLUTION");
			else
				parameterize(i);
		else
			for(int p = 0; p < numD; p++) {
				double solved = noob[p][numD]/noob[p][p];
				System.out.println("X" + (p + 1) + " = " + solved);
			}
				
		System.out.println();
		
		toPrintI();
	}
	
	//Prints out Inverse
	public static void toPrintI() {
		for(int n = 0; n < numD; n++) {
			for(int x = 0; x < numD + 1; x++)
				System.out.print(inv[n][x] + " ");
			
			System.out.println();
		}	
	}
	
	//Parameterizes
	public static void parameterize(int i) {		
		double[][] sol = new double [numD][2];
				
		sol[numD - 1][1] = 1;
		
		for(int p = numD - 2; p >= 0; p--) {
			sol[p][0] = noob[p][numD]/noob[p][p];
			sol[p][1] = -1 * noob[p][numD - 1]/noob[p][p];
		}
		
		for(int p = 0; p < numD; p++)
			System.out.println("X" + (p + 1) + " = " + sol[p][0] + " + " + sol[p][1] + "t");	
	}	
}
