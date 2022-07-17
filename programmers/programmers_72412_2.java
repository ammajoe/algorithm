import java.util.*;

public class programmers_72412_2 {

	public static void main(String[] args) {
		
		Solution2 sol = new Solution2();
		String[] info = {"java backend junior pizza 150",
		                 "python frontend senior chicken 210",
		                 "python frontend senior chicken 150",
		                 "cpp backend senior pizza 260",
		                 "java backend junior chicken 80",
		                 "python backend senior chicken 50"};
		
		String[] query = {"java and backend and junior and pizza 100",
						  "python and frontend and senior and chicken 200",
						  "cpp and - and senior and pizza 250",
						  "- and backend and senior and - 150",
						  "- and - and - and chicken 100",
						  "- and - and - and - 150"};
		
		System.out.println(Arrays.toString(sol.solution(info, query)));
	}
}

class Solution2 {
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];        
        
        for(int i=0; i<query.length; i++) {
        	// 0: 언어, 2: 직군, 4: 경력, 6: 소울푸드, 7: 점수
        	String[] q = query[i].split(" ");
        	int cnt = 0;
        	
        	for(int j=0; j<info.length; j++) {
        		String[] in = info[j].split(" ");
        		if(!q[0].equals("-") && !q[0].equals(in[0])) continue;
        		if(!q[2].equals("-") && !q[2].equals(in[1])) continue;
        		if(!q[4].equals("-") && !q[4].equals(in[2])) continue;
        		if(!q[6].equals("-") && !q[6].equals(in[3])) continue;
        		
        		int num = Integer.parseInt(q[7]);
        		int grade = Integer.parseInt(in[4]); 
        		if(num > grade) continue;
        		
        		cnt++;
        	}
        	
        	answer[i] = cnt;
        }
        
        return answer;
    }
}
