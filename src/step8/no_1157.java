package step8;

import java.util.Arrays;
import java.util.Scanner;

public class no_1157 {

	public static void main(String[] args) {
		
		int[] count = new int[26]; //알파벳 count 배열
		int index = 0; //가장 큰 배열 인덱스 저장용
		Boolean eq = false; //갯수가 가장 많은 철자가 여러개일때 확인용
		Scanner sc = new Scanner(System.in);
		
		Arrays.fill(count, 0); //배열 초기화
		String input = sc.nextLine();
		char[] arr = input.toCharArray();
		
		for(int i=0; i<arr.length; i++) {
			int code = (int)arr[i];
			if(code <= 90) {
				count[code-65] += 1;
			}else {
				count[code-97] += 1;
			}
		}
		
		for(int i=1; i<count.length; i++) {
			if(count[index] < count[i]) {
				index = i;
				eq = false;
			}else if(count[index] == count[i]) {
				eq = true;
			}
		}
		
		if(eq) {
			System.out.println("?");
		}else {
			System.out.println((char)(index + 65));
		}
	}
	
	/*	모범답안
	    Scanner sc = new Scanner(System.in);
        String str = sc.nextLine().toUpperCase();
 
        int[] cnt = new int[26];
        int max = 0;
        char result = '?';
 
        for (int i = 0; i < str.length(); i++) {
            cnt[str.charAt(i) - 65]++;
            if (max < cnt[str.charAt(i) - 65]) {
                max = cnt[str.charAt(i) - 65];
                result = str.charAt(i);
            } else if (max == cnt[str.charAt(i) - 65]) {
                result = '?';
            }
        }
        System.out.println(result);
 
        sc.close();
	 */

}
