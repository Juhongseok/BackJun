package BackJun.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class dfsAndbfs {

	static int[][] arr;
	static boolean[] check;
	static StringBuilder sb;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][N+1];
		check = new boolean[N+1];
		
		for(int i=0; i<M; ++i) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			arr[start][end] =1;
			arr[end][start] = 1;
		}
		
		dfs(V);
		sb.append("\n");
		Arrays.fill(check, false);
		bfs(V);
		
		System.out.println(sb);
		
	}

	static void dfs(int v) {
		sb.append(v + " ");
		check[v] = true;
		
		for(int i=1; i<check.length; ++i)
			if(i!= v && check[i] == false && arr[v][i] == 1)
				dfs(i);
	}
	
	static void bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(v);
		check[v] = true;
		
		while(!q.isEmpty()) {
			int temp = q.poll();
			
			sb.append(temp + " ");
			for(int i=1; i<check.length; ++i)
				if(check[i] == false && arr[temp][i] == 1) {
					q.offer(i);
					check[i] = true;
				}
					
		}
			
	}
}
