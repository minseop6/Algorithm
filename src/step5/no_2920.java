package step5;

import java.util.Scanner;

public class no_2920 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String scale = sc.nextLine();
		String asc = "1 2 3 4 5 6 7 8";
		String desc = "8 7 6 5 4 3 2 1";
		
		if(scale.equals(asc)) {
			System.out.println("ascending");
		}else if(scale.equals(desc)){
			System.out.println("descending");
		}else {
			System.out.println("mixed");
		}

//		Scanner sc = new Scanner(System.in);
//		int n = 8;
//		int[] scale = new int[n];
//				boolean check = true;
//		
//		for(int i=0; i<n; i++) {
//			scale[i] = sc.nextInt();
//		}
//		
//		for(int i=0; i<n; i++) {
//			if(scale[i] != i+1) {
//				break;
//			}
//			if(i==7) {
//				check = false;
//				System.out.println("ascending");
//			}
//		}
//		
//		for(int i=0; i<n; i++) {
//			if(scale[i] != n-i) {
//				break;
//			}
//			if(i==7) {
//				check = false;
//				System.out.println("descending");
//			}
//		}
//		
//		if(check) {
//			System.out.println("mixed");
//		}
	}

}
