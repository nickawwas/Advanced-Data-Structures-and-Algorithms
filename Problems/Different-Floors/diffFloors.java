/*
 * diffFloors.java
 * Author: Nicholas Kawwas
 * Completed: November, 2018
 * Purpose: Different Floors Problem
 */
 
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class diffFloors{
	static int cost = 6;
	static String[] temp, names, rules;
	static int[] intN = { 0, 1, 2, 3, 4};
	
	public static void readFile() throws Exception {
		Scanner scanF = new Scanner(new File("src/floors.txt"));
		
		ArrayList<String> not = new ArrayList<String>();
		
		temp = new String[6];
		names = new String[5];
		rules = new String[6];
		
		for(int i = 0; i < 6; i++) {
			temp[i] = scanF.next();
			rules[i] = temp[i] + scanF.nextLine();
			
			if(!(not.contains(temp[i])))
				not.add(temp[i]);
		}	
		
		if(not.size() != 5) {
			for(int i = 0; i < 6; i++) {
				if(rules[i].contains(" TO ") && rules[i].contains(" NOT ")) {
					if(!not.contains(rules[i].substring(temp[i].length() + 26)))
						not.add(rules[i].substring(temp[i].length() + 26));
				} else if(rules[i].contains(" TO ")) {
					if(!not.contains(rules[i].substring(temp[i].length() + 22)))
						not.add(rules[i].substring(temp[i].length() + 22));
				} else if(rules[i].contains(" THAN ")) {
					if(!not.contains(rules[i].substring(temp[i].length() + 22)))
						not.add(rules[i].substring(temp[i].length() + 22));
				}
			}
		}	
		
		for(int i = 0; i < 5; i++)
			names[i] = not.get(i);
	}
	
	public static int ruleC(int[] S) {
		cost = 6;
		
		for(int i = 0; i < 6; i++) {
			if(rules[i].contains("NOT ON FLOORS"))
				notOn(temp[i], rules[i].substring(temp[i].length() + 15, temp[i].length() + 16), rules[i].substring(temp[i].length() + 20), S);
			else if(rules[i].contains("NOT ON FLOOR"))
				notOn(temp[i], rules[i].substring(temp[i].length() + 14), "oneOnly", S);
			else if(rules[i].contains("HIGHER FLOOR"))
				onHigh(temp[i], rules[i].substring(temp[i].length() + 22), S);
			else if(rules[i].contains("NOT ON ADJACENT FLOOR"))
				notAdj(temp[i], rules[i].substring(temp[i].length() + 26), S);
			else
				onAdj(temp[i], rules[i].substring(temp[i].length() + 22), S);
		}
		
		return cost;
	}
	
	public static void notOn(String name, String floor, String floors, int[] S) {
		for(int i = 0; i < 5; i++) {
			if(name.equals(names[S[i]])) {
				if(floors.equals("oneOnly")) {
					if(i != (Integer.parseInt(floor) - 1))
						cost--;
				} else {
					if(i != (Integer.parseInt(floor) - 1) && i != (Integer.parseInt(floors) - 1))
						cost--;	
				}
			}
		}	
	}
	
	public static void onHigh(String name, String othername, int[] S) {
		for(int i = 0; i < 5; i++)
			if(name.equals(names[S[i]])) {
				for(int r = 0; r < 5; r++) {
					if(othername.equals(names[S[r]])) {
						if(i > r) {
							cost--; 
							break;
						}
					}	
				}
			}
	}
	
	public static void notAdj(String name, String othername, int[] S) {
		for(int i = 0; i < 5; i++)
			if(name.equals(names[S[i]])) {
				for(int r = 0; r < 5; r++) {
					if(othername.equals(names[S[r]])) {
						if(i != r + 1 && i != r - 1) {
							cost--;
							break;
						}
					}	
				}
			}
	}
	
	public static void onAdj(String name, String othername, int[] S) {
		for(int i = 0; i < 5; i++)
			if(name.equals(names[S[i]])) {
				for(int r = 0; r < 5; r++) {
					if(othername.equals(names[S[r]])) {
						if(i == r + 1 || i == r - 1) {
							cost--;
							break;
						}
					}	
				}
			}
	}
	
	public static int[] swap(int[] S) {
		int rdPick = (int)(Math.random() * 5);
		int rndPck = (int)(Math.random() * 5);
		
		while(rndPck == rdPick)
			rndPck = (int)(Math.random() * 5);

		int[] step = new int[5];

		for(int r = 0; r < 5; r++)
			step[r] = S[r];

		int rep = step[rdPick];
		step[rdPick] = step[rndPck];
		step[rndPck] = rep;

		return step;
	}
	
	public static double acceptProb(double temp, double cost, double cPrime) {
		double deltaCost = cPrime - cost;
		if (deltaCost <= 0)
			return 1;
		else
			return Math.exp((-deltaCost / temp));
	}

	public static void main(String[] args) throws Exception {
		readFile();

		int[] S = intN, Sprime;
		int cost = ruleC(S), steps = 0;
		double temp = 1000;
	
		while (cost > 0) {
			Sprime = swap(S);
			int Cprime = ruleC(Sprime);
			double ap = acceptProb(temp, cost, Cprime);
	
			if (Math.random() < ap) {
				S = Sprime;
				cost = Cprime;
				temp = Math.max(temp - 1, 1);
			}
	
			steps++;
		}
	
		for(int f = 5; f > 0; f--)
			System.out.println(f + " " + names[S[f - 1]]);
	}
}
