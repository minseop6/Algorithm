import java.util.Arrays;

public class Runner {
  public static void main(String[] args) {
    var result = new 섬연결하기().solution(4, new int[][]{{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}});
    System.out.println("=======================result");
    System.out.println(result);
//    Arrays.stream(result).forEach(System.out::println);
  }
}
