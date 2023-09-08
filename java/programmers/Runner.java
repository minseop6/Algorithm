import java.util.Arrays;

public class Runner {
  public static void main(String[] args) {
    long result = new 시소짝꿍().solution(new int[]{ 100,180,360,100,270 });
    System.out.println("=======================result");
    System.out.println(result);
//    Arrays.stream(result).forEach((i) -> System.out.println(i));
  }
}
