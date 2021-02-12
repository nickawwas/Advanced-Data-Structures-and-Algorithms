/*
 * mergeSort.java
 * Author: Nicholas Kawwas
 * Completed: November, 2020
 * Purpose: Merge Sort w/ Sublinear Extra Space + Selection Sort
*/

public class mergeSort {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 1, 9, 12, 2, 4, 6, 3, 7, 10, 14, 0};
    
        int M = 5;
        int N = arr.length;

        int block = 0;
        while(block < N/M) {
            selectionSort(arr, block*M, (block + 1)*M - 1);
            block++;
        }

        printed(arr);

        int[] tmp = new int[N];
        sort(arr, tmp, N, M);

        printed(arr);
    }

    //Print Array Contents
    public static void printed(int[] arr) {
        for(int i: arr)
            System.out.print(i + " ");
        
        System.out.println();
    }
    
    //Call to Merge Selection Sorted Blocks
    public static void sort(int[] a, int[] tmp, int N, int M) {
        int currBlock = 1, numBlocks = N/M;

        while(currBlock < numBlocks) {
            merge(a, tmp, 0, currBlock*M, (currBlock + 1)*M);
            currBlock++;
        }
    }

	public static void merge(int[] a, int[] tmp, int l, int m, int h) {
        //Copy into Aux
        for(int i = l; i < h; i++) {
            tmp[i] = a[i];
        }

        //Merge Part
        int leftS = l, rightS = m;
        for(int j = l; j < h; j++) {
            //Finished first block, Take from second block
            if(leftS >= m) {
                a[j] = tmp[rightS++];
            //Finished second block, Take from first block
            } else if (rightS >= h) {
                a[j] = tmp[leftS++];
            //Compare both, Take smaller element
            } else if (tmp[rightS] < tmp[leftS]) {
                a[j] = tmp[rightS++];
            } else {
                a[j] = tmp[leftS++];
            }
        }   
    }
    
    //Selection Sort Alg
    public static void selectionSort(int[] a, int start, int end) {
        for(int i = start; i < end; i++){
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