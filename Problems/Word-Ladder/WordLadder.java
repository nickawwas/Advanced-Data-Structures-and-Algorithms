/*
 * WordLadder.java
 * Author: Nicholas Kawwas
 * Completed: September, 2018
 * Purpose: Word Ladder Problem
*/

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;

public class WordLadder{
    public static HashSet<String> dict, sameLWDict, visitedW;
    
    public static void main(String[] args) throws Exception{
    		long startTime = System.nanoTime();
    	
        Scanner scanF = new Scanner(new File("src/ladderinput.txt"));
        loadDict();
        
        //Reads through file, finding start and end word, then calls findLadder
        while (scanF.hasNextLine()){
            String startW = scanF.next(); 
            String endW = scanF.next();
            System.out.println(startW + " " + endW);
    		System.out.println("[" + findLadder(startW, endW) + "]");
    		//After printing the word ladder, clear the words visited and dictionary
            sameLWDict.clear(); visitedW.clear();
            
            long endTime = System.nanoTime();
            long duration = (endTime - startTime);
            System.out.println(duration/1000000000 + " seconds");
        }
    }
    
    //Loads all words in the dictionary onto a Hashset
    public static void loadDict() throws Exception{
		Scanner scanD = new Scanner(new File("src/dictionary.txt"));
		dict = new HashSet<String>();
		while(scanD.hasNextLine())
			dict.add(scanD.next());
	}
    
    //Copies the initial stack by popping all of the elements into a holder stack then 
    //  pushes the first element by peaking it and then pops it into the final stack
   	  public static AdvCSStack<String> deepCopy(AdvCSStack<String> stacked, String word){
   		AdvCSStack<String> tempS = new AdvCSStack<String>(); 
   		AdvCSStack<String> finalS = new AdvCSStack<String>();
        while(!stacked.isEmpty())
        	tempS.push(stacked.pop());
        while(!tempS.isEmpty()){
        	stacked.push(tempS.peek());
        	finalS.push(tempS.pop());
        }
        finalS.push(word);
        return finalS;
    }
   
    public static String findLadder(String startW, String endW){
	    	AdvCSStack<String> stacked = new AdvCSStack<String>();
	    	AdvCSQueue<AdvCSStack<String>> wordQ = new AdvCSQueue<AdvCSStack<String>>();
	    	visitedW = new HashSet<String>();
	    	
	    //Loads a smaller dictionary with all words of the same length
	    	sameLWDict = new HashSet<String>();
		for(String word : dict)
			if(word.length() == startW.length())
				sameLWDict.add(word);
			
		//If words are valid and equal in length, then word ladder is possible
	    	if(sameLWDict.contains(startW) && sameLWDict.contains(endW) && startW.length() == endW.length()){
	        	stacked.push(startW);
	        	visitedW.add(startW);
	        	wordQ.enqueue(stacked);
	        	
	        	String solutionW = "";
	        	
	        	while(!wordQ.isEmpty()){
	        		stacked = wordQ.dequeue();
	                visitedW.add(stacked.peek());	
	                
	        		if(!stacked.peek().equals(endW)){
	        			//Searching through dictionary to find all words one letter apart
	        			for(String word : sameLWDict){
	        				int counter = 0;
	        				if(!visitedW.contains(word)){
	        					for(int i = 0; i < startW.length(); i++){
	        						if(stacked.peek().charAt(i) != word.charAt(i))
	        							counter++;
	        						if(counter > 1)
	        							break;	
	        					}
	        					//If hop found, enqueue it by creating a deep copy of the stack
	        					// in order to find later find all other n-step hops (Queue partial paths)
	        					if(counter == 1)
	        						wordQ.enqueue(deepCopy(stacked, word));	
	        				}
	        			}
	        		} else {
	        			while(!stacked.isEmpty())
	        				solutionW = " " + stacked.pop() + " " + solutionW;
	        			return solutionW;
	        		}
	        	}
	    	}  	
	    
	    	return("No ladder from " + startW + " to " + endW); 
    } 
}    
