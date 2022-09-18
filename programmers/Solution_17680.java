package suwan_09_02;

import java.util.*;

class Solution {
	static LinkedList<Node> cache;
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize == 0) return cities.length*5;
        cache = new LinkedList<Node>();
        
        for(int i=0; i<cities.length; i++) {
        	String lowStr = cities[i].toLowerCase();
        	
        	if(isContain(lowStr)) {
        		answer++;        		
        	} else {
        		if(cache.size() < cacheSize ) {
        			cache.add(new Node(lowStr, 0));
        		} else {
        			int min = Integer.MAX_VALUE;
        			int min_idx = 0;
        			
        			for(int j=0; j<cacheSize; j++) {
        				if(min>cache.get(j).hit) min_idx = 0;
        			}
        			cache.remove(min_idx);
        			cache.add(new Node(lowStr, 0));
        		}
        		answer += 5;
        	}
        }
        return answer;
    }
    
	private boolean isContain(String string) {
		for(int i=0; i<cache.size(); i++) {
			if(cache.get(i).str.equals(string)) {
				int hit = cache.get(i).hit+1;
				cache.add(new Node(string, hit));
				cache.remove(i);
				return true;
			}
		}
		return false;
	}
}

class Node{
	String str;
	int hit;
	
	Node(String str, int hit){
		this.str = str;
		this.hit = hit;
	}
}