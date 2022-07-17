import java.util.Scanner;

public class Main_1193 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int sum = 0;
		int a, b = 0;
		int i=1;
		
		while(true) {
			sum = sum + i;
			if(sum >= n) {
				int idx = sum - i;
				a = n - idx;
				b = i - a;
				
				if(i%2==0) {
					System.out.println(a+"/"+b);
					break;
				}else {
					System.out.println(b+"/"+a);
					break;
				}
			}
			i++;
		}
		
	}

}