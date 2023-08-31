import java.util.Arrays;

public class 요격시스템 {
  public int solution(int[][] targets) {
    Arrays.sort(targets, (a, b) -> a[1] - b[1]);

    int count = 0;
    int position = -1;
    for (int[] target : targets) {
      if (position == -1) {
        count++;
        position = target[1];
      } else {
        if (position <= target[0]) {
          count++;
          position = target[1];
        }
      }
    }
    return count;
  }
}
