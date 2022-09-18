import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4013_김지호 {
	static int arr[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1 ; tc<=T; tc++) {
			
			int K = Integer.parseInt(br.readLine());
			arr = new int[4][8];
			
			// 톱니 입력 받기
			for(int i=0 ; i<4; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0 ; j<8; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 명령 입력받기
			for(int i=0 ; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int idx = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				check(idx-1, dir);
			}
			
			// 점수 세기
			int sum = 0;
			for(int i=0; i<4; i++) {
				if(arr[i][0]==1) sum += Math.pow(2, i);
			}
			
			System.out.println("#"+tc+" "+sum);
		}
	}
	
	// 자성 확인
	private static void check(int idx, int dir) {
		int[] direction = new int[4];
		direction[idx]=dir;
		
		// 오른쪽 확인
		for(int i=idx; i<3; i++) {
			if(arr[i][2] != arr[i+1][6]) {
				direction[i+1] = (-1)*direction[i];
			}else break;
		}
		
		//왼쪽 확인
		for(int i=idx; i>0; i--) {
			if(arr[i][6] != arr[i-1][2]) {
				direction[i-1] = (-1)*direction[i];
			} else break;
		}
		
		turn(direction);
	}
	
	// 돌리기
	private static void turn(int[] direction) {
		for(int i=0; i<4; i++) {
			if(direction[i] == 1) { // 시계
				int temp=arr[i][7];
				
				for(int j=7 ; j>0; j--) {
					arr[i][j]=arr[i][j-1];
				}
				arr[i][0]=temp;
			
			}else if(direction[i] == -1) { // 반시계
				int temp=arr[i][0];
				
				for(int j=0; j<7 ; j++) {
					arr[i][j]=arr[i][j+1];
				}
				arr[i][7]=temp;
			}
		}
	}
}

