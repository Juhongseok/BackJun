package BackJun.DP;

import java.util.Scanner;

public class tile {

	static int n;
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		System.out.println(fillTile());
		scan.close();
		
	}
	
	static int fillTile() {
		int[] tile = new int[n];
		
		if(n == 1)
			return 1;
		else {
			tile[0] = 1;
			tile[1] = 2;
			
			for(int i=2; i<n; ++i)
				tile[i] = (tile[i-1] + tile[i-2])%10007;
			
			return tile[n-1];
		}
	}
}
