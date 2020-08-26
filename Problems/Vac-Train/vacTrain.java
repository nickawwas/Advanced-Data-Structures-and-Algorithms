/*
 * vacTrain.java
 * Author: Nicholas Kawwas
 * Completed: March, 2019
 * Purpose: Vac Train Problem
 */
 
import java.io.File;
import java.util.Stack;
import java.util.Scanner;
import java.util.ArrayDeque;

public class vacTrain {
	public static void main(String[] args) throws Exception {
		Scanner scanFC = new Scanner(new File("src/vacTrainPacking.txt"));
		
		int vacCount = 0;
		Stack<String> vacA = new Stack<String>();
		Stack<String> vacB = new Stack<String>();
		Stack<String> vacC = new Stack<String>();
 		ArrayDeque<String> wareHouse = new ArrayDeque<String>();
 		
		while(scanFC.hasNextLine()) {
			String fs = scanFC.nextLine();
			Scanner ls = new Scanner(fs);
			String lsN = ls.next();
			
			if(lsN.equals("RECV"))
				wareHouse.add(ls.next() + " " + ls.next());
			else if(lsN.equals("LOAD")) {
				String lsDouble = ls.next();
				
				if(lsDouble.equals("A"))
					vacA.add(wareHouse.poll());
				else if(lsDouble.equals("B"))
					vacB.add(wareHouse.poll());
				else
					vacC.add(wareHouse.poll());
			} else if(lsN.equals("XFER")) {
				String lsSingle = ls.next();
				
				if(lsSingle.equals("A"))
					if(ls.next().equals("B"))
						vacB.add(vacA.pop());
					else 
						vacC.add(vacA.pop());
				else if(lsSingle.equals("B"))
					if(ls.next().equals("A"))
						vacA.add(vacB.pop());	
					else
						vacC.add(vacB.pop());
				else
					if(ls.next().equals("A")) 
						vacA.add(vacC.pop());	
					else
						vacB.add(vacC.pop());	
			} else if(lsN.equals("SEND")) {
				String lsSingle = ls.next();
				
				vacCount++;
				System.out.println("VACTRAIN " + vacCount);
				
				if(lsSingle.equals("A")) 
					while(!vacA.isEmpty())
						System.out.println(vacA.pop());
				else if(lsSingle.equals("B")) 
					while(!vacB.isEmpty())
						System.out.println(vacB.pop());
				else 
					while(!vacC.isEmpty())
						System.out.println(vacC.pop());
			}
		}
	}	
}
