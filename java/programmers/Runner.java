import java.util.Arrays;

public class Runner {
  public static void main(String[] args) {
    var result = new 인사고과().solution(new int[][] {{2,2},{1,4},{3,2},{3,2},{2,1}});
    System.out.println("=======================result");
    System.out.println(result);
//    Arrays.stream(result).forEach(System.out::println);
  }
}
