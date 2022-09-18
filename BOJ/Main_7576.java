import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int m = Integer.parseInt(st.nextToken()); // 가로 수
		int n = Integer.parseInt(st.nextToken()); // 세로 수
		
		int[][] arr = new int[n][m]; // 토마토 상자
		
		Queue<int[]> queue = new LinkedList<int[]>();
		
		// 1 : 익은 토마토, 0 : 익지 않은 토마토, -1 : 빈칸
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				int tomato = Integer.parseInt(st.nextToken());
				arr[i][j] = tomato;
				int[] xy = {i,j,0};
				if(tomato == 1) {
					queue.add(xy);
				}
			}
		}
		
		if(isGood(arr)) System.out.println(0);
		
		else {
			int dx[] = {0,0,1,-1};
			int dy[] = {1,-1,0,0};
			
			
			int day = 0;
			
			while(!queue.isEmpty()) {
				int[] cur = queue.poll();
				
				int x = cur[0];
				int y = cur[1];
				day = cur[2];
//				System.out.println(x+" "+y+" "+day);
				for(int i=0; i<4; i++) {
					int X = x+dx[i];
					int Y = y+dy[i];
					if(X>=0 && X <n && Y>=0 && Y<m) {
						if(arr[X][Y] == 0) {
							int[] xy = {X,Y,day+1};
							arr[X][Y] = 1;
							queue.add(xy);
						}
					}
				}
			}
			
			if(isGood(arr)) System.out.println(day);
			else System.out.println(-1);
		}
	}

	private static boolean isGood(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				if(arr[i][j] == 0) return false;
			}
		}
		return true;
	}

}
