import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class 수식최대화 {
    private static Long max = 0L;
    static boolean[] visited;
    private static List<String> operatorCategory;
    private static List<Long> numberList = new ArrayList<>();
    private static List<String> operatorList = new ArrayList<>();
    public long solution(String expression) {
        var operatorCategoryList = List.of("+", "-", "*");
        StringBuilder tempNumber = new StringBuilder();
        for (var character : expression.split("")) {
            if (operatorCategoryList.contains(character)) {
                numberList.add(Long.valueOf(tempNumber.toString()));
                operatorList.add(character);
                tempNumber = new StringBuilder();
            } else {
                tempNumber.append(character);
            }
        }
        numberList.add(Long.valueOf(tempNumber.toString()));
        this.operatorCategory = new ArrayList<>(new HashSet<>(operatorList));
        visited = new boolean[this.operatorCategory.size()];
        priorityOrder(new ArrayList<String>());

        return max;
    }

    private void priorityOrder(List<String> order) {
        if (order.size() == operatorCategory.size()) {
            max = Math.max(calculate(order), max);
            return;
        }

        for (var i = 0; i < operatorCategory.size(); i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            order.add(operatorCategory.get(i));
            priorityOrder(order);;
            visited[i] = false;
            order.remove(order.size() - 1);
        }
    }

    private Long calculate(List<String> order) {
        var numberList = new ArrayList<Long>(this.numberList);
        var operatorList = new ArrayList<String>(this.operatorList);

        for (var operator : order) {
            for (var i = 0; i < operatorList.size(); i++) {
                if (!operator.equals(operatorList.get(i))) {
                    continue;
                }

                var calculatedNumber = calculateByOperator(numberList.get(i), numberList.get(i + 1), operator);
                numberList.set(i, calculatedNumber);
                numberList.remove(i + 1);
                operatorList.remove(i);
                i--;
            }
        }

        return Math.abs(numberList.get(0));
    }

    private Long calculateByOperator(long a, long b, String operator) {
        if (operator.equals("+")) {
            return a + b;
        } else if (operator.equals("-")) {
            return a - b;
        } else {
            return a * b;
        }
    }
}
