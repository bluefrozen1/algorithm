package programmers.위장;

import java.util.*;

class Solution {

    // https://programmers.co.kr/learn/courses/30/lessons/42578

    public int solution(String[][] clothes) {

        Map<String, String> map = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        for(int i=0; i< clothes.length; i++) {
            String type = clothes[i][1];
            String name = clothes[i][0];
            map.put(name, type);
        }

        for(String str : map.values()) {
            map2.put(str, map2.getOrDefault(str, 0) + 1);
        }

        int count = 1;
        for(Integer c : map2.values()) {
            count = (c+1) * count;
        }
        count = count-1;

        return count;
    }
}
