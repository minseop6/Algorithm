package step4;

import java.util.Scanner;

public class no_1110 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		int num = sc.nextInt();
		int newNum = num;
		while(true) {
			if(num != newNum || count == 0) {
				if(newNum<10) {
					int result = newNum * 10;
					result = result / 10 + result % 10;
					newNum = newNum % 10 * 10 + result % 10;
					
					count++;
				}else {
					int result = newNum;
					result = result / 10 + result % 10;
					newNum = newNum % 10 * 10 + result % 10;
					
					count++;
				}
			}else {
				break;
			}
		}
		System.out.println(count);
	}
}
