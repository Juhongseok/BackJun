package BackJun.DP;

import java.util.Scanner;

public class plusWith123 {
	
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		int T = init();
		int[] number = new int[10];
		int[] n = new int[T];
		number[0] = 1;
		number[1] = 2;
		number[2] = 4;
		
		for(int i=0; i<T; ++i) 
			n[i] = scan.nextInt();
			
		for(int i=3; i<10; ++i)
			number[i] = number[i-1] + number[i-2] + number[i-3];
		
		
		for(int i=0; i<T; ++i)
			System.out.println(number[n[i]-1]);
		
	}
	
	static int init() {
		return scan.nextInt();
	}

}
