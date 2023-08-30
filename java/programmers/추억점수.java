import java.util.*;

public class 추억점수 {
  public int[] solution(String[] name, int[] yearning, String[][] photo) {
    Map<String, Integer> yearingMap = new HashMap<String, Integer>();
    int index = 0;
    for (int grade : yearning) {
      yearingMap.put(name[index], grade);
      index++;
    }
    List<Integer> answer = new ArrayList<Integer>();
    for (String[] people : photo) {
      int accumulatedGrade = 0;
      for (String person : people) {
        accumulatedGrade += yearingMap.getOrDefault(person, 0);
      }
      answer.add(accumulatedGrade);
    }
    return answer.stream().mapToInt((number) -> number).toArray();
  }
}
