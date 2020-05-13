package step2;

import java.util.Scanner;

public class no_1330 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int A, B;
		
		A = input.nextInt();
		B = input.nextInt();
		
		if(A > B) {
			System.out.println(">");
		}else if(A < B){
			System.out.println("<");
		}else {
			System.out.println("==");
		}
	}

}
