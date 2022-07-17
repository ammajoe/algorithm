import java.util.Scanner;

public class Main_2525 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int time = sc.nextInt();
		int minute = sc.nextInt();
		
		int cook = sc.nextInt();
		
		int cook_time = cook / 60;
		int cook_minute = cook % 60;
		
		int ans_time = 0;
		int ans_minute = 0;
		
		if(minute + cook_minute<60) {
			ans_minute = minute + cook_minute;
		}else {
			if(time+1>24) {
				ans_time = 0;
			}else {
				ans_time += 1;
			}
			ans_minute = minute + cook_minute - 60;
		}
		
		if(time+ans_time+cook_time>=24) {
			ans_time = time+ans_time+cook_time-24;
		}else {
			ans_time += time+cook_time;
		}
		
		System.out.println(ans_time + " " + ans_minute);
	}

}
