import java.util.stream.IntStream;

public class 혼자서하는틱택토 {
  public int solution(String[] board) {
    String[][] matrix = new String[board.length][board[0].length()];
    int xCount = 0;
    int oCount = 0;
    for (int y : IntStream.range(0, board.length).toArray()) {
      String[] line = board[y].split("");
      for (int x : IntStream.range(0, line.length).toArray()) {
        String currentSpace = line[x];
        if (currentSpace.equals("X")) {
          xCount++;
        } else if (currentSpace.equals("O")) {
          oCount++;
        }
        matrix[y][x] = line[x];
      }
    }

    if (xCount > oCount || oCount - xCount >= 2) {
      return 0;
    }

    boolean oCheck = check("O", matrix);
    boolean xCheck = check("X", matrix);

    if (oCheck && xCount + 1 != oCount)
      return 0;

    if (xCheck && xCount != oCount)
      return 0;

    return 1;
  }

  private boolean check(String target, String[][] matrix) {
    for(int i : IntStream.range(0, matrix.length).toArray()) {
      if (matrix[i][0].equals(target) && matrix[i][1].equals(target) && matrix[i][2].equals(target))
        return true;
    }

    for(int i : IntStream.range(0, matrix.length).toArray()) {
      if (matrix[0][i].equals(target) && matrix[1][i].equals(target) && matrix[2][i].equals(target))
        return true;
    }

    if (matrix[0][0].equals(target) && matrix[1][1].equals(target) && matrix[2][2].equals(target)) {
      return true;
    }

    if (matrix[2][0].equals(target) && matrix[1][1].equals(target) && matrix[0][2].equals(target)) {
      return true;
    }

    return false;
  }
}
