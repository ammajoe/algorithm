import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14503 {
	static int n,m,cnt;
	static int[][] arr;
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, 1, 0, -1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cnt = 0;
		dfs(r,c,d);
		System.out.println(cnt);
	}

	private static void dfs(int r, int c, int d) {
		// 현재 위치 청소
		if(arr[r][c]==0) {
			cnt++;
			arr[r][c]=-1;
		}
		
		
		for(int i=0; i<4; i++) {
			d = (d + 3) % 4;
			int x = r+dx[d];
			int y = c+dy[d];
			
			if(x>0 && x<n && y>0 && y<m && arr[x][y]==0) {
				dfs(x,y,d);
				return;
			}
		}
		
		int dir = (d+2)%4;
		int x = r+dx[dir];
		int y = c+dy[dir];
		
		if(x>=0 && x<n && y>=0 && y<m && arr[x][y]!=1) {
			dfs(x,y,d);
		}
	}
}
