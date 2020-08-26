/*
 * EinsteinsRiddle.java
 * Author: Nicholas Kawwas
 * Completed: September, 2018
 * Purpose: Einsteins Riddle Solver
*/

import java.text.DecimalFormat;

public class EinsteinsRiddle {
	static String[] nat = { "Dane", "Brit", "Swede", "Norwegian", "German" };
	static String[] col = { "Yellow", "Red", "White", "Green", "Blue" };
	static String[] pet = { "Horse", "Cat", "Bird", "Fish", "Dog" };
	static String[] bev = { "Water", "Tea", "Milk", "Coffee", "Root Beer" };
	static String[] cig = { "Pall Mall", "Prince", "Blue Master", "Dunhill", "Blends" };

	static String[][] lookup = { nat, col, pet, bev, cig };

	//Generate starting state
	public static int[][] init() {
		int[] intN = {0, 1, 2, 3, 4};
		int[] intC = {0, 1, 2, 3, 4};
		int[] intP = {0, 1, 2, 3, 4};
		int[] intB = {0, 1, 2, 3, 4};
		int[] intD = {0, 1, 2, 3, 4};
		
		int[][] intit = {intN, intC, intP, intB, intD};
		return intit;
	}

	//Generate new state by swapping one pair of items
	public static int[][] step(int[][] S) {	
		int row = (int)(Math.random() * 5);
		int rdPick = (int)(Math.random() * 5);
		int rndPck = (int)(Math.random() * 5);
		
		while(rndPck == rdPick)
			rndPck = (int)(Math.random() * 5);

		int[][] step = new int[5][5];
		for(int r = 0; r < 5; r++)
			for(int c = 0; c < 5; c++)
				step[r][c] = S[r][c];
			
		int rep = step[row][rdPick];
		step[row][rdPick] = step[row][rndPck];
		step[row][rndPck] = rep;

		return step;
	}

	//Determine the "cost" for state S
	//For every rule that is satisfied, reduce the cost
	public static int cost(int[][] S) {
		int cost = 15;
		
		for(int i = 0; i < 5; i++) {
			//Norwegian in First House
			if(i == 0 && S[0][i] == 3)
				cost--;
			//Brit Has Red
			if(S[0][i] == 1 && S[1][i] == 1)
				cost--;
			//Green directly Left White -- 
			if(S[1][i] == 2)
				if(i != 0 && S[1][i-1] == 3)
					cost--;
			//Norwegian Next To Blue
			if(S[0][i] == 3)
				if(i != 4 && S[1][i+1] == 4)
					cost--;	
			
			//Swede Has Dog
			if(S[0][i] == 2 && S[2][i] == 4)
				cost--;
			//Pall Mall Has Bird
			if(S[4][i] == 0 && S[2][i] == 2)
				cost--;
			//Blends Next To Cat
			if(S[4][i] == 4)
				if(i != 0 && S[2][i-1] == 1)
					cost--;
			
			//Dane Drinks Tea
			if(S[0][i] == 0 && S[3][i] == 1)
				cost--;
			//Center House Drinks Milk
			if(i == 2 && S[3][i] == 2)
				cost--;
			//Blue Master Drinks Root Beer
			if(S[4][i] == 2 && S[3][i] == 4)
				cost--;
			//Green Drinks Coffee
			if(S[1][i] == 3 && S[3][i] == 3)
				cost--;
			//Blends Next to Water
			if(S[4][i] == 4)
				if(i != 0 && S[3][i-1] == 0)
					cost--;	
			
			//Yellow Smokes Dunhill
			if(S[1][i] == 0 && S[4][i] == 3)
				cost--;
		    //German Smokes Prince
			if(S[0][i] == 4 && S[4][i] == 1)
				cost--;
			//Horse Next To Dunhill
			if(S[2][i] == 0)
				if(i != 0 && S[4][i-1] == 3)
					cost--; 
		}
		
		return cost;
	}

	//Determine the probability of transitioning to the new state
	public static double acceptProb(double temp, double cost, double cPrime) {
		double deltaCost = cPrime - cost;
		if (deltaCost <= 0)
			return 1;
		else
			return Math.exp((-deltaCost / temp));

	}
	
	//Print an array
	public static void printArr(int[][] arr) {
		for (int[] r : arr) {
			for (int i : r)
				System.out.print(i + " ");
			System.out.println();
		}
	}

	//Print the actual words, not just the ints
	public static void printStr(int[][] arr) {
		for (int c = 0; c < 5; c++) {
			System.out.print("House " + (c+1) + ": ");
			for (int r = 0; r < 5; r++)
				System.out.print(lookup[r][arr[r][c]] + ", ");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[][] S = init(), Sprime;
		int cost = cost(S), steps = 0;
		double temp = 1000;

		while (cost > 0) {
			Sprime = step(S);
			int Cprime = cost(Sprime);
			double ap = acceptProb(temp, cost, Cprime);

			if (Math.random() < ap) {
				S = Sprime;
				cost = Cprime;
				temp = Math.max(temp - 1, 1);
			}
			
			steps++;
		}
		
		System.out.println("Final cost is " + cost(S) + "\n");
		printStr(S);
		
		double percent = ((double) steps) / (Math.pow(120, 5));
		String perStr = (new DecimalFormat("##.#####%")).format(percent);
		System.out.print("\n[" + steps + " steps,");
		System.out.println(perStr + " of all states]");
	}
}
