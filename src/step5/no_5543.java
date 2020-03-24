package step5;

import java.util.Scanner;

public class no_5543 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int burger[] = new int[3];
		int beverage[] = new int[2];
		int min = 3000, sum=0;
		
		for(int i=0; i<3; i++) {
			burger[i] = sc.nextInt();
			if(burger[i] < min) {
				min = burger[i];
			}
		}
		sum += min;
		min = 3000;
		for(int i=0; i<2; i++) {
			beverage[i] = sc.nextInt();
			if(beverage[i] < min) {
				min = beverage[i];
			}
		}
		sum += min;
		System.out.println(sum-50);
	}
}
