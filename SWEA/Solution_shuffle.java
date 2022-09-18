import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_shuffle {
	static int N, min;
	static int[] arr;
	static boolean[] selected, fish;
	public static void main(String[] args) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st;
			int T = Integer.parseInt(br.readLine());
			
			for(int tc=1; tc<=T; tc++) {
				
				N = Integer.parseInt(br.readLine());
				arr = new int[N]; // n개의 카드
				
				st = new StringTokenizer(br.readLine());
				for(int i=0; i<N; i++) {
					arr[i] = Integer.parseInt(st.nextToken()); // 정렬되지 않은 N개의 카드
				}
				
				min = Integer.MAX_VALUE;
				
				Queue<Card> queue = new LinkedList<>();
				
				for(int i=0; i<N; i++) {
					queue.add(new Card(arr, 0, i));
				}
				int cnt = 0;
				
				while(!queue.isEmpty()) {
					Card cur = queue.poll();
					int[] arr = cur.arr;
					cnt = cur.cnt;
					int num = cur.num;
					
					if(cnt==6) {
						cnt = -1;
						break;
					}
					
					// 정렬되어있는지 확인
					if(isAscending(arr) || isDescending(arr)) break;
					
					// 카드섞기
					int[] next = suffle(arr, num);
					
//					int[] arr1 = Arrays.copyOfRange(arr, 0, N/2);        
//					int[] arr2 = Arrays.copyOfRange(arr, N/2, N);
					
					// 다음 섞을 카드 queue에 넣기
					for(int i=0; i<N; i++) {
						queue.add(new Card(next, cnt+1, i));
					}
				}
				
				System.out.println("#"+tc+" "+cnt);
			}
	}
	
	private static int[] suffle(int[] arr, int num) {
		int[] front = new int[N/2];
		int[] back = new int[N/2];
		
		if(num < N/2) {
			for(int i=0; i<N/2; i++) {
				front[i] = arr[i];
				back[i] = arr[(N/2)+i];
			}
		} else {
			for(int i=0; i<N/2; i++) {
				back[i] = arr[i];
				front[i] = arr[(N/2)+i];
			}
		}
		
		int x = 0;
		if(num >= N/2) x = N-num-1;
		else x = num;
		int[] next = new int[N];
		
		int idx = 1;
		
		for(int i=0; i<N/2; i++) {
			if(i>=(N/2-x)) {
				next[i+idx] = front[i];
				idx++;
			} else next[i] = front[i];
		}
		
		// 남은 자리에 집어넣기
		idx = 0;
		for(int i=0; i<N; i++) {
			if(next[i] ==0) next[i] = back[idx++];
		}
		
		return next;
	}
	
	private static boolean isAscending(int[] arr) {
		// 오름차순일 때
		for(int i=1; i<arr.length; i++) {
			if(arr[i-1] > arr[i]) return false;
		}
		return true;
	}
	
	private static boolean isDescending(int[] arr) {
		// 내림차순일 때
		for(int i=1; i<arr.length; i++) {
			if(arr[i-1] < arr[i]) return false;
		}
		return true;
	}
}

class Card{
	int[] arr;
	int cnt;
	int num;
	
	Card(int[] arr, int cnt, int num){
		this.arr = arr;
		this.cnt = cnt;
		this.num = num;
	}
}
