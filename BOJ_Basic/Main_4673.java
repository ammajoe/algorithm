
public class Main_4673 {

	public static void main(String[] args) {
		int arr[] = new int[20000];
		
		for(int i=1; i<=10000; i++) {
			
			arr[d(i)]++;
		}
		
		for(int i=1; i<=10000; i++) {
			if(arr[i] == 0) {
				System.out.println(i);
			}
		}
		
	}
		
	public static int d(int n) {
		int tot=n;
		
		while(n != 0) {
			tot += n%10;
			n /= 10;
		}
		
		return tot;
	}
}
