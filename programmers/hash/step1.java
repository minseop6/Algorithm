package hash;

import java.util.HashMap;

class step1 {
    public String solution(String[] participant, String[] completion) {
        
        String answer = "";
        
		HashMap<String, Integer> hash = new HashMap<>();
		
		for(String element : participant) {
			hash.put(element, hash.getOrDefault(element, 0) + 1);
		}
		for(String element : completion) {
			hash.put(element, hash.get(element) - 1);
		}
		for(String key : hash.keySet()) {
			if(hash.get(key) != 0) {
				answer += key;
			}
		}
        
        return answer;
    }
}
