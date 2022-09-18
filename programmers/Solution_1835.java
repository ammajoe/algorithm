package suwan_09_01;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;

public class Solution_1835 {
	public static void main(String[] args) throws IOException {
		String[] expr = {"N~F=0", "R~T>2"};
		Solution sol = new Solution();
		int ans = sol.solution(2,expr);
		System.out.println(ans);
	}
}

class Solution {
	static LinkedList<Character> list;
	static char[] arr = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
	static int count;
	static String[] str;
    public int solution(int n, String[] data) {
    	str = data;
        list = new LinkedList<Character>();
        boolean[] visit = new boolean[8];
        count = 0;
        perm(0,visit, list);
        
        return count;
    }
    
	private void perm(int cnt, boolean[] visit, LinkedList<Character> list) {
		if(cnt==8) {
			for(int i=0; i<str.length; i++) {
				char[] data = str[i].toCharArray(); // 0,2,3,4
				int diff=Math.abs(list.indexOf(data[0])-list.indexOf(data[2]))-1;
				
				if(data[3] == '=') {
					if(diff != data[4]-'0') return;
				} else if(data[3] == '<') {
					if(diff >= data[4]-'0') return;
				} else {
					if(diff <= data[4]-'0') return;
				}
			}
			count++;
			return;
		}
		
		for(int i=0; i<8; i++) {
			if(!visit[i]) {
				visit[i] = true;
				LinkedList<Character> copy = new LinkedList<>();
				list.add(cnt, arr[i]);
				perm(cnt+1, visit, list);
				list.remove(cnt);
				visit[i] = false;
			}
		}
	}
}