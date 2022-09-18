package suwan_09_02;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class Solution_72411 {
	public static void main(String[] args) throws IOException {
		String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
		int[] course = {2,3,4};
		Solution3 sol = new Solution3();
		ArrayList<String> ans = sol.solution(orders, course);
		
		for(int i=0; i<ans.size(); i++) {
			System.out.println(ans.get(i));
		}
	}
}

class Solution3 {
	static HashMap<String, Integer> map;
	static int max;
	public ArrayList<String> solution(String[] orders, int[] course) {
		
		ArrayList<String> list = new ArrayList<>();
		
        for(int i=0; i<course.length; i++) {
        	map = new HashMap<>();
        	max = 0;
        	for(int j=0; j<orders.length; j++) {
        		if(orders[j].length() < course[i]) continue;
        		char[] ch = orders[j].toCharArray();
        		Arrays.sort(ch);
        		String str = "";
        		
        		menu(ch, course[i], 0, str, 0);
        	}
        	
        	for(Entry<String, Integer> entry : map.entrySet()){
                if(max >=2 && entry.getValue() == max) list.add(entry.getKey());
    		}
        }
        
        Collections.sort(list);
        
        return list;
    }
	
	private void menu(char[] ch, int n, int idx, String str, int cnt) {		
		if(cnt == n) {
			int count = 1;
			
			if(map.containsKey(str)) {
				count += map.get(str);
			}
			
			max = Math.max(max, count);
			map.put(str, count);
			
			return;
		}
		
		for(int i=idx; i<ch.length; i++) {
			String copy = str;
			copy += ch[i];
			menu(ch, n, i+1, copy, cnt+1);

		}
	}
}