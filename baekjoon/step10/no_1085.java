package step10;

import java.util.Scanner;

public class no_1085 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		int n1 = Integer.MAX_VALUE, n2 = Integer.MAX_VALUE;
		
		if(x < (double)w / 2) {
			n1 = x;
		}else {
			n1 = w-x;
		}
		
		if(y < (double)h / 2) {
			n2 = y;
		}else {
			n2 = h-y;
		}
		
		if(n1<n2) {
			System.out.println(n1);
		}else {
			System.out.println(n2);
		}
	}
}

//모범답안
//public class Main {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		ArrayList<Integer> list = new ArrayList<Integer>();
//		
//		Scanner sc = new Scanner(System.in);
//		int x=sc.nextInt();
//		int y=sc.nextInt();
//		int w=sc.nextInt();
//		int h=sc.nextInt();
//		
//		list.add(x);
//		list.add(y);
//		list.add(w-x);
//		list.add(h-y);
//		Collections.sort(list);
//		System.out.println(list.get(0));
//	}
//
//}
