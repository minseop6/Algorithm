import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class 부대복귀 {
  private static final ArrayList<ArrayList<Integer>> roadMap = new ArrayList<>();
  private static int[] distances;
  private static final int MAX = 1_000_000_000;
  public int[] solution(int n, int[][] roads, int[] sources, int destination) {
    for (int i = 0; i <= n; i++) {
      roadMap.add(new ArrayList<>());
    }
    for (var road : roads) {
      var left = road[0];
      var right = road[1];
      roadMap.get(left).add(right);
      roadMap.get(right).add(left);
    }

    distances = new int[n + 1];
    Arrays.fill(distances, MAX);
    dijkstra(destination);
    int[] answer = new int[sources.length];
    for (var i = 0; i < sources.length; i++) {
      answer[i] = distances[sources[i]] == MAX ? -1 : distances[sources[i]];
    }
    return answer;
  }

  private void dijkstra(int destination) {
    var queue = new LinkedList<Integer>();
    queue.add(destination);
    distances[destination] = 0;
    while (!queue.isEmpty()) {
      var currentPoint = queue.poll();
      for (var i = 0; i < roadMap.get(currentPoint).size(); i++) {
        var nextPoint = roadMap.get(currentPoint).get(i);
        if (distances[nextPoint] > distances[currentPoint] + 1) {
          distances[nextPoint] = distances[currentPoint] + 1;
          queue.add(nextPoint);
        }
      }
    }
  }
}
