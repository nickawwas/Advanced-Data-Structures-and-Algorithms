/*
 * TimeQuickSort.java
 * Author: Nicholas Kawwas
 * Completed: November, 2020
 * Purpose: Implemented Quicksort using Comparable Class
*/

import java.util.Scanner; 

public class TimeQuickSort {
    public static void main(String[] args) {
        Scanner scl = new Scanner(System.in);

		System.out.println("Enter Array Size (N): ");
		int n = scl.nextInt();
        
		Time[] tms = new Time[n];
        
        //Random Time Generator
        Time temp = new Time();
        for(int i = 0; i < n; i++)
            tms[i] = temp.randTime();
        
        //Quick Sort Times Array
        quickSort(tms, 0, n - 1);

        //Print Times Array
        printed(tms);
    

        //Checks for Distinct Times
        distinctTimes(tms, n);

        scl.close();
    }

    //Print Time Array Contents
    public static void printed(Time[] arr) {
        System.out.println("Times Array:");

        for(Time t: arr)
            System.out.println(t.getHour() + ":" +  t.getMin() + ":" + t.getSec());
    }
    

    //Quick Sort Algorithm
    public static void quickSort(Time[] a, int l, int h) {
        if(h <= l)
            return;
        
        int p = partition(a, l, h);

        quickSort(a, l , p - 1);
        quickSort(a, p + 1, h);
    }

    //Partitions Array into Smaller and Greater Halves
	public static int partition(Time[] a, int l, int h) {
        int i = l, j = h + 1;

        while(j > i) {
            //Move Left if Smaller
            while(a[++i].compareTo(a[l]) < 0)
                //Exit If End is Reached
                if(i == h)
                    break;
            
            //Move Right if Larger
            while(a[l].compareTo(a[--j]) < 0)
                //Exit If Beginning is Reached
                if(j == l)
                    break;

            //Swap j and i
            if(j > i) {
                Time tmp = a[j];
                a[j] = a[i];
                a[i] = tmp;
            }
        }
        
        //Swap j with partition
        Time tmp = a[j];
        a[j] = a[l];
        a[l] = tmp;

        return j;
    }

    //Checks if Duplicate Times are Present
    public static void distinctTimes(Time[] a, int n) {
        for(int i = 1; i < n; i++)
            if(a[i - 1].compareTo(a[i]) == 0) {
                System.out.println("Times are NOT all Distinct");
                return;
            }
        
        System.out.println("Times are ALL Distinct");
    }
}