package step8;

import java.util.Scanner;

public class no_5622 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		String str = sc.nextLine();
		
		for(int i=0; i<str.length(); i++) {
			if(str.charAt(i) < 80) {
				sum += (str.charAt(i)-65) / 3 + 3;
			}else if(str.charAt(i) < 84) {
				sum += 8;
			}else if(str.charAt(i) < 87) {
				sum += 9;
			}else if(str.charAt(i) < 91) {
				sum += 10;
			}else {
				sum += 11;
			}
		}
		System.out.println(sum);
	}
	
//    int[] arr = {3, 3, 3, 4, 4, 4, 5, 5, 5, 6, 6, 6, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 10, 10, 10, 10};
//    int result = 0;
//    
//    for(int i=0 ; i<input.length() ; i++)
//        result += arr[input.charAt(i)-'A'];
//    
//    System.out.println(result)
}
