package study_08_04;

public class Solution_17682 {

	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		String dartStr = "1S2D*3T";
		
		System.out.println(sol.solution(dartStr));		
	}
}

class Solution1 {
	public int solution(String dartResult) {
		
		char[] dart = dartResult.toCharArray();
		
		int[] num = new int[3];
		int idx = 0;
		boolean seq = false;
		for(int i=0; i<dart.length; i++) {
			
			if(dart[i] >= 48 && dart[i] <= 57) {
				if(!seq) {
					num[idx++] = dart[i] - '0';
					seq = true;
				} else {
					num[idx-1] = 10;
				}
				
			}else {
				seq = false;
			} 
			if(dart[i] == 'D') {
				num[idx-1] = (int)Math.pow(num[idx-1], 2);
			} else if(dart[i] == 'T') {
				num[idx-1] = (int)Math.pow(num[idx-1], 3);
			} else if(dart[i] == '*') {
				num[idx-1] *= 2;
				if(idx==1) continue;
				num[idx-2] *= 2;
			} else if(dart[i] == '#') {
				num[idx-1] = num[idx-1]*(-1);
			}
		}
		
		int answer = 0;
        
		for(int i=0; i<3; i++) {
			answer += num[i];
		}
        return answer;
    }
}
