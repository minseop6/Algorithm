import java.util.Arrays;

public class Runner {
  public static void main(String[] args) {
    var result = new 징검다리건너기().solution(new int[] { 2, 4, 5, 3, 2, 1, 4, 2, 5, 1 }, 3);
    System.out.println("=======================result");
    System.out.println(result);
//    Arrays.stream(result).forEach(System.out::println);
  }
}
