import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_2564 {
	static ArrayList<point> arr = new ArrayList<>();
	static int C,R,num,ans;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		num = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < num+1; i++) {
			
			st = new StringTokenizer(br.readLine());
			int dir = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			
			if(dir==1) {
				arr.add(new point(0, len));
			}else if(dir==2) {
				arr.add(new point(C, len));
			}else if(dir==3) {
				arr.add(new point(len, 0));
			}else if(dir==4) {
				arr.add(new point(len,R));
			}
		}
		search();
		System.out.println(ans);
	}
	private static void search() {
		for (int i = 0; i < num; i++) {
			
			if(Math.abs(arr.get(num).x-arr.get(i).x)==C) {
				ans+=C;
				ans+=Math.min(arr.get(num).y+arr.get(i).y, 2*R-arr.get(num).y-arr.get(i).y);
			}else if(Math.abs(arr.get(num).y-arr.get(i).y)==R) {
				ans+=R;
				ans+=Math.min(arr.get(num).x+arr.get(i).x, 2*C-arr.get(num).x-arr.get(i).x);
			}else {
				ans+=Math.abs(arr.get(num).x-arr.get(i).x);
				ans+=Math.abs(arr.get(num).y-arr.get(i).y);
			}
		}
	}
	
	static class point{
		int x;
		int y;
		public point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}