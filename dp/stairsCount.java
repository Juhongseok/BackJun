package BackJun.DP;

import java.util.Scanner;

public class stairsCount {
	
	static Long[][] dp;
	final static long mod = 1000000000;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		
		dp = new Long[N+1][10];
		
		for(int i=0; i<10; ++i)
			dp[1][i] = 1L;
		
		long result = 0;
		
		// 재귀호출 방식 - top down
		//for(int i=1; i<10; ++i)
			//result += count(N, i);
		
		// for문 방식 - bottom up
		for(int i=2; i<=N; ++i) {
			for(int j=0; j<10; ++j) {
				if(j == 0)
					dp[i][j] = dp[i-1][1] % mod;
				else if(j == 9)
					dp[i][j] = dp[i-1][8] % mod;
				else
					dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % mod;
			}
		}
		for(int i=0; i<10; ++i)
			result += dp[N][i];
		
		System.out.println(result % mod);
		scan.close();
	}
	
	static long count(int digit, int val) {
		if(digit == 1)
			return dp[digit][val];
		
		if(dp[digit][val] == null) {
			if(val == 0) 
				dp[digit][val] = count(digit-1, 1);
			else if(val == 9)
				dp[digit][val] = count(digit-1, 8);
			else
				dp[digit][val] = count(digit-1, val-1) + count(digit-1, val+1);
		}
		
		return dp[digit][val] % mod;
	}

}
