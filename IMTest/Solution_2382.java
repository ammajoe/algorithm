import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_2382 {
	static class Node {
		int x;
		int y;
		int num;
		int dir;
		
		public Node(int x, int y, int num, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.num = num;
			this.dir = dir;
		}
	}
	
	static int dx[] = {0,-1,1,0,0}; // 상하좌우
	static int dy[] = {0,0,0,-1,1}; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // n*n 
			int M = Integer.parseInt(st.nextToken()); // m시간
			int K = Integer.parseInt(st.nextToken()); // k 미생물 군집
			
			LinkedList<Node> list = new LinkedList<Node>();
			
			for(int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()); // x
				int y = Integer.parseInt(st.nextToken()); // y
				int num = Integer.parseInt(st.nextToken()); // 미생물 수
				int dir = Integer.parseInt(st.nextToken()); // 방향
				
				list.add(new Node(x,y,num,dir));
			}
			
			// M 시간 동안 진행
			for(int i=1; i<M; i++) {
				
//				if(count(list) == 0) break; // 남은 미생물 0이면 
				
				// 리스트 크기만큼 움직이기
				for (int j = 0; j < list.size(); j++) {
					int x = list.get(j).x;
					int y = list.get(j).y;
					int num = list.get(j).num;
					int dir = list.get(j).dir;
					
					int nx = x + dx[dir];
					int ny = y + dy[dir];
					
					// 다음칸이 경계이면
					if(nx==0 || nx==(N-1) || ny==0 || ny==(N-1)) {
						
						if(num/2==0) { // 미생물 0이라 죽이기
							list.remove(j);
							j--;
							
						}else {
							list.get(j).x = nx;
							list.get(j).y = ny;
							list.get(j).num = num/2;
							list.get(j).dir = direction(dir);
						}
 					}else {
 						list.get(j).x = nx;
						list.get(j).y = ny;
 					}
				}
				
				// 합쳐지는 미생물 있는지 확인하기
				int[][][] arr = new int[N][N][2];
							
				for (int j = 0; j < list.size(); j++) {
					int x = list.get(j).x;
					int y = list.get(j).y;
					int num = list.get(j).num;
					int dir = list.get(j).dir;
					
					if(arr[x][y][0] == 0) { // 혼자 방문 했을 때
						arr[x][y][0] = num;
						arr[x][y][1] = dir;
					} else { // 이미 누가 있으면
						if(arr[x][y][0] < num) {
							arr[x][y][0] += num;
							arr[x][y][1] = dir;
						}
					}
				}
			}
			
			int cnt = count(list);
			System.out.println("#"+tc+" "+cnt);
		}
	}
	
	// 남은 미생물 수 세기
	private static int count(LinkedList<Node> list) {
		int cnt = 0;
		for (int j = 0; j < list.size(); j++) {
			cnt += list.get(j).num;
		}
		return cnt;
	}
	
	// 방향 설정하기
	private static int direction(int dir) {
		if(dir==1) return 2;
		if(dir==2) return 1;
		if(dir==3) return 4;
		if(dir==4) return 3;
		return 0;
	}

}
