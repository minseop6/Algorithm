import java.util.*;

public class 귤고르기 {
  public int solution(int k, int[] tangerine) {
    HashMap<Integer, Integer> tangerineCountMap = new HashMap<Integer, Integer>();
    for (int key : tangerine) {
      int count = tangerineCountMap.getOrDefault(key, 0);
      tangerineCountMap.put(key, ++count);
    }
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
    queue.addAll(tangerineCountMap.values());
    int answer = 0;
    while (k > 0 && !queue.isEmpty()) {
      int count = queue.poll();
      k -= count;
      answer++;
    }
    return answer;
  }
}
