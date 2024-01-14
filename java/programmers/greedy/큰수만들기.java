package greedy;

import java.util.Arrays;

public class 큰수만들기 {
    public String solution(String number, int k) {

        var numbers = Arrays.stream(number.split("")).mapToInt(Integer::valueOf).toArray();
        var left = 0;
        StringBuilder answer = new StringBuilder();
        for (var sequence = 0; sequence < numbers.length - k; sequence++)  {
            var largestNumber = 0;
            for (var i = left; i <= numbers.length - (numbers.length - k - sequence); i++) {
                if (numbers[i] > largestNumber) {
                    left = i + 1;
                    largestNumber = numbers[i];
                }
            }
            answer.append(largestNumber);
        }

        return answer.toString();
    }
}
