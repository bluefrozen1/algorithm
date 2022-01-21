package programmers.기능개발;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


class Solution {

    // https://programmers.co.kr/learn/courses/30/lessons/42586

    public int[] solution(int[] progresses, int[] speeds) {

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<progresses.length; i++) {
            map.put(i, progresses[i]);
        }

        List<Integer> result = new ArrayList<>();
        while(true) {

            boolean complated = false;
            int complatedIndex = -1;
            for(int j=progresses.length-1; j>=0; j--) {
                if(map.get(j) == null) continue;
                if(map.get(j) > 99) {
                    complated = true;
                    if(complatedIndex == -1) complatedIndex = j;
                } else {
                    complated = false;
                    complatedIndex = -1;
                }
            }
            if(complated) {
                int count = 0;
                for(int z=0; z<=complatedIndex; z++) {
                    if(map.remove(z) != null) {
                        count++;
                    }
                }
                result.add(count);

                if(map.size() == 0) {
                    break;
                }
            }

            for(int k=0; k<progresses.length; k++) {
                if(map.get(k) != null) {
                    map.put(k, map.get(k)+speeds[k]);
                }
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
