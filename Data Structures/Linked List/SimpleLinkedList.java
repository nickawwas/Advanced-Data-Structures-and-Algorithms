/*
 * SimpleLinkedList.java
 * Author: Nicholas Kawwas
 * Completed: October, 2020
 * Purpose: Implemented a Simple Linked List
*/

public class SimpleLinkedList { 
	private Node head;
	
	//Node Class - Current Node Value and Next Node Reference
	public class Node { 
		private int value; 
		private Node nextNode; 
	
		public Node(int v) {
			value = v;
			nextNode = null;
		}
	} 
	
	//Default SLL Constructor - Set Head to Null
	public SimpleLinkedList() {
		head = null;
	}
	
	//SLL Constructor - Give Head a Value and Reference of Null
	public SimpleLinkedList(int v) {
		head = new Node(v);
	}
	
	//Add New Node to End of Linked List 
	public void add(int i) {
		if(head == null)
			head = new Node(i);
		else {
			Node tmp = head;
			
			while(tmp.nextNode != null)
				tmp = tmp.nextNode;
			
			tmp.nextNode = new Node(i);	
		}
	}

    //Deletes the Kth Element in LL
	public void delete(int k) {
	    if(head != null) {
    		//Removes Head
    		if(k == 1) {
    		    head = head.nextNode;
            //Removes Any Other Element, If It Exists
            } else {
	    		    int counter = 1;
	    		    Node tmp = head;
	    		    
	        		while(tmp.nextNode != null) {
	        			if(counter == k - 1) {
	        				tmp.nextNode = tmp.nextNode.nextNode;
	        				break;
	        			} else {
	        			    tmp = tmp.nextNode;
	        				counter++;
	        			}
	        		}	  
    			}
	    }
	}
	
    //Prints All Links of LL
	public void printLinks() {
	    Node tmp = head;
	    while(tmp != null) {
	        System.out.print(tmp.value + " -> ");
	        tmp = tmp.nextNode;
	    }
	    
	    System.out.println("NULL");
	}

    //Returns Maximum Value in LL
	public int max() {
        int max = 0;
        Node tmp = head;
    
	    	while(tmp != null) {
	    		max = tmp.value > max ? tmp.value : max;
	    		tmp = tmp.nextNode;
	    	}
	    	
	    	return max;
	}
}