import java.util.Arrays;
import java.util.Scanner;

public class Main_2309 {
	static int[] input, numbers, ans;
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		input = new int[9];
		numbers = new int[7];
		ans = new int[7];

		for(int i=0; i<9; i++) {
			input[i] = sc.nextInt();
		}
		solve(0,0);
		for(int i=0; i<7; i++) {
			System.out.println(ans[i]);
		}
	}
	
	public static int sum(int arr[]) {
		
		int sum = 0;
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
		}
		return sum;
	}
	
	public static void solve(int cnt, int start) {
		
		if(cnt == 7) {
			if(sum(numbers)==100) {
				Arrays.sort(numbers);
				for(int i=0; i<7; i++) {
					ans[i] = numbers[i];
				}
			}
			return;
		}
		
		for(int i=start; i<9; i++) {
			numbers[cnt] = input[i];
			solve(cnt+1, i+1);
		}
	}

}
