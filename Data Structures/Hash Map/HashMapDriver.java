/*
 * HashMap.java
 * Author: Nicholas Kawwas
 * Completed: December, 2020
 * Purpose: HashMap Implementation for Employee Salaries in Different Cash Brackets
 * Complexity: Insert, Delete, and Search - O(1) in HashMaps
*/

import java.io.File;
import java.util.Scanner;

public class HashMapDriver {
    public static void main(String[] args) throws Exception {
        //1 - Request and Read User Input
        System.out.print("Enter The Number of Salary Brackets: ");
        Scanner scl = new Scanner(System.in);
        int numBrackets = scl.nextInt();

        HashMap hm = new HashMap(numBrackets);

        //2 - Read Employees File, Insert Key-Value Pairs into Right Bracket of HashMap
        Scanner sf = new Scanner(new File("Practice/Employees.txt"));	
        
        // Store Min and Max Salaries
        int min = sf.nextInt();
        int max = sf.nextInt();

        // Calculate Range of Salaries
        int bracketWidth = (max - min)/numBrackets;

        // Insert All Ids and Salaries into HashMap in Correct Bracket
        while(sf.hasNextLine()) {
            int id = sf.nextInt();
            int salary = sf.nextInt();

            //Calcualte Proper Bracket 
            int bracket = findBracket(min, bracketWidth, numBrackets, salary);

            //Insert Person into Bracket in HashMap
            hm.put(bracket, id, salary);
        }

        //3 - Test and Add More Employees to HashMap
        String ans;
        do {
            System.out.print("Want to Enter a New Employee? (Y for Yes, N for No): ");
            scl = new Scanner(System.in);
            ans = scl.nextLine();

            if(!ans.contains("Y")) {
                System.out.println("Thank You!");
            } else {
                System.out.print("Enter a New Employee (Id Salary):" );
                scl = new Scanner(System.in);
                int newId = scl.nextInt();
                int newSalary = scl.nextInt();

                //Testing Find Bracket Method - CHECK
                int newBracket = findBracket(min, bracketWidth, numBrackets, newSalary);
                System.out.println("Employee Bracket: " + newBracket + "\n");

                //Testing Put Function - CHECK
                hm.put(newBracket, newId, newSalary);

                //Testing Get Function - CHECK
                int valueFound = hm.getValue(newBracket, newId);
                if(valueFound != -1)
                    System.out.println("SUCCESS: Salary Of " + valueFound + "$ Added!\n");
            }
        } while(ans.contains("Y"));

        
        //HashMaps Are Working - CHECK

        //Print HashMaps Per Bracket - Check That Employees Were Added to Correct Bracket
        //hm.printHm();

        //Additional Test Cases
        int i = 733, s = 52000;
        int b = findBracket(min, bracketWidth, numBrackets, s);
        hm.put(b, i, s);

        System.out.println(hm.getValue(b, i) > 0 ? "SUCCESS" : "FAIL");

        i = 655; s = 43000;
        b = findBracket(min, bracketWidth, numBrackets, s);
        hm.put(b, i, s);

        System.out.println(hm.getValue(b, i) > 0 ? "SUCCESS" : "FAIL");

        i = 505; s = 74000;
        b = findBracket(min, bracketWidth, numBrackets, s);
        hm.put(b, i, s);

        System.out.println(hm.getValue(b, i) > 0 ? "SUCCESS" : "FAIL");

        scl.close();
    }

    //Calculate The Bracket To Insert the Employee Into
    public static int findBracket(int min, int bracketWidth, int numBrackets, int salary) {
        int bracket = 0;
        int currBracket = min;
    
        while(currBracket + bracketWidth < salary && bracket < numBrackets - 1)
            currBracket = min + (++bracket)*bracketWidth;

        return bracket;
    }
}
