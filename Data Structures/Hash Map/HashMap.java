/*
 * HashMap.java
 * Author: Nicholas Kawwas
 * Completed: December, 2020
 * Purpose: HashMap Implementation for Employee Salaries in Different Cash Brackets
*/

public class HashMap {
    //HashMap Size
    private int M = 500; 
    private Node[][] hashmap;

    //Node for Seperate Chaining 
    public class Node {
        int key, value;
        Node next;

        public Node(int k, int v) {
            key = k;
            value = v;
            next = null;
        }
    }

    //HashMap Constructor
    public HashMap(int b) {
        hashmap = new Node[b][M];
    }

    //Hash Function
    public int hashFunction(int id) {
        return id % M;
    }

    //Places Key and Value Pair in Symbol Table
    public void put(int b, int id, int sal) {
        int pos = hashFunction(id);

        if(hashmap[b][pos] == null)
            hashmap[b][pos] = new Node(id, sal);
        else {
            Node tmp = hashmap[b][pos];

            while(tmp.next != null) {
                //If Key is Already Present Exist
                if(tmp.key == id) {
                    System.out.println("Employee Already Exists!\nTry Adding Someone New to System!\n");
                    break;
                }

                tmp = tmp.next;
            }

            if(tmp.key == id)
                System.out.println("Employee Already Exists!\nTry Adding Someone New to System!\n");

            tmp.next = new Node(id, sal);
        }
    }

    //Gets Value Based On Key
    public int getValue(int b, int id) {
        int pos = hashFunction(id);

        if(hashmap[b][pos] != null) {
            Node tmp = hashmap[b][pos];

            while(tmp.next != null) {
                //If Key is Found
                if(tmp.key == id)
                    return tmp.value;

                tmp = tmp.next;
            }

            //If Key is Found
            if(tmp.key == id)
                return tmp.value;
        }

        return -1;
    }

    //Print HashMap Per Bracket
    public void printHm() {
        int counter = 0;
        for(Node[] h: hashmap) {
            System.out.println("Bracket" + counter++);
            
            for(Node n: h)
                if(n == null)
                    System.out.print("- ");
                else
                    System.out.print("<" + n.key + "," + n.value + "> ");

            System.out.println();
        }
    }
}
