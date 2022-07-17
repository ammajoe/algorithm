import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class P_72415_2 {

	public static void main(String[] args) {
		Solution3 sol = new Solution3();
		
		int[][] arr1 = {{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}};
		int[][] arr2 = {{3,0,0,2},{0,0,1,0},{0,1,0,0},{2,0,0,3}};
		
		int r1 = 1;
		int c1 = 0;
		
		int r2 = 0;
		int c2 = 1;
		
		System.out.println(sol.solution(arr1, r1, c1));
//		System.out.println(sol.solution(arr2, r2, c2));
		
	}
}

class Solution3 {
	
	static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    
    static int num, min, row, col;
    
    static Map<Integer, ArrayList<Node>> card;
    
    public int solution(int[][] board, int r, int c) {
    	// board[][] 같은 카드 입력하기
    	// 카드 번호, r, c 값
    	card =  new HashMap<>();
    	
    	num=0; // 카드 개수 
    	min = Integer.MAX_VALUE;
    	row = r;
    	col = c;
    	
    	for(int i=0; i<4; i++) {
    		for(int j=0; j<4; j++) {
    			
    			ArrayList<Node> list = new ArrayList<>();
    			
    			if(board[i][j] !=0 && !card.containsKey(board[i][j])) {
    				num++;
    				list.add(new Node(i,j,0));
    				card.put(board[i][j], list);
    				
    			} else if(card.containsKey(board[i][j])) {
    				list = card.get(board[i][j]);
    				list.add(new Node(i,j,0));
    				card.put(board[i][j], list);
    			}
    		}
    	}
    	
    	int[] number = new int[num];
    	int[] order = new int[num*2];
    	boolean[] visited = new boolean[num];
    	
    	int i = 0;
    	for(int n : card.keySet()) {
    		number[i++] = n; 
    	}
    	
    	// 카드 뒤집을 순서 정하기
    	// 카드 순서에 따라서 bfs해서 최단 경로 알아내기
    	perm(board, number, order, visited, 0);
    	
        return min;
    }
    
    // 순열
    static void perm(int[][] board, int[] arr, int[] order, boolean[] visited, int cnt) {
    	
    	if(cnt == num) {
//    		System.out.println(Arrays.toString(output));
    		
    		int count = num*2; // enter 숫자
    		
    		int start_r = row;
    		int start_c = col;
    		
    		// 순서 정해지면 최단 경로 알아내기
    		for(int i=0; i<num; i++) {
    			
    			ArrayList<Node> list = card.get(order[i]);
        		
        		Node first = list.get(0);
        		Node sec = list.get(1);
        		
        		Node start = new Node(start_r, start_c, 0);
        		
        		int len1 = bfs(board, start, first) + bfs(board, first, sec);
        		int len2 = bfs(board, start, sec) + bfs(board, sec, first);
        		
        		System.out.println();
        		
        		if(len1 < len2) {
        			start_r = sec.r;
            		start_c = sec.c;
            		count += len1;
        		}else {
        			start_r = first.r;
            		start_c = first.c;
            		count += len2;
        		}
    		}
    		
    		min = Math.min(min, count);
    		
    		return;
    	}
    	
    	for(int i = 0; i < num; i++) {
    		if(!visited[i]) {
    			visited[i] = true;
    			order[cnt] = arr[i];
    			perm(board, arr, order, visited, cnt + 1);
    			visited[i] = false;
    		}
    	}
    }
    
    private static int bfs(int[][] board, Node start, Node end) {
    	
    	boolean[][] visited = new boolean[4][4];
    	
    	Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(start.r, start.c, 0));
		visited[start.r][start.c] = true;
		Node cur = null;
		
		while(!queue.isEmpty()) {
    		
    		// 현재 커서 위치
    		cur = queue.poll();
//    		System.out.println(cur.r+" "+cur.c+" "+cur.move+" "+end.r+" "+end.c);
    		
    		if(cur.r==end.r && cur.c==end.c) {
//    			System.out.println(start.r+" "+start.c+" "+cur.move+" "+end.r+" "+end.c);
//    			System.out.println(cur.move);
    			return cur.move;
    		}
    		
    		for(int d=0; d<4; d++) {
    			int nr = cur.r+dx[d];
    			int nc = cur.c+dy[d];
    			// 한칸만
    			if(nr<4 && nr >=0 && nc<4 && nc >= 0 && !visited[nr][nc]) {
    				
    				queue.offer(new Node(nr, nc, cur.move+1));
    				visited[nr][nc] = true;
    			}
    			
    			int nnr = 0;
    			int nnc = 0;
    			// ctrl + 방향키
    			while(nr<4 && nr >=0 && nc<4 && nc >= 0) {
    				
    				nnr = nr;
    				nnc = nc;
    				
    				if(board[nr][nc] != 0) break;
    				
    				nr += dx[d];
    				nc += dy[d];
    			}
    			
    			if(nnr<4 && nnr >=0 && nnc<4 && nnc >= 0 && !visited[nnr][nnc]) {
    				queue.offer(new Node(nnr, nnc, cur.move+1));
    				visited[nnr][nnc] = true;
    			}
    		}
    	}
		
		return cur.move;
	}
    
	static class Node{
    	int r;
    	int c;
    	int move;
    	
    	public Node(int r, int c, int move){
    		this.r =r;
    		this.c =c;
    		this.move = move;
    	}
    }
}

