package BackJun.DP;
import java.util.Arrays;
import java.util.Scanner;

public class increaseSequence {

	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		int A = init();
		int[] number = new int[A];
		int[] dp = new int[A];
		
		for(int i=0; i<A; ++i)
			number[i] = init();
		
		for(int i=0; i<A; ++i) {
			dp[i] = 1;
			
			for(int j=0; j<i; ++j) {
				if(number[i] > number[j] && dp[i] <= dp[j])
					dp[i] = dp[j]+1;
			}
		}
			
			
		System.out.println(Arrays.stream(dp).max().getAsInt());

	}
	static int init() {
		return scan.nextInt();
	}

}
