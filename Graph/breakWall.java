package BackJun.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class breakWall {

	static int[][] arr, visit;
	static int N, M;
	static int answer;
	static int[] dx = {0, 1, 0, -1}, dy = {1, 0, -1, 0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int [N][M];
		visit = new int[N][M];
		answer = -1;
		
		for(int i=0; i<N; ++i) {
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			for(int j=0; j<M; ++j) {
				visit[i][j] = Integer.MAX_VALUE;
				arr[i][j] = temp.charAt(j)-'0';
			}
		}
		bfs(0,0);
		System.out.println(answer);
	}
	
	static void bfs(int x, int y) {
		Queue<place> q = new LinkedList<>();
		q.add(new place(x, y, 1, 0));
		
		while(!q.isEmpty()) {
			place p = q.poll();
			
			if(p.x == N-1 && p.y == M-1) {
				answer = p.dis;
				break;
			}
			
			for(int i=0; i<4; ++i) {
				int x_ = p.x + dx[i];
				int y_ = p.y + dy[i];
				
				if(x_<0 || y_<0 ||x_>=N || y_>=M)
					continue;
				
				if(visit[x_][y_] <= p.breakCount)
					continue;
				
				if(arr[x_][y_] == 0) {
					visit[x_][y_] = p.breakCount;
					q.add(new place(x_, y_, p.dis+1, p.breakCount));
				}
				else {
					if(p.breakCount == 0) {
						visit[x_][y_] = p.breakCount+1;
						q.add(new place(x_, y_, p.dis+1, p.breakCount+1));
					}
				}
			}
		}
		
	}

}
class place{
	int y;
	int x;
	int dis;
	int breakCount;
	
	public place(int x, int y, int dis, int breakCount) {
		this.x = x;
		this.y = y;
		this.dis = dis;
		this.breakCount = breakCount;
	}
}