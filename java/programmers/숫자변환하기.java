import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class 숫자변환하기 {
  public int solution(int x, int y, int n) {
    return bfs(x, y, n);
  }

  private int bfs(int x, int y, int n) {
    HashSet<Integer> set = new HashSet<Integer>();
    Queue<Node> queue = new LinkedList<Node>();
    set.add(x);
    queue.add(new Node(x, 0));

    while (!queue.isEmpty()) {
      Node currentNode = queue.poll();
      if (currentNode.currentValue == y) {
        return currentNode.count;
      }
      int multiplicationBy2 = multiplication(currentNode.currentValue, 2);
      int multiplicationBy3 = multiplication(currentNode.currentValue, 3);
      int additionByn = addition(currentNode.currentValue, n);

      if (multiplicationBy2 <= y && !set.contains(multiplicationBy2)) {
        set.add(multiplicationBy2);
        queue.add(new Node(multiplicationBy2, currentNode.count + 1));
      }
      if (multiplicationBy3 <= y && !set.contains(multiplicationBy3)) {
        set.add(multiplicationBy3);
        queue.add(new Node(multiplicationBy3, currentNode.count + 1));
      }
      if (additionByn <= y && !set.contains(additionByn)) {
        set.add(additionByn);
        queue.add(new Node(additionByn, currentNode.count + 1));
      }
    }

    return -1;
  }

  private int multiplication(int multiplicand, int multiplier) {
    return multiplicand * multiplier;
  }

  private int addition(int addend1, int addend2) {
    return addend1 + addend2;
  }

  static class Node {
    int count;
    int currentValue;

    public Node(int currentValue, int count) {
      this.currentValue = currentValue;
      this.count = count;
    }
  }
}
