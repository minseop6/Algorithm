package step7;

import java.util.Scanner;

public class no_1065 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();
         
        if (N < 100) {
            System.out.println(N);
        } else {
            int result = 99;
             
            for (int i = 100; i <= N; ++i) {
            	int n1 = i / 100 % 10;
            	int n2 = i / 10 % 10;
            	int n3 = i % 10;
            	
            	if(n1 - n2 == n2 - n3) {
            		result++;
            	}
            }
             
            if (N == 1000) result--;
             
            System.out.println(result);
        }
    }

}
