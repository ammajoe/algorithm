package study_07_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_5212 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		char[][] arr = new char[r+2][c+2];
		char[][] ans = new char[r+2][c+2];
		
		// 입력받기
		for(int i=0; i<r; i++) {
			
			String str = br.readLine();
			char[] temp = str.toCharArray();
			
			for(int j=0; j<c; j++) {
				arr[i+1][j+1] = temp[j];
				ans[i+1][j+1] = temp[j];
			}
		}
		
		for(int i=0; i<r+2; i++) {
			arr[i][0] = '.';
			arr[i][c+1] = '.';
		}
		for(int i=0; i<c+2; i++) {
			arr[0][i] = '.';
			arr[r+1][i] = '.';
		}
		
		int dx[] = {-1,1,0,0};
		int dy[] = {0,0,-1,1};
		
		for(int i=0; i<r; i++) {
			for(int j=0; j<c; j++) {
				if(arr[i+1][j+1]=='.') continue;
				int cnt = 0;
				for(int d=0; d<4; d++) {
					int X = i+1 + dx[d];
					int Y = j+1 + dy[d];
					if(arr[X][Y] == '.') cnt++;
				}
				if(cnt >= 3) ans[i+1][j+1] = '.';				
			}
		}
		int first_start = Integer.MAX_VALUE;
		int first_end = 0;
		
		int last_start = Integer.MAX_VALUE;
		int last_end = 0;
		
		for(int i=0; i<r+2; i++) {
			for(int j=0; j<c+2; j++) {
				if(ans[i][j] == 'X') {
					first_start = Math.min(first_start, i);
					first_end = Math.max(first_end, i);
				}
			}
		}
		
		for(int i=0; i<c+2; i++) {
			for(int j=0; j<r+2; j++) {
				if(ans[j][i] == 'X') {
					last_start = Math.min(last_start, i);
					last_end = Math.max(last_end, i);
				}
			}
		}
		
		for(int i=first_start; i<=first_end; i++) {
			for(int j=last_start; j<=last_end; j++) {
				System.out.print(ans[i][j]);
			}
			System.out.println();
		}
	}

}
