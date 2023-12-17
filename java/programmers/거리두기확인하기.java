import java.util.LinkedList;

public class 거리두기확인하기 {
    private static int[] distanceX = new int[] { -1, 0, 1, 0 };
    private static int[] distanceY = new int[] { 0, -1, 0, 1 };
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (var roomIndex = 0; roomIndex < places.length; roomIndex++) {
            var place = places[roomIndex];
            var validRoom = 1;
            for (var rowIndex = 0; rowIndex < 5; rowIndex++) {
                for (var colIndex = 0; colIndex < 5; colIndex++) {
                    var currentLocation = places[roomIndex][rowIndex].charAt(colIndex);
                    if (currentLocation != 'P') {
                        continue;
                    }
                    var result = search(rowIndex, colIndex, place);
                    if (!result) {
                        validRoom = 0;
                    }
                }
            }
            answer[roomIndex] = validRoom;
        }
        return answer;
    }

    private boolean search(int row, int col, String[] place) {
        var visitedPlace = new boolean[5][5];
        var queue = new LinkedList<int[]>();
        queue.add(new int[] { row, col });
        visitedPlace[row][col] = true;
        while (!queue.isEmpty()) {
            var currentLocation = queue.pop();
            var currentRowIndex = currentLocation[0];
            var currentColIndex = currentLocation[1];
            for (var i = 0; i < distanceX.length; i++) {
                var nextRowIndex = currentRowIndex + distanceX[i];
                var nextColIndex = currentColIndex + distanceY[i];
                int manhattanDistance = calculateManhattanDistance(nextRowIndex, nextColIndex, row, col);
                if (
                        manhattanDistance <= 2
                                && nextRowIndex >= 0 && nextColIndex >= 0 && nextRowIndex < 5 && nextColIndex < 5
                                && !visitedPlace[nextRowIndex][nextColIndex]
                ) {
                    var nextPlace = place[nextRowIndex].split("")[nextColIndex];
                    if (nextPlace.equals("X")) {
                        continue;
                    } else if (nextPlace.equals("P")) {
                        return false;
                    }
                    queue.add(new int[] { nextRowIndex, nextColIndex });
                    visitedPlace[nextRowIndex][nextColIndex] = true;
                }
            }
        }

        return true;
    }

    private int calculateManhattanDistance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}
