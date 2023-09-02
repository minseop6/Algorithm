import java.util.*;

public class 광물캐기 {
  public int solution(int[] picks, String[] minerals) {
    int totalPick = Arrays.stream(picks).sum();
    int[][] fatigueMatrix = new int[minerals.length / 5 + 1][3];
    for (int i = 0; i < minerals.length && totalPick > 0; i++) {
      switch (minerals[i]) {
        case "diamond":
          fatigueMatrix[i / 5][0] += 1;
          fatigueMatrix[i / 5][1] += 5;
          fatigueMatrix[i / 5][2] += 25;
          break;
        case "iron":
          fatigueMatrix[i / 5][0] += 1;
          fatigueMatrix[i / 5][1] += 1;
          fatigueMatrix[i / 5][2] += 5;
          break;
        case "stone":
          fatigueMatrix[i / 5][0] += 1;
          fatigueMatrix[i / 5][1] += 1;
          fatigueMatrix[i / 5][2] += 1;
          break;
      }
      if (i % 5 == 4) {
        totalPick--;
      }
    }

    Arrays.sort(fatigueMatrix, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[2] < o2[2] ? 1 : -1;
      }
    });

    int answer = 0;
    for (int i = 0, pick = 0; i < fatigueMatrix.length; i++) {
      while(pick < 3 && picks[pick] == 0) pick++;
      if(pick == 3) break;
      picks[pick]--;
      answer += fatigueMatrix[i][pick];
    }
    return answer;
  }
}
