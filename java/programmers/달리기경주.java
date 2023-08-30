import java.util.HashMap;
import java.util.Map;

public class 달리기경주 {
  public String[] solution(String[] players, String[] callings) {
    Map<String, Integer> playerMap = new HashMap<String, Integer>();
    Map<Integer, String> rankMap = new HashMap<Integer, String>();
    int index = 0;
    for (String player : players) {
      playerMap.put(player, index);
      rankMap.put(index, player);
      index++;
    }
    for (String calling : callings) {
      int rank = playerMap.get(calling);
      String frontOfCalledPlayer = rankMap.get(rank - 1);
      playerMap.put(calling, rank - 1);
      playerMap.put(frontOfCalledPlayer, rank);
      rankMap.put(rank - 1, calling);
      rankMap.put(rank, frontOfCalledPlayer);
    }
    return rankMap.values().toArray(new String[0]);
  }
}
