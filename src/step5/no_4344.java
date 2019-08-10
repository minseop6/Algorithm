package step5;

import java.util.Scanner;

public class no_4344 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			int students = sc.nextInt();
			int[] score = new int[students];
			double avg = 0;
			int count = 0;
			
			for(int j=0; j<students; j++) {
				score[j] = sc.nextInt();
				avg += score[j];
			}
			avg /= students;
			
			for(int j=0; j<students; j++) {
				if(score[j] > avg) {
					count++;
				}
			}
			double result = (double)count / students * 100;
			System.out.println(String.format("%.3f", result) + "%");
		}
	}
}
