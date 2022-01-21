package programmers.전화번호목록;

import java.util.*;

class Solution {

    // https://programmers.co.kr/learn/courses/30/lessons/42577

    public boolean solution(String[] phone_book) {
        List<String> list = new ArrayList<>(Arrays.asList(phone_book));
        Collections.sort(list);

        for(int i=0; i<list.size(); i++) {
            if(i<list.size()-1) {
                if(list.get(i+1).startsWith(list.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}