/*
 * HeapDriver.java
 * Author: Nicholas Kawwas
 * Completed: October, 2018
 * Purpose: Heap Implementation
*/

public class HeapDriver {
	public static void main(String[] args) {
		AdvCSHeap<String> strHeap = new AdvCSHeap<String>(13);
		strHeap.add(50, "fifty");
		strHeap.add(30, "thirty");
		strHeap.add(80, "eighty");
		strHeap.add(100, "one hundred");
		strHeap.add(70, "seventy");
		strHeap.add(60, "sixty");
		
		System.out.println(strHeap);
		
		for (int i = 0; i < 6; i++) {
			strHeap.remove();
			System.out.println(strHeap);
		}
	}
}
