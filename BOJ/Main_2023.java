package suwan_09_02;

import java.util.Scanner;

public class Main_2023 {
	static int n;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		dfs(0,0);
	}
	
	private static void dfs(int num, int cnt) {
		
		if(cnt == n) {
			System.out.println(num);
			return;
		}
		
		for(int i=1; i<=9; i++) {
			if(isPrime(num*10+i)) dfs(num*10+i,cnt+1);
		}
	}

	private static boolean isPrime(int num) {
		
		if(num <2) return false;
		
		for(int i=2 ; i*i<=num; i++) {
			if(num%i==0) return false;
		}
		
		return true;
	}
}
