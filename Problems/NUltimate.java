/*
 * NUltimate.java
 * Author: Nicholas Kawwas
 * Completed: September, 2018
 * Purpose: NUltimate Problem
*/

package GenStackInterface;

import java.io.File;
import java.util.Scanner;
import java.util.Stack;

public class NUltimate {
	public static void main(String[] args) throws Exception {
		Scanner scanF = new Scanner(new File("src/nUlt.txt"));
		
		while(scanF.hasNextLine()){
			Stack<String> stacked = new Stack<String>();
			int scanNum = scanF.nextInt();
			if (scanNum == 0)
				break;
			String scanStr = scanF.next();
			while (!scanStr.equals("$")) {
				stacked.push(scanStr);
				scanStr = scanF.next();
			}
			
			for(int j = 0; j < (scanNum-1); j++)
				stacked.pop();
				   
			System.out.println(stacked.peek()); 
		}
		scanF.close();
	} 
}
