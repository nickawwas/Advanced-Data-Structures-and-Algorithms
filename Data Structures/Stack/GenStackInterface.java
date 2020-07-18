/*
 * GenStackInterface.java
 * Author: Nicholas Kawwas
 * Completed: September, 2018
 * Purpose: Stack Implementation
 */
 
public interface GenStackInterface <T> {
	public T pop(); //Removes the last item of stack
	public T peek(); //Checks the last item of stack
	public void push(T t); //Adds item t to stack
	public boolean isEmpty(); //Checks if stack is empty or not 
}
