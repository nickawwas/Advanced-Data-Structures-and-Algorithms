/*
 * mergeSort.java
 * Author: Nicholas Kawwas
 * Completed: November, 2020
 * Purpose: Indirect Merge Sort
*/

public class indirectMergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 1, 9, 12, 2, 4, 6, 3, 7, 10 };
        int[] tmp = new int[arr.length];
        
        int[] perm = new int[arr.length];
        for(int i = 0; i < arr.length; i++)
            perm[i] = i;

        sort(arr, tmp, perm, 0, arr.length - 1);

        //Prints Indices of Sorted Array
        for(int i: perm)
            System.out.print(i + " ");

        System.out.println();

        //Prints Sorted Array Using Indices
        for(int i: perm)
            System.out.print(arr[i] + " ");
    }
	
	public static void merge(int[] arr, int[] tmp, int[] perm, int l, int m, int h) {
        //Copy into Temp Array
        for(int i = l; i <= h; i++) {
            tmp[i] = perm[i];
        }

        //Merge Code
        int leftS = l, rightS = m + 1;
        for(int j = l; j <= h; j++) {
            //Finished left subarray, Take from right
            if(leftS > m) {
                perm[j] = tmp[rightS++];
            //Finished right subarray, Take from left
            } else if (rightS > h) {
                perm[j] = tmp[leftS++];
            //Compare both, Take smaller element
            } else if (arr[tmp[rightS]] < arr[tmp[leftS]]) {
                perm[j] = tmp[rightS++];
            } else {
                perm[j] = tmp[leftS++];
            }
        }   
    }
    
    //Recursive Call to Sort
    public static void sort(int[] a, int[] tmp, int[] perm, int l, int h) {
        if(h <= l)
            return;
        
        int m = (l + h)/2;
        sort(a, tmp, perm, l , m);
        sort(a, tmp, perm, m + 1, h);
        merge(a, tmp, perm, l , m, h);
	}
}