import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17281 {
	static int n,max;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n][9];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = 0;
		
		boolean[] visit = new boolean[8];
		int[] num = new int[8];
		
		perm(0, visit, num);
		System.out.println(max);
	}
	
	private static void perm(int cnt, boolean[] visit, int[] num) {
		if(cnt==8) {
			play(num);
		}
		
		for(int i=0; i<8; i++) {
			if(!visit[i]) {
				visit[i] = true;
				num[cnt] = i;
				perm(cnt+1, visit, num);
				visit[i] = false;
			}
		}
	}

	private static void play(int[] num) {
		
		int player[] = new int[9];
		player[3] = 0;
		for(int i=0; i<8; i++) {
			if(i>=3) player[i+1] = num[i]+1;
			else player[i] = num[i]+1;
		}
//		System.out.println(Arrays.toString(player));
		
		int cnt = 0;
		int idx = 0; // 현재 타자.
		
		// n이닝 만큼 play
		for(int i=0; i<n; i++) {
			int out = 0;
			int base[] = new int[3];
			while(out<3) {
				int result = arr[i][player[idx]]; // i이닝에 현재 타자의 공격 결과
				
				if(result == 4) {
					for(int j=0; j<3; j++) {
						if(base[j]==1) {
							base[j] = 0;
							cnt++;
						}
					}
					cnt++;
					
				} else if(result==3) {
					if(base[2]==1) {
						cnt++;
						base[2]=0;
					}
					if(base[1]==1) {
						cnt++;
						base[1]=0;
					}
					if(base[0]==1) {
						cnt++;
						base[0]=0;
					}
					base[2] = 1;
					
				} else if(result==2) {
					if(base[2]==1) {
						cnt++;
						base[2]=0;
					}
					if(base[1]==1) {
						cnt++;
						base[1]=0;
					}
					if(base[0]==1) {
						base[2]=1;
						base[0]=0;
					}
					base[1] = 1;
				} else if(result==1) {
					if(base[2]==1) {
						cnt++;
						base[2]=0;
					}
					if(base[1]==1) {
						base[2]=1;
						base[1]=0;
					}
					if(base[0]==1) {
						base[1]=1;
					}
					base[0] = 1;
					
				} else out++;
				
				idx = (idx+1)%9;
			}
		}
		
		max = Math.max(cnt, max);
	}
}


