package step23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no_2579 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        int[] stairs = new int[count + 1];
        for (int index = 1; index <= count; index++) {
            stairs[index] = Integer.parseInt(reader.readLine());
        }

        StairDP stairDP = new StairDP();
        int result = stairDP.calculate(stairs);
        System.out.println(result);
    }
}

class StairDP {

    private final int[] dp = new int[301];

    public int calculate(int[] stairs) {
        dp[1] = stairs[1];
        if (stairs.length > 2) {
            dp[2] = stairs[1] + stairs[2];
        }
        for (int index = 3; index < stairs.length; index++) {
            dp[index] = Math.max(dp[index - 2], dp[index - 3] + stairs[index - 1]) + stairs[index];
        }
        return dp[stairs.length - 1];
    }
}