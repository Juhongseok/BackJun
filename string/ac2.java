/*인터넷 참조 - deque => stack + queue*/
package BackJun.string;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ac2 {

	static Scanner scan = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayDeque<Integer> deque;
		StringTokenizer st;
		
		int T = scan.nextInt();
		
		while(T-- > 0) {
			String command = scan.next();
			int n = scan.nextInt();
			
			st = new StringTokenizer(scan.next(), "[],");
			deque = new ArrayDeque<Integer>();
			
			for(int i=0; i<n; ++i)
				deque.add(Integer.parseInt(st.nextToken()));
			
			AC(command, deque);
		}
		System.out.println(sb);
	}
	
	public static void AC(String command, ArrayDeque<Integer> deque) {
		boolean isRight = true;
		for(char cmd : command.toCharArray()) {
			if(cmd == 'R') {
				isRight = !isRight;
				continue;
			}
		
			if(isRight) { 
				if(deque.pollFirst() == null) {
					sb.append("error\n");
					return;
				}
			}
			else
				if(deque.pollLast() == null) {
					sb.append("error\n");
					return;
				}
		}
		print(deque, isRight);
	}
	public static void print(ArrayDeque<Integer> deque, boolean isRight) {
		sb.append("[");
		if(deque.size() >0)
			if(isRight) {
				sb.append(deque.pollFirst());
				while(!deque.isEmpty())
					sb.append(',').append(deque.pollFirst());
			}
			else {
				sb.append(deque.pollLast());
				while(!deque.isEmpty())
					sb.append(',').append(deque.pollLast());
			}
		
		sb.append(']').append('\n');
	}

}
