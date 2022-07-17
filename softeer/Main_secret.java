import java.util.*;
import java.io.*;

public class Main_secret {
	static int m,n, ans[], button[];
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken()); // 비밀 버튼 조작
		n = Integer.parseInt(st.nextToken()); // user input
		int k = Integer.parseInt(st.nextToken());
		
		if(m>n) System.out.println("normal");
		else {
			ans = new int[m];
			button = new int[n];
			
			// 조작법 입력 받기
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<m; i++) {
				ans[i] = Integer.parseInt(st.nextToken());
			}
			
			// 사용자의 버튼 조작
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				button[i] = Integer.parseInt(st.nextToken());
			}
			
			if(secret()) System.out.println("secret");
			else System.out.println("normal");
		}	
	}
	
	private static boolean secret() {
		
		boolean check = false;
		
		for(int i=0; i<n-m+1; i++) {
			check = true;
			for(int j=0; j<m; j++) {
				System.out.println(button[i+j]+" "+ans[j]);
				if(button[i+j] != ans[j]) {
					check=false;
					break;
				}
			}
			
			if(check) return true;
		}
		
		return false;
	}

}
