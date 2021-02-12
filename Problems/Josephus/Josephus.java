/*
 * Josephus.java
 * Author: Nicholas Kawwas
 * Completed: October, 2020
 * Purpose: Solves the Josephus Problem using Queue
*/

import java.util.Scanner; 

public class Josephus {
	public static void main(String[] args) {
		int n, m;
		
		System.out.print("Enter Number of People In Circle (N): ");
		Scanner scl = new Scanner(System.in);
		n = scl.nextInt();
		
		System.out.print("Enter Number To Eliminate People By (M): ");
		m = scl.nextInt();
		
		eliminationGame(n, m);
		
		scl.close();
	}
	
	
	public static void eliminationGame(int n, int m) {
		SimpleQueue q = new SimpleQueue();

		for(int i = 0; i < n; i++)
			q.enqueue(i);

		System.out.print("KILLED: ");

		while(q.front() != q.back()) {
			for(int j = 1; j < m + 1; j++) {
				if(j % m != 0) {
					int toBack = q.front();
					q.dequeue();
					q.enqueue(toBack);
				} else {
					System.out.print(q.front() + " ");
					q.dequeue();
				}
			}
		}
		System.out.println();
		System.out.print(q.front());
	}
}