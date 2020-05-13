package step8;

import java.util.Scanner;

public class no_2941 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String[] croatia = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		String str = sc.nextLine();
		
		for(String item : croatia) {
			str = str.replace(item, "a");
		}
		
		System.out.println(str.length());
	}

}
