import java.util.Arrays;

public class 입국심사 {
    public long solution(int n, int[] times) {

        Arrays.sort(times);

        var left = (long) times[0];
        var right = (long) times[times.length - 1] * n;

        long answer = right;
        while (left <= right) {
            var mid = (left + right) / 2;
            var count = 0L;
            for (var time : times) {
                count += mid / time;
            }

            if (count >= n) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;
    }
}
