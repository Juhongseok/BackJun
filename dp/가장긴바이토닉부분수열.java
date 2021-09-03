package BackJun.DP;

import java.util.Arrays;
import java.util.Scanner;

public class 가장긴바이토닉부분수열 {

	static int[] dpLeft;
	static int[] dpRight;
	static int[] arr;
	static int N;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		N = scan.nextInt();
		arr = new int[N];
		dpLeft = new int[N];
		dpRight = new int[N];
		int[] dp = new int[N];

		for (int i = 0; i < N; ++i)
			arr[i] = scan.nextInt();

		countLeft();
		countRight();

		for(int i : dpLeft)
			System.out.print(i + " ");
		System.out.println();
		for(int i : dpRight)
			System.out.print(i + " ");
		System.out.println();
		
		for(int i=0; i<N; ++i)
			dp[i] = dpLeft[i] + dpRight[i];
		
		System.out.println(Arrays.stream(dp).max().getAsInt()-1);
		scan.close();
	}

	static void countLeft() {
		for(int i=0; i<N; ++i) {
			dpLeft[i] = 1;
			for(int j=0; j<i; ++j) 
				if(arr[i] > arr[j] && dpLeft[i] < dpLeft[j]+1)
					dpLeft[i] = dpLeft[j]+1;
		}
	}

	static void countRight() {
		for(int i = N-1; i>=0; i--) {
			dpRight[i] = 1;
			for(int j=N-1; j>i; j--)
				if(arr[i]>arr[j] && dpRight[i] < dpRight[j]+1)
					dpRight[i] = dpRight[j]+1;
		}
	}

}
