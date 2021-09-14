package BackJun.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Alphabet {
	
	static int r, c, max = 0;
	static char[][] arr;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new char[r+1][c+1];
		visit = new boolean[26];
		
		for(int i=1; i<=r; ++i) {
			String s = br.readLine();
			for(int j=1; j<=c; ++j)
				arr[i][j] =s.charAt(j-1);
		}		
		dfs(1,1,1);
		System.out.println(max);
	}
	
	static void dfs(int x, int y, int d) {
		int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};
		
		visit[arr[x][y] - 'A'] = true; // 지나 간것 을 표시
		for(int i=0; i<4; ++i) {
			int x_ = x+dx[i], y_ = y+dy[i];
			
			if(0 < x_ && x_ <= r && 0 < y_ && y_ <= c)
				if(!visit[arr[x_][y_]-'A'])
					dfs(x_, y_, d+1);
		}
		visit[arr[x][y]-'A'] = false; // 다음 깊이 탐색을 위한 초기화 과정
		max = Math.max(max, d);
	}
}