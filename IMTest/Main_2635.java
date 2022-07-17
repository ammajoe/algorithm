import java.util.Scanner;

public class Main_2635 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();

		int max = 0;
		
		int n3 = 0;
		int n2 = 0;
		int n1 = 0;
		int num = 0;
		
		for(int i=0; i<=n; i++) {
			int cnt = 1;
			n1 = n;
			n2 = i;
			while(true) {
				n3= n1-n2;
				n1 = n2;
				n2 = n3;
				cnt ++;
				if(n3 <0) break;
			}
			
			if(max < cnt) {
				max = cnt;
				num = i;
			}
		}
		
		int[] arr = new int[max];
		
		arr[0] = n;
		arr[1] = num;
		sb.append(arr[0]+" ");
		sb.append(arr[1]+" ");
		
		for(int i=2; i<max; i++) {
			arr[i] = arr[i-2]- arr[i-1];
			sb.append(arr[i]+" ");
		}
		
		System.out.println(max);
		System.out.println(sb.toString());
	}
}
