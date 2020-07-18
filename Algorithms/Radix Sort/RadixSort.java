/*
 * RadixSort.java
 * Author: Nicholas Kawwas
 * Completed: September, 2018
 * Purpose: Radix Sort Implementation
*/

import java.util.Scanner;
import java.io.File;

public class RadixSort {
	private static AdvCSLL<Integer>[] arrLL; 

	public static void main(String[] args) throws Exception{
		Scanner scanF = new Scanner(new File("src/radixInput.txt"));
			
		while(scanF.hasNextLine()){
			//Sets size by reading first integer of line
			int arrSize = scanF.nextInt();
		    int arr[] = new int[arrSize];
		 
		    //Reads from file and creates the array 
		    for(int i = 0; i < arrSize; i++)
		      arr[i] = scanF.nextInt();
		 
		    //Sorts the list using radixS method
		    arr = radixS(arr);
		 
		    //Prints the sorted list
		    for(int i = 0; i < arr.length; i++)
		      System.out.print(arr[i] + " ");
		    System.out.println();
		}   	
	}
	
	@SuppressWarnings("unchecked")
	public static int[] radixS(int arr[]){
		String times = "" + arr[1];
		int divP = 1; int modP = 10; 

		//Instantiates the Array of Linked Lists
		arrLL = new AdvCSLL[10]; 
		for(int i = 0; i < 10; i++)
			arrLL[i] = new AdvCSLL<Integer>();
		
		//Sorting Process: 
		for(int i = 0; i < times.length(); i++){
			//Separates arr into buckets by finding 1s, then 10s, and so on
			for(int d = 0; d < arr.length; d++){
				int bucket = arr[d] % modP;
				bucket /= divP;
				arrLL[bucket].add(arr[d]);
			}
			int counter = 0;
			//Places back into arr the numbers from each bucket
			for(int pb = 0; pb < arrLL.length; pb++){
				while(!arrLL[pb].isEmpty()){
					arr[counter] = arrLL[pb].removeFirst();
					counter++;
				}	
			}	
			modP *= 10; divP *= 10;
		}	
		return arr;
	}	
}
