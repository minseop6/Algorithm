package step5;

import java.util.Scanner;

public class no_3052 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] num = new int[10];
		int[] result = new int[10];
		int count = 10;
		
		for(int i=0; i<10; i++) {
			num[i] = sc.nextInt();
			result[i] = num[i] % 42;
		}
		
		for(int i=0; i<9; i++) {
			for(int j=i+1; j<10; j++) {
				if(result[i] == result[j]) {
					count--;
					break;
				}
			}
		}
		
		System.out.println(count);
	}

}
