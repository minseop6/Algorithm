import java.util.Arrays;

public class Runner {
  public static void main(String[] args) {
    var result = new 메뉴리뉴얼().solution(new String[] { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" }, new int[] { 2, 3, 4 });
    System.out.println("=======================result");
//    System.out.println(result);
    Arrays.stream(result).forEach(System.out::println);
  }
}
