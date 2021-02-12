/*
 * MaxMinPQ.java
 * Author: Nicholas Kawwas
 * Completed: November, 2020
 * Purpose: Implemented a Double Ended (Max/Min) Priority Queue
 * Complexity: O(log(n)) Insert and Delete Max/Min, O(1) Find Max/Min
*/

public class MaxMinPQ <Key extends Comparable <Key>> {
    private Key[] pqMax, pqMin;
    private int curSizeMax, curSizeMin;
    private int maxSize;
    
    //Base Constructor - Create Empty Max and Min Priority Queues
    public MaxMinPQ(int s) {
        pqMax = (Key[]) new Comparable[s + 1];
        pqMin = (Key[]) new Comparable[s + 1];
        curSizeMax = curSizeMin = 0;
        maxSize = s;
    } 

    //Max/Min Heap Insert Key to the Bottom and Find Position by Swimming
    public void insert(Key k) {
        if(curSizeMax + 1 >  maxSize || curSizeMin + 1 >  maxSize) {
            System.out.println("You reached the end of the heap!");
            return;
        }

        pqMax[++curSizeMax] = pqMin[++curSizeMin] = k;
        
        swimMax(curSizeMax);
        swimMin(curSizeMin);
    }

    //Returns Max Key
    public Key findMax() {
        return pqMax[1];
    }

    //Returns Max Key
     public Key findMin() {
        return pqMin[1];
    }

    //Delete Max (Current Root)
    public Key delMax() {
        Key max = findMax();

        swap(pqMax, 1, curSizeMax--);
        sinkMax(1);

        pqMax[curSizeMax + 1] = null;

        return max;
    }

    //Delete Min (Current Root)
    public Key delMin() {
        Key min = findMin();

        swap(pqMin, 1, curSizeMin--);
        sinkMin(1);

        pqMin[curSizeMin + 1] = null;

        return min;
    }

   //Promotion of Key, Moving Key Upward for Max Heap
   private void swimMax(int n) {
       int currElement = n;
       int currParent = n/2;

       //Max Heap
        while(currElement > 1 && isLess(pqMax, currParent, currElement)){
            //Swap n and Parent Up
            swap(pqMax, currElement, currParent);

            //Move on to Next Parent
            currElement = currParent;
            currParent /= 2;
        }
    }

    //Demotion of Key, Moving Key Down for Max Heap
    private void sinkMax(int n) {
        int currChild = n, currParent = 2*n;
        while(currParent <= curSizeMax) {
            int nextChild = currParent;
            
            //Checks Whether to Go Left or Right
            if(nextChild < curSizeMax && isLess(pqMax, nextChild, nextChild + 1))
                nextChild++;
            
            //Exist if Out of Range
            if(!isLess(pqMax, currChild, nextChild))
                break;
            
            //Swap n and Child Down
            swap(pqMax, currChild, nextChild);

            //Move on to Next Children
            currChild = nextChild;
            currParent = 2*currChild;
        }
    }

    //Promotion of Key, Moving Key Upward for Min Heap
    private void swimMin(int n) {
    int currElement = n;
    int currParent = n/2;

    //Min Heap
     while(currElement > 1 && isLess(pqMin, currElement, currParent)){
         //Swap n and Parent Up
         swap(pqMin, currElement, currParent);

         //Move on to Next Parent
         currElement = currParent;
         currParent /= 2;
     }
 }

    //Demotion of Key, Moving Key Down for Min Heap
    private void sinkMin(int n) {
        int currChild = n, currParent = 2*n;
        while(currParent <= curSizeMin) {
            int nextChild = currParent;
            
            //Checks Whether to Go Left or Right
            if(nextChild < curSizeMin && isLess(pqMin, nextChild + 1, nextChild))
                nextChild++;
            
            //Exit if Position Found
            if(!isLess(pqMin, nextChild, currChild))
                break;
            
            //Swap n and Child Down
            swap(pqMin, currChild, nextChild);

            //Move on to Next Children
            currChild = nextChild;
            currParent = 2*currChild;
        }
    }

    //Checks if n1 isLess than n2
    private boolean isLess(Key[] heap, int n1, int n2) {
        return heap[n1].compareTo(heap[n2]) < 0;
    }

    //Swaps n1 and n2
    private void swap(Key[] heap, int n1, int n2) {
        Key temp = heap[n1];
        heap[n1] = heap[n2];
        heap[n2] = temp;
    }

    //Prints Contents of Max and Min Heaps
    public void printHeaps() {
        System.out.println("\nMin Heap: ");
        for(Key min : pqMin)
            System.out.print(min + " ");

        System.out.println("\nMax Heap: ");
        for(Key max : pqMax)
            System.out.print(max + " ");

        System.out.println();
    }

}
