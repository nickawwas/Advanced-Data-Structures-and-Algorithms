/*
 * selectionSort.java
 * Author: Nicholas Kawwas
 * Completed: November, 2020
 * Purpose: Implemented Selection Sort
*/

public class selectionSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 1, 9, 12, 2, 4, 6, 3, 7, 10 };
    
        selectionSorting(arr);

        printed(arr);
    }
    
    public static void printed(int[] arr) {
        for(int i: arr)
            System.out.print(i + " ");
        
        System.out.println();
    }
	
    //Selection Sort Alg
    public static void selectionSorting(int[] a) {
        for(int i = 0; i < a.length; i++){
            int min = a[i], swap = i;
            for(int j = i; j < a.length; j++)
                if(a[j] < min) {
                    min = a[j];
                    swap = j;
                }

            int temp = a[swap];   
            a[swap] = a[i];
            a[i] = temp;
        }
    }
    
}