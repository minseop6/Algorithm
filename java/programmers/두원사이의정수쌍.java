
public class 두원사이의정수쌍 {
  public long solution(int r1, int r2) {
    long count = 0;
    for (int i = 1; i <= r2; i++) {
      long minH = (long) Math.ceil(Math.sqrt(1.0 * r1 * r1 - 1.0 * i * i));
      long maxH = (long) Math.floor(Math.sqrt(1.0 * r2 * r2 - 1.0 * i * i));

      count += (maxH - minH + 1);
    }
    return count;
  }
}
