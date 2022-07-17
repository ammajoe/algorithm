import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_2112 {
	static int D, W, K, min;
	static int[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new int[D][W];
			
			for(int i=0; i<D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			min = Integer.MAX_VALUE;
			dfs(arr,0,0);
			System.out.println("#"+tc+" "+min);
		}
	}
	
	static void dfs(int[][] film, int index, int count) {
		
        //합격 기준을 통과한 경우 최솟값을 count값(현재 약품 투여 횟수)으로 변경하고 return
        if(check(film)) {
            min = count;
            return;
        }
        
        //현재 약품 투여 횟수가 이미 최솟값을 넘은 경우 더 검사할 필요가 없으므로 return
        if(count >= min) return; 
        
        //막의 범위를 넘어가는 경우 return
        if(index == D) return;
        
        //새로 넘겨줄 배열 생성
        int[][] arr = new int[D][W];
        // 배열 깊은 복사
        for(int i=0; i<D; i++) {
            for(int j=0; j<W; j++) {
                arr[i][j] = film[i][j];
            }
        }
        
        //index행에 약품을 투여하지 않는 경우
        dfs(arr,index+1,count);
         
        //index행에 A약품을 투여하는 경우
        for(int j=0; j<W; j++) {
            arr[index][j] = 0;
        }
        
        dfs(arr,index+1, count+1);
        
        //index행에 B약품을 투여하는 경우
        for(int j=0; j<W; j++) {
            arr[index][j] = 1;
        }
        
        dfs(arr,index+1, count+1);
	}
	
	private static boolean check(int[][] film) {
		
		boolean flag = false;
		 
 		//모든 열을 검사 
        for(int j=0; j<W; j++) {
        
        	//각 열의 셀을 모두 검사 
            for(int i=0; i<=D-K; i++) {
                flag = true;
                
                //각 열에서 K개만큼의 연속적인 셀을 검사 
                for(int l=i+1; l<i+K; l++) {
                    if(film[i][j] != film[l][j]) {
                        flag = false; //K개만큼 연속적으로 같지 않으면 break 하고 밑의 셀부터 다시 검사 
                        break;
                    }
                }
                //K개 연속적으로 같은 셀이 있으면 한 번이라도 있으면 이번 열은 바로 통과하고 다음 열로 넘어간다.
                if(flag) break;                 
            }
            //이번 검사한 열이 검사를 통과하지 못하므로 아예 테스트 통과 불가능 
            if(!flag) break;
        }
        
        if(!flag)
            return false;
        else
            return true;
	}
	
}
