import java.util.Collections;
import java.util.PriorityQueue;

public class 디펜스게임 {
  public int solution(int n, int k, int[] enemy) {
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
    int answer = enemy.length;
    for (int i = 0; i < enemy.length; i++) {
      queue.add(enemy[i]);
      n -= enemy[i];
      System.out.println(n);
      System.out.println(i);
      System.out.println(enemy[i]);
      System.out.println("----------------");
      if (n < 0) {
        if (k > 0) {
          n += queue.poll();
          k--;
        } else {
          answer = i;
          break;
        }
      }
    }

    return answer;
  }
}
