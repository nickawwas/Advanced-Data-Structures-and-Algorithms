/*
 * hashFunc.java
 * Author: Nicholas Kawwas
 * Completed: December, 2020
 * Purpose: Implemented a Perfect Hash Function With Linear Probing - a * k % M for Min Values
*/

import java.util.*;
import java.util.Scanner;

public class hashFunc {
    public static void main(String[] args) {
        HashSet<Integer> unique = new HashSet<Integer>();
        char keys[] = {'S', 'E', 'A', 'R', 'C', 'H', 'X', 'M', 'P', 'L'};
        
        int a = 0, m = 0;
        boolean minFound = false;

        //Loop Until Mins are Found
        while(!minFound) {
            a++;

            while(!minFound) {
                m++;

                int counter = 0;
                for(char k : keys) {
                    int hashed = (a * (int)k) % m;

                    if(unique.contains(hashed))
                        break;
                    else {
                        unique.add(hashed);
                        counter++;
                    }
                }

                unique.clear();
                if(counter == keys.length)
                    minFound = true;
            }
        }
        
        //Found Mins: a = 1 and m = 20
        System.out.println("Found Min A & M: "  + a + " " + m);
    }
}
