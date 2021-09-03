package BackJun.DP;

import java.util.Scanner;

public class sumDiv {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int k = scan.nextInt();
		
		int[][] arr = new int[n][k];

		for(int i=0; i<n; ++i) 
			arr[i][0] = 1;
			
		for(int i=0; i<k; ++i)
			arr[0][i] = i+1;
		
		for(int i=1; i<n; ++i)
			for(int j=1; j<k; ++j)
				arr[i][j] = (arr[i-1][j] + arr[i][j-1]) % 1000000000;
		
		System.out.println(arr[n-1][k-1]);
		scan.close();
	}

}
