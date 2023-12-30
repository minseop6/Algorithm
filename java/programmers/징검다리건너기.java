public class 징검다리건너기 {
    public int solution(int[] stones, int k) {
        var min = 0;
        var max = Integer.MAX_VALUE;

        var answer = 0;
        while (min <= max) {
            var mid = (max + min) / 2;
            if (check(stones, k, mid)) {
                min = mid + 1;
                answer = mid;
            } else {
                max = mid - 1;
            }
        }

        return answer;
    }

    private boolean check(int[] stones, int k, int mid) {
        var count = 0;
        for (var stone : stones) {
            if (stone < mid) {
                count++;
                if (count >= k) {
                    return false;
                }
            } else {
                count = 0;
            }
        }

        return true;
    }
}
