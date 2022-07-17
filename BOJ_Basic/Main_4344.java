import java.util.Scanner;

public class Main_4344 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int arr[];
		for(int i=0; i<t; i++) {
			int n = sc.nextInt();
			arr = new int[n];
			int sum=0;
			for(int j=0; j<n; j++) {
				arr[j]= sc.nextInt();
				sum += arr[j];
			}
			float avg = sum/(float)n;
			
			int count =0;
			
			for(int j=0; j<n; j++) {
				if(arr[j]>avg) {
					count++;
				}
			}
			
			float per = ((float)count/(float)n)*100;

			System.out.printf("%.3f", per);
			System.out.println("%");
			
		}

	}

}
