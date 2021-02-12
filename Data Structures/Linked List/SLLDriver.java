/*
 * SLLDriver.java
 * Author: Nicholas Kawwas
 * Completed: October, 2020
 * Purpose: Main Program for SLL
*/

public class SLLDriver {
	public static void main(String[] args) {
		SimpleLinkedList ll = new SimpleLinkedList();
  		ll.add(6);
  		ll.add(5);
 		ll.add(4);
 		ll.add(3);
 		ll.add(7);
 		ll.add(19);
 		ll.add(9);
 		ll.add(39);
 		ll.add(82);
 		ll.add(78);
  		
// 	    ll.delete(1);
// 	    ll.delete(2);
 	    ll.delete(3);
 	    ll.delete(7);
//      ll.delete(1);
//  	ll.delete(10);  // Element Doesn't Exist - No Problem :)
// 	    ll.delete(5);
// 	    ll.delete(4);
// 	    ll.delete(3);
// 	    ll.delete(2); 
// 	    ll.delete(1);
		
	    ll.printLinks();	
	    
	    System.out.println(ll.max());	

	}
}