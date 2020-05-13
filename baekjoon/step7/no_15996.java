package step7;

public class no_15996 {
	
    long sum(int[] a) {
        long ans = 0;
        for(int i=0; i<a.length; i++) {
			ans += a[i];
		}
        return ans;
    }
}
