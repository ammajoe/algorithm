import java.util.Scanner;

public class Main_10974 {
	static int N;
	static int[] per;
	static boolean[] isSelected;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		isSelected = new boolean[N];
		per = new int[N];
		
		perm(0);
	}
	
	public static void perm(int cnt) {
		
		if(cnt == N) {
			for(int i=0; i<N; i++) {
				System.out.print(per[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(isSelected[i]) continue;
			
			per[cnt] = i+1;
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i] = false;
		}
	}
}
