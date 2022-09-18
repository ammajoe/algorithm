package study_08_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2792 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int left = 1;
		int right = 0;
		int arr[] = new int[m];
		
		for(int i=0; i<m; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			right = Math.max(right, arr[i]);
		}
		
		int ans = 0;
		
		while (left <= right) {
			int mid = (left + right) / 2;
			
			int cnt = count(arr, mid);
			
			if (cnt > n) {
				left = mid + 1;
			}
			else {
				right = mid - 1;
				ans = mid;
			}
		}
		System.out.println(ans);		
	}
	
	private static int count(int[] arr, int mid) {
		int cnt = 0;
		
		for(int i=0; i<arr.length; i++) {
			cnt += arr[i]/mid;
			if (arr[i] % mid != 0) cnt++;
		}
		return cnt;
	}
}
