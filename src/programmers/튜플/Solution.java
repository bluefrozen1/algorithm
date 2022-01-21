package programmers.튜플;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        int[] result = new Solution().solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
        System.out.println(Arrays.toString(result));
    }

    public int[] solution(String s) {

        String[] numberArr = s.replace("{", "").replace("}", "").split(",");

        Map<Integer, Integer> keyMap = new HashMap<>();
        Map<Integer, Integer> valueMap = new HashMap<>();

        for(String numberStr : numberArr) {
            Integer number = Integer.parseInt(numberStr);
            keyMap.compute(number, (k, v) -> v == null ? 1 :  v + 1);
        }

        for(Map.Entry<Integer, Integer> entry : keyMap.entrySet()) {
           valueMap.put(entry.getValue(), entry.getKey());
        }

        int[] answer = new int[valueMap.size()];
        for(Map.Entry<Integer, Integer> entry : valueMap.entrySet()) {
            answer[valueMap.size() - entry.getKey()] = entry.getValue();
        }
        return answer;
    }
}
