/*
 * GenQueueInterface.java
 * Author: Nicholas Kawwas
 * Completed: September, 2018
 * Purpose: Queue Implementation
 */

public interface GenQueueInterface <T>{
		public T dequeue(); //Removes the first item of queue
		public T peek(); //Checks the first item of queue
		public void enqueue(T t); //Adds item t to queue
		public boolean isEmpty(); //Checks if queue is empty or not 
}
