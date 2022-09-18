package suwan_09_01;

import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_67257 {
	public static void main(String[] args) throws IOException {
		String expr = "100-200*300-500+20";
		Solution1 sol = new Solution1();
		long ans = sol.solution(expr);
		System.out.println(ans);
	}
}

class Solution1 {
	static char[] operation = {'+', '-', '*'};
	static long max;
	static LinkedList<Long> num, copy_num;
	static LinkedList<Character> oper, copy_oper;
    public long solution(String expression) {
    	
    	char[] expr = expression.toCharArray();
    	
    	num = new LinkedList();
    	oper = new LinkedList();
    	
    	for(int i=0; i<expr.length; i++) {
    		if(expr[i] == '+' || expr[i]=='-' || expr[i]=='*') oper.add(expr[i]);
    	}
    	
    	expression = expression.replaceAll("\\-", " ");
    	expression = expression.replaceAll("\\+", " ");
    	expression = expression.replaceAll("\\*", " ");
    	
    	StringTokenizer st = new StringTokenizer(expression);
    	
    	for(int i=0; i<oper.size()+1; i++) {
    		num.add(Long.parseLong(st.nextToken()));
    	}
    	
    	boolean[] visit = new boolean[3];
    	int[] number = new int[3];
    	max = 0;
    	
    	// 우선순위 정하기
        perm(0, visit, number);
        
        return max;
    }
	private void perm(int cnt, boolean[] visit, int[] number) {
		
		if(cnt==3) {
			copy_num = (LinkedList<Long>) num.clone();
			copy_oper = (LinkedList<Character>) oper.clone();
			cal(number);
			return;
		}
		
		for(int i=0; i<3; i++) {
			if(!visit[i]) {
				visit[i] = true;
				number[cnt] = i;
				perm(cnt+1, visit, number);
				visit[i] = false;
			}
		}
	}
	
	private void cal(int[] number) {
		
		for(int i=0; i<3; i++) {
			
			char cur = operation[number[i]];
			
			for(int j=0; j<copy_oper.size(); j++) {
				
				if(copy_oper.get(j).equals(cur)) {
					
					if(cur == '+') {
						copy_num.set(j, copy_num.get(j) + copy_num.get(j+1));
						copy_num.remove(j+1);
						copy_oper.remove(j);
						j--;
					} else if (cur == '-') {
						copy_num.set(j, copy_num.get(j) - copy_num.get(j+1));
						copy_num.remove(j+1);
						copy_oper.remove(j);
						j--;
					} else {
						copy_num.set(j, copy_num.get(j) * copy_num.get(j+1));
						copy_num.remove(j+1);
						copy_oper.remove(j);
						j--;
					}
				}
			}
			
			if(copy_num.size()==1) {
				max = Math.max(Math.abs(copy_num.get(0)), max);
				return;
			}
		}
	}
}