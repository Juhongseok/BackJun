package BackJun.DP;

import java.util.Arrays;
import java.util.Scanner;

public class consecutiveSum {

	static int[] dp;
	static int[] arr;
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		arr = new int[n];
		dp = new int[n];
		
		for(int i=0; i<n; ++i)
			arr[i] = scan.nextInt();
		
		dp[0] = arr[0];
		count(n-1);
		System.out.println(Arrays.stream(dp).max().getAsInt());
		scan.close();
	}

	static int count(int N) {
		
		if(N>0)
			dp[N] = Math.max(arr[N], count(N-1)+arr[N]);

		return dp[N];
	}
}
