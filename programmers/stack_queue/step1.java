package stack_queue;

class Solution {
    public int[] solution(int[] heights) {
		int[] answer = new int[heights.length];
		for(int i=0; i<heights.length; i++) {
			answer[i] = 0;
		}
		
		for(int i=heights.length - 1; i>0; i--) {
			for(int j=i-1; j>=0; j--) {
				if(heights[i] < heights[j]) {
					answer[i] = j + 1;
					break;
				}
			}
		}
        return answer;
    }
}

//모범답안
//class Solution {
//    class Tower {
//        int idx;
//        int height;
//
//        public Tower(int idx, int height) {
//            this.idx = idx;
//            this.height = height;
//        }
//
//        @Override
//        public String toString() {
//            return "idx : " + idx + " height : " + height;
//        }
//    }
//
//    public int[] solution(int[] heights) {
//        Stack<Tower> st = new Stack<>();
//        int[] answer = new int[heights.length];
//
//        for (int i = 0; i < heights.length; i++) {
//            Tower tower = new Tower(i + 1, heights[i]);
//            int receiveIdx = 0;
//
//            while (!st.isEmpty()) {
//                Tower top = st.peek();
//
//                if (top.height > tower.height) {
//                    receiveIdx = top.idx;
//                    break;
//                }
//
//                st.pop();
//            }
//
//            st.push(tower);
//            answer[i] = receiveIdx;
//        }
//
//        return answer;
//    }
//}