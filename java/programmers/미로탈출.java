import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.IntStream;

public class 미로탈출 {
  public int solution(String[] maps) {
    char[][] graph = new char[maps.length][maps[0].length()];
    Position startPosition = null;
    Position leverPosition = null;
    Position exitPosition = null;
    for (int x : IntStream.range(0, maps.length).toArray()) {
      for (int y : IntStream.range(0, maps[x].length()).toArray()) {
        char currentChar = maps[x].charAt(y);
        graph[x][y] = currentChar;
        if (currentChar == 'S') {
          startPosition = new Position(x, y, 0);
        } else if (currentChar == 'L') {
          leverPosition = new Position(x, y, 0);
        } else if (currentChar == 'E') {
          exitPosition = new Position(x, y, 0);
        }
      }
    }

    int startPointToLeverPoint = bfs(graph, startPosition, leverPosition);
    int leverPointToExitPoint = bfs(graph, leverPosition, exitPosition);
    return startPointToLeverPoint == -1 || leverPointToExitPoint == -1
            ? -1
            : startPointToLeverPoint + leverPointToExitPoint;
  }

  private int bfs(char[][] graph, Position startingPosition, Position destinationPosition) {
    int[] dX = { -1, 0, 1, 0 };
    int[] dY = { 0, 1, 0, -1 };
    int maxHeight = graph.length;
    int maxWidth = graph[0].length;
    boolean[][] visitedPoint = new boolean[maxHeight][maxWidth];
    Queue<Position> queue = new LinkedList<Position>();
    queue.add(new Position(startingPosition.x, startingPosition.y, 0));
    visitedPoint[startingPosition.x][startingPosition.y] = true;

    while(!queue.isEmpty()) {
      Position currentPosition = queue.poll();
      int x = currentPosition.x;
      int y = currentPosition.y;
      if (x == destinationPosition.x && y == destinationPosition.y) {
        return currentPosition.count;
      }

      for (int i : IntStream.range(0, dX.length).toArray()) {
        int currentX = x + dX[i];
        int currentY = y + dY[i];
        if(currentX < 0 || currentX >= maxHeight || currentY < 0 || currentY >= maxWidth) {
          continue;
        }
        if (!visitedPoint[currentX][currentY] && graph[currentX][currentY] != 'X') {
          queue.add(new Position(currentX, currentY, currentPosition.count + 1));
          visitedPoint[currentX][currentY] = true;
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
