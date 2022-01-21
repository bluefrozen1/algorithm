package programmers.뉴스클러스터링;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

class Solution {

    // https://programmers.co.kr/learn/courses/30/lessons/17677

    public static void main(String[] args) {

        System.out.println(new Solution().solution("FRANCE", "french"));
        System.out.println(new Solution().solution("handshake", "shake hands"));
        System.out.println(new Solution().solution("aa1+aa2", "AAAA12"));
        System.out.println(new Solution().solution("E=M*C^2", "e=m*c^2"));
    }
    public int solution(String str1, String str2) {

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        if(str1.equals(str2)) {
            return 65536;
        }

        Map<String, Integer> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();

        char[] chars1 = str1.toCharArray();
        for(int i=0; i<str1.length()-1; i++) {
            String key = String.valueOf(chars1[i]) + String.valueOf(chars1[i+1]);

            if(Pattern.matches("[a-zA-Z]+", key)) {
                map1.put(key, map1.getOrDefault(key, 0)+1);
            }
        }

        char[] chars2 = str2.toCharArray();
        for(int i=0; i<str2.length()-1; i++) {
            String key = String.valueOf(chars2[i]) + String.valueOf(chars2[i+1]);
            if(Pattern.matches("[a-zA-Z]+", key)) {
                map2.put(key, map2.getOrDefault(key, 0)+1);
            }
        }

        int intersectionCount = 0;
        for(Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            if(map1.containsKey(key)) {
                intersectionCount += Math.min(value, map1.get(key));
            }
        }

        int unionCount = 0;
        for(Map.Entry<String, Integer> entry : map2.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

            if(map1.containsKey(key)) {
                map1.put(key, Math.max(map1.get(key), value));
            } else {
                map1.put(key, value);
            }
        }

        for(Map.Entry<String, Integer> entry : map1.entrySet()) {
            unionCount += entry.getValue();
        }

        double d = (double)intersectionCount/(double)unionCount;
        int answer = (int)(d*65536D);
        return answer;
    }
}
