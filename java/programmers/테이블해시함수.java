import java.util.Arrays;
import java.util.stream.IntStream;

public class 테이블해시함수 {
  public int solution(int[][] data, int col, int row_begin, int row_end) {
    int answer = 0;
    sortBySelectionSort(data, col - 1);
    for (int i : IntStream.rangeClosed(row_begin, row_end).toArray()) {
      answer = answer ^ Arrays.stream(data[i - 1]).reduce(0, (acc, cur) -> acc + cur % i);
      System.out.println(answer);
    }
    return answer;
  }

  private void sortBySelectionSort(int[][] data, int col) {
    for (int i = 0; i < data.length - 1; i++) {
      int minIdx = i;
      for (int j = i + 1; j < data.length; j++) {
        if (data[j][col] < data[minIdx][col]) {
          minIdx = j;
        } else if (data[j][col] == data[minIdx][col]) {
          minIdx = data[j][0] < data[minIdx][0] ? minIdx : j;
        }
      }
      swap(data, i, minIdx);
    }
  }

  public static void swap(int[][] data, int idx1, int idx2) {
    int[] tmp = data[idx1];
    data[idx1] = data[idx2];
    data[idx2] = tmp;
  }
}
