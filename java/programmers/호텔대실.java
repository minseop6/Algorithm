import java.util.ArrayList;
import java.util.PriorityQueue;

public class 호텔대실 {
  public int solution(String[][] book_time) {
    ArrayList<BookTime> booktimes = new ArrayList<BookTime>();
    for (String[] bookTime : book_time) {
      booktimes.add(new BookTime(bookTime[0], bookTime[1]));
    }
    booktimes.sort((a, b) -> a.checkin == b.checkin ? a.checkout - b.checkout : a.checkin - b.checkin);
    PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
    for (BookTime bookTime : booktimes) {
      if (queue.size() == 0) {
        queue.add(bookTime.checkout);
        continue;
      }

      int prevBookTime = queue.peek();
      if (bookTime.checkin >= prevBookTime) {
        queue.poll();
        queue.add(bookTime.checkout);
      } else {
        queue.add(bookTime.checkout);
      }
    }

    return queue.size();
  }

  static class BookTime {
    public int checkin;
    public int checkout;

    BookTime (String checkin, String checkout) {
      this.checkin = convertToInt(checkin);
      this.checkout = convertToInt(checkout) + 10;
    }

    private int convertToInt(String time) {
      String[] splitedTime = time.split(":");
      return Integer.parseInt(splitedTime[0]) * 60 + Integer.parseInt(splitedTime[1]);
    }
  }
}
