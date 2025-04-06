package step23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class no_2156 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        int[] wineGlasses = new int[count + 1];
        for (int index = 1; index <= count; index++) {
            wineGlasses[index] = Integer.parseInt(reader.readLine());
        }
        WineGlassesDP wineGlassesDP = new WineGlassesDP();
        int result = wineGlassesDP.calculate(wineGlasses);
        System.out.println(result);
    }
}

class WineGlassesDP {

    private final int[] dp = new int[10001];

    public int calculate(int[] wineGlasses) {

        dp[1] = wineGlasses[1];
        if (wineGlasses.length > 2) {
            dp[2] = dp[1] + wineGlasses[2];
        }

        for (int index = 3; index < wineGlasses.length; index++) {
            dp[index] = Math.max(
                    dp[index - 1],
                    Math.max(dp[index - 2], dp[index - 3] + wineGlasses[index - 1]) + wineGlasses[index]
            );
        }

        return dp[wineGlasses.length - 1];
    }
}
