/*
 * AdvCSBinTree.java
 * Author: Nicholas Kawwas
 * Completed: October, 2018
 * Purpose: Binary Tree Implementation
 */

public class AdvCSBinTree<T> {
	private BinTreeNode<T> root;
	
	public class BinTreeNode<T> {
		public T data;
		public int key; 
		public BinTreeNode<T> left, right;
		
		//Constructor: Sets reference to null and root to inputed node
		public BinTreeNode(T nodeD, int keyV){
			data = nodeD;
			key = keyV;
			left = null;
			right = null;
		}
		
		//Method toString: Returns a string of Key and Data
		public String toString(){
			return "Key Value: " + key + "\tData Stored: " + data;
		}  
	}
	
	//Constructor: Creates a generic AdvCSBinTree
	public AdvCSBinTree(){ 
		root = null;
	}
	
	//Method add: Adds new item to tree
	public void add(T nodeD, int keyV){
		if(root == null) 
			root = new BinTreeNode<T>(nodeD, keyV);
		else {
			BinTreeNode<T> temp = root;
			
			while(temp != null) {
				if(keyV < temp.key) 
					if(temp.left == null) {
						temp.left = new BinTreeNode<T>(nodeD, keyV);
						break;
					} else
						temp = temp.left;
				else
					if(temp.right == null) {
						temp.right = new BinTreeNode<T>(nodeD, keyV);
						break;
					} else
						temp = temp.right;	
			}	
		}		
	}
	
	//Prints out the tree inOrder
	public void traversal(){
		this.inOrder(root);
		System.out.println();
	}
	
	//Returns the tree inOrder
	public void inOrder(BinTreeNode<T> node){
		if(node == null) 
			return;
		inOrder(node.left);
		System.out.print(node.key + " ");
		inOrder(node.right);
	}
	
	//Deletes a certain key from the tree
	public T delete(int key) {
		BinTreeNode<T> cur = root, parent = null;
		while(cur.key != key) { 
			if(key < cur.key) {
				if(cur.left != null) {
					parent = cur;
					cur = cur.left;
				}
				else {
					return null;
				}
			} else { 
				if(cur.right != null) {
					parent = cur;
					cur = cur.right;
				}
				else {
					return null;
				}
			}
		}
		//Deletes a node if it is a leaf by setting parent's reference equal to null
		if(cur.left == null && cur.right == null) {
			if(parent.left != null && parent.left.key == key) {
				parent.left = null;
			} else {
				parent.right = null;
			}		
		} 
		//Deletes a node if it has one child by setting parent's reference to the deleted node's child
		else if(cur.left == null || cur.right == null) {
			if(parent.left != null && parent.left.key == key) {
				if(cur.left != null)
					parent.left = parent.left.left;
				else
					parent.left = parent.left.right;
			} else {
				if(cur.left != null)
					parent.right = parent.right.left;
				else
					parent.right = parent.right.right;
			}
		//Deletes node if it has two children by setting the node equal to its left-most child from its
		//right child and by using a recursive call to delete the left-most child as a node with one child
		} else {			
			BinTreeNode<T> successor = cur.right;
			while(successor.left != null)
				successor = successor.left;
			delete(successor.key);
	
			T temp = cur.data;
			cur.key = successor.key;
			cur.data = successor.data;
			return temp;
		}
		return cur.data;
	}
	
	//Displays the tree
	 public void displayTree() {
	        AdvCSStack<BinTreeNode<T>> globalStack = new AdvCSStack<>();
	        globalStack.push(root);
	       
	        System.out.println("......................................................");
	        
	        int nBlanks = 32;
	        boolean isRowEmpty = false;
	        
	        while (!isRowEmpty) {
	            AdvCSStack<BinTreeNode<T>> localStack = new AdvCSStack<>();
	            isRowEmpty = true;
	            
	            for (int j = 0; j < nBlanks; j++)
	                System.out.print(' ');
	            
	            while (!globalStack.isEmpty()) {
	                BinTreeNode<T> temp = (BinTreeNode<T>)globalStack.pop();
	                if (temp != null) {
	                    System.out.print(temp.key);
	                    localStack.push(temp.left);
	                    localStack.push(temp.right);
	                    if (temp.left != null || temp.right != null)
	                        isRowEmpty = false;
	                } else {
	                    System.out.print("--");
	                    localStack.push(null);
	                    localStack.push(null);
	                }
	                for (int j = 0; j < nBlanks * 2 - 2; j++)
	                    System.out.print(' ');
	            }
	            
	            nBlanks /= 2;
	            System.out.println();
	            
	            while (!localStack.isEmpty())
	                globalStack.push(localStack.pop());
	        } 
	        
	        System.out.println("......................................................\n");
	    } 
}
