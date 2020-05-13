package step9;

import java.util.Scanner;

public class no_2839 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int count = Integer.MAX_VALUE;
		
		for(int i=0; i<=N/3+1; i++) {
			for(int j=0; j<=N/3+1; j++) {
				if(N - i*5 - j*3 == 0) {
					if(count > i + j) {
						count = i + j;
					}
				}
			}
		}
		
		if(count == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(count);
		}
	}
}
