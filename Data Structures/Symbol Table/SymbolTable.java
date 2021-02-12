/*
 * SymbolTable.java
 * Author: Nicholas Kawwas
 * Completed: November, 2020
 * Purpose: Implemented a Symbol Table For GPA Calculation
*/

public class SymbolTable <Key extends Comparable<Key>, Value> {
    private Node head;
    
    public class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key k, Value v) {
            key = k;
            value = v;
            next = null;
        }
    }

    public SymbolTable() {}

    //Places Key and Value Pair in Symbol Table
    public void put(Key k, Value v) {
        Node insertNode = new Node(k, v);

        if(head == null) 
            head = insertNode;
        else {
            Node tmp = head;

            while(tmp.next != null) 
                if (tmp.next.key.compareTo(k) < 0)
                    tmp = tmp.next;
                else {
                    insertNode.next = tmp.next;
                    break;
                }
            
            tmp.next = insertNode;
        }
    }

    //Gets Value Based On Key
    public Value getValue(Key k) {
        if(head == null)
            return null;

        Node tmp = head;
        while(tmp.next != null) 
            if ((tmp.key).compareTo(k) == 0)
                return tmp.value;
            else 
                tmp = tmp.next;

        return null;
    }



    //Prints Keys and Values
    public void printST() {
        if(head == null)
            return;

        Node tmp = head;
        while(tmp != null) {
            System.out.print(tmp.key + " -> ");
            tmp = tmp.next;
        }

        System.out.println();

        Node valTemp = head;
        while(valTemp != null) {
            System.out.print(valTemp.value + " -> ");
            valTemp = valTemp.next;
        }
    }

    //Rank by Number of Smaller Keys
    public int rank(Key k) {
        int ranked = 0;
        if(head == null)
            return ranked;
        
        Node temp = head;
        while(temp != null) {
            if ((temp.key).compareTo(k) > 0)
                return ranked;
            ++ranked;
            temp = temp.next;
        }

        return 0;
    }

    //Floor - Largest Element <= to Key
    public Key floor(Key k) {
        if(head == null)
        return null;

        Node temp = head;
        while(temp != null && (temp.key).compareTo(k) > 0) {
            temp = temp.next;
        }

        return temp.key;
    }

    //Ceiling - Smallest Element >= to Key
    public Key ceiling(Key k)  {
        if(head == null)
        return null;

        Node temp = head;
        while(temp != null && (temp.key).compareTo(k) < 0) {
            temp = temp.next;
        }

        return temp.key;
    }

    //Select Key of Rank i
    public Key select(int i) {
        if(head == null)
            return null;

        int count = 1;
        Node temp = head;
        while(temp != null && count++ < i) {
            temp = temp.next;
        }
    
        return temp.key;
    }

    //Return Smallest Key
    public Key min() { 
        return head.key;
    }

    //Return Largest Key
    public Key max() {
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }

        return temp.key;
    }

    //Deletes Smallest Key
    public void deleteMin() {
        head = head.next;
    }

    //Deletes Largest Key
    public void deleteMax() {
        if(head == null) return;

        Node temp = head;
        while(temp.next.next != null) {
            temp = temp.next;
        }

        temp.next = null;
    }
}
