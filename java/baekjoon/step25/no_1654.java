package step25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class no_1654 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] counts = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int existLanLineCount = counts[0];
        int needLanLineCount = counts[1];

        int[] lanLines = new int[existLanLineCount];
        for (int index = 0; index < existLanLineCount; index++) {
            lanLines[index] = Integer.parseInt(reader.readLine());
        }

        LanLineCutter lanLineCutter = new LanLineCutter(lanLines);
        long result = lanLineCutter.cut(needLanLineCount);
        System.out.println(result);
    }
}

class LanLineCutter {

    private final int[] lanLines;
    private final long longestLanLine;

    public LanLineCutter(int[] lanLines) {
        this.lanLines = lanLines;
        longestLanLine = Arrays.stream(lanLines).max().orElse(0);
    }

    public long cut(int count) {
        long left = 0;
        long right = longestLanLine + 1;

        while (left < right) {
            long mid = (left + right) / 2;
            long cuttableCount = getCuttableCount(mid);
            if (cuttableCount >= count) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left - 1;
    }

    private long getCuttableCount(long length) {
        return Arrays.stream(lanLines)
                .mapToLong(lanLine -> lanLine / length)
                .sum();
    }
}