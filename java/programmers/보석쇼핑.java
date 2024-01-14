import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class 보석쇼핑 {
    public int[] solution(String[] gems) {
        var gemCategorySize = new HashSet<String>(List.of(gems)).size();
        var gemMap = new HashMap<String, Integer>();

        var left = 0;
        var answer = new int[] { 0, gems.length };
        for (var right = 0; right < gems.length; right++) {
            var count = gemMap.getOrDefault(gems[right], 0);
            gemMap.put(gems[right], count + 1);

            while (gemMap.get(gems[left]) > 1) {
                gemMap.put(gems[left], gemMap.get(gems[left]) - 1);
                left++;
            }

            if (gemMap.size() == gemCategorySize && right - left < answer[1] - answer[0]) {
                answer[0] = left + 1;
                answer[1] = right + 1;
            }
        }

        return answer;
    }
}
