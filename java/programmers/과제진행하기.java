import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

//[["music", 740, "40"], ["computer", 750, "100"], ["science", 760, "50"], ["history", 840, "30"]]
// computer 90 music 30
// science history
public class 과제진행하기 {
  public String[] solution(String[][] plans) {
    List<String> answer = new ArrayList<String>();
    Arrays.sort(plans, (a, b) -> a[1].compareTo(b[1]));
    List<Node> nodes = new ArrayList<Node>();
    for (int i = 0; i < plans.length; i++) {
      String[] currentPlan = plans[i];
      String[] splitTimes = currentPlan[1].split(":");
      Node node = new Node(i, currentPlan[0], Integer.parseInt(splitTimes[0]) * 60 + Integer.parseInt(splitTimes[1]), Integer.parseInt(currentPlan[2]));
      nodes.add(node);
    }
    Stack<Node> remainNodes = new Stack<Node>();
    for (int i = 0; i < plans.length - 1; i++) {
      Node currentNode = nodes.get(i);
      Node nextNode = nodes.get(i + 1);
      int remainTime = nextNode.start - (currentNode.start + currentNode.playTime);
      if (remainTime >= 0) {
        answer.add(currentNode.name);
        while (remainTime > 0 && !remainNodes.isEmpty()) {
          Node remainNode = remainNodes.peek();
          int time = Math.min(remainNode.playTime, remainTime);
          remainNode.playTime -= time;
          remainTime -= time;
          if (remainNode.playTime == 0) {
            answer.add(remainNode.name);
            remainNodes.pop();
          }
        }
      } else {
        currentNode.playTime -= nextNode.start - currentNode.start;
        remainNodes.push(currentNode);
      }
    }
    answer.add(nodes.get(nodes.size() - 1).name);
    while (!remainNodes.isEmpty()) {
      Node remainNode = remainNodes.pop();
      answer.add(remainNode.name);
    }

    return answer.toArray(new String[] {});
  }

  static class Node{
    int index;
    String name;
    int start;
    int playTime;

    public Node(int index, String name, int start, int playTime){
      this.index = index;
      this.name = name;
      this.start = start;
      this.playTime = playTime;
    }
  }
}
