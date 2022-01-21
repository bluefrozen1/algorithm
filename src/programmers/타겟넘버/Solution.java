package programmers.타겟넘버;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


class Solution {

    // https://programmers.co.kr/learn/courses/30/lessons/43165

    public static void main(String[] args) {
        System.out.println("답:" + new Solution().solution(new int[]{1, 1, 1, 1, 1}, 3));
    }

    public int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int depth, int sum) {
        int matchCount = 0;

        if (depth == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        matchCount += dfs(numbers, target, depth + 1, sum + numbers[depth]);
        matchCount += dfs(numbers, target, depth + 1, sum - numbers[depth]);
        return matchCount;
    }
}