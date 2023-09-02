import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class 리코쳇로봇 {
  public int solution(String[] board) {
    Position startPosition = null;
    Position endPosition = null;
    char[][] graph = new char[board.length][board[0].length()];
    for (int y : IntStream.range(0, board.length).toArray()) {
      for (int x : IntStream.range(0, board[0].length()).toArray()) {
        char currentChar = board[y].charAt(x);
        graph[y][x] = currentChar;
        if (currentChar == 'R') {
          startPosition = new Position(x, y, 0);
        } else if (currentChar == 'G') {
          endPosition = new Position(x, y, 0);
        }
      }
    }

    return bfs(graph, startPosition, endPosition);
  }

  private int bfs(char[][] graph, Position startPosition, Position endPosition) {
    int[] xD = { -1, 0, 1, 0 };
    int[] yD = { 0, 1, 0, -1 };
    int maxHeight = graph.length;
    int maxWidth = graph[0].length;
    boolean[][] visitedPosition = new boolean[maxHeight][maxWidth];
    Queue<Position> queue = new LinkedList<Position>();
    queue.add(startPosition);
    visitedPosition[startPosition.y][startPosition.x] = true;

    while (!queue.isEmpty()) {
      Position currentPosition = queue.poll();
      int x = currentPosition.x;
      int y = currentPosition.y;
      if (x == endPosition.x && y == endPosition.y) {
        return currentPosition.count;
      }

      for (int i : IntStream.range(0, xD.length).toArray()) {
        int currentX = x;
        int currentY = y;
        int nextX = currentX + xD[i];
        int nextY = currentY + yD[i];
        while (nextX >= 0 && nextX < maxWidth && nextY >= 0 && nextY < maxHeight && graph[nextY][nextX] != 'D') {
          currentX += xD[i];
          currentY += yD[i];
          nextX += xD[i];
          nextY += yD[i];
        }
        if (!visitedPosition[currentY][currentX]) {
          visitedPosition[currentY][currentX] = true;
          queue.add(new Position(currentX, currentY, currentPosition.count + 1));
        }
      }
    }

    return -1;
  }

  static class Position {
    public int x;
    public int y;
    public int count;

    Position (int x, int y, int count) {
      this.x = x;
      this.y = y;
      this.count = count;
    }
  }
}
