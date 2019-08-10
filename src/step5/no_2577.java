package step5;

import java.util.Scanner;

public class no_2577 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] count = new int[10];
		int A, B, C, result;
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		
		for(int i=0; i<10; i++) {
			count[i] = 0;
		}
		
		result = A * B * C;
		for(int i=0; i<(int)(Math.log10(result)+1); i++) {
			int num = (int) (result / Math.pow(10, i) % 10);
			switch (num) {
				case 0: count[0]++;
						break;
				case 1: count[1]++;
						break;
				case 2: count[2]++;
						break;
				case 3: count[3]++;
						break;
				case 4: count[4]++;
						break;
				case 5: count[5]++;
						break;
				case 6: count[6]++;
						break;
				case 7: count[7]++;
						break;
				case 8: count[8]++;
						break;
				case 9: count[9]++;
						break;
			}
		}
		
		for(int i=0; i<10; i++) {
			System.out.println(count[i]);
		}
	}
}
