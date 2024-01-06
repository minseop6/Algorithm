import java.util.Arrays;

public class Runner {
  public static void main(String[] args) {
    var result = new 자물쇠와열쇠().solution(new int[][] {{0, 0, 0}, {1, 0, 0}, {0, 1, 1} }, new int[][] { {1, 1, 1}, {1, 1, 0}, {1, 0, 1} });
    System.out.println("=======================result");
    System.out.println(result);
//    Arrays.stream(result).forEach(System.out::println);
  }
}
