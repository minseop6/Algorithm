package step23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no_1463 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());

        int[] dp = new int[number + 1];

        dp[0] = dp[1] = 0;
        for (int index = 2; index <= number; index++) {
            dp[index] = dp[index - 1] + 1;
            if (index % 2 == 0) {
                dp[index] = Math.min(dp[index], dp[index / 2] + 1);
            }
            if (index % 3 == 0) {
                dp[index] = Math.min(dp[index], dp[index / 3] + 1);
            }
        }

        System.out.println(dp[number]);
    }
}
