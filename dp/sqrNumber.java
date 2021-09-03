package BackJun.DP;

import java.util.Scanner;

public class sqrNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int n = scan.nextInt();
		scan.close();
		
		int[] dp = new int[n+1];
		dp[1] = 1;
		
		for(int i=2; i<n+1; ++i) {
			dp[i] = i;
			for(int j=1; j*j<=i; j++)
				dp[i] = Math.min(dp[i], dp[i-j*j]+1);
		}
		
		System.out.println(dp[n]);
		scan.close();
	}

}
/*
 * 0 : 0
1 : 1
2 : 1+1
3 : 1+1+1
4 : 2*2 dp[0]+1
5 : 2*2+1 = dp[4] +dp[1]
6 : 2*2+1+1 = dp[4]+dp[2]
7 : 2*2+1+1+1 = dp[4] + dp[3]
8 : 2*2+2*2 = dp[4] + dp[4]
9 : 3*3 = dp[0]+1
10 : 3*3+1 = dp[9]+dp[1]
11 : 3*3+1+1 =  dp[9]+dp[2]
12 : 3*3+1+1+1 = dp[9] + dp[3]
13 : 3*3+2*2 = dp[9] + dp[4]
14 : 3*3+2*2+1 = dp[9]+dp[5]
15 : 3*3+2*2+1+1 = dp[9]+dp[6]
16 : 4*4 = dp[0]+1
17 : 4*4+1 = 1+dp[1]
18 : 4*4+1+1, 3*3+3*3
 */