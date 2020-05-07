package step9;

import java.util.Scanner;

public class no_2292 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		int add = 0, count = 1;
		
		while(true) {
			if(N <= add * 6 + 1) {
				break;
			}
			add += count;
			count++;
		}
		System.out.println(count);
	}

}
