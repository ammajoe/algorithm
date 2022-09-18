package study_08_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3079 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		int max = 0;
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }
        
        long left = 0L;
        long right = (max) * 1000000000L;
		
        long ans = 0L;
        
		while(left <= right) {
			
			long mid = (left+right)/2;
			
			long cnt = time(arr, mid);
//			System.out.println(cnt);
			
			if(cnt >= m) {
				ans = mid;
				right = mid-1;
			} else if(cnt < m) {
				left = mid+1;
			}
		}
		
		System.out.println(ans);
	}
	
	private static long time(int[] arr, long mid) {
		long cnt = 0;
		
		for(int i=0; i<arr.length; i++) {
			cnt += (mid/arr[i]);
		}
		
		return cnt;
	}

}
