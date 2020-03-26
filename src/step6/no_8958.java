package step6;

import java.util.Scanner;

public class no_8958 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] score = new int[n];
		String quiz;
		
		for(int i=0; i<n; i++) {
			score[i] = 0;
		}
		
		for(int i=0; i<n; i++) {
			quiz = sc.next();
			String[] temp = quiz.split("");
			int correct = 1;
			for(int j=0; j<quiz.length(); j++) {
				if(temp[j].equals("O")) {
					score[i] += correct;
					correct++;
				}else if(temp[j].equals("X")) {
					correct = 1;
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			System.out.println(score[i]);
		}
	}
}
