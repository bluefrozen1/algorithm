package leetcode.MinimumWindowSubstring_76;

import java.util.HashMap;
import java.util.Map;

class Solution {

    // https://leetcode.com/problems/minimum-window-substring/

    public static void main(String[] args) {
        System.out.println(new Solution().minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(new Solution().minWindow("a", "a"));
        System.out.println(new Solution().minWindow("a", "aa"));
        System.out.println(new Solution().minWindow("aa", "aa"));


    }
    public String minWindow(String s, String t) {

        if(s.equals(t)) {
            return s;
        }

        Map<Character, Integer> map = new HashMap<>();
        String answer = "";

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        int[] index = new int[t.length()];

        for (int i = 0; i < tChars.length; i++) {
            map.put(tChars[i], map.getOrDefault(tChars[i], 0)+1);
        }

        int left = 0, right = 0;

        while(right < sChars.length) {

            if(map.containsKey(sChars[right])) {
                map.put(sChars[right], map.get(sChars[right]) - 1);
                if(searchComplate(map)) {
                    String newAnswer = s.substring(left, right+1);
                    if("".equals(answer) || answer.length() > newAnswer.length()) {
                        answer = newAnswer;
                    }
                    while(left<right) {
                        if(map.containsKey(sChars[left])) {
                            map.put(sChars[left], map.get(sChars[left]) + 1);
                        }
                        left++;
                        if(searchComplate(map)) {
                            newAnswer = s.substring(left, right+1);
                            if("".equals(answer) || answer.length() > newAnswer.length()) {
                                answer = newAnswer;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
            right++;
        }

        return answer;
    }

    public boolean searchComplate(Map<Character, Integer> map) {
        for(Integer count : map.values()) {
            if(count > 0) return false;
        }

        return true;
    }
}
