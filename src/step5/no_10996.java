package step5;

import java.util.Scanner;

public class no_10996 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=1; i<=2*N; i++) {
			for(int j=1; j<=N; j++) {
				if(i%2==1) {
					if(j%2==1) {
						System.out.print("*");
					}else {
						System.out.print(" ");
					}
				}else {
					if(j%2==1) {
						System.out.print(" ");
					}else {
						System.out.print("*");
					}
				}
			}
			System.out.println();
		}
	}

}
