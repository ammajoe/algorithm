import java.util.Scanner;

public class Main_2477 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		
		int[] check = new int[5];
		int [][] arr = new int[6][2];
		for(int i=0; i<6; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
			
			check[arr[i][0]] += 1;
		}
		
		int[] num = new int[2];
		int idx=0;
		
		for(int i=0; i<5; i++) {
			if(check[i]==1) {
				num[idx++] = i;
			}
		}
		
		int i=0; 
		int n1=0, n2=0;
		while(true) {
			
			if((arr[i][0] == num[0] && arr[(i+1)%6][0] == num[1]) ||
					(arr[i][0] == num[1] && arr[(i+1)%6][0] == num[0])) {
				n1 = (i+1)%6;
				n2 = i;
				break ;
			}
			i++;
		}
		
		int max = arr[n1][1] * arr[n2][1];
		int min = arr[(n1+2)%6][1] * arr[(n2+4)%6][1];
		
		System.out.println((max-min)*K);
	}
}
