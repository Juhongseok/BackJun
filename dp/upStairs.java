package BackJun.DP;

import java.util.Scanner;

public class upStairs {

	static int[] arr;
	static Integer[] dp;
	static int n;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		n = scan.nextInt();
		arr = new int[n];
		dp = new Integer[n+1];
		
		for(int i=0; i<n; ++i)
			arr[i] = scan.nextInt();
		dp[0] = 0;
		dp[1] = arr[0];
		if(n>=2)
			dp[2] = dp[1]+arr[1];
		for(int i=3; i<=n; ++i)
			dp[i] = Math.max(dp[i-2], dp[i-3]+arr[i-2])+arr[i-1];
		System.out.println(dp[n]);
		scan.close();
	}
}
