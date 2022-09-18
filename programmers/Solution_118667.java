package suwan_09_02;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_118667 {
	public static void main(String[] args) throws IOException {
		int[] q1 = {3, 2, 7, 2};
		int[] q2 = {4, 6, 5, 1};
		
		Solution1 sol = new Solution1();
		System.out.println(sol.solution(q1, q2));
	}
}

class Solution1 {
	public int solution(int[] queue1, int[] queue2) {
		
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        long sum = 0;
        long sum1 = 0;
        long sum2 = 0;
        
        for(int i=0; i<queue1.length; i++) {
        	q1.add(queue1[i]);
        	q2.add(queue2[i]);
        	sum1 += queue1[i];
        	sum2 += queue2[i];
        }
        
        sum = sum1+sum2;
        if (sum%2==1) return -1;
        
        int cnt = 0;
        while(sum1 != sum2) {
        	cnt++;
        	if(cnt > queue1.length *3) return -1;
        	
        	if(sum1 > sum2) {
        		int num = q1.poll();
        		sum1 -= num;
        		sum2 += num;
        		q2.add(num);
        	} else {
        		int num = q2.poll();
        		sum1 += num;
        		sum2 -= num;
        		q1.add(num);
        	}
        }
        
        return cnt;
    }
}