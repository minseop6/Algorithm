package step7;

public class no_4673 {

	static int d(int n) {
		
		int result = 0;
		result += n;
		int length = (int)(Math.log10(n)+1);
		for(int i=0; i<length; i++) {
			result += n % 10;
			n /= 10;
		}
		
		return result;
	}
	
	public static void main(String[] args) {

		for(int i=1; i<=10000; i++) {
			boolean check = true;
			
			for(int j=1; j<i; j++) {
				
				if(i == d(j)) {
					check = false;
					break;
				}
			}
			
			if(check) {
				System.out.println(i);
			}
		}
	}

}
