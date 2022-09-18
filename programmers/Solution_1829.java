package suwan_09_02;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_1829 {
	public static void main(String[] args) throws IOException {
		int[][] pic = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		Solution2 sol = new Solution2();
		int[] ans = sol.solution(6, 4, pic);
		System.out.println(Arrays.toString(ans));
	}
}

class Solution2 {
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        
        boolean[][] visit = new boolean[m][n];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
            	
                if(picture[i][j] != 0 && !visit[i][j]){
                    numberOfArea++;
                    
                    Queue<int[]> queue = new LinkedList<int[]>();
                    int[] arr = new int[2];
                    arr[0] = i;
                    arr[1] = j;
                    visit[i][j] = true;
                    queue.add(arr);
                    
                    int cnt = 0;
                    
                    while(!queue.isEmpty()){
                        cnt++;
                        int[] cur = queue.poll();
                        
                        int x = cur[0];
                        int y = cur[1];
                        
                        for(int d=0; d<4; d++){
                            int X = x + dx[d];
                            int Y = y + dy[d];
                            
                            if(X>=0 && X<m && Y>=0 && Y<n && (picture[x][y]==picture[X][Y]) && !visit[X][Y]){
                                int add[] = new int[2];
                                add[0] = X;
                                add[1] = Y;
                                visit[X][Y] = true;
                                queue.add(add);
                            }
                        }
                    }
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        
        return answer;
    }
}