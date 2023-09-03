import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class 무인도여행 {
  public int[] solution(String[] maps) {
    char[][] graph = new char[maps.length][maps[0].length()];
    for (int y : IntStream.range(0, maps.length).toArray()) {
      for (int x : IntStream.range(0, maps[0].length()).toArray()) {
        char currentChar = maps[y].charAt(x);
        graph[y][x] = currentChar;
      }
    }
    LinkedList<Integer> answer = new LinkedList<Integer>();
    boolean[][] visitedPosition = new boolean[graph.length][graph[0].length];
    for (int y : IntStream.range(0, graph.length).toArray()) {
      for (int x : IntStream.range(0, graph[0].length).toArray()) {
        char currentDay = graph[y][x];
        if (currentDay != 'X' && !visitedPosition[y][x]) {
          Position position = new Position(x, y, currentDay);
          answer.add(bfs(graph, position, visitedPosition));
        }
      }
    }
    return answer.size() == 0 ? new int[] { -1 } : answer.stream().sorted((a, b) -> a - b).mapToInt((i) -> i).toArray();
  }

  private int bfs(char[][] graph, Position startPosition, boolean[][] visitedPosition) {
    int[] dX = { -1, 0, 1, 0 };
    int[] dY = { 0, 1, 0, -1 };
    Queue<Position> queue = new LinkedList<Position>();
    queue.add(startPosition);
    visitedPosition[startPosition.y][startPosition.x] = true;
    int maxHeight = graph.length;
    int maxWidth = graph[0].length;
    int total = 0;
    while (!queue.isEmpty()) {
      Position currentPosition = queue.poll();
      System.out.println(currentPosition.x + ", " + currentPosition.y + ", " + currentPosition.day + ", " + total);
      total += currentPosition.day;
      for (int i : IntStream.range(0, dX.length).toArray()) {
        int nextX = currentPosition.x + dX[i];
        int nextY = currentPosition.y + dY[i];
        if (nextX >= 0 && nextX < maxWidth && nextY >= 0 && nextY < maxHeight && graph[nextY][nextX] != 'X' && !visitedPosition[nextY][nextX]) {
          visitedPosition[nextY][nextX] = true;
          queue.add(new Position(nextX, nextY, graph[nextY][nextX]));
        }
      }
    }

    return total;
  }

  static class Position {
    public int x;
    public int y;
    public int day;

    Position (int x, int y, char day) {
      this.x = x;
      this.y = y;
      this.day = day == 'X' ? 0 : Character.getNumericValue(day);
    }
  }
}
