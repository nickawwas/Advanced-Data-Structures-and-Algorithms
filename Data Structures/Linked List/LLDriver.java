/*
 * LLDriver.java
 * Author: Nicholas Kawwas
 * Completed: October, 2018
 * Purpose: Linked List Implementation
*/

public class LLDriver {
	public static void main(String[] args){
		AdvCSLL<String> strLL = new AdvCSLL<>();
		
		System.out.println("Is initial list empty? : " + strLL.isEmpty());
		
		System.out.println("Ok, add words...\n");
		
		strLL.add("delete");
		strLL.add("My");
		strLL.add("list");
		strLL.add("is");
		strLL.add("not");
		strLL.add("working!");
		strLL.remove("not");
		
		strLL.removeFirst();
		
		System.out.println(strLL.toString());
		
		
		System.out.println("\nList contains 'list'? : " + strLL.contains("list"));
		System.out.println("List contains 'not'? : " + strLL.contains("not"));
		System.out.println("List contains 'hey'? : " + strLL.contains("hey"));
		
		System.out.println("Is current list empty? : " + strLL.isEmpty());
		
		System.out.println("\nOk, clear list...\n");
		strLL.clear();
		
		System.out.println("Is final list empty? : " + strLL.isEmpty()); 
		
	}
}
