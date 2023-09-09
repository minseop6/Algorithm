import java.util.Arrays;

public class Runner {
  public static void main(String[] args) {
    long result = new 디펜스게임().solution(2, 4, new int[] { 3, 3, 3, 3 });
    System.out.println("=======================result");
    System.out.println(result);
//    Arrays.stream(result).forEach((i) -> System.out.println(i));
  }
}
