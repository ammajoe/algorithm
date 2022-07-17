import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_21608 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int dx[] = {-1,1,0,0};
		int dy[] = {0,0,1,-1};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N+1][N+1];
		int[][] student = new int[N*N][5];
		int[] satis = new int[N*N];
		
		for(int t=0; t<N*N; t++) {
			// 한명씩 입력 받기
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<5; i++) {
				student[t][i] = Integer.parseInt(st.nextToken());
			}
			
			int max = 0;
			int maxi = 0; 
			int maxj = 0;
			int start = 0;
			// N*N칸 돌아보기
			outer:for(int i=1; i<N+1; i++) {
				for(int j=1; j<N+1; j++) {
					int cnt = 0;
					
					if(t==0) {
						arr[2][2] = student[t][0];
						continue outer;
					}
					
					if(arr[i][j] !=0) continue;
					
					// 4방향 탐색하기
					for(int k = 0; k<4; k++) {
						int X = i+dx[k];
						int Y = j+dy[k];
						
						if(X>0 && X<N+1 && Y>0 && Y<N+1) {
							if(start==0) {
								maxi=i;
								maxj=j;
								start=1;
							}
							//좋아하는 친구 있는지
							for(int m = 1; m<=4; m++) {
								// 좋아하는 친구일 때
								if(arr[X][Y] == student[t][m]) cnt++;
								
							}
						}
					}
										
					if(max < cnt) {
						max = cnt;
						maxi=i;
						maxj=j;
					}else if(max == cnt) {
						int mn=0;
						int cn=0;
						// 주위 빈칸 세기
						for(int m = 0; m<4; m++) {
							int iX = i+dx[m];
							int iY = j+dy[m];
							
							int mX = maxi+dx[m];
							int mY = maxj+dy[m];
							
							if(iX>0 && iX<N+1 && iY>0 && iY<N+1 && arr[iX][iY] ==0) cn++;
							if(mX>0 && mX<N+1 && mY>0 && mY<N+1 && arr[mX][mY] ==0) mn++;
							
						}
						
						if(mn < cn) {
							max = cnt;
							maxi=i;
							maxj=j;
							
						}else if(mn == cn) {
							// 빈칸 수 같을 때 행,열 순으로 작은 곳 
							if(maxi > i) {
								max = cnt;
								maxi=i;
								maxj=j;
								
							}else if(maxi == i) {
								if(maxj > j) {
									max = cnt;
									maxi=i;
									maxj=j;
									
								}
							}
						}
					}
				}
			}
			arr[maxi][maxj] = student[t][0];
		}
		
		
		// 만족도 조사
		int sat = 0;
		for(int t=0; t<N*N; t++) {
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					
					if(arr[i][j] == student[t][0]) {
						sat = 0;
						for(int k = 0; k<4; k++) {
							
							int X = i+dx[k];
							int Y = j+dy[k];
							
							if(X>0 && X<N+1 && Y>0 && Y<N+1) {
								//좋아하는 친구 있는지
								for(int m = 1; m<=4; m++) {
									// 좋아하는 친구일 때
									if(arr[X][Y] == student[t][m]) sat++;
								}
							}
						}
					}
					satis[t] = sat;
				}
			}
		}
		
		// 점수 더하기
		int ans = 0;
		
		int[] grade = {0,1,10,100,1000};
		
		for(int i=0; i<N*N; i++) {
			ans += grade[satis[i]];
		}
		System.out.println(ans);
	}
	
}
