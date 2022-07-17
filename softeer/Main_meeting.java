import java.util.*;
import java.io.*;

public class Main_meeting {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		ArrayList<String> room = new ArrayList<>();
		boolean[][] arr = new boolean[n][10];
		
		for(int i=0; i<n; i++) {
			room.add(br.readLine());
		}
		
		Collections.sort(room);
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			int s = Integer.parseInt(st.nextToken())-9;
			int e = Integer.parseInt(st.nextToken())-9;
			
			int idx = room.indexOf(str);
			
			for(int j=s; j<e; j++) {
				arr[idx][j] = true;
			}
		}
		
		for(int i=0; i<n; i++) {
			System.out.println("Room "+room.get(i)+":");
			if(empty(arr[i])) {
				System.out.println("Not available");
			}else {
				int cnt = count(arr[i]);
				System.out.println(cnt + " available:");
				ableTime(arr[i]);
			}
			
			if(i==n-1) continue;
			else System.out.println("-----");
		}
	}
	
	private static void ableTime(boolean[] bs) {
		int s=0;
		int e=0; 
		for(int i=0; i<bs.length-1; i++) {
			if(!bs[i]) {
				s = i+9;
				while(!bs[i] && i<bs.length-1) {
					i++;
					e=i+9;
				}
				if(s==9) System.out.println("09-"+e);
				else System.out.println(s+"-"+e);
			}
		}
	}
	
	private static int count(boolean[] bs) {
		int cnt=0;
		
		for(int i=0; i<bs.length-1; i++) {
			if(!bs[i]) {
				cnt++;
				while(!bs[i] && i<bs.length-1) {
					i++;
				}
			}
		}
		return cnt;
	}
	
	private static boolean empty(boolean[] bs) {
		for(int i=0; i<bs.length-1; i++) {
			if(!bs[i]) return false;
		}
		return true;
	}
}
