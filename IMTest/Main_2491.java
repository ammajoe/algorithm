import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2491 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		st = new StringTokenizer(br.readLine());
		
		int cnt_1 = 1;
		int cnt_2 = 1;
		int max = 1;
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int idx=1; idx<N; idx++) {
			
			if(arr[idx-1] <= arr[idx]) {
				cnt_1 += 1;
			}else cnt_1 = 1;
			
			if(arr[idx-1] >= arr[idx]) {
				cnt_2 += 1;
			}else cnt_2 = 1;
			
			int cnt = Math.max(cnt_1, cnt_2);
			max = Math.max(max, cnt);
		}

		System.out.println(max);
		
	}
}
