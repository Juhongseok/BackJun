package BackJun.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class z {

	static int[][] arr;
	static int count = 0;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		divide((int)Math.pow(2,N), r, c);
		System.out.println(count);
	}

	public static void divide(int size, int r, int c) {
		if(size == 1)
			return;
		
		if(r < size/2 && c < size/2)
			divide(size/2, r, c);
		else if(r < size/2 && c >= size/2) {
			count += size * size / 4;
			divide(size/2, r, c-size/2);
		}
		else if(r >= size/2 && c < size/2) {
			count += size * size / 4 * 2;
			divide(size/2, r-size/2, c);
		}
		else if(r >= size/2 && c >= size/2){
			count += size * size / 4 * 3;
			divide(size/2, r-size/2, c-size/2);
		}
	}
}