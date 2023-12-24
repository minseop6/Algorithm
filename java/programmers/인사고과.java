import java.util.Arrays;

public class 인사고과 {
    public int solution(int[][] scores) {
        int answer = 0;
        var targetScore = scores[0];
        Arrays.sort(scores, (a, b) ->
            a[0] == b[0]
                    ? Integer.compare(a[1], b[1])
                    : Integer.compare(b[0], a[0])
        );

        var maxCoworkerScore = Integer.MIN_VALUE;
        for (int[] score : scores) {
            if (maxCoworkerScore > score[1]) {
                if (score[0] == targetScore[0] && score[1] == targetScore[1]) {
                    return -1;
                }
                continue;
            }
            if (score[0] + score[1] > targetScore[0] + targetScore[1]) {
                answer++;
            }
            maxCoworkerScore = score[1];
        }

        return answer + 1;
    }
}
