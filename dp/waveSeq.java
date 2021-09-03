package BackJun.DP;

import java.util.Scanner;

public class waveSeq {

	static Long[] dp;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		Long[] answer = new Long[N];
		dp = new Long[101];
		
		dp[0] = 0L;
		dp[1] = 1L;
		dp[2] = 1L;
		dp[3] = 1L;
		
		
		for(int i=0; i<N; ++i) {
			int t = scan.nextInt();
			answer[i] = count(t);
		}
		for(Long i : answer)
			System.out.println(i);
		scan.close();
	}

	static long count(int n) {
		if(dp[n] == null)
			dp[n] = count(n-2) + count(n-3);
		return dp[n];
	}
}
