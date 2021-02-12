/*
 * Dijkstra2Stacks.java
 * Author: Nicholas Kawwas
 * Completed: October, 2020
 * Purpose: Implemented Dijkstra's Two Stack Algorithm
*/

import java.util.*;
import java.io.File;
import java.util.Scanner; 

public class Dijkstra2Stacks {
	public static void main(String[] args) throws Exception {
		Scanner scanF = new Scanner(new File("src/d2s.txt"));	
		
		String symb = "*/+-";
		Stack<String> symbols = new Stack<String>();
		Stack<String> numbers = new Stack<String>();
		
		//Using Dijkstra's Two Stack Algorithm
		while(scanF.hasNext()) {
			String current = scanF.next();
			
			//Pushes Numbers into Numbers Stack
			if(Character.isDigit(current.charAt(0))) {
				numbers.push(current);
			//Pushes Symbols into Symbols Stack
			} else if(symb.contains(current)) {
				symbols.push(current);
			//Adds Parentheses to Equation
			} else {
				String parensAdded = "(" + combined(numbers, symbols) + ")";
				numbers.push(parensAdded);
			}
		}
		
		//Combine Stacks To Fix Answer
		while(!symbols.isEmpty()) {
			String fixedEq = combined(numbers, symbols);
			numbers.push(fixedEq);
		}
		
		System.out.println(numbers.pop());	
		
		scanF.close();
	}
	
	public static String combined(Stack<String> num, Stack<String> sym) {
		String n2 = num.pop();
		String n1 = num.pop();
		String s = sym.pop();
		
		String comb = n1 + " " + s + " " + n2;
		return comb;
	}
}

//More Test Cases
//1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )
//1 + 2 * 3 - 4 ) * 5 - 6 ) 
//13 + 25000000 * 3000 - 41223 * 511 - 6 ) ) )
//13 + 25000000 * 3000 - 41223 * 511 - 6