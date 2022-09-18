package study_07_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17086 {
	static int N, M;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int max = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] != 1) {
					max = Math.max(max, bfs(i,j));
				}
			}
		}
		
		System.out.println(max);
		
	}

	private static int bfs(int i, int j) {
		boolean[][] visit = new boolean[N][M];
		
		int[] dx = {0,0,-1,1,1,-1,-1,1};
		int[] dy = {-1,1,0,0,1,-1,1,-1};
		
		Queue<int[]> queue = new LinkedList();
		int[] xy = {i,j,1};
		queue.add(xy);
		int cnt = 1;
		
		visit[i][j] = true;
		
		while(!queue.isEmpty()) {
			int[] cur = queue.poll();
			int x = cur[0];
			int y = cur[1];
			cnt = cur[2];
			
			for(int d=0; d<8; d++) {
				int X = x+dx[d];
				int Y = y+dy[d];
				
				if(X<N && X>=0 && Y<M && Y>=0 && !visit[X][Y]) {
					if(arr[X][Y]==1) return cnt;
					if(arr[X][Y] != 1) {
						int[] XY = {X, Y, cnt+1};
						queue.add(XY);
						visit[X][Y] = true;
					}
				}
			}
			
		}
		
		return cnt;
	}

}
