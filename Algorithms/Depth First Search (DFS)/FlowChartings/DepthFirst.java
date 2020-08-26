/*
 * DepthFirst.java
 * Author: Nicholas Kawwas
 * Completed: October, 2018
 * Purpose: DFS Post Order Tree Traversal 
 */
 
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class DepthFirst{
	public static void main(String[] args) throws Exception {
		Scanner scanFC = new Scanner(new File("src/FlowChartings.txt"));		
		ArrayList<BinTreeNode<Character>> buildingT = new ArrayList<BinTreeNode<Character>>();
		
		int times = scanFC.nextInt(); 
		while(scanFC.hasNextLine()) {
			Character head = scanFC.next().charAt(0); 
		    Character left = scanFC.next().charAt(0);
		    Character right = scanFC.next().charAt(0); 
		    buildingT.add(new BinTreeNode<Character>(head, left, right));
		}    
		BinTreeNode<Character> treeRoot = null;
		buildTree(findRoot(treeRoot, buildingT), buildingT);
		postOrderT(buildTree(findRoot(treeRoot, buildingT), buildingT));
	}

	public static class BinTreeNode<T> {
		public Character upperK, leftK, rightK;
		public BinTreeNode<T> leftN, rightN;

		public BinTreeNode(Character upperKey, Character leftKey, Character rightKey) {
			leftK = leftKey;
			rightK = rightKey;
			upperK = upperKey;
		}
		
		public String toString(){
			return "" + upperK + leftK + rightK;
		}
	}
	
	public static BinTreeNode<Character> findRoot(BinTreeNode<Character> treeRoot, ArrayList<BinTreeNode<Character>> buildingT){
		for(int rootFinder = 0; rootFinder < buildingT.size(); rootFinder++) {
			for(int e = 0; e < buildingT.size(); e++) {
				if((buildingT.get(rootFinder).upperK != buildingT.get(e).leftK) && (buildingT.get(rootFinder).upperK != buildingT.get(e).rightK)){
					treeRoot = buildingT.get(rootFinder);
					if(e == buildingT.size() - 1)
						return treeRoot;
 				}
				else
					break;	
			}
		}
		return treeRoot;
	}
	
	public static BinTreeNode<Character> buildTree(BinTreeNode<Character> treeRoot, ArrayList<BinTreeNode<Character>> buildingT){
		for(int treeBuilder = 0; treeBuilder < buildingT.size(); treeBuilder++) {
			if(treeRoot.leftK == buildingT.get(treeBuilder).upperK) {
				treeRoot.leftN = buildingT.get(treeBuilder);
				buildTree(treeRoot.leftN, buildingT);
			}
			else if(treeRoot.rightK == buildingT.get(treeBuilder).upperK) {
				treeRoot.rightN = buildingT.get(treeBuilder);
				buildTree(treeRoot.rightN, buildingT);
			}
		}
		return treeRoot;
	}

	public static void postOrderT(BinTreeNode<Character> treeRoot){
		if(treeRoot == null)
			return;
		
		postOrderT(treeRoot.leftN);
		if(treeRoot.leftN == null && treeRoot.leftK != '.')
			System.out.print(treeRoot.leftK);
		
		postOrderT(treeRoot.rightN);
		if (treeRoot.rightN == null && treeRoot.rightK != '.')
			System.out.print(treeRoot.rightK);
		
		System.out.print(treeRoot.upperK);
	}
}
