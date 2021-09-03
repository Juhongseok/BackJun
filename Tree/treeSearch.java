package BackJun.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class treeSearch {
	static String answer = "";
	static Map<String, List<String>> tree = new HashMap<>();
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		String[] data = new String[3];
		int nodeCount = scan.nextInt();
		scan.nextLine();
		
		for(int i=0; i<nodeCount; ++i) {
			data = scan.nextLine().split(" ");
			List<String> list = new ArrayList<>();
			list.add(data[1]);
			list.add(data[2]);
			
			tree.put(data[0], list);
		}
		preOrder("A");
		System.out.println(answer);
		answer = "";
		inOrder("A");
		System.out.println(answer);
		answer = "";
		postOrder("A");
		System.out.println(answer);
		answer = "";
		scan.close();
	}
	
	static void preOrder(String s) {
		if(s.equals("."))
			return;
		answer += s;
		preOrder(tree.get(s).get(0));
		preOrder(tree.get(s).get(1));
		
	}
	static void inOrder(String s) {
		if(s.equals("."))
			return;
		inOrder(tree.get(s).get(0));
		answer += s;
		inOrder(tree.get(s).get(1));
	}
	static void postOrder(String s) {
		if(s.equals("."))
			return;
		postOrder(tree.get(s).get(0));
		postOrder(tree.get(s).get(1));
		answer += s;
	}
}
