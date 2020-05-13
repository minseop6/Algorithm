package step5;

import java.util.Scanner;

public class no_2523 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=1; i<=2*N-1; i++) {
			if(i<=N) {
				for(int j=0; j<i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}else {
				for(int j=0; j<2*N-i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}

}
