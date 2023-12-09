import java.util.Arrays;

public class Runner {
  public static void main(String[] args) {
//    var result = new no3().solution(5, new int[] { 16,15,9,17,1,3 });
    var result = new 부대복귀().solution(5, new int[][] {
      { 1, 2 },
      { 1, 4 },
      { 2, 4 },
      { 2, 5 },
      { 4, 5 },
    },
      new int[] { 1, 3, 5 }, 5);
//    var result = new 부대복귀().solution(3, new int[][] {
//        { 1, 2 },
//        { 2, 3 },
//      },
//      new int[] { 2, 3 }, 1);
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
