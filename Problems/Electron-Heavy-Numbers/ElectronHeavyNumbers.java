/*
 * ElectronHeavyNumbers.java
 * Author: Nicholas Kawwas
 * Completed: September, 2018
 * Purpose: Electron Heavy Numbers Problem
*/

package codeWars;

import java.io.File;
import java.util.Scanner;

public class ElectronHeavyNumbers {
	public static void main(String[] args) throws Exception {
		Scanner scanF = new Scanner(new File("src/electronHeavy.txt"));
		
		while(scanF.hasNextLine()){
			int countZ = 0; 
			int countO = 0; 
			
			int scanInt = scanF.nextInt();
			
			if(scanInt != 0){
				System.out.print(scanInt + " ");
		
				while(scanInt != 0){
					if(scanInt % 2 == 0)
						countZ++;
					else if(scanInt % 2 == 1)
						countO++;
					scanInt /= 2;
				}
				
				if(countZ > countO)
					System.out.println("LIGHT");
				else if(countZ < countO)
					System.out.println("HEAVY");
				else
					System.out.println("BALANCED");
			}
		}
	}
}
