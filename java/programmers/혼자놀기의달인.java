import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 혼자놀기의달인 {
  public int solution(int[] cards) {
    boolean[] visitedBox = new boolean[cards.length];
    Arrays.fill(visitedBox, false);
    ArrayList<Integer> gradeList = new ArrayList<Integer>();
    for (int i = 0; i < cards.length; i++) {
      if (!visitedBox[i]) {
        visitedBox[i] = true;
        int grade = dfs(cards, visitedBox, cards[i]) + 1;
        gradeList.add(grade);
      }
    }

    if (gradeList.size() <= 1) {
      return 0;
    }

    gradeList.sort(Collections.reverseOrder());
    return gradeList.get(0) * gradeList.get(1);
  }

  private int dfs(int[] cards, boolean[] visitedBox, int index) {
    if (visitedBox[index - 1]) {
      return 0;
    }
    visitedBox[index - 1] = true;
    return dfs(cards, visitedBox, cards[index - 1]) + 1;
  }
}
