package suwan_09_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5582 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		char[] ch1 = str1.toCharArray();
		char[] ch2 = str2.toCharArray();
		
		int len1 = str1.length();
		int len2 = str2.length();
		
		int max = 0;
		
		int[][] arr = new int[len1+1][len2+1];
		
		for(int i=1; i<=len1; i++) {
			for(int j=1; j<=len2; j++) {
				if(ch1[i-1] == ch2[j-1]) {
					arr[i][j] = arr[i-1][j-1]+1;
					max = Math.max(max, arr[i][j]);
				}
			}
		}
		
		System.out.println(max);
		
	}

}
