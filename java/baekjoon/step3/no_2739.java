package step3;

import java.util.Scanner;

public class no_2739 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i=1; i<=9; i++) {
			int result= num * i;
			System.out.println(num + " * " + i + " = " + result);
		}
	}

}
