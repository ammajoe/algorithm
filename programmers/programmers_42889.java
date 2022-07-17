import java.util.*;

public class programmers_42889 {

	public static void main(String[] args) {
		
		Solution1 sol = new Solution1();
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		
		System.out.println(Arrays.toString(sol.solution(N, stages)));
		
	}
}

class Solution1 {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        float user = stages.length;
        
        LinkedList<float[]> list = new LinkedList<>();
        
        int cnt = 0;
        
        for(int i=1; i<=N; i++) { // i번째 스테이지
        	
        	// i번째 스테이지에 도달했지만, 클리어하지 못한 user 수 세기
        	for(int j=0; j<stages.length; j++) {
        		if(i==stages[j]) cnt++;
        	}
        	
        	if(cnt==0) {
        		list.add(new float[] {i,0});
        		continue;
        	}
        	
        	list.add(new float[] {i,cnt/user});
        	user-=cnt;
        	cnt=0;
        }
        
        list.sort((a,b)->Float.compare(b[1],a[1]));
        
        for(int i=0;i<list.size();i++){
            answer[i]=(int)list.get(i)[0];
        }
        
        return answer;
    }
}
