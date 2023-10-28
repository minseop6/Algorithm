import java.util.LinkedList;
import java.util.Queue;

public class 삼각달팽이 {
  public int[] solution(int n) {
    Queue<Movement> movementQueue = new LinkedList<Movement>();
    movementQueue.add(new Movement(1, 0));
    movementQueue.add(new Movement(0, 1));
    movementQueue.add(new Movement(-1, 0));
    movementQueue.add(new Movement(1, -1));

    var row = 0;
    var col = 0;
    var moveCount = 0;
    var limit = n;
    var matrix = new int[n][n];
    var boxCount = getBoxCount(n);
    for (var i = 1; i <= boxCount; i++) {
      matrix[row][col] = i;
      moveCount++;
      if (moveCount == limit) {
        var currentMovement = movementQueue.poll();
        if (limit != n) {
          movementQueue.add(currentMovement);
        }
        limit--;
        moveCount = 0;
      }
      var movement = movementQueue.peek();
      row += movement.nextRow;
      col += movement.nextCol;
    }

    int[] answer = new int[boxCount];
    var index = 0;
    for (var i = 0; i < n; i++) {
      for (var j = 0; j < n; j++) {
        if (matrix[i][j] != 0) {
          answer[index] = matrix[i][j];
          index++;
        }
      }
    }
    return answer;
  }

  private int getBoxCount(int n) {
    var boxCount = (n + 1) * (n / 2);
    if (n % 2 != 0) {
      boxCount += n / 2 + 1;
    }

    return boxCount;
  }

  static class Movement {
    int nextRow;
    int nextCol;

    Movement(int nextRow, int nextCol) {
      this.nextRow = nextRow;
      this.nextCol = nextCol;
    }
  }
}
