/*
 * GradeDriver.java
 * Author: Nicholas Kawwas
 * Completed: November, 2020
 * Purpose: Implemented a Symbol Table Driver Using Linked List
*/

import java.util.Scanner;

public class GradeDriver {
    public static void main(String[] args) {
        SymbolTable<String, Double> mp = new SymbolTable<>();

        mp.put("A+", 4.3);
        mp.put("A", 4.0);
        mp.put("A-", 3.7);
        mp.put("B+", 3.3);
        mp.put("B", 3.0);
        mp.put("B-", 2.67);
        mp.put("C+", 2.33);
        mp.put("C", 2.0);
        mp.put("C-", 1.67);
        mp.put("D", 1.0);
        mp.put("F", 0.0);

        System.out.print("Enter Your Grades: ");
		Scanner scl = new Scanner(System.in);
		String[] grades = scl.nextLine().split(" ");
        
        int avg = 0;
        for(int i = 0; i < grades.length; i++)
            avg += mp.getValue(grades[i]);
        
        avg /= grades.length;
        
        mp.printST();

        System.out.println("\nAvg GPA: " + avg);
    }
}
