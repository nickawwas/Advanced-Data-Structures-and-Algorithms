/*
 * AdvCSHeap.java
 * Author: Nicholas Kawwas
 * Completed: October, 2018
 * Purpose: Heap Implementation
 */

public class AdvCSHeap<T>{
	private int arrSize;
	public HeapNode<T> arr[];
	
	public class HeapNode<T> {
		public T data;
		public int key;
		
		//Constructor: Sets reference to null and root to inputed node
		public HeapNode(int keyV, T nodeD){
			key = keyV;
			data = nodeD;
		}
		
		//Method toString: Returns a string of Data
		public String toString() {
			return "Key Value: " + key + "\tData Stored: " + data; 
		}
	}
	
	//Constructor: Creates a generic AdvCSHeap
	public AdvCSHeap(int size){ 
		arrSize = 0;
		arr = new HeapNode[size];
	}
		
	//Method add: Adds new item to arr using trickleUp
	public void add(int keyV, T nodeD){
		arr[arrSize] = new HeapNode<T>(keyV, nodeD);		
		arrSize++;
		trickleUp();
	}
	
	//Method trickleUp: Add element to arr in the right place
	private void trickleUp() {
		if(arrSize > 1)
			for(int i = arrSize - 1; i > 0; i = (i - 1)/2)
				if(arr[(i - 1)/2].key < arr[i].key) {
					HeapNode<T> temp = arr[(i - 1)/2];
					arr[(i - 1)/2] = arr[i];
					arr[i] = temp;
				}	
	}
	
	//Method remove: Removes the first element by setting the first element 
	//to the last and setting the last equal to null and by using trickleDown
	public void remove() {
		arr[0] = arr[arrSize - 1];
		arr[arrSize - 1] = null;
		arrSize--;
		trickleDown();
	}
	
	//Method trickleDown: Private helper for remove
	private void trickleDown() {
		if(arrSize == 2) { 
			if(arr[0].key < arr[1].key) {
				HeapNode<T> temp = arr[0];
				arr[0] = arr[1];
				arr[1] = temp;
			}
		} else {
			//If you go right, you need to do 2*i + 2 so I added 1 to 2*i + 1
			for(int i = 1; i < arrSize - 1; i = 2*i + 1) {
				if(arr[i].key < arr[i + 1].key)
					i++;	
				HeapNode<T> temp = arr[(i-1)/2];
				arr[(i-1)/2] = arr[i];
				arr[i] = temp;
			}	
		}
	}
	
	//Method toString(): Prints out nodes in index order
	public String toString() {
		String str = "";
		for(int i = 0; i < arrSize; i++)
			str += "Priority " + arr[i].key + ", " +  arr[i].data + "\n";
		return str;
	} 
}
