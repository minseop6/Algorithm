import java.util.Arrays;

public class Runner {
  public static void main(String[] args) {
//    var result = new 인사고과().solution(new int[][] {{2,2},{1,4},{3,2},{3,2},{2,1}});
    var result = new 파괴되지않은건물().solution(new int[][] {{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5},{5,5,5,5,5}}, new int[][] { {1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1} });
    System.out.println("=======================result");
    System.out.println(result);
//    Arrays.stream(result).forEach(System.out::println);
  }
}
