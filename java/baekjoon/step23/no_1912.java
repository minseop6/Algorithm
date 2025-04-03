package step23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class no_1912 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        List<Integer> numbers = Arrays.stream(reader.readLine().split(" ")).map(Integer::parseInt)
                .collect(Collectors.toList());
        ContinuousSequenceSumDP continuousSequenceSumDP = new ContinuousSequenceSumDP(numbers);
        int result = continuousSequenceSumDP.sum();
        System.out.println(result);
    }
}


class ContinuousSequenceSumDP {

    private final Integer[] dp;
    private final List<Integer> numbers;

    public ContinuousSequenceSumDP(List<Integer> numbers) {
        this.numbers = numbers;
        this.dp = new Integer[numbers.size()];
    }

    public int sum() {
        int maxValue = Integer.MIN_VALUE;
        for (int index = 0; index < numbers.size(); index++) {
            dp[index] = index == 0
                    ? numbers.get(index)
                    : Math.max(dp[index - 1] + numbers.get(index), numbers.get(index));
            maxValue = Math.max(maxValue, dp[index]);
        }

        return maxValue;
    }
}