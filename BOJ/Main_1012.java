package study_07_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_1012 {
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int N,M;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			arr = new int[M][N];
			
			LinkedList<int []> list = new LinkedList();
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				arr[x][y] = 1;
				int[] xy = {x,y};
				list.add(xy);
			}
			
			int cnt = 0;
			for(int i=0; i<K; i++) {
				if(arr[list.get(i)[0]][list.get(i)[1]] !=0) {
					dfs(list.get(i)[0], list.get(i)[1]);
					cnt++;
				}
			}
			
			System.out.println(cnt);
		}
	}
	
	private static void dfs(int i, int j) {
		
		for(int d=0; d<4; d++) {
			int X = i + dx[d];
			int Y = j + dy[d];
			
			if(X<M && X >=0 && Y < N && Y >=0) {
				if(arr[X][Y] == 1) {
					arr[X][Y] = 0;
					dfs(X,Y);
				}
			}
		}
	}

}
