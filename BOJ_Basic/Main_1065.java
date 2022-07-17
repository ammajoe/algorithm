import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1065 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		br.close();
		System.out.println(han(t));
	}
	
	public static int han(int t) {
		int cnt = 0;
		for(int i=1; i<=t; i++) {
			if(i<100) {
				cnt=i;
			}else if(i<1000) {
				int a = i%10, b = (i/10)%10, c = (i/100)%10;
				
				if((a-b)==(b-c)) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
