package step5;

import java.util.Scanner;

public class no_2562 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] num = new int[9];
		int n = 0;
		
		for(int i=0; i<9; i++) {
			num[i] = sc.nextInt();
		}
		for(int i=1; i<9; i++) {
			if(num[i] > num[n]) {
				n = i;
			}
		}
		System.out.println(num[n]);
		n=n+1;
		System.out.println(n);
	}
}
