/*
 * AdvCSQueue.java
 * Author: Nicholas Kawwas
 * Completed: September, 2018
 * Purpose: Queue Implementation
 */
 
import java.util.ArrayList;

public class AdvCSQueue<T> implements GenQueueInterface <T> {
	private ArrayList<T> tArray; //Defines generic ArrayList

	//Constructor 
	public AdvCSQueue (){ 
		this.tArray = new ArrayList<T>(); //Creates generic ArrayList
	}
	
	//Method dequeue: removes first item of queue
	public T dequeue(){
		return(tArray.remove(0)); //Removes the first item of queue
	}
	
	//Method peek: checks the first item of queue
	public T peek(){
		return(tArray.get(0)); //Gets the first item of queue
	}	
	
	//Method enqueue: adds item t to end of queue
	public void enqueue(T thing){
		tArray.add(thing); //Adds item t to queue
	}
	
	//Method isEmpty: checks if queue is empty or not 
	public boolean isEmpty(){
		return(tArray.isEmpty()); //Checks and returns whether or not queue is empty
	}
}
