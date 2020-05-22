package step10;

import java.util.Scanner;

public class no_4153 {

	public static void main(String[] args) {
		
		int side1, side2, side3;
		double result;
		
		Scanner sc = new Scanner(System.in);
		while(true) {
			side1 = sc.nextInt();
			side2 = sc.nextInt();
			side3 = sc.nextInt();
			
			if(side1 == 0 && side2 == 0 && side3 == 0) {
				break;
			}
			
			if(side1 > side2) {
				result = Math.pow(side1, 2) - Math.pow(side2, 2) - Math.pow(side3, 2);
			}else if(side2 > side3){
				result = Math.pow(side2, 2) - Math.pow(side1, 2) - Math.pow(side3, 2);
			}else {
				result = Math.pow(side3, 2) - Math.pow(side1, 2) - Math.pow(side2, 2);
			}
			if(result == 0) {
				System.out.println("right");
			}else {
				System.out.println("wrong");
			}
		}
	}
}
