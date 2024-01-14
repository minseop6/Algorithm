import java.util.Arrays;

public class Runner {
  public static void main(String[] args) {
    var result = new 보석쇼핑().solution(new String[] {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"});
    System.out.println("=======================result");
//    System.out.println(result);
    Arrays.stream(result).forEach(System.out::println);
  }
}
