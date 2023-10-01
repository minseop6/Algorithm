import java.util.Arrays;

public class 혼자놀기의달인 {
  public int solution(int[] cards) {
    int answer = 0;
    for (int i = 0; i < cards.length; i++) {
      boolean[] visitedBox = new boolean[cards.length];
      Arrays.fill(visitedBox, false);
      int firstGrade = grade(cards, visitedBox, i);
      int secondGrade = 0;
      for (int j = 0; j < visitedBox.length; j++) {
        if (!visitedBox[j]) {
          secondGrade = Math.max(grade(cards, visitedBox, j), secondGrade);
        }
      }
      answer = Math.max(answer, firstGrade * secondGrade);
    }
    return answer;
  }

  private int grade(int[] cards, boolean[] visitedBox, int startBox) {
    int currentIndex = startBox;
    int grade = 0;
    while (!visitedBox[currentIndex]) {
      visitedBox[currentIndex] = true;
      currentIndex = cards[currentIndex] - 1;
      grade++;
    }
    return grade;
  }
}
