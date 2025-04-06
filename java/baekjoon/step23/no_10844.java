package step23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class no_10844 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        SimpleStairNumbersDP simpleStairNumbersDP = new SimpleStairNumbersDP();
        long result = simpleStairNumbersDP.calculate(number);

        System.out.println(result % 1000000000L);
    }
}

class SimpleStairNumbersDP {

    private final long[][] dp = new long[101][10];
    private final long MOD_VALUE = 1000000000L;

    public long calculate(int count) {
        for (int number = 1; number <= 9; number++) {
            dp[1][number] = 1;
        }

        for (int index = 2; index <= count; index++) {
            for (int number = 0; number <= 9; number++) {
                if (number == 0) {
                    dp[index][number] = dp[index - 1][1] % MOD_VALUE;
                } else if (number == 9) {
                    dp[index][number] = dp[index - 1][8] % MOD_VALUE;
                } else {
                    dp[index][number] = (dp[index - 1][number - 1] + dp[index - 1][number + 1]) % MOD_VALUE;
                }
            }
        }

        return Arrays.stream(dp[count]).sum();
    }
}