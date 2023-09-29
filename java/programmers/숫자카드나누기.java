import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class 숫자카드나누기 {
  public int solution(int[] arrayA, int[] arrayB) {
    int minimumNumberOfArrayA = Arrays.stream(arrayA).sorted().toArray()[0];
    int minimumNumberOfArrayB = Arrays.stream(arrayB).sorted().toArray()[0];

    ArrayList<Integer> divisorsA = getDivisors(minimumNumberOfArrayA);
    ArrayList<Integer> divisorsB = getDivisors(minimumNumberOfArrayB);
    divisorsA.sort(Collections.reverseOrder());
    divisorsB.sort(Collections.reverseOrder());

    return Math.max(check(divisorsA, arrayA, arrayB), check(divisorsB, arrayB, arrayA));
  }

  private ArrayList<Integer> getDivisors(int number) {
    ArrayList<Integer> divisors = new ArrayList<Integer>();
    for (int i = 1; i <= Math.sqrt(number); i++) {
      if (number % i == 0) {
         if (i != 1) {
           divisors.add(i);
         }
        if (Math.pow(i, 2) != number) {
           divisors.add(number / i);
        }
      }
    }

    return divisors;
  }

  private int check(ArrayList<Integer> divisors, int[] divideArray, int[] array) {
    for (int divisor : divisors) {
      if (
        Arrays.stream(divideArray).allMatch((number) -> number % divisor == 0)
        && Arrays.stream(array).allMatch((number) -> number % divisor != 0)
      ) {
        return divisor;
      }
    }

    return 0;
  }
}
