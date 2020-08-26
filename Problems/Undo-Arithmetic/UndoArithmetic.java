/*
 * UndoArithmetic.java
 * Author: Nicholas Kawwas
 * Completed: August, 2018
 * Purpose: Undo Arithmetic Problem
*/

package GenStackInterface;

import java.util.Stack;
import java.io.File;
import java.util.Scanner;

public class UndoArithmetic {
	public static void main(String[] args) throws Exception {
		Stack<Double> stacked = new Stack<Double>();
		Scanner scanF = new Scanner(new File("src/UndoArithmetic.txt"));
		double scanDouble = 0, mD;
		
		while(scanF.hasNextLine()){
			String scanStr = scanF.nextLine();
			if(scanStr.contains("UNDO")){
				stacked.pop();
				scanStr = "UNDO";
				scanDouble = stacked.peek();
			}
			else {
				mD = Double.parseDouble(scanStr.substring(2));
				if (scanStr.contains("*"))
					scanDouble *= mD;
				else if(scanStr.contains("/"))
					scanDouble /= mD;
				else if(scanStr.contains("+"))
					scanDouble += mD;
				else if(scanStr.contains("-"))
					scanDouble -= mD;
				else
					scanDouble = Double.parseDouble(scanStr);
				stacked.push(scanDouble);	
			}	
			System.out.println(scanStr + "\t" + stacked.peek());
		}
	}	
} 
