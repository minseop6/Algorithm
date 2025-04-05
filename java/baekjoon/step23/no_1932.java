package step23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class no_1932 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        List<String> rawValues = IntStream.rangeClosed(1, count).boxed().map(index -> {
            try {
                return reader.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());

        Triangle triangle = Triangle.from(rawValues);
        TrianglePathDP trianglePathDP = new TrianglePathDP(triangle);
        int result = trianglePathDP.calculate();
        System.out.println(result);
    }
}

class Triangle {

    private final int[][] triangle;

    private Triangle(int[][] triangle) {
        this.triangle = triangle;
    }

    public static Triangle from(List<String> rawValues) {
        int[][] triangle = new int[rawValues.size()][rawValues.size()];
        for (int i = 0; i < rawValues.size(); i++) {
            String[] values = rawValues.get(i).split(" ");
            for (int j = 0; j < values.length; j++) {
                triangle[i][j] = Integer.parseInt(values[j]);
            }
        }
        return new Triangle(triangle);
    }

    public int getHeight() {
        return triangle.length;
    }

    public int get(int depth, int index) {
        return triangle[depth][index];
    }
}

class TrianglePathDP {

    private final int[][] dp = new int[501][501];
    private final Triangle triangle;

    public TrianglePathDP(Triangle triangle) {
        this.triangle = triangle;
    }

    public int calculate() {
        for (int depth = 0; depth < triangle.getHeight(); depth++) {
            for (int index = 0; index <= depth; index++) {
                if (depth == 0) {
                    dp[depth][index] = triangle.get(depth, index);
                } else {
                    int left = index == 0 ? 0 : dp[depth - 1][index - 1];
                    int right = index == depth ? 0 : dp[depth - 1][index];
                    dp[depth][index] = Math.max(left, right) + triangle.get(depth, index);
                }
            }
        }
        return Arrays.stream(dp[triangle.getHeight() - 1]).max().orElse(0);
    }
}