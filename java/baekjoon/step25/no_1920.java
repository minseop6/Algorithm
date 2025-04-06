package step25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class no_1920 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(reader.readLine());
        int[] queries = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        NumberBinarySearcher searcher = new NumberBinarySearcher(numbers);
        StringBuilder result = new StringBuilder();
        for (int query : queries) {
            int isInclude = searcher.search(query) ? 1 : 0;
            result.append(isInclude).append("\n");
        }

        System.out.print(result);
    }
}

class NumberBinarySearcher {

    private final int[] numbers;

    public NumberBinarySearcher(int[] numbers) {
        this.numbers = Arrays.stream(numbers).sorted().toArray();
    }

    public boolean search(int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (numbers[mid] == target) {
                return true;
            } else if (target < numbers[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return false;
    }
}