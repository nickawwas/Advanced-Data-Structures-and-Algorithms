/*
 * AdvCSStack.java
 * Author: Nicholas Kawwas
 * Completed: September, 2018
 * Purpose: Stack Implementation
 */
 
import java.util.ArrayList;

public class AdvCSStack<T> implements GenStackInterface <T> {
	private ArrayList<T> tArray; //Defines generic ArrayList

	//Constructor 
	public AdvCSStack (){ 
		this.tArray = new ArrayList<T>(); //Creates generic ArrayList
	}
	
	//Method pop: removes top item of stack
	public T pop(){
		int len = tArray.size()-1; //Finds the index of top item of stack
		return (tArray.remove(len)); //Gets the top item of stack
	}
	
	//Method peek: checks the first item of stack
	public T peek(){
		int len = tArray.size()-1; //Checks the last item of stack
		return(tArray.get(len)); //Gets the top item of stack
	}	
	
	//Method push: adds item t to stack
	public void push(T thing){
		tArray.add(thing); //Adds item t to stack
	}
	
	//Method isEmpty: checks if stack is empty or not 
	public boolean isEmpty(){
		return(tArray.isEmpty()); //Checks and returns whether or not a stack is empty
	}
}
