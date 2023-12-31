import java.util.stream.Stream;

public class 연속펄스부분수열의합 {
    public long solution(int[] sequence) {
        var positiveSequence = new int[sequence.length];
        var negativeSequence = new int[sequence.length];
        var signature = 1;
        for (var i = 0; i < sequence.length; i++) {
            positiveSequence[i] = sequence[i] * signature;
            signature *= -1;
            negativeSequence[i] = sequence[i] * signature;
        }

        var positiveDp = new long[sequence.length];
        var negativeDp = new long[sequence.length];
        positiveDp[0] = positiveSequence[0];
        negativeDp[0] = negativeSequence[0];
        var answer = Math.max(positiveDp[0], negativeDp[0]);
        for (var i = 1; i < sequence.length; i++) {
            positiveDp[i] = Math.max(positiveDp[i - 1] + positiveSequence[i], positiveSequence[i]);
            negativeDp[i] = Math.max(negativeDp[i - 1] + negativeSequence[i], negativeSequence[i]);
            answer = Stream.of(positiveDp[i], negativeDp[i], answer).max(Long::compare).get();
        }

        return answer;
    }
}
