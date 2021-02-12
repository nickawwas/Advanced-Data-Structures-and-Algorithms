/*
 * entropyOptimalSort.java
 * Author: Nicholas Kawwas
 * Completed: November, 2020
 * Purpose: Implemented a Bentley-Mcllroy Quick Sort + 3 Way Quick Sort + Visual Trace
*/

public class entropyOptimalSort {
    public static void main(String[] args) {
        char[] arr = {'B', 'A', 'B', 'A', 'B', 'A', 'B', 'A', 'C', 'A', 'D', 'A', 'B', 'R', 'A'};
        
        System.out.print("lp i hp        ");
        for(int i = 0; i < arr.length; i++)
            System.out.print(i + " ");
        System.out.println();

        quickSort(arr, 0, arr.length - 1);
    }
    
    //Entropy Optimal 3-Way Quick Sort + Visual Trace
    public static void quickSort(char[] a, int l, int h) {
        if(h <= l)
            return;
        
        //Three Way Partition
        int i = l, lp = l, hp = h;
        char v = a[l];

        while(i <= hp) {
             //Smaller - Swap to Lower 
            if(a[i] < v) {
                swap(a, i++, lp++);
            //Larger - Swap to Back
            } else if(a[i] >  v)
                swap(a, i, hp--);
            //Equal - Increment Pointer
            else
                i++;

            
            //Prints Trace of Quick Sort
            System.out.print(lp + " " + i + " " + hp + "    |    ");
            
            for(int k = 0; k < a.length; k++)
                //Low 
                if(k == lp || k == hp)
                    System.out.print("\033[0;32m" + a[k] + " " + "\033[0m");
                else if(k == i)
                    System.out.print("\033[0;31m" + a[k] + " " + "\033[0m");
                else
                    System.out.print("\033[0;37m" + a[k] + " " + "\033[0m");
                
            System.out.println();
        }

        quickSort(a, l , lp - 1);
        quickSort(a, hp + 1, h);
    }

    //Bentley McIlroy 3-Way Quick Sort
    public static void bmQuickSort(char[] a, int l, int h) {
        if(h <= l)
            return;
        
        //Three Way Partition w/ i, j, p, and q
        int i = l, j = h + 1;
        int p = l, q = h + 1;

        char v = a[l];
        while(i < j) {
            //Stop when Larger than Partition
            while(a[++i] < v)
                if(i == h) break;
            
            //Stop when Smaller than Partition
            while(a[--j] > v)
                if(j == l) break;

            if(j >= i) {
                //Swap i and j
                swap(a, i, j);
                
                //Swap with p if Equal
                if(a[i] == v)
                    swap(a, ++p, i);

                //Swap with q if Equal
                if(a[j] == v)
                    swap(a, --q, j);
            }
        }
        //Swaps Equal Items to Center
        //From Left to Center
        for(int k = l; k <= p; k++) 
            swap(a, k, j--);
        //From Right to Center
        for(int k = h; k >= q; k--) 
            swap(a, k, i++);

        bmQuickSort(a, l ,  j);
        bmQuickSort(a, i, h);
    }

    public static void swap(char[] a, int i, int j) {
        char temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
}