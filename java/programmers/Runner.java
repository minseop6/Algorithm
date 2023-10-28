import java.util.Arrays;

public class Runner {
  public static void main(String[] args) {
    var result = new 삼각달팽이().solution(6);
//    boolean result = new no4().solution(new String[][] {
//      { "O", "A", "C", "D", "E", "O" },
//      { "H", "O", "T", "C", "A", "P" },
//      { "P", "U", "S", "E", "T", "Z" }
//    }, "ATS");
    System.out.println("=======================result");
//    System.out.println(result);
    Arrays.stream(result).forEach(System.out::println);
  }
}
