import java.util.Arrays;

public class Runner {
  public static void main(String[] args) {
    int result = new 혼자서하는틱택토().solution(new String[]{ "O.X", ".O.", "..X" });
    System.out.println("=======================result");
    System.out.println(result);
//    Arrays.stream(result).forEach((i) -> System.out.println(i));
  }
}
