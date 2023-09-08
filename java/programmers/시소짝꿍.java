import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 시소짝꿍 {
  public long solution(int[] weights) {
    long answer = 0;

    Arrays.sort(weights);
    HashMap<Double, Integer> map = new HashMap<Double, Integer>();
    for (int weight : weights) {
      double one = weight * 2.0 / 2.0;
      double twoThird = weight * 2.0 / 3.0;
      double oneHalf = weight * 2.0 / 4.0;
      double threeFourth = weight * 3.0 / 4.0;

      for (double item : List.of(one, twoThird, oneHalf, threeFourth)) {
        if (map.containsKey(item)) {
          answer += map.get(item);
        }
      }

      map.put(one, map.getOrDefault(one, 0) + 1);
    }

    return answer;
  }
}
