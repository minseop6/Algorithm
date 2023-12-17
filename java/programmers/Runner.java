import java.util.Arrays;

public class Runner {
  public static void main(String[] args) {
//    var result = new no3().solution(5, new int[] { 16,15,9,17,1,3 });
    var result = new 거리두기확인하기().solution(new String[][] {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}});
    System.out.println("=======================result");
//    System.out.println(result);
    Arrays.stream(result).forEach(System.out::println);
  }
}
