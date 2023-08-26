package step8;

import java.util.Scanner;

public class no_1152 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int count = 0;
		boolean check = false;
		String str = sc.nextLine();
		
		for(int i=0; i<str.length(); i++) {
			
			if(str.charAt(i) != 32) {
				if(!check) {
					count++;
					check = true;
				}
			}else {
				check = false;
			}
		}
		System.out.println(count);
		
		//모범 답안
//		Scanner sc = new Scanner(System.in);
//        String input = sc.nextLine().trim();
//        sc.close();
//         
//        if (input.isEmpty()) {
//            System.out.println(0);
//        } else {
//            System.out.println(input.split(" ").length);
//        }
	}
}
