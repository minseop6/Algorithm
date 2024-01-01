import java.util.Arrays;

public class Runner {
  public static void main(String[] args) {
    var result = new 정수삼각형().solution(new int[][] {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
    System.out.println("=======================result");
    System.out.println(result);
//    Arrays.stream(result).forEach(System.out::println);
  }
}
