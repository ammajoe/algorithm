import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution_hunt {
	static int N, min;
	static int[][] arr;
	static LinkedList<Node> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N][N]; 
			
			list = new LinkedList();
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					if(arr[i][j] != 0) {
						list.add(new Node(i,j,arr[i][j]));
					}
				}
			}
			
			boolean visit[] = new boolean[list.size()];
			int[] num = new int[list.size()];
			min = Integer.MAX_VALUE;
			dfs(0, visit, num);
			System.out.println("#"+tc+" "+min);
			
		}
	}
	private static void dfs(int idx, boolean[] visit, int[] num) {
		if(idx == list.size()) {
			hunt(num);
			return;
		}
		
		for(int i=0; i<list.size(); i++) {
			if(!visit[i]) {
				visit[i] =true;
				num[idx] = i;
				dfs(idx+1, visit, num);
				visit[i] = false;
			}
		}
	}
	
	private static void hunt(int[] number) {
		
		if(!isHunt(number)) return;
		
		int cnt = 0;
		
		cnt += list.get(number[0]).x;
		cnt += list.get(number[0]).y;
		
		for(int i=1; i<list.size(); i++) {
			cnt += Math.abs(list.get(number[i-1]).x-list.get(number[i]).x);
			cnt += Math.abs(list.get(number[i-1]).y-list.get(number[i]).y);
		}
		min = Math.min(min, cnt);
	}
	
	private static boolean isHunt(int[] number) {
		// 사냥 순서가 바른지 확인
		for(int i=0; i<list.size()-1; i++) {
			int num = list.get(number[i]).num;
			
			for(int j=i+1; j<list.size(); j++) {
				int num2 = list.get(number[j]).num;
				if(num < 0 && num*(-1)==num2) return false; 
			}
		}
		return true;
	}
}

class Node{
	int x;
	int y;
	int num;
	
	Node(int x, int y, int num){
		this.x = x;
		this.y = y;
		this.num = num;
	}
}
