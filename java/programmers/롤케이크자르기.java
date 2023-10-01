import java.util.HashMap;
import java.util.HashSet;

public class 롤케이크자르기 {
  public int solution(int[] topping) {
    int answer = 0;
    HashMap<Integer, Integer> leftToppings = new HashMap<Integer, Integer>();
    for (int i : topping) {
      int count = leftToppings.getOrDefault(i, 0);
      leftToppings.put(i, ++count);
    }

    HashSet<Integer> rightCount = new HashSet<Integer>();
    for (int i = 1; i < topping.length; i++) {
      int currentTopping = topping[topping.length - i];
      rightCount.add(currentTopping);
      int leftTopping = leftToppings.get(currentTopping);
      if (leftToppings.get(currentTopping) - 1 == 0) {
        leftToppings.remove(currentTopping);
      } else {
        leftToppings.put(currentTopping, --leftTopping);
      }

      if (leftToppings.keySet().size() == rightCount.size()) {
        answer++;
      }
    }

    return answer;
  }
}
