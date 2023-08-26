public class No11ContainerWithMostWater {
  public int maxArea(int[] heights) {
    int left = 0;
    int right = heights.length - 1;
    int largestArea = 0;
    while (left < right) {
      int leftHeight = heights[left];
      int rightHeight = heights[right];
      int area = Math.min(rightHeight, leftHeight) * (right - left);
      largestArea = Math.max(area, largestArea);
      if (leftHeight > rightHeight) {
        right--;
      } else{
        left++;
      }
    }

    return largestArea;
  }
}
