import java.util.Arrays;

public class Runner {
  public static void main(String[] args) {
//    var result = new no3().solution(5, new int[] { 16,15,9,17,1,3 });
    var result = new 할인행사().solution(new String[] { "banana", "apple", "rice", "pork", "pot" },
      new int[] { 3, 2, 2, 2, 1 }, new String[] { "chicken", "apple", "apple", "banana", "rice", "apple", "pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana" });
    System.out.println("=======================result");
    System.out.println(result);
//    Arrays.stream(result).forEach(System.out::println);
  }
}
