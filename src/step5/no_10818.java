package step5;

import java.util.Scanner;

public class no_10818 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n= sc.nextInt();
		int[] array = new int[n];
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<n; i++) {
			array[i] = sc.nextInt();
		}
		
		for(int i=0; i<n; i++) {
			if(array[i]>max) {
				max = array[i];
			}
			if(array[i]<min) {
				min = array[i];
			}
		}
		System.out.println(min + " " + max);
	}
}
