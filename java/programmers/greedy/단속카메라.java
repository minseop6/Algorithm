package greedy;

import java.util.Arrays;

public class 단속카메라 {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (item1, item2) -> {
            if (item1[1] == item2[1]) {
                return item1[0] - item2[0];
            }
            return item1[1] - item2[1];
        });

        int answer = 1;
        var endPosition = routes[0][1];
        for (var i = 1; i < routes.length; i++) {
            if (endPosition < routes[i][0]) {
                answer++;
                endPosition = routes[i][1];
            }
        }

        return answer;
    }
}
