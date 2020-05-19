package step10;

import java.util.Scanner;

public class no_4948 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int n = sc.nextInt();			
			if(n==0) {
				break;
			}
			
			boolean[] arr = new boolean[2 * n + 1];
			int count = 0;
			
			for(int i=2; i<=2*n; i++) {
				arr[i] = true;
			}
			
			for(int i=2; i*i<=2*n; i++) {
				if(arr[i]) {
					for(int j=i*i; j<=2*n; j+=i) {
						arr[j] = false;
					}
				}
			}
			
			for(int i=n+1; i<=2*n; i++) {
				if(arr[i]) {
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
