import java.util.HashMap;

public class 할인행사 {
    private static HashMap<String, Integer> shoppingItems = new HashMap<>();
    private static HashMap<String, Integer> wantedItems = new HashMap<>();
    public int solution(String[] want, int[] number, String[] discount) {
        for (var i = 0; i < want.length; i++) {
            wantedItems.put(want[i], number[i]);
        }
        resetShoppingItems();

        int answer = 0;
        var leftIndex = 0;
        var rightIndex = 0;
        while (rightIndex < discount.length) {
            var todayDiscountItem = discount[rightIndex];
            if (!wantedItems.containsKey(todayDiscountItem)) {
                resetShoppingItems();
                rightIndex++;
                leftIndex = rightIndex;
            } else {
                var count = shoppingItems.get(todayDiscountItem);
                shoppingItems.put(todayDiscountItem, count + 1);
                if (rightIndex - leftIndex == 9) {
                    if (compare()) {
                        answer++;
                    }
                    var previousItem = discount[leftIndex];
                    var previousItemCount = shoppingItems.get(previousItem);
                    shoppingItems.put(previousItem, previousItemCount - 1);
                    leftIndex++;
                }
                rightIndex++;
            }
        }

        return answer;
    }

    private void resetShoppingItems() {
        wantedItems.keySet().forEach((item) -> shoppingItems.put(item, 0));
    }

    private boolean compare() {
        for (var wantedItem : wantedItems.entrySet()) {
            if (!shoppingItems.get(wantedItem.getKey()).equals(wantedItem.getValue())) {
                return false;
            }
        }
        return true;
    }
}
