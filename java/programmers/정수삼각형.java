import java.util.Arrays;

public class 정수삼각형 {
    private static int[][] memoizationValues;
    public int solution(int[][] triangle) {
        memoizationValues = new int[triangle.length][triangle[triangle.length - 1].length];
        memoizationValues[0][0] = triangle[0][0];
        for (var row = 1; row < triangle.length; row++) {
            for (var col = 0; col < triangle[row].length; col++) {
                var currentValue = triangle[row][col];
                memoizationValues[row][col] = currentValue + Math.max(
                        memoizationValues[row - 1][col],
                        col - 1 < 0 ? 0 : memoizationValues[row - 1][col - 1]
                );
            }
        }
        return Arrays.stream(memoizationValues[triangle.length - 1]).max().getAsInt();
    }
}
