package BackJun.DP;

import java.util.Scanner;

public class fibonacciFunc {

	static Integer[][] arr = new Integer[41][2];

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = scan.nextInt();

		arr[0][0] = 1;
		arr[0][1] = 0;
		arr[1][0] = 0;
		arr[1][1] = 1;

		while (T-- > 0) {
			int n = scan.nextInt();
			fibonacci(n);
			sb.append(arr[n][0] + " " + arr[n][1] + "\n");
		}
		System.out.println(sb);
		scan.close();

	}

	static Integer[] fibonacci(int n) {
		if (arr[n][0] == null && arr[n][1] == null) {
			arr[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
			arr[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
		}
		return arr[n];
	}
}
