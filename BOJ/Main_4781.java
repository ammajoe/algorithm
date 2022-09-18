package suwan_09_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4781 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		
		while(true) {
			st= new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st.nextToken()); // 사탕 가지수
			double tmp = Double.parseDouble(st.nextToken());
			int m = (int) ((tmp+0.005)*100); // 가지고 있는 돈의 양
			
			if(n==0 && m==0) break;
			
			int[][] arr = new int[n+1][2];
			int[] dp = new int[m+1];
			
			// 입력 받기
			for (int i = 1; i <= n; i++) {
				st = new StringTokenizer(br.readLine()); // arr[i][0] : 칼로리
				arr[i][0] = Integer.parseInt(st.nextToken());
				tmp = Double.parseDouble(st.nextToken());
				arr[i][1] = (int) ((tmp+0.005)*100); // arr[i][1] : 가격
			}
			
			for (int k = 1; k < m+1; k++) {
				for (int i = 1; i < n+1; i++) {
					if(k - arr[i][1] >=0){
						dp[k] = Math.max(dp[k], dp[k-arr[i][1]] + arr[i][0]);
					}
					
				}
			}
			
			System.out.println(dp[m]);
		}
	}

}
