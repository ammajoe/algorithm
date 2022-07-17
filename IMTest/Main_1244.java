import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1244 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine())+1;
		int arr[] = new int [n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=1; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int num = Integer.parseInt(br.readLine());
		for(int i=0; i<num; i++) {
			st = new StringTokenizer(br.readLine());
			int gender = Integer.parseInt(st.nextToken());
			int idx = Integer.parseInt(st.nextToken());
			
			if(gender == 1) {
				
				for(int k = idx; k<n; k+=idx) {
					arr[k] = (arr[k]==0?1:0);
				}
				
			}else if(gender == 2) {
				arr[idx] = (arr[idx]==0?1:0);
				int k=1;
				
				while((idx-k>0)&&(idx+k<n)) {
					
					if(arr[idx-k] != arr[idx+k]) break;
					arr[idx-k] = (arr[idx-k]==0?1:0);
					arr[idx+k] = (arr[idx+k]==0?1:0);
					k++;
				}
			}
		}
		
		for(int i=1; i<n; i++) {
			System.out.print(arr[i]+" ");
			if(i%20==0) System.out.println();
		}
	}

}
