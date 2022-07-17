import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_9229 {
	static int[] input, numbers;
	static int N, M, max;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int T = Integer.parseInt(str);
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			input = new int[N];
			numbers = new int[2];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			max = -1;
			solve(0,0);
			
			System.out.println("#"+tc+" "+max);
		}
	}
	
	public static void solve(int cnt, int start) {
		
		if(cnt == 2) {
			int weight = numbers[0]+numbers[1];
			
			if(weight > M) return;
			
			max = Math.max(max, weight);
			return;
		}
		
		for(int i=start; i<N; i++) {
			numbers[cnt] = input[i];
			solve(cnt+1, i+1);
		}
		
	}

}
