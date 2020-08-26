/*
 * DecToBin.java
 * Author: Nicholas Kawwas
 * Completed: August, 2018
 * Purpose: Converts from Decimal to Binary
*/

package GenStackInterface;

import java.util.ArrayList;
import java.util.Scanner;

public class DecToBin {
	public static void main(String[] args) {
		//Creates AdvCSStack ArrayList
		AdvCSStack<Integer> stacked = new AdvCSStack<Integer>(); 
		System.out.println("Enter an integer: ");
		
		//Scanning the integer input
		Scanner scan = new Scanner(System.in); 
		int enteredB = scan.nextInt(); 
		
		//If the integer is not zero, continue adding elements to the ArrayList stacked
		while(enteredB != 0){ 
			 //If the remainder is 0, then add zero
			if(enteredB % 2 == 0){
				stacked.push(0);
				 //Divided the integer by two to continue the process of binary conversion 
				enteredB = enteredB/2;
			}
			else {
				//If the remainder isn't zero (meaning it's 1), then add one
				stacked.push(1); 
				enteredB = enteredB/2;
			}	
		}
		//If stack is not empty, the stack is popped 
		while(!stacked.isEmpty()){ 
		//stack.isEmpty is false since there are elements in the stack, so I added ! to make it true	
			System.out.print(stacked.pop());
		}
	}	
}
