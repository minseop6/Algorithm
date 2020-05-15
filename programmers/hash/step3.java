package hash;

import java.util.HashMap;

class step3 {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        HashMap<String, Integer> hash = new HashMap<>();
		for(String[] elem : clothes) {
			hash.put(elem[1], hash.getOrDefault(elem[1], 0) + 1);
		}
		for(int num : hash.values()) {
			answer *= (num + 1);
		}
		answer -= 1;
        
        return answer;
    }
}
