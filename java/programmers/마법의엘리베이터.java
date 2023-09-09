public class 마법의엘리베이터 {
  public int solution(int storey) {
    int count = 0;

    while (storey > 0) {
      int remain = storey % 10;
      if (remain > 5 || (remain == 5 && storey / 10 % 10 == 9)) {
        count += 10 - remain;
        storey += 10 - remain;
      } else {
        count += remain;
      }
      storey = storey / 10;
    }

    return count;
  }
}
