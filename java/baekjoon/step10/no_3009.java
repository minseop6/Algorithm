package step10;

import java.util.Scanner;

public class no_3009 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] x = new int[3];
		int[] y = new int[3];
		int[] result = new int[2];
		int res = 0;
		
		for(int i=0; i<x.length; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		
		loop :
		for(int i=0; i<x.length; i++) {
			for(int j=0; j<x.length; j++) {
				if(x[i] == x[j] && i != j) {
					continue loop;
				}
			}
			result[0] = x[i];
		}
		
		loop :
		for(int i=0; i<y.length; i++) {
			for(int j=0; j<y.length; j++) {
				if(y[i] == y[j] && i != j) {
					continue loop;
				}
			}
			result[1] = y[i];
		}
		
		System.out.println(result[0] + " " + result[1]);
	}
}

//모범답안
//public class Main {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int[] x = new int[3];
//		int[] y = new int[3];
//		int dx, dy;
//		
//		for(int i = 0; i < 3; i++) {
//			x[i] = sc.nextInt();
//			y[i] = sc.nextInt();
//		}
//		
//		if(x[1] == x[2])
//			dx = x[0];
//		else
//			dx = (x[0] == x[1]) ? x[2] : x[1];
//		
//		if(y[1] == y[2])
//			dy = y[0];
//		else
//			dy = (y[0] == y[1]) ? y[2] : y[1];
//			
//		System.out.println(dx + " " + dy);
//	}
//}