import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_2628{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();

		LinkedList<Integer> listx = new LinkedList<Integer>();
		LinkedList<Integer> listy = new LinkedList<Integer>();
		
		listx.add(N);
		listy.add(M);
		listx.add(0);
		listy.add(0);
		
		int num = sc.nextInt();
		
		for(int i=0; i<num; i++) {
			int type = sc.nextInt();
			int line = sc.nextInt();
			
			if(type == 0) {
				listx.add(line);
			}else{
				listy.add(line);
			}
		}
		
		Collections.sort(listx);
		Collections.sort(listy);
		
		int X = 1;
		for(int i=listx.size()-1; i>0; i--) {
			X = Math.max(X, listx.get(i)-listx.get(i-1));
		}
		
		int Y = 1;
		for(int i=listy.size()-1; i>0; i--) {
			Y = Math.max(Y, listy.get(i)-listy.get(i-1));
		}
		
		System.out.println(X*Y);
	}
}