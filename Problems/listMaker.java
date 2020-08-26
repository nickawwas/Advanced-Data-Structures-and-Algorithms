/*
 * listMaker.java
 * Author: Nicholas Kawwas
 * Completed: September, 2018
 * Purpose: Makes a List Using ADD, REMOVE, INSERT Keywords
 */

package listMaker;
import java.util.ArrayList; 
import java.util.Scanner;

public class listMaker {
	public static void main(String[] args){
		ArrayList<String> listMaker = new ArrayList<String>();
		Scanner scan = new Scanner(System.in);
		int endP = 0;
	
		while (endP == 0) {
			String inStr = scan.nextLine();
			Scanner strS = new Scanner(inStr);
			String cmd = strS.next();
			
			if(cmd.equals("ADD")){
				listMaker.add(strS.next());
			}
				
			else if(cmd.equals("REMOVE")){
				listMaker.remove(strS.next());
			}	
			
			else if(cmd.equals("INSERT")){
				String st = strS.next();
				int ln = listMaker.indexOf(strS.next());
				listMaker.add(ln,st);
			}
			
			else {
				endP++;
			}
		}
		
		System.out.print(listMaker);
	}
}
