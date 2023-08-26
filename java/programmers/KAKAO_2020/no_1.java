package KAKAO_2020;

public class no_1 {

	public int solution(String s) {
        int answer = s.length(), count;
        String str = "", result = "";

        for(int i=1; i<=(double)s.length()/2; i++) {
            result = "";
            count = 1;
            str = s.substring(0, i);
            for(int j=i; j<s.length() - i + 1; j+=i) {
                if(str.equals(s.substring(j, j+i))) {
                    count++;
                }else {
                    if(count > 1) {
                        result += count;
                        count = 1;
                    }
                    result += str;
                    str = s.substring(j, j+i);
                }
            }

            if(count > 1) {
                result += count;
            }
            result += str;

            int remainder = s.length() % i;
            result += s.substring(s.length() - remainder, s.length());

            if(result.length() < answer) {
                answer = result.length();
            }
        }

        return answer;
    }
}

//모범답안
//class Solution {
//    public int solution(String s) {
//        int answer = 0;
//
//        for(int i=1; i<=(s.length()/2)+1; i++){
//            int result = getSplitedLength(s, i, 1).length();
//            answer = i==1 ? result : (answer>result?result:answer);
//        }
//
//        return answer;
//    }
//
//    public String getSplitedLength(String s, int n, int repeat){
//        if(s.length() < n) return s;
//        String result = "";
//        String preString = s.substring(0, n);
//        String postString = s.substring(n, s.length());
//
//        // 불일치 -> 현재까지 [반복횟수 + 반복문자] 조합
//        if(!postString.startsWith(preString)){
//            if(repeat ==1) return result += preString + getSplitedLength(postString, n, 1);
//            return result += Integer.toString(repeat) + preString + getSplitedLength(postString, n, 1);
//        }
//
//        return result += getSplitedLength(postString, n, repeat+1);
//    }
//}
