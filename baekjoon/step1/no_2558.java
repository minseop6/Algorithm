package step1;

import java.util.Scanner;

public class no_2558 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int A, B;
		
		A = input.nextInt();
		B = input.nextInt();
		
		System.out.println(A * (B % 10));
		System.out.println(A * (B / 10 % 10));
		System.out.println(A * (B / 100));
		System.out.println(A * B);
	}

}
