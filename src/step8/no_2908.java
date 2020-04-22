package step8;

import java.util.Scanner;

public class no_2908 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String num1 = "", num2 = "";
		String str1 = sc.next();
		String str2 = sc.next();
		
		for(int i=str1.length() - 1; i>=0; i--) {
			num1 += str1.charAt(i);
			num2 += str2.charAt(i);
		}
		
		if(Integer.parseInt(num1) > Integer.parseInt(num2)) {
			System.out.println(num1);
		}else {
			System.out.println(num2);
		}
	}

}
