package step9;

import java.util.Scanner;

public class no_1193 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int X = sc.nextInt();
		int n = 2, count = 0;
		String result = null;
		
		loop:
		while(true) {
			count += (n-1);
			if(X <= count) {
				X = X - count + n -1;
				if(n % 2 == 1) {
					for(int j=0; j<n; j++) {
						if(X == 0) {
							result = j + "/" + (n-j);
							break loop;
						}
						X -= 1;
					}
				}else {
					for(int j=0; j<n; j++) {
						if(X == 0) {
							result = (n-j) + "/" + j;
							break loop;
						}
						X -= 1;
					}
				}
			}
			n++;
		}
		
		System.out.println(result);
		
		//모법답안
//		Scanner sc = new Scanner(System.in);
//		int X = sc.nextInt();
//		int line = 0, count = 0;
//		while(count < X) {
//			line++;
//			count = line * (line+1) / 2;
//		}
//		if(line % 2 != 0){
//			int top = 1 + (count - n);
//			int bottom = line - (count - n);
//			System.out.println(top + "/" + bottom);
//		}else {
//			int bottom = 1 + (count - n);
//			int top = line - (count - n);
//			System.out.println(top + "/" + bottom);
//		}
	}
}
