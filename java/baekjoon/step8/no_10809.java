package step8;

import java.util.Scanner;

public class no_10809 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String S = sc.nextLine();
		int[] result = new int[26];
		
		//result 배열 초기화
		for(int i=0; i<result.length; i++) {
			result[i] = -1;
		}
		
		for(int i=0; i<S.length(); i++) {
			for(int j=97; j<=122; j++) {
				if(S.charAt(i) == j && result[j-97] == -1) {
					result[j-97] = i;
				}
			}
		}
		
		for(int i=0; i<26; i++) {
			System.out.print(result[i] + " ");
		}
	}
}
