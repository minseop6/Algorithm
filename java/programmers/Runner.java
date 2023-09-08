import java.util.Arrays;

public class Runner {
  public static void main(String[] args) {
    long result = new 테이블해시함수().solution(new int[][]{ {2,2,6},{1,5,10},{4,2,9},{3,8,3} }, 2, 2, 3);
    System.out.println("=======================result");
    System.out.println(result);
//    Arrays.stream(result).forEach((i) -> System.out.println(i));
  }
}
