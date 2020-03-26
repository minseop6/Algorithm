package step5;

import java.util.Scanner;

public class no_2446 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int star = 2 * N + 1;
		for(int i=0; i<2*N-1; i++) {
			if(i<N) {
				star -= 2;
				for(int j=0; j<i; j++) {
					System.out.print(" ");
				}
				for(int j=0; j<star; j++) {
					System.out.print("*");
				}
				System.out.println();
			}else {
				star += 2;
				for(int j=0; j<=i-star; j++) {
					System.out.print(" ");
				}
				for(int j=0; j<star; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}
	}

}
