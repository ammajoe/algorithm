package study_08_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17276 {
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			int arr[][] = new int[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int D = 0;
			if(Math.abs(d)==360) D=0;
			else if(d<0) D = Math.abs(d)/45;
			else if(d>0) D = (360-d)/45;
			
			for(int i=0; i<D; i++) {
				// 반시계방향 돌리기
				int n = N;
				int center = n/2;
				int start_x=0;
				int start_y=0;
				
				int start = arr[start_x][start_y];
				
				// 시작하는 값이 센터가 아닐동안
				while(!(start_x==center && start_y==center)) {
					int x=start_x;
					int y=start_y;
					
					// 4방향 돌기
					int idx = 0;
					
					while(idx < 4) {
						int X = x + (n/2)*dx[idx];
						int Y = y + (n/2)*dy[idx];
						
						if(X<start_x || X >= (N-start_x) || Y <start_y || Y >= (N-start_y)) {
							idx++;
							continue;
						}
						// 다음칸 땡기기
						arr[x][y] = arr[X][Y];
						x=X;
						y=Y;
					}
					
					arr[x - (n/2)*dx[3]][y - (n/2)*dy[3]] = start;
					
					n=n-2;
					
					start_x +=1;
					start_y +=1;
					
					start = arr[start_x][start_y];
				}
			}
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}
		
	}

}
