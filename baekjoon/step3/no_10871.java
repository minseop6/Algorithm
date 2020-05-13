package step3;

import java.util.Scanner;

public class no_10871 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(), x = sc.nextInt();
		int[] array = new int[n];
		int[] result = new int[n];
		int count = 0;
		
		for(int i=0; i<n; i++) {
			array[i] = sc.nextInt();
		}
		
		for(int i=0; i<n; i++) {
			if(array[i]<x) {
				result[count] = array[i];
				count++;
			}
		}
		
		for(int i=0; i<count; i++) {
			System.out.print(result[i] + " ");
		}
	}

}
