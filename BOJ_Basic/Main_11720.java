import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main_11720 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.valueOf(br.readLine());
		String str = br.readLine();
		
		int sum = 0; 
		
		for(int i=0; i<n; i++) {
			sum += Integer.parseInt(str.split("")[i]);
		}
		
		System.out.println(sum);
	}

}

