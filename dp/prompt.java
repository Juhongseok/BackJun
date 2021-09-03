package BackJun.DP;

import java.util.Scanner;

public class prompt {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		String[] fileName = new String[N];
		String answer = "";
		for(int i=0; i<N; ++i) 
			fileName[i] = scan.next();
		
		for(int i=0; i<fileName[0].length(); ++i) {
			boolean flag = true;
			char comp = fileName[0].charAt(i);
			for(int j=1; j<N; ++j) {
				if(fileName[j].charAt(i) != comp) {
					flag = false;
					break;
				}
			}
			if(flag)
				answer+= comp;
			else
				answer += '?';
		}
		
		System.out.println(answer);
		scan.close();
	}
}
