package step8;

import java.util.Arrays;
import java.util.Scanner;

public class no_1316 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int count = 0;
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			String input = sc.next();
			String[] arr = new String[input.length()];
			boolean check = false;
			int index = 1;
			for(int j=1; j<input.length(); j++) {
				if(input.charAt(j-1) != input.charAt(j)) {
					String str = Character.toString(input.charAt(j-1));
					arr[index] = str;
					index++;
					if(Arrays.asList(arr).contains(Character.toString(input.charAt(j)))) {
						check = true;
					}
				}
			}
			if(!check) {
				count++;
			}
		}
		System.out.println(count);
	}
}
