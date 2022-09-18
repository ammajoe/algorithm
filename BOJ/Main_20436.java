package study_07_04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_20436 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		char left = st.nextToken().charAt(0);
		char right = st.nextToken().charAt(0);
		
		char[] word = br.readLine().toCharArray();
		
		char[][] arr = new char[3][10];
		
		String first = "qwertyuiop";
		String sec = "asdfghjkl0";
		String third = "zxcvbnm000";
		
		arr[0] = first.toCharArray();
		arr[1] = sec.toCharArray();
		arr[2] = third.toCharArray();
		
		int cnt = 0;
		
		int left_x = 0;
		int left_y = 0;
		
		int right_x = 0;
		int right_y = 0;
		
		for(int i=0; i<3; i++) {
			for(int j=0; j<10; j++) {
				
				if(arr[i][j] == left) {
					left_x = i;
					left_y = j;
				}
				
				if(arr[i][j] == right) {
					right_x = i;
					right_y = j;
				}
			}
		}
		
		for(int w=0; w<word.length; w++) {
			
			for(int i=0; i<3; i++) {
				for(int j=0; j<10; j++) {
					
					if(arr[i][j] == word[w]) {
						// 왼손일 떄
						if((i==0 && j<5) || (i==1 && j<5) || (i==2 && j<4)) {
							cnt += Math.abs(left_x-i) + Math.abs(left_y-j);
							left_x = i;
							left_y = j;
						}else {
							cnt += Math.abs(right_x-i) + Math.abs(right_y-j);
							right_x = i;
							right_y = j;
						}
					}
				}
			}
		}
		
		System.out.println(cnt+word.length);
	}
}
