import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17485 {
	static int[] dy = {-1,0,1};
	static int[][] arr, dp;
	static int n,m;
	public static void main(String[] args) throws IOException {
		// 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 행렬 크기
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		// arr, dp 배열
		arr = new int[n][m];
		dp = new int[n+1][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<n+1; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		
		for(int i=0; i<m; i++) {
			dp[0][i] = arr[0][i];
		}
		
		for(int i=0; i<m; i++) {
			dfs(0, i, 1);
		}
		
		for(int i=0; i<n+1; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		
		// 최소 연료값 출력
		int min = Integer.MAX_VALUE;
		for(int i=0; i<m; i++) {
			min = Math.min(dp[n][i], min);
		}
		System.out.println(min);
		
	}
	
	private static void dfs(int r, int c, int d) {
		
		if(r == n) return;
		
		for(int i=0; i<3; i++) {
			int nr = r+1;
			int nc = c+dy[i];
			
			// 이전과 같은 방향이면 탐색하지 않음.
			if(i == d) continue;
			// 범위 벗어나면 탐색하지 않음.
			if(nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
			
			dp[nr][nc] = Math.min(dp[nr][nc], dp[r][c]+arr[nr][nc]);
			System.out.println(nr+" "+nc+" "+d+" "+dp[nr][nc]);
			dfs(nr, nc, i);
			
		}
		
	}

}
