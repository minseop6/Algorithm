package step8;

import java.util.Scanner;

public class no_2675 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		String[] P = new String[T];
		
		for(int i=0; i<T; i++) {
			P[i] = "";
		}
		
		for(int i=0; i<T; i++) {
			int R = sc.nextInt();
			String S = sc.nextLine();
			
			for(int j=1; j<S.length(); j++) {
				for(int k=0; k<R; k++) {
					P[i] += S.charAt(j);
				}
			}
		}
		
		for(int i=0; i<T; i++) {
			System.out.println(P[i]);
		}
	}
}
