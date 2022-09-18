import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1260 {
	static int[][] arr;
	static int n,m,v;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		v = Integer.parseInt(st.nextToken());
		
		arr = new int[n+1][n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			arr[v1][v2] = 1;
			arr[v2][v1] = 1;
		}
		
		boolean[] visit = new boolean[n+1];
		visit[v] = true;
		System.out.print(v+" ");
		dfs(v,visit);
		
		System.out.println();
		
		visit = new boolean[n+1];
		bfs(visit);
		
	}
	
	private static void dfs(int cur, boolean[] visit) {
		
		for(int i=1; i<=n; i++) {
			
			if(arr[cur][i] == 1 || arr[i][cur] == 1) {
				if(!visit[i]) {
					System.out.print(i+" ");
					visit[i] = true;
					dfs(i, visit);
				}
			}
		}
	}
	
	private static void bfs(boolean[] visit) {
		Queue<Integer> queue = new LinkedList<Integer>();
		
		queue.add(v);
		visit[v] = true;
		
		while(!queue.isEmpty()) {
			
			int cur = queue.poll();
			System.out.print(cur+" ");
			
			for(int i=1; i<=n; i++) {
				if(arr[cur][i] == 1 || arr[i][cur]==1) {
					if(!visit[i]) {
						queue.add(i);
						visit[i] = true;
					}
				}
			}
		}
	}
}
