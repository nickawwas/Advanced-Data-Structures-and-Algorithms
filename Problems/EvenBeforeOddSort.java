/*
 * EvenBeforeOddSort.java
 * Author: Nicholas Kawwas
 * Completed: November, 2020
 * Purpose:Rearrange All Even Before Odd
*/

public class EvenBeforeOddSort {
	public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        
        evenOddSort(arr, 0, arr.length - 1);

        for(int i: arr) {
            System.out.print(i + " ");
        }
	}
	
	public static void evenOddSort(int[] a, int l, int h) {
        //Base Case
        if(l >= h)
            return;
        //Odd Numbers
        else if(a[l] % 2 != 0) {
            int tmp = a[h];
            a[h] = a[l];
            a[l] = tmp;
            evenOddSort(a, l, h - 1);
        //Even Numbers
        } else {
            evenOddSort(a, l + 1, h);
        }
	}
}