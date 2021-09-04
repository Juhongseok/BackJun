package BackJun.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 단어공부_1157 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int[] arr = new int[26];
		String s = scan.next().toUpperCase();
		for(int i=0; i<s.length(); ++i) {
			if('A' <= s.charAt(i) && s.charAt(i) <= 'Z')
				arr[s.charAt(i) - 'A']++;
		}
		
		int max = 0;
		char answer = '?';
		
		for(int i=0; i<26; ++i) {
			if(arr[i] > max) {
				max = arr[i];
				answer = (char)(i+65);
			}
			else if(arr[i] == max)
				answer = '?';
		}
		System.out.println(answer);
	}

}
