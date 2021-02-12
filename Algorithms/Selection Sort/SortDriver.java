/*
 * SortDriver.java
 * Author: Nicholas Kawwas
 * Completed: November, 2020
 * Purpose: Implemented Selection Sort on Data and Volume Objects Read from File
*/

import java.io.File;
import java.util.Scanner;

public class SortDriver{
    public static void main(String[] args) throws Exception {
        DateVolumeSort[] data = new DateVolumeSort[10];
        
        Scanner sf = new Scanner(new File("Ass3/DateVolume.txt"));	

        int curInd = 0;
        while(sf.hasNextLine()) {
            String d = sf.next();
            int v = sf.nextInt();

            data[curInd++] = new DateVolumeSort(d, v);
        }

        //printDV(data, curInd);

        sortByDate(data, curInd);
        sortByVolume(data, curInd);
        
        System.out.println("Sorted Dates and Volumes: ");
        
        printDV(data, curInd);
    }

    //Prints Data Volumes 
    public static void printDV(DateVolumeSort[] data, int curInd) {
        for(int i = 0; i < curInd; i++) {
            System.out.println(data[i].getFullDate() + " " + data[i].getVolume());
        }
    }

    //Selection Sort By Volume
    public static void sortByVolume(DateVolumeSort[] data, int curInd) {
        for(int i = 0; i < curInd; i++) {
            int swapIndex = i;
            for(int j = i; j < curInd; j++)
                if(compareVolume(data[j], data[swapIndex]) < 0)
                    swapIndex = j;
            
            swap(data, i, swapIndex);
        }
    }

    //Selection Sort By Date
    public static void sortByDate(DateVolumeSort[] data, int curInd) {
        for(int i = 0; i < curInd; i++) {
            int swapIndex = i;
            for(int j = i; j < curInd; j++)
                if(compareDate(data[j], data[swapIndex]) < 0)
                    swapIndex = j;
            
            swap(data, i, swapIndex);
        }
    }

    //Helps Sort by Date
    public static int compareDate(DateVolumeSort a, DateVolumeSort b) {
        //A > B Years
        if(a.getYear().compareTo(b.getYear()) > 0)
            return 1;
        //A Years = B Years
        else if(a.getYear().compareTo(b.getYear()) == 0) {
            //A > B Months
            if(a.getMonth().compareTo(b.getMonth()) > 0)
                return 1;
            //A Months = B Months
            else if(a.getMonth().compareTo(b.getMonth()) == 0) {
                //A > B Days
                if(a.getDate().compareTo(b.getDate()) > 0)
                    return 1;
                //A = B
                else if(a.getDate().compareTo(b.getDate()) == 0)
                    return 0;
            }
        }

        //B > A
        return -1;
    }

    //Helps Sort By Volume
    public static int compareVolume(DateVolumeSort a, DateVolumeSort b) {
        return a.getVolume() - b.getVolume();
    }

    //Swaps Values at i and j indices
    public static void swap(DateVolumeSort[] data, int a, int b) {
        DateVolumeSort tmp = data[a];
        data[a] = data[b];
        data[b] = tmp;
    }
}
