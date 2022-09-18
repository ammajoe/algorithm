package suwan_09_01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2661 {
	static int[] arr= {1,2,3};
	static int N;
	static String str;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		str = "";
		perm(0, str);
		System.out.println(str);
	}
	
	private static void perm(int cnt, String string) {
		if(!str.equals("")) return;
		
		if(cnt==N) {
			str = string;
			return;
		}
		
		for(int i=1; i<=3; i++) {
			boolean go = true;
			String copy = string;
			copy+=i;
			for(int j=0; j<cnt; j++) {
				if(!check(copy, j, cnt+1)) {
					go=false;
					break;
				}
			}
			if(!go) continue;
			perm(cnt+1, copy);
		}
	}
	
	private static boolean check(String string, int j, int cnt) {
		int idx = 0;
		while(idx+j < cnt) {
			if(string.substring(idx ,idx+j+1).equals(string.substring(idx+j+1))) return false;
			idx++;
		}
		return true;
	}
	
}
