package step10;

import java.util.Scanner;

public class no_1978 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int num, count = 0;
		
		loop :
		for(int i=0; i<N; i++) {
			num = sc.nextInt();
			for(int j=2; j<=(double)num/2; j++) {
				if(num % j == 0) {
					continue loop;
				}
			}
			if(num != 1) {
				count++;
			}
		}
		
		System.out.println(count);
	}
}
