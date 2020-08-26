/*
 * primeNumber.java
 * Author: Nicholas Kawwas
 * Completed: November, 2018
 * Purpose: Prime Number Problem
 */
 
import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

public class primeNumber {
	public static void main(String[] args) throws Exception {
		Scanner scanF = new Scanner(new File("src/primeP.txt"));
		int size = scanF.nextInt();
		
		HashSet<Integer> setP = new HashSet<Integer>();
		for(int i = 2; i <= size; i++)
			setP.add(i);
		
		for(int i = 2; i <= size; i++) 
			for(int j = i + i; j <= size; j += i) 
				setP.remove(j);

		System.out.println(setP);
		System.out.println(setP.size());
	}
}
