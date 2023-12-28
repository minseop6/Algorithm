import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class 메뉴리뉴얼 {
    private static final HashMap<String, Integer> courseMap = new HashMap<>();
    private static int[] max;
    private static int[] courses = new int[] {};
    public String[] solution(String[] orders, int[] course) {
        max = new int[course.length];
        courses = course;
        for (var order : orders) {
            var sortedOrder = sort(order);
            dfs(new boolean[sortedOrder.length()], sortedOrder, 0);
        }

        var answer = new ArrayList<String>();
        for (var item : courseMap.entrySet()) {
            for (var i = 0; i < courses.length; i++) {
                if (item.getKey().length() == courses[i] && item.getValue() != 1 && max[i] == item.getValue()) {
                    answer.add(item.getKey());
                }
            }
        }

        return answer.stream().sorted().toArray(String[]::new);
    }

    private void dfs(boolean[] visited, String order, int depth) {
        if (depth == order.length()) {
            var menuBuilder = new StringBuilder();
            for (var i = 0; i < order.length(); i++) {
                if (visited[i]) {
                    menuBuilder.append(order.charAt(i));
                }
            }
            var menu = menuBuilder.toString();
            if (menu.length() < 2) {
                return;
            }
            for (var i = 0; i < courses.length; i++) {
                if (menu.length() == courses[i]) {
                    var count = courseMap.getOrDefault(menu, 0);
                    count++;
                    courseMap.put(menu, count);
                    max[i] = Math.max(count, max[i]);
                }
            }
            return;
        }

        visited[depth] = true;
        dfs(visited, order, depth + 1);
        visited[depth] = false;
        dfs(visited, order, depth + 1);
    }

    private String sort(String order) {
        var charArray = order.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }
}
