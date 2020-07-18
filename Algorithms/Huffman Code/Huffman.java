/*
 * Huffman.java
 * Author: Nicholas Kawwas
 * Completed: October, 2018
 * Purpose: Huffman Code Implementation (Encoding & Decoding)
*/

import java.io.File;
import java.util.Scanner;
import java.util.PriorityQueue;

public class Huffman {
	public static int[] occrncs;
	public static String[] huffC;
	public static PriorityQueue<Node> qHuff;
	
	public static void main(String[] args) throws Exception {
		occrncs = new int[128];
		huffC = new String[128];
	
		readFile(); 
		buildTree();
		buildHuffTable(qHuff.element(), "");
		
		String message = encode();
		System.out.println(message);
		decode(message);
	}
	
	public static class Node implements Comparable<Node> {
		public char chars;
		public int occurs;
		public Node left, right;
		
		public Node(char curChar, int freq, Node leftC, Node rightC) {
			occurs = freq;
			chars = curChar;
			left = leftC;
			right = rightC;
		}
	
		public int compareTo(Node one){
			return this.occurs - one.occurs;
		}     
		
		public String toString() {
			return "Character: " + chars + "\t" + "Frequency: " + occurs + "\n";
		}
	}
	
	//Reads the input; Counts the char/punctuation frequencies
	public static void readFile() throws Exception {
		Scanner scanFC = new Scanner(new File("src/Huffmans.txt"));
		
		while(scanFC.hasNext()) {
			String str = scanFC.nextLine();
			
			for(int i = 0; i < str.length(); i++) {
				char ch = str.toUpperCase().charAt(i);
				occrncs[ch]++;
			}
		}
	}
		
	//Build the Huffman Tree using priority queue
	public static PriorityQueue<Node> buildTree() {
		qHuff = new PriorityQueue<Node>();
		
		for(int r = 0; r < occrncs.length; r++)
			if(occrncs[r] != 0)
				qHuff.add(new Node((char)r, occrncs[r], null, null));
		
		while(qHuff.size() > 1) {
			Node nodeC = qHuff.poll(); 
			Node nodeCmp = qHuff.poll();
			
			qHuff.add(new Node('+', nodeC.occurs + nodeCmp.occurs, nodeC, nodeCmp)); 
		}

		return qHuff;
	}

	//Traverse the tree to create the Huffman Codes
	public static void buildHuffTable(Node nodes, String cMessage) {
		Node traverse = nodes;
		String cMess = cMessage;
		
		if(traverse.left == null && traverse.right == null) {
			huffC[traverse.chars] = cMess;
			return;
		}
		
		if(traverse.left != null) {
			cMess += "0";
			buildHuffTable(traverse.left, cMess);
			cMess = cMessage;
		} 
		
		if(traverse.right != null) {
			cMess += "1";
			buildHuffTable(traverse.right, cMess);
		}
	}

	//Use the Huffman Codes to encode the input file
	public static String encode() throws Exception {	
		Scanner scanFC = new Scanner(new File("src/Huffmans.txt"));
		String encodedM = "";
		
		while(scanFC.hasNextLine()) {
			String str = scanFC.nextLine();
			for(int i = 0; i < str.length(); i++) {
				char chars = str.toUpperCase().charAt(i);
				encodedM += huffC[chars];
			}
			encodedM += "\n";
		}
		return encodedM;
	}

	//Decode the string of Huffman bits
	public static void decode(String message) {
		String decodedM = "";
		Node temp = qHuff.peek();
		
		for(int i = 0; i < message.length(); i++) {
			if(temp.left == null && temp.right == null) {
				decodedM += temp.chars;
				temp = qHuff.peek();
			}
			if(message.charAt(i) == '0')
				temp = temp.left;
			if(message.charAt(i) == '1')
				temp = temp.right;
		}
		System.out.println(decodedM);
	}
}
