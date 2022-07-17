import java.util.*;
import java.io.*;

public class Main_GBC {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] el = new int[100];
		int[] ex = new int[100];
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int idx=0;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<l; j++) {
				el[idx++] = v; 
			}
		}
		
		idx=0;
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<l; j++) {
				ex[idx++] = v; 
			}
		}
		
		int max = 0;
		
		for(int i=0; i<100; i++) {
			max = Math.max(max, ex[i]-el[i]);
		}
		
		System.out.println(max);
		
	}
}
