import java.io.IOException;
import java.util.Arrays;

public class Solution_92342 {
	public static void main(String[] args) throws IOException {
		int n = 9;
		int[] info = {0,0,1,2,0,1,1,1,1,1,1};
		
		Solution1 sol = new Solution1();
		System.out.println(Arrays.toString(sol.solution(n, info)));
	}
}

class Solution1 {
	static int[] ans;
	static int max;
	public int[] solution(int n, int[] info) {
		
        ans = new int[1];
        ans[0] = -1;
        
        max = 0;
        int[] lion = new int[11];
        
        dfs(0, n, info, lion);
        
        return ans;
    }
	
	private void dfs(int cnt, int n, int[] info, int[] lion) {
		if(cnt==n) {
			win(info, lion);
			return;
		}
		
		for(int i=0; i<=n; i++) {
			if(lion[i] > info[i]) return;
			lion[i] += 1;
			dfs(cnt+1, n, info, lion);
			lion[i] -= 1;
		}
	}

	private void win(int[] info, int[] lion) {
		
		int info_grade = 0;
		int lion_grade = 0;
		
		for(int i=0; i<11; i++) {
			if(info[i]==0 && lion[i]==0) continue;
			if(info[i] >= lion[i]) info_grade += 10-i;
			else lion_grade += 10-i;
		}
		
		if(info_grade < lion_grade) {
			if(max <= lion_grade-info_grade) {
				max = lion_grade-info_grade;
				copy(lion);
			}
		}
	}
	
	private void copy(int[] lion) {
		ans = new int[11];
		for(int i=0; i<11; i++) {
			ans[i] = lion[i];
		}
	}
}