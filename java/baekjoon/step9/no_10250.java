package step9;

import java.util.Scanner;

public class no_10250 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int H, W, N;
		int floor, room;
		String[] result = new String[T];
		
		for(int i=0; i<T; i++) {
			H = sc.nextInt(); //층
			W = sc.nextInt(); //방
			N = sc.nextInt();
			
			floor = N % H;
			room = (int)Math.ceil((double)N / H);
			if(floor == 0) {
				floor = H;
			}
			if((int)(Math.log10(room)+1) == 1) {
				result[i] = floor + "0" + room;
			}else {
				result[i] = floor + "" + room;
			}
		}
		
		for(int i=0; i<T; i++) {
			System.out.println(result[i]);
		}
	}
}
