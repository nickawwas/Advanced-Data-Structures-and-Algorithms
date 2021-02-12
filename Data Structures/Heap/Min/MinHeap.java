/*
 * MinHeap.java
 * Author: Nicholas Kawwas
 * Completed: November, 2020
 * Purpose: Implemented a Min Priority Queue 
 * Complexity: O(log(n)) Insert and Delete Min, O(1) Find Min
*/

public class MinHeap <Key extends Comparable <Key>> {
    private Key[] pqMin;
    private int size;
    private int maxSize;
    
    //Base Constructor - Create an Empty Priority Queue
    public MinHeap(int s) {
        pqMin = (Key[]) new Comparable[s + 1];
        size = 0;
        maxSize = s;
    }

    public boolean isEmpty() {
        return size == 0;
    }   

    //Insert Key to the Bottom and Find Position by Swimming
    public void insert(Key k) {
        if(size + 1 >=  maxSize) {
            System.out.println("You reached the end of the heap!");
            return;
        }

        pqMin[++size] = k;
        swim(size);
    }

    //Delete Min (Current Root)
    public Key delMin() {
        Key root = pqMin[1];

        swap(1, size--);
        sink(1);

        pqMin[size++] = null;

        return root;
    }

   //Promotion of Key, Moving Key Upward
   private void swim(int n) {
        int currElement = n;
        int currParent = n/2;

        while(currElement > 1 && isLess(currElement, currParent)){
            //Swap n and Parent Up
            swap(currElement, currParent);

            //Move on to Next Parent
            currElement = currParent;
            currParent /= 2;
        }
    }

    //Demotion of Key, Moving Key Down
    private void sink(int n) {
        int currChild = 2*n;
        while(currChild <= size) {
            int nextChild = 2*n;
            
            //Checks Whether to Go Left or Right
            if(nextChild < size && isLess(nextChild, nextChild + 1))
                nextChild++;
            
            //Exist if Out of Range
            if(!isLess(nextChild, n))
                break;
            
            //Swap n and Child Down
            swap(n, nextChild);

            //Move on to Next Children
            currChild = 2*nextChild;
        }
    }

    //Checks if n1 isLess than n2
    private boolean isLess(int n1, int n2) {
        return pqMin[n1].compareTo(pqMin[n2]) < 0;
    }

    //Swaps n1 and n2
    private void swap(int n1, int n2) {
        Key temp = pqMin[n1];
        pqMin[n1] = pqMin[n2];
        pqMin[n2] = temp;
    }
}
