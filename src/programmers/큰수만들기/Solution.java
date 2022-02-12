package programmers.큰수만들기;

import java.util.Stack;
public class Solution {

    // https://programmers.co.kr/learn/courses/30/lessons/42883

    public static void main(String[] args) {
        System.out.println(new Solution().solution("1924", 2)); // 94
        System.out.println(new Solution().solution("1231234", 3)); // 3234
        System.out.println(new Solution().solution("4177252841", 4)); // 775841
    }

    public String solution(String number, int k) {
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<number.length(); i++) {
            char c = number.charAt(i);
            while (!stack.isEmpty() && stack.peek() < c && k-- > 0) {
                stack.pop();
            }
            stack.push(c);
        }
        for (int i=0; i<result.length; i++) {
            result[i] = stack.get(i);
        }
        return new String(result);
    }

}
