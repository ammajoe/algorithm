import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken()); // 가로 수
		int n = Integer.parseInt(st.nextToken()); // 세로 수
		int h = Integer.parseInt(st.nextToken()); // 높이
		
		int[][][] arr = new int[h][n][m]; // 토마토 상자
		
		Queue<int[]> queue = new LinkedList<int[]>();
		
		// 1 : 익은 토마토, 0 : 익지 않은 토마토, -1 : 빈칸
		for(int k=0; k<h; k++) {
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<m; j++) {
					int tomato = Integer.parseInt(st.nextToken());
					arr[k][i][j] = tomato;
					int[] xy = {k,i,j,0};
					if(tomato == 1)	queue.add(xy);
				}
			}
		}
		
		if(isGood(arr)) System.out.println(0);
		
		else {
			int dx[] = {0,0,1,-1};
			int dy[] = {1,-1,0,0};
			int dh[] = {1,-1};
			
			int day = 0;
			
			while(!queue.isEmpty()) {
				int[] cur = queue.poll();
				
				int z = cur[0];
				int x = cur[1];
				int y = cur[2];
				day = cur[3];
				for(int i=0; i<4; i++) {
					int X = x+dx[i];
					int Y = y+dy[i];
					if(X>=0 && X <n && Y>=0 && Y<m) {
						if(arr[z][X][Y] == 0) {
							int[] zxy = {z,X,Y,day+1};
							arr[z][X][Y] = 1;
							queue.add(zxy);
						}
					}
				}
				
				for(int i=0; i<2; i++) {
					int Z = z+dh[i];
					if(Z>=0 && Z < h) {
						if(arr[Z][x][y] == 0) {
							int[] zxy = {Z,x,y,day+1};
							arr[Z][x][y] = 1;
							queue.add(zxy);
						}
					}
				}
			}
			
			if(isGood(arr)) System.out.println(day);
			else System.out.println(-1);
		}
	}
	
	private static boolean isGood(int[][][] arr) {
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				for(int k=0; k<arr[i][j].length; k++) {
					if(arr[i][j][k] == 0) return false;
				}
			}
		}
		
		return true;
	}

}
