package BackJun.DP;

import java.util.Scanner;

public class ÀÌÄ£¼ö {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		long[] dp = new long[N];

		if (N == 1)
			System.out.println(1);
		else {

			dp[0] = 1;
			dp[1] = 1;

			for (int i = 2; i < N; ++i)
				dp[i] = dp[i - 1] + dp[i - 2];
			System.out.println(dp[N - 1]);
		}
		scan.close();
	}

}
