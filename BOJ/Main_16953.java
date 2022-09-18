package study_07_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16953 {
	static long min, a, b;
	static boolean success;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		min = Integer.MAX_VALUE;
		success = false;
		
		dfs(a, 1);
		
		if(!success) System.out.println(-1);
		else System.out.println(min);
		
	}

	private static void dfs(long num, int cnt) {
		
		if(num > b) return;
		
		if(num == b) {
			min = Math.min(min, cnt);
			success = true;
			return;
		}
		
		dfs(num*2, cnt+1);
		dfs(num*10+1, cnt+1);
	}

}
