package step9;

import java.util.Scanner;

public class no_1712 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		long A = sc.nextInt();
		long B = sc.nextInt();
		long C = sc.nextInt();
		int count = 1;
		while(true) {
			if(A + B * count < C * count) {
				break;
			}else {
				count++;
			}
			
			if(B >= C) {
				count = -1;
				break;
			}
		}
		System.out.println(count);
	}
}
