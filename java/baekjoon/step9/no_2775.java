package step9;

import java.util.Scanner;

public class no_2775 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int k, n;
		int[] result = new int[T];
		
		for(int i=0; i<T; i++) {
			k = sc.nextInt(); //층
			n = sc.nextInt(); //호
			int[][] room = new int[k+1][n+1];
			
			for(int j=1; j<=n; j++) {
				room[0][j] = j;
			}
			
			for(int j=1; j<=k; j++) {
				for(int m=1; m<=n; m++) {
					if(m == 1) {
						room[j][m] = 1;
					}else {
						room[j][m] = room[j][m-1] + room[j-1][m];
					}
				}
			}
			result[i] = room[k][n];
		}
		
		for(int i=0; i<T; i++) {
			System.out.println(result[i]);
		}
	}
}

// 모범답안
//public class java_2775 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
// 
//        for (int i = 0; i < num; i++) {
//            int k = sc.nextInt();
//            int n = sc.nextInt();
//            System.out.println(el(k, n));
//        }
//        sc.close();
//    }
// 
//    private static int el(int k, int n) {
//        if (n == 0)
//            return 0;
//        else if (k == 0)
//            return n;
//        else {
//            return el(k, n - 1) + el(k - 1, n);
//        }
//    }
//}