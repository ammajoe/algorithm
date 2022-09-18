import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2606 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n+1][n+1];
		
		// 입력받기
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			arr[v1][v2] = 1;
			arr[v2][v1] = 1;
		}
		
		boolean[] visit = new boolean[n+1];
		Queue<Integer> queue = new LinkedList<Integer>();
		
		int cnt = 0;
		queue.add(1);
		visit[1] = true;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for(int i=1; i<=n; i++) {
				if(arr[cur][i]==1 || arr[i][cur]==1) {
					if(!visit[i]) {
						queue.add(i);
						visit[i] = true;
						cnt++;
					}
				}
			}
		}
		
		System.out.println(cnt);
	}
}
