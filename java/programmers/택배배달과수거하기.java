public class 택배배달과수거하기 {
  public long solution(int cap, int n, int[] deliveries, int[] pickups) {
    long answer = 0;
    int currentDeliveries = 0;
    int currentPickups = 0;
    for (int i = n - 1; i >= 0; i--) {
      if (deliveries[i] > 0 || pickups[i] > 0) {
        int count = 0;
        while (currentDeliveries < deliveries[i] || currentPickups < pickups[i]) {
          count++;
          currentDeliveries += cap;
          currentPickups += cap;
        }
        currentDeliveries -= deliveries[i];
        currentPickups -= pickups[i];
        answer += (long) (i + 1) * count * 2;
      }
    }
    return answer;
  }
}
