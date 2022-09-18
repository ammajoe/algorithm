package study_08_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3020 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // n미터
		int h = Integer.parseInt(st.nextToken()); // h미터

		int up[] = new int[h+1];
		int down[] = new int[h+1];
		
		for(int i=0; i<n; i++) {
			if(i%2==0) down[Integer.parseInt(br.readLine())]++;
			else up[h-Integer.parseInt(br.readLine())]++;
		}
		
		// 누적합 구하기
		for (int i=1; i<=h; i++) {
			down[i] += down[i-1];
		}
		for (int i=h-1; i>=1; i--) {
			up[i] += up[i+1];
		}
		
		int min = n;
		int cnt = 0;

		for (int i=1; i<=h; i++) {
			int count = (down[h]-down[i-1]) + (up[1]-up[i]);
			if (count < min) {
				min = count;
				cnt = 1;
			} else if (count == min)
				cnt++;
		}
		
		System.out.println(min+" "+cnt);
	}
}
