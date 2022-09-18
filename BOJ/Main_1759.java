package suwan_09_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1759 {
	static char[] arr, str;
	static int L, C;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		arr = new char[C];
		for(int i=0; i<C; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		boolean[] visit = new boolean[C];
		str = new char[L];
		Arrays.sort(arr);
		perm(0, visit, str);
	}
	
	private static void perm(int cnt, boolean[] visit, char[] str) {
		
		if(cnt==L) {
			
			if(!check(str)) return;
			
			for(int i=0; i<L; i++) {
				System.out.print(str[i]);
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<C; i++) {
			if(!visit[i]) {
				visit[i] = true;
				str[cnt] = arr[i];
				
				if(cnt>0) {
					if(str[cnt-1] > str[cnt]) {
					} else {
						perm(cnt+1, visit, str);
					}
				} else {
					perm(cnt+1, visit, str);
				}
				visit[i] = false;
			}
		}
	}

	private static boolean check(char[] str2) {
		int cnt1 =0;
		int cnt2= 0;
		
		for(int i=0; i<str2.length; i++) {
			if(str2[i]=='a'||str2[i]=='e'||str2[i]=='i'||str2[i]=='o'||str2[i]=='u') cnt1++;
			else cnt2++;
			
			if(cnt1>0 && cnt2>1) return true;
			
		}
		return false;
	}

}
