package step6;

import java.util.Scanner;

public class no_1546 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		double[] score = new double[n];
		int max = 0;
		double[] newScore = new double[n];
		double avg = 0;
		
		for(int i=0; i<n; i++) {
			score[i] = sc.nextInt();
			if(score[i] > score[max]) {
				max = i;
			}
		}
		
		for(int i=0; i<n; i++) {
			newScore[i] = score[i] / score[max] * 100;
			avg += newScore[i];
		}
		avg /= n;
		System.out.println(avg);
	}
}
