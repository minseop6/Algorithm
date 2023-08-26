package step10;

import java.util.Scanner;

public class no_2581 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int min = -1, sum = 0;
		
		loop :
		for(int i=M; i<=N; i++) {
			for(int j=2; j<=(double)i/2; j++) {
				if(i % j == 0) {
					continue loop;
				}
			}
			if(min == -1 && i != 1) {
				min = i;
			}
			if(i != 1) {
				sum += i;
			}
		}
		
		if(min != -1) {
			System.out.println(sum);
		}
		System.out.println(min);
	}
}
