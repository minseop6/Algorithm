import java.util.Arrays;

public class Runner {
  public static void main(String[] agrs) {
    int[] result = new 무인도여행().solution(new String[] {"X591X", "X1X5X", "X231X", "1XXX1" });
    System.out.println("=======================result");
    Arrays.stream(result).forEach((i) -> System.out.println(i));
  }
}
