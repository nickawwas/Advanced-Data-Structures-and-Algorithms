/*
 * Josephus.java
 * Author: Nicholas Kawwas
 * Completed: October, 2020
 * Purpose: Implemented a Simple Queue to solve Josephus Problem
*/

public class SimpleQueue {
	private Node head, tail;
	
	//Node Class - Current Node Value and Next Node Reference
	public class Node { 
		private int value; 
		private Node nextNode; 
	
		public Node(int v) {
			value = v;
			nextNode = null;
		}
	} 
	
	//Default SQ Constructor - Set Head to Null
	public SimpleQueue() {
		head = null;
		tail = null;
	}

	//Adds from Back of Queue
	public void enqueue(int i) {
		Node tmp = new Node(i);
		
		//Empty Queue
		if(tail == null)
			head = tail = tmp;
		else {
			tail.nextNode = tmp;
			tail = tmp;
		}
	}

    //Removes from Front of Queue
	public void dequeue() {
	    if(head != null)
			//Removes Head
			if(head.nextNode != null)
				head = head.nextNode;
			else {
				head = tail = null;
			}
	}

	//Returns Front Value
	public int front() {
		if(head != null)
			return head.value;
		
		return -1;
	}

	//Returns Front Value
	public int back() {
		if(tail != null)
			return tail.value;
		
		return -1;
	}
}