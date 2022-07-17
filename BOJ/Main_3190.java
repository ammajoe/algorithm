import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class location{
	int x;
	int y;
	char dir;
	
	public location(int x, int y, char dir) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
	}
}

public class Main_3190 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		LinkedList<location> list = new LinkedList<location>();
		
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0}; 
		
		// 보드 입력
		int n = Integer.parseInt(br.readLine());
		char[][] arr = new char[n][n];
		
		// 사과 위치 입력 받기
		int apple = Integer.parseInt(br.readLine());
		for(int i=0; i<apple; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[x-1][y-1] = 'a';
		}
		
		int move = Integer.parseInt(br.readLine());
		int i = 0;
		int cnt = 0; // 게임이 몇초에 끝나는지
		int idx = 0; // dx dy 좌표 관리
		char dir = 'D';
		list.add(new location(0,0,dir));
		
		outer: while(i<move) {
			st = new StringTokenizer(br.readLine());
			int sec = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<sec; j++) {
				int X = list.get(0).x+dx[idx];
				int Y = list.get(0).y+dx[idx];
				
				if(X<0 && X>n && Y<0 && Y>n) {
					if(arr[X][Y] == 'a') {
						list.add(new location(list.get(0).x,list.get(0).y,dir));
					}
					list.get(0).x = X;
					list.get(0).y = Y;
					cnt++;
				}else break outer; 
			}
			
			dir = st.nextToken().charAt(0);
			System.out.println(dir);
			if(dir=='L') idx = (idx-1)%4;
			else if(dir=='D') idx = (idx+1)%4;
			
			i++;
		}
	}

}
