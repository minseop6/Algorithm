import greedy.단속카메라;

public class Runner {
  public static void main(String[] args) {
    var result = new 단속카메라().solution(new int[][]{{-20,-15},{-14,-5},{-18,-13},{-5,-3}});
    System.out.println("=======================result");
    System.out.println(result);
//    Arrays.stream(result).forEach(System.out::println);
  }
}
