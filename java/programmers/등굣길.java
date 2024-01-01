public class 등굣길 {
    private static int MOD_VALUE = 1_000_000_007;
    public int solution(int m, int n, int[][] puddles) {
        var area = new int[m + 1][n + 1];
        for (var puddle : puddles) {
            area[puddle[0]][puddle[1]] = -1;
        }

        area[1][1] = 1;
        for (var row = 1; row <= m; row++) {
            for (var col = 1; col <= n; col++) {
                if (area[row][col] == -1) {
                    continue;
                }
                if (area[row - 1][col] > 0) {
                    area[row][col] += area[row - 1][col] % MOD_VALUE;
                }
                if (area[row][col - 1] > 0) {
                    area[row][col] += area[row][col - 1] % MOD_VALUE;
                }
            }
        }

        return area[m][n] % MOD_VALUE;
    }
}
