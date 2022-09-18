package study_08_02;

import java.util.HashMap;

public class Solution_42888 {

	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
		
		System.out.println(sol.solution(record));		
	}
}

class Solution {
    public String[] solution(String[] record) {
    	
        HashMap<String,String> map = new HashMap<String,String>();
        
        int size = 0;
        
        for(int i=0; i<record.length; i++) {
        	String[] str = record[i].split(" ");
        	if(!str[0].equals("Change")) size++;
        	if(str[0].equals("Leave")) continue;
        	map.put(str[1], str[2]);
        }
        
        String[] answer = new String[size];
        int idx = 0;
        for(int i=0; i<record.length; i++) {
        	String[] str = record[i].split(" ");
        	if(str[0].equals("Enter")) {
        		answer[idx++] = map.get(str[1])+"님이 "+"들어왔습니다.";
        	} else if(str[0].equals("Leave")) {
        		answer[idx++] = map.get(str[1])+"님이 "+"나갔습니다.";
        	}
        }
        return answer;
    }
}
