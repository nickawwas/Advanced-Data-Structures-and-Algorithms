/*
 * hashFunc.java
 * Author: Nicholas Kawwas
 * Completed: December, 2020
 * Purpose: Implemented Linear Probing to Deal With Collisions
*/

import java.util.*;
import java.util.Scanner;

public class hasher {
    public static void main(String[] args) {
        int arr[] = {32, 147, 265, 195, 207, 180, 21, 16, 189, 202, 91, 94, 162, 75, 37, 77, 81, 48};

        //Question 4 & 5
        HashSet<Integer> set = new HashSet<Integer>();

        int counter = 0, k = 13;
        for(int a: arr)
            if(set.contains(a % k))
                System.out.println("Collision Detected! #" + ++counter);
            else
                set.add(a % k); 
        
        for(int a: arr)
            System.out.println("Hash of "  + a + " :" + a % k);

        //Question 6
        int m = 11;
        int nums[] = {25, 7, 22, 3, 34, 120, 59, 15};
        // int nums[] = {31, 45, 14, 89, 24, 95, 12, 38, 27, 16, 25};
        int ans[] = new int[13];

        for(int n: nums) {
            int index = (13*n + 3) % m;
            System.out.println(index);
            while(ans[index] != 0)
                index = (index < 12) ? ++index : 0;

            ans[index] = n;
        }

        for(int a: ans)
            System.out.print(a + " ");
    }
}
