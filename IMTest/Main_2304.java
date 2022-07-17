import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;
/*
 * ㅅㅂ 어디가 틀린지 모르겠다
 * 개짱나
 * 나 바보인가
 */
public class Main_2304 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[n][2];
		int max = 0;
		int sum = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			if(max < arr[i][1]) max = arr[i][1];
		}
		
		Arrays.sort(arr, new Comparator<int[]>() { 
			@Override 
			public int compare(int[] o1, int[] o2) {
				return o1[0] - o2[0];
			}
		});
		
		int fx = arr[0][0];
		int bx = arr[n-1][0];
		
		int i=0;
		int x =0, h = arr[0][1];
		
		while(max != arr[i][1]) {
			
			x += arr[i+1][0] - arr[i][0];
			
			if(arr[i+1][1]>arr[i][1]) {
				sum += x*h;
				x = 0;
				h = arr[i+1][1];
			}
			i++;
			fx = arr[i][0];
		}
		
		i = n-1;
		x =0; h = arr[n-1][1];
		
		while(max != arr[i][1]) {
			
			x += arr[i][0] - arr[i-1][0];
			
			if(arr[i-1][1]>arr[i][1]) {
				sum += x*h;
				x = 0;
				h = arr[i-1][1];
			}
			i--;
			bx = arr[i][0];
		}
		
		sum += (bx-fx+1)*max;
		
		System.out.println(sum);

	}
}
