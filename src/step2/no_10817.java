package step2;

import java.util.Scanner;

public class no_10817 {

	public static void main(String[] args) {
		
		int[] array = new int[3];
		int max=-1, min=101;
		int maxIndex=-1, minIndex=-1;
		
		Scanner input = new Scanner(System.in);
		
		array[0] = input.nextInt();
		array[1] = input.nextInt();
		array[2] = input.nextInt();
		
		for(int i=0; i<2; i++) {
			int temp = 0;
			
			for(int j=i+1; j<3; j++) {
				if(array[i]>=array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		System.out.println(array[1]);
	}
}
