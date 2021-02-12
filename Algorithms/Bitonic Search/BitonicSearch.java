/*
 * BitonicSearch.java
 * Author: Nicholas Kawwas
 * Completed: October, 2020
 * Purpose: Implemented Bitonic Search Using Binary Search
 * Complexity: O(logn) Time w/ ~ 3logn
*/

public class BitonicSearch {
	public static void main(String[] args) {
		int[] test = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		System.out.print(bitonic(test, 2));
	}
	
	public static boolean bitonic(int[] arr, int value) {
		int bp = bitonicPoint(arr, 0, arr.length - 1);		
		
		//If Greater Than Bp Automatically Doesn't Exist
		if(value <= arr[bp]) {
			int searchL = leftSide(arr, 0, bp, value);
			if(searchL != -1)
				return true;
			
			int searchR = rightSide(arr, bp + 1, arr.length - 1, value);
			if(searchR != - 1)
				return true;
		} 
		
		return false;
	}
	
	//Find Bitonic Point Starting from Center of Array
	public static int bitonicPoint(int[] arr, int l, int h) {
		if(l <= h) {
			int point = l + (h - l)/2;

			//Base Case: Found Bitonic Point
			if(arr[point - 1] < arr[point] && arr[point + 1] < arr[point])
				return point;
			//If Increasing, Move to Right
			else if(arr[point - 1] < arr[point] && arr[point + 1] > arr[point])
				return bitonicPoint(arr, point, h);
			//If Decreasing, Move to Left
			else
				return bitonicPoint(arr, l, point);
		}

		return -1;
	}	

	//Search Left Side for Value
	public static int leftSide(int[] arr, int l, int h, int value) {
		if(l <= h) {
			int currIndex = l + (h - l)/2;
			
			//Base: Doesn't Exist and Exists
			if(arr[currIndex] == value)
				return currIndex;
			//Binary Search On Left Side Recursively
			else if(arr[currIndex] > value)
				return leftSide(arr, l, currIndex - 1, value);
			else
				return leftSide(arr, currIndex + 1, h, value);
		}

		return -1;
	}

	//Search Right Side for Value
	public static int rightSide(int[] arr, int l, int h, int value) {
		if(l <= h) {
			int currIndex = l + (h - l)/2;

			//Base: Doesn't Exist and Exists
			if(arr[currIndex] == value)
				return currIndex;
			//Binary Search On Right Side Recursively
			else if(arr[currIndex] > value)
				return rightSide(arr, l, currIndex - 1, value);
			else
				return rightSide(arr, currIndex + 1, h, value);
		}

		return -1;
	}
}
