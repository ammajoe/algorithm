package study_07_04;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main_15683 {
	static int R, C, len, min;
	// 상, 좌, 하, 우
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,-1,0,1};
	
	static LinkedList<int[]> list;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[R][C];
		
		list = new LinkedList();
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] != 0 && arr[i][j] !=6) {
					int[] xy = {arr[i][j], i, j};
					list.add(xy);
				}
			}
		}
		
		len = list.size();
		min = Integer.MAX_VALUE;
		
		dfs(0, arr);
		System.out.println(min);
		
	}
	
	private static void dfs(int idx, int[][] arr) {
		int[][] v = new int[R][C];
		if(idx == len) {
			int cnt = count(arr);
			if(min > cnt) {
				min = cnt;
				
			}
			return;
		}
		
		int num = list.get(idx)[0];
		int x = list.get(idx)[1];
		int y = list.get(idx)[2];
		
		if(num==1) {
			
			for(int d=0; d<4; d++) {
				v = copy(arr);
				int X = x;
				int Y = y;
				while(true) {
					X+= dx[d];
					Y+= dy[d];
					if(X < 0 || X >= R || Y < 0 || Y >= C || v[X][Y] == 6) break;
					if(v[X][Y]==0) v[X][Y] = 7;
				}
				dfs(idx+1, v);
			}
		}else if(num==2) {
			
			for(int d=0; d<2; d++) {
				v = copy(arr);
				for(int r=0; r<3; r=r+2) {
					int X = x;
					int Y = y;
					while(true) {
						X += dx[(d+r)%4];
						Y += dy[(d+r)%4];
						if(X < 0 || X >= R || Y < 0 || Y >= C || v[X][Y] == 6) break;
						if(v[X][Y]==0) v[X][Y] = 7;
					}
				}
				
				dfs(idx+1, v);
			}
		}else if(num == 3) {
			
			for(int d=0; d<4; d++) {
				v = copy(arr);
				for(int r=0; r<2; r++) {
					int X = x;
					int Y = y;
					while(true) {
						X+=dx[(d+r)%4];
						Y+=dy[(d+r)%4];
						if(X < 0 || X >= R || Y < 0 || Y >= C || v[X][Y] == 6) break;
						if(v[X][Y]==0) v[X][Y] = 7;
					}
				}
				
				dfs(idx+1, v);
			}
		}else if(num == 4) {
			for(int d=0; d<4; d++) {
				v = copy(arr);
				for(int r=0; r<3; r++) {
					int X = x;
					int Y = y;
					while(true) {
						X+=dx[(d+r)%4];
						Y+=dy[(d+r)%4];
						if(X < 0 || X >= R || Y < 0 || Y >= C || v[X][Y] == 6) break;
						if(v[X][Y]==0) v[X][Y] = 7;
					}
				}
				dfs(idx+1, v);
			}
		} else if(num == 5) {
			v = copy(arr);
			for(int d=0; d<4; d++) {
				int X = x;
				int Y = y;
				while(true) {
					X+= dx[d];
					Y+= dy[d];
					if(X < 0 || X >= R || Y < 0 || Y >= C || v[X][Y] == 6) break;
					if(v[X][Y]==0) v[X][Y] = 7;
				}
			}
			dfs(idx+1, v);
		}
	}
	
	private static int[][] copy(int[][] arr){
		int[][] copy_arr = new int[R][C];
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				copy_arr[i][j] = arr[i][j];
			}
		}
		
		return copy_arr;
	}
	
	private static int count(int[][] arr) {
		int cnt=0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arr[i][j] == 0) cnt++;
			}
		}
		
		return cnt;
	}

}
