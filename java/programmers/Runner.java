import java.util.Arrays;

public class Runner {
  public static void main(String[] args) {
    var result = new 큰수만들기().solution("1924", 2);
    System.out.println("=======================result");
    System.out.println(result);
    var result2 = new 큰수만들기().solution("1231234", 3);
    System.out.println("=======================result2");
    System.out.println(result2);
    var result3 = new 큰수만들기().solution("4177252841", 4);
    System.out.println("=======================result3");
    System.out.println(result3);
//    Arrays.stream(result).forEach(System.out::println);
  }
}
