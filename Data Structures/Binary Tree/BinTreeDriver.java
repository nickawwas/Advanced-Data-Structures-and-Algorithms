/*
 * BinTreeDriver.java
 * Author: Nicholas Kawwas
 * Completed: October, 2018
 * Purpose: Binary Tree Implementation
*/

public class BinTreeDriver {
	public static void main(String[] args){
		AdvCSBinTree<String> intBin = new AdvCSBinTree<String>();
		
		intBin.add("A", 53);
		intBin.add("B", 30);
		intBin.add("C", 72);
		intBin.add("D", 61);
		intBin.add("E", 65);
		intBin.add("F", 63);
		intBin.add("G", 6);
		intBin.add("H", 84);
		intBin.add("I", 79);
		intBin.add("J", 14);
		intBin.add("K", 39);
		intBin.add("L", 34);
		intBin.add("M", 9);
		intBin.add("N", 23);
		intBin.add("O", 47);
				
		intBin.displayTree();
		
		System.out.println(intBin.delete(9));
		System.out.println(intBin.delete(23));
		System.out.println(intBin.delete(65));
		System.out.println(intBin.delete(30));
		System.out.println(intBin.delete(53));
		System.out.println(intBin.delete(53));

		intBin.displayTree();
		
		intBin.traversal();
	}
}
