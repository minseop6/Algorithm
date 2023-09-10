public class 점찍기 {
  public long solution(int k, int d) {
    int index = 0;
    long answer = 0;
    while (index <= d) {
      double y = Math.sqrt(Math.pow(d, 2) - Math.pow(index, 2));
      answer += Math.floor(y / k) + 1;
      index += k;
    }

    return answer;
  }
}
