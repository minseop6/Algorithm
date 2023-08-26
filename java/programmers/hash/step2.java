package hash;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        loop:
        for(int i=0; i<phone_book.length; i++) {
            for(int j=0; j<phone_book.length; j++) {
                if(phone_book[j].length() > phone_book[i].length() && i != j) {
                    if(phone_book[j].substring(0, phone_book[i].length()).equals(phone_book[i])){
                        answer = false;
                        break loop;
                    }
                }else if(i != j) {
                    if(phone_book[i].substring(0, phone_book[j].length()).equals(phone_book[j])){
                        answer = false;
                        break loop;
                    }
                }
            }
        }

        return answer;
    }
}

//모범답안
//class Solution {
//    public boolean solution(String[] phoneBook) {
//       for(int i=0; i<phoneBook.length-1; i++) {
//            for(int j=i+1; j<phoneBook.length; j++) {
//                if(phoneBook[i].startsWith(phoneBook[j])) {return false;}
//                if(phoneBook[j].startsWith(phoneBook[i])) {return false;}
//            }
//        }
//        return true;
//    }
//}