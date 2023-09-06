import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

public class 뒤에있는큰수찾기 {
  public int[] solution(int[] numbers) {
    int[] answer = new int[numbers.length];
    Arrays.fill(answer, -1);
    Stack<Integer> stack = new Stack<Integer>();
    stack.push(0);

    for (int i : IntStream.range(1, numbers.length).toArray()) {
      while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
        answer[stack.pop()] = numbers[i];
      }
      stack.push(i);
    }

    return answer;
  }
}
