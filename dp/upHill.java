package BackJun.DP;

import java.util.Arrays;
import java.util.Scanner;

public class upHill {

	static int N;
	static int[] dp;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		int result = 0;
		
		dp = new int[10];
		for(int i=0; i<10; ++i)
			dp[i] = 1;
		
		if(N == 1)
			result = Arrays.stream(dp).sum();
		else {
			for(int j=1; j<N; ++j) {
				for(int i=8; i>=0; --i) { 
					dp[i] += dp[i+1];
					dp[i] %= 10007;
				}
			}
			result = Arrays.stream(dp).sum();
		}
		System.out.println(result%10007);
		scan.close();
	}
}
