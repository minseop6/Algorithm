package step10;

import java.util.ArrayList;
import java.util.Scanner;

public class no_9020 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i=0; i<T; i++) {
			int n = sc.nextInt();
			boolean[] arr = new boolean[n+1];
			ArrayList<Integer> prime = new ArrayList<>();
			int gap = Integer.MAX_VALUE;
			int res1=0, res2=0;
			
			for(int j=2; j<=n; j++) {
				arr[j] = true;
			}
			arr[0] = arr[1] = false;
			
			for(int j=2; j*j<=n; j++) {
				if(arr[j]) {
					for(int k=j*j; k<=n; k+=j) {
						arr[k] = false;
					}
				}
			}
			
			for(int j=2; j<=n; j++) {
				if(arr[j]) {
					prime.add(j);
				}
			}
			
			for(int j=0; j<prime.size(); j++) {
				for(int k=j; k<prime.size(); k++) {
					if(prime.get(j) + prime.get(k) == n) {
						if(prime.get(k) - prime.get(j) < gap) {
							gap = prime.get(k) - prime.get(j);
							res1 = prime.get(j);
							res2 = prime.get(k);
						}
					}
				}
			}
			
			System.out.println(res1 + " " + res2);
		}
	}
}
