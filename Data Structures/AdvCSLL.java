/*
 * AdvCSLL.java
 * Author: Nicholas Kawwas
 * Completed: October, 2018
 * Purpose: Linked List Implementation
 */
 
public class AdvCSLL<T> {
	private LLNode<T> head;
	
	//LLNode<T> Class
	public class LLNode<T> {
		public T node; 
		public LLNode<T> reference;
		
		//Constructor: Sets reference to null and node to inputed node
		public LLNode(T nodeLL){
			node = nodeLL;
			reference = null;
		}
	}
	
	//Constructor: Creates a generic Linked List
	public AdvCSLL(){
		head = null;
	}

	//Method add: Adds new item to end of list by calling method link from LLNode
	public void add(T next){
		if(head == null)
			head = new LLNode<T>(next);
		else {
			LLNode<T> temp = head;
			while(temp.reference != null)
				temp = temp.reference;
			temp.reference = new LLNode<T>(next);	
		}
	}
	
	//Method remove: Removes specified item from list
	public void remove(T item){
		LLNode<T> temp = head;
		while(temp != null && temp.reference != null) {
			if(temp.reference.node != item)
				temp = temp.reference;
			else
				temp.reference = temp.reference.reference;
		}	
	}	

	//Method removeFirst: Removes first element from list if possible
	public T removeFirst(){
		if(head == null) {
			return null;
		} else {
			LLNode<T> temp = head;
			if(head.reference == null)
				head = null;
			else
				head = temp.reference;
			return temp.node;
		}
	}	
	
	//Method contains: Checks whether the list contains a specific word
	public boolean contains(T item){
		if(head == null)
			return false;
		else {
			LLNode<T> temp = head;
			while(temp.node != item){ 
				if(temp.reference == null)
					return false;
				temp = temp.reference;
			}
			return true;	
		}
	}
	
	//Method clear: Sets node and reference to null, clearing the list 
	public void clear(){
		head = null;
	}
		
	//Method isEmpty: Checks & returns whether or not a list is empty or not 
	public boolean isEmpty(){
		return(head == null); 
	}
	
	//Method toString: Returns a string of all the elements in the linked list
	public String toString(){
		LLNode<T> temp = head;
		String str = "";
		while (temp != null) {
			str +=  temp.node + "  ";
			temp = temp.reference;
		}  
		return str;
	} 
}
