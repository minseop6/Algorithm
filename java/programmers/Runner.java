import java.util.Arrays;

public class Runner {
  public static void main(String[] args) {
    var result = new 연속펄스부분수열의합().solution(new int[] { 2, 3, -6, 1, 3, -1, 2, 4 });
    System.out.println("=======================result");
    System.out.println(result);
//    Arrays.stream(result).forEach(System.out::println);
  }
}
