import java.util.*;
import java.io.*;

public class Main_panel {
	static int[][] number= {
			{1,1,1,0,1,1,1},
			{0,0,1,0,0,1,0},
			{0,1,1,1,1,0,1},
			{0,1,1,1,0,1,1},
			{1,0,1,1,0,1,0},
			{1,1,0,1,0,1,1},
			{1,1,0,1,1,1,1},
			{1,1,1,0,0,1,0},
			{1,1,1,1,1,1,1},
			{1,1,1,1,0,1,1}
	};
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			System.out.println(swtich(s,e));
		}
	}
	
	private static int swtich(int s, int e) {
		
		int cnt = 0;
		
		int[][] first= new int[5][];
		int[][] second = new int[5][];
		
		
		String strS = Integer.toString(s); 
		int[] arrS = new int[strS.length()]; 
		
		for (int i = 0; i < strS.length(); i++) { 
			arrS[i] = strS.charAt(i) - '0'; 
		}
//		System.out.println(strS.length());
		int idx=0;
		int x = 0;
		while(idx<5) {
			if(idx < 5-strS.length()) {
				first[idx++] = new int[7];
			}else {
				first[idx++] = number[arrS[x++]];
			}
		}
		
		String strE = Integer.toString(e); 
		int[] arrE = new int[strE.length()]; 
		for (int i = 0; i < strE.length(); i++) { 
			arrE[i] = strE.charAt(i) - '0'; 
		}
		
		idx=0;
		x=0;
		while(idx<5) {
			if(idx < 5-strE.length()) {
				second[idx++] = new int[7];
			}else {
				second[idx++] = number[arrE[x++]];
			}
		}
		
		for(int n=0; n<5; n++) {
			for(int j=0; j<7; j++) {
				if(first[n][j] != second[n][j]) cnt++;
			}
		}
		
		return cnt;
	}
}
