package BackJun.DP;

import java.util.Scanner;

public class tile3 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int[] dp = new int[N+1];
		
		if(N%2 != 0)
			dp[N] = 0;
		dp[0] = 1;
		if(N>=2)
			dp[2] = 3;
		
		for(int i=4; i<=N; i+=2) {
			dp[i] = dp[i-2]*3;
			for(int j=0; j<i-2; j+=2)
				dp[i] += dp[j]*2;
		}
		System.out.println(dp[N]);
		scan.close();
	}

}
/*
 * N answer
0  1
1  0
2  dp[0]*3 = 3
3  0
4  dp[2]*3+2
5  0
6  dp[4]*3+dp[2]*2+2
*/
