package BackJun.DP;

import java.util.Arrays;
import java.util.Scanner;

public class maxSequence {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		int N = scan.nextInt();
		int[] arr = new int[N];
		int[] dp = new int[N];
		
		for(int i=0; i<N; ++i)
			arr[i] = scan.nextInt();
		
		for(int i=0; i<N; ++i) {
			dp[i] = arr[i];
			for(int j=0; j<i; ++j) {
				if(arr[j] < arr[i] && dp[i]<dp[j] + arr[i])
					dp[i] = dp[j] + arr[i];
			}
		}
		System.out.println(Arrays.stream(dp).max().getAsInt());
		scan.close();
	}

}
