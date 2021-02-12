/*
 * algorithms.java
 * Author: Nicholas Kawwas
 * Completed: December, 2020
 * Purpose: Implemented Many Sorting, Searching, and Shuffling Algorithms
*/

import java.util.*;

public class algorithms {
    //Main Tester Program 
    public static void main(String[] args) {
        int arr[] = {1, 4, 6, 8, 0, 2, 4, 10, 13};
        // selectionSort(arr);
        // insertionSort(arr);
        // shellSort(arr);
        // mergeSort(arr);
        // quickSort(arr, 0, arr.length - 1);

        //int found = binarySearch(arr, 0, arr.length - 1, 13);
        //shuffle(arr);

        printArray(arr);
    }

    //Print Array 
    public static void printArray(int[] arr) {
        for(int i: arr)
            System.out.print(i + " ");

        System.out.println();
    }

    // Recursive Binary Search - O(logn)
    public static int binarySearch(int[] arr, int low, int high, int n) {
        if(low <= high) {
            int mid = low + (high - low)/2;
                
            if(arr[mid] < n)
                return binarySearch(arr, mid + 1, high, n);
            else if(arr[mid] > n)
                return binarySearch(arr, low, mid - 1, n);
            else
                return mid;
        }

        return -1;
    }

    // Selection Sort - O(n^2)
    public static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int min = i;
            for(int j = i + 1; j < arr.length; j++)
                if(arr[j] < arr[min])
                    min = j;

            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

    // Insertion Sort - O(n^2) , Better than Selection Sort
    public static void insertionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++)
            for(int j = i; j > 0; j--)
                if(arr[j] < arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                } else
                    break;       
    }

    // Shell Sort - O(n^3/2) , Improved Insertion Sort
    public static void shellSort(int[] arr) {
        //Find h using 3x + 1
        int h = 1;
        while(h < arr.length/3)
            h = 3*h + 1; 
        
        //H - Sort
        while(h >= 1) {
            for(int i = h; i < arr.length; i++)
                for(int j = i; j >= h; j -= h) {
                    if(arr[j] >= arr[j - h])
                        break;
                
                    int temp = arr[j];
                    arr[j] = arr[j - h];
                    arr[j - h] = temp;
                    //printArray(arr);
                }

            h /= 3;
        }   
    }

    // Knuth Shuffle 
    public static void shuffle(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            //Select Random Index to Swap With
            int newIndex = (int)Math.random()*(i + 1);

            //Shuffle
            int temp = arr[newIndex];
            arr[newIndex] = arr[i];
            arr[i] = temp;
        }
    }

    // Merge Sort - Time: O(logn) , Space: O(n)
    public static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length];

        sort(arr, tmp, 0, arr.length - 1);
    }

    public static void merge(int[] arr, int[] tmp, int l, int m, int h) {
        //Copy into Temp Array
        for(int i = l; i <= h; i++)
            tmp[i] = arr[i];

        //Merge Code
        int leftS = l, rightS = m + 1;
        for(int j = l; j <= h; j++) {
            //Finished left subarray, Take from right
            if(leftS > m) {
                arr[j] = tmp[rightS++];
            //Finished right subarray, Take from left
            } else if (rightS > h) {
                arr[j] = tmp[leftS++];
            //Compare both, Take smaller element
            } else if (tmp[rightS] < tmp[leftS]) {
                arr[j] = tmp[rightS++];
            } else {
                arr[j] = tmp[leftS++];
            }
        }   
    }
    
    //Recursive Call to Sort
    public static void sort(int[] a, int[] tmp, int l, int h) {
        if(h <= l)
            return;
        
        int m = (l + h)/2;
        sort(a, tmp, l , m);
        sort(a, tmp, m + 1, h);

        merge(a, tmp, l, m, h);
    }


    //Quicksort - Time: O(nlogn)
    public static void quickSort(int[] a, int l, int h) {
        if(h <= l)
            return;
        
        int p = partition(a, l, h);

        quickSort(a, l , p - 1);
        quickSort(a, p + 1, h);
    }

    //Partitions Array into Smaller and Greater Halves
	public static int partition(int[] a, int l, int h) {
        int i = l, j = h + 1;

        while(j > i) {
            //Move Left if Smaller
            while(a[++i] < a[l])
                //Exit If End is Reached
                if(i == h)
                    break;
            
            //Move Right if Larger
            while(a[l] < a[--j])
                //Exit If Beginning is Reached
                if(j == l)
                    break;

            //Swap j and i
            if(j > i) {
                int tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
            }
        }
        
        //Swap j with partition
        int temp = a[j];
        a[j] = a[l];
        a[l] = temp;

        return j;
    }

    //Dijkstra 3 Way Parititioning Quicksort - For Few Unique, Multiple Duplicate Keys
    public static void quickSort3Way(int[] a, int l, int h) {
        if(h <= l)
            return;
        
        //Three Way Partition
        int i = l, lp = l, hp = h;

        //Pivot
        int v = a[l];

        while(i <= hp) {
            //Smaller - Swap to Lower 
            if(a[i] < v) {
                int temp = a[i];
                a[i] = a[lp];
                a[lp] = temp;

                i++;
                lp++;
            //Larger - Swap to Back
            } else if(a[i] >  v) {
                int tmp = a[i];
                a[i] = a[hp];
                a[hp] = tmp;
                
                hp--;
            }
            //Equal - Increment Pointer
            else
                i++;
        }

        quickSort3Way(a, l , lp - 1);
        quickSort3Way(a, hp + 1, h);
    }

    //Dual Pivot Quicksort - Partition into 3 Sub Arrays to Recursively Sort
    public static void dualPivotQuickSort(int[] a, int l, int h) {
        if(h <= l)
            return;
        
        //Swap P & Q to Make P Smaller Than Q
        if(a[h] > a[l]) {
            int temp = a[l];
            a[l] = a[h];
            a[h] = temp;
        }

        //Dual Pivots
        int p = a[l], q = a[h];

        //Three Way Partition
        int i = l, lp = l, hp = h;
        
        while(i <= hp) {
            //Smaller Than Pivot 1 - Swap to Lower 
            if(a[i] < p) {
                int temp = a[i];
                a[i] = a[lp];
                a[lp] = temp;

                i++;
                lp++;
            //Larger Than Pivot 2 - Swap to Back
            } else if(a[i] >  q) {
                int tmp = a[i];
                a[i] = a[hp];
                a[hp] = tmp;
                
                hp--;
            }
            //Equal - Increment Pointer
            else
                i++;
        }

        //Swap l and lp
        int tmp = a[l];
        a[l] = a[--lp];
        a[lp] = tmp;

        //Swap h and hp
        tmp = a[h];        
        a[h] = a[++hp];
        a[hp] = tmp;

        //Sort Smaller Than P
        quickSort3Way(a, l , lp - 1);
        //Sort In Between P and Q
        quickSort3Way(a, lp + 1, hp - 1);
        //Sort Larger Than Q
        quickSort3Way(a, hp + 1, h);
    }

    //Quick Select - Find Kth Smallest Element in Unsorted Array, Time: O(n)
    public static int quickSelect(int[] a, int k) { 
        int l = 0, h = a.length - 1;

        while(h < l) {
            //Index of Partition
            int p = partition(a, l, h);

            if(p < k) 
                l = p + 1;
            else if(p > k)
                h = p - 1;
            else
                return a[k];
        }

        return a[k];
    }

    // NEED TO FINISH HEAP SORT, DFS, BFS
    
    //Heap Sort - Sort Max or Min Priority Queue, Time: O(nlogn)
    public static void heapSort(int[] a) { 
        int n = a.length;

        //Build Heap Bottom Up
        for(int k = n/2; k >= 1; k--)
            //sink(a, k, n);
        
        //Remove Max One By One
        while(n > 1) {
            int temp = a[1];
            a[1] = a[n];
            a[n] = temp;
            sink(a, --n);
            //sink(a, 1, --n);
        }

    }

    //Demotion of Key, Moving Key Down
    public static void sink(int[] a, int n) {
        int currChild = 2*n;
        while(currChild <= a.length) {
            int nextChild = 2*n;
            
            //Checks Whether to Go Left or Right
            if(nextChild < a.length && a[nextChild + 1] < a[nextChild])
                nextChild++;
            
            //Exist if Out of Range
            if(a[n] >= a[nextChild])
                break;
            
            //Swap n and Child Down
            int tmp = a[n];
            a[n] = a[nextChild];
            a[nextChild] = tmp;

            //Move on to Next Children
            currChild = 2*nextChild;
        }
    }

    //DFS - Graph Traversal
    public static void depthFirstSearch(int start) {
        //Uses Stack
        //Visit Vertex V
        //Recursively Visit All Unmarked Adjacent to V 
    }

    //BFS - Graph Traversal
    public static void breadthFirstSearch(int start) {
        //Uses Queue
        //Visit Vertex V
        //Recursively Visit All Unmarked Adjacent to V 
    }

    //Data Structures
    //- Stack
    //- Queue
    //- Linked List
    //- Priority Queue - Binary Heaps
    //- Binary Tree
    //- 2-3 BST
    //- Black Red Trees
    //- Hash Table - Seperate Chaining and Linear Probing
    //- Undirect & Directed Graphs - BST and DST
}
