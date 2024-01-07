import java.util.PriorityQueue;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        var queue = new PriorityQueue<Integer>();
        for (var scale : scoville) {
            queue.add(scale);
        }

        int answer = 0;
        while (!queue.isEmpty()) {
            var minScale = queue.poll();
            if (minScale >= K) {
                return answer;
            }
            if (queue.isEmpty()) {
                return -1;
            }
            var secondScale = queue.poll();
            queue.add(minScale + secondScale * 2);
            answer++;
        }

        return -1;
    }
}
