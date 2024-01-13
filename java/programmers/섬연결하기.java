import java.util.Arrays;

public class 섬연결하기 {
    private static int[] parent;
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        for (var i = 0; i < n; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs, (item1, item2) -> item1[2] - item2[2]);
        var totalCost = 0;
        for (var cost : costs) {
            var fromParent = find(cost[0]);
            var toParent = find(cost[1]);
            if (fromParent == toParent) {
                continue;
            }
            totalCost += cost[2];
            parent[toParent] = fromParent;
        }

        return totalCost;
    }

    private static int find(int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }
}
