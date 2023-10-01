import java.util.Stack;
import java.util.stream.IntStream;

public class 택배상자 {
  public int solution(int[] order) {
    int index = 0;
    int answer = 0;
    Stack<Integer> stack = new Stack<Integer>();
    for (int i : IntStream.rangeClosed(1, order.length).toArray()) {
      if (order[index] != i) {
        stack.push(i);
      } else {
        answer++;
        index++;
      }

      while (!stack.isEmpty() && order[index] == stack.peek()) {
        stack.pop();
        answer++;
        index++;
      }
    }

    return answer;
  }
}
