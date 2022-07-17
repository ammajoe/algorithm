import java.util.Scanner;

public class Solution_5215 {
	static int[][] arr;
	static int N, L, max;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc=1; tc<=T; tc++) {
			N = sc.nextInt();
			L = sc.nextInt();
			arr = new int[N][2];
			
			for(int i=0; i<N; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}
			
			max = 0;
			
			solve(0,0,0);
			
			System.out.println("#"+tc+" "+max);
			
			
		}
	}
	
	public static void solve(int cnt, int grade, int kcal) {
		
		if(kcal > L) return;
		
		if(cnt == N) {
			max = Math.max(max, grade);
			return;
		}
		
		solve(cnt+1, grade, kcal);
		solve(cnt+1, grade+arr[cnt][0], kcal+arr[cnt][1]);

	}

}
