/*
 * heapDriver.java
 * Author: Nicholas Kawwas
 * Completed: November, 2020
 * Purpose: Implemented a Double Ended (Max/Min) Priority Queue
 * Complexity: O(log(n)) Insert and Delete Max/Min, O(1) Find Max/Min
*/

public class heapDriver {
    public static void main(String[] args) {
        MaxMinPQ<Integer> dHeap = new MaxMinPQ<>(10);

        dHeap.insert(5);
        dHeap.insert(3);
        dHeap.insert(8);
        dHeap.insert(6);
        dHeap.insert(1);
        dHeap.insert(10);
        dHeap.insert(0);
        
        dHeap.printHeaps();

        System.out.println("\nMax: " + dHeap.findMax()); 
        dHeap.delMax();

        System.out.println("Max: " + dHeap.findMax()); 
        dHeap.delMax();

        dHeap.printHeaps();      
        
        System.out.println("\nMin: " + dHeap.findMin()); 
        dHeap.delMin();

        System.out.println("Min: " + dHeap.findMin()); 
        dHeap.delMin();

        dHeap.printHeaps();  
    }
}
