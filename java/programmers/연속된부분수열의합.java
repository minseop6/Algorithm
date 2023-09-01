public class 연속된부분수열의합 {
  public int[] solution(int[] sequence, int k) {
    int n = sequence.length;
    int leftPoint = 0;
    int rightPoint = n;
    int accumulatedValue = 0;
    for (int l = 0, r = 0; l < n; l++) {
      while (r < n && accumulatedValue < k) {
        accumulatedValue += sequence[r++];
      }
      int range = r - l - 1;
      if (accumulatedValue == k && (rightPoint - leftPoint) > range) {
        leftPoint = l;
        rightPoint = r - 1;
      }

      accumulatedValue -= sequence[l];
    }

    int[] answer = { leftPoint, rightPoint };
    return answer;
  }
}
