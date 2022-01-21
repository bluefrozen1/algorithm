package programmers.짝지어제거하기;

import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


class Solution {

    // https://programmers.co.kr/learn/courses/30/lessons/12973

    public static void main(String[] args) {
        System.out.println("답:" + new Solution().solution("cdcd"));
    }

    public int solution(String s) {
        int position = -1;
        char[] chars = s.toCharArray();
        Stack<Character> q = new Stack<>();
        for(int i=0; i<chars.length; i++) {
            if (q.isEmpty()) {
                q.add(chars[i]);
                continue;
            }

            if (q.peek() == chars[i]) {
                q.pop();
            } else {
                q.add(chars[i]);
            }
        }
        if(q.isEmpty()) {
            return 1;
        } else {
            return 0;
        }
    }
}
