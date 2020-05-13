package step5;

import java.util.Scanner;

public class no_10039 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int score[] = new int[5];
		int avg = 0;
		
		for(int i=0; i<5; i++) {
			score[i] = sc.nextInt();
			if(score[i] < 40) {
				score[i] = 40;
			}
			avg += score[i];
		}
		
		System.out.println(avg/5);
	}

}
