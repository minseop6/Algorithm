package step9;

import java.util.Scanner;

public class no_1011 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int x, y, count, num;
		int[] result = new int[T];
		
		for(int i=0; i<T; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			count = 0;
			num = 0;
			while(count < y-x) {
				num++;
				count += Math.ceil((double)num / 2);
			}
			result[i] = num;
		}
		
		for(int i=0; i<T; i++) {
			System.out.println(result[i]);
		}
	}
}
