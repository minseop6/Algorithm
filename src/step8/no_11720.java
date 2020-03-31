package step8;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class no_11720 {

	public static void main(String[] args) throws IOException {
		
		Scanner sc = new Scanner(System.in);
		InputStreamReader re = new InputStreamReader(System.in);
		int sum = 0;
		
		int N = sc.nextInt();
		String str = sc.next();
		
		for(int i=0; i<N; i++) {
			sum += str.charAt(i) - '0';
		}
		
		System.out.println(sum);
	}

}
