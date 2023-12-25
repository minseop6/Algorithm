import java.util.HashMap;

public class 파괴되지않은건물 {
    public int solution(int[][] board, int[][] skill) {
        var damageMatrix = new int[board.length + 1][board[0].length + 1];
        for (var currentSkill : skill) {
            var degree = getDegree(currentSkill[0], currentSkill[5]);
            var startX = currentSkill[1];
            var startY = currentSkill[2];
            var endX = currentSkill[3];
            var endY = currentSkill[4];
            damageMatrix[startX][startY] += degree;
            damageMatrix[startX][endY + 1] -= degree;
            damageMatrix[endX + 1][startY] -= degree;
            damageMatrix[endX + 1][endY + 1] += degree;
        }

        for (var x = 0; x <= board.length; x++) {
            for (var y = 0; y < board[0].length; y++) {
                damageMatrix[x][y + 1] += damageMatrix[x][y];
            }
        }
        for (var y = 0; y <= board[0].length; y++) {
            for (var x = 0; x < board.length; x++) {
                damageMatrix[x + 1][y] += damageMatrix[x][y];
            }
        }

        int answer = 0;
        for (var x = 0; x < board.length; x++) {
            for (var y = 0; y < board[0].length; y++) {
                if (board[x][y] + damageMatrix[x][y] > 0) {
                    answer++;
                }
            }
        }

        return answer;
    }

    private int getDegree(int type, int degree) {
        return (type == 1 ? -1 : 1) * degree;
    }
}
