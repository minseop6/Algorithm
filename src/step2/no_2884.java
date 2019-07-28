package step2;

import java.util.Scanner;

public class no_2884 {

	public static void main(String[] args) {
		
		int H ,M;
		
		Scanner input = new Scanner(System.in);
		
		H = input.nextInt();
		M = input.nextInt();
		
		if(M-45 < 0) {
			H -= 1;
			M = M - 45 + 60;
			
			if(H<0) {
				H = 23;
			}
			
			System.out.println(H + " " + M);
		}else {
			M = M - 45;
			System.out.println(H + " " + M);
		}
	}

}
