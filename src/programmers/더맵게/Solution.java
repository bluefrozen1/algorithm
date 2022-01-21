package programmers.더맵게;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


class Solution {

    // https://programmers.co.kr/learn/courses/30/lessons/42626

    public static void main(String[] args) {
        System.out.println("답:" + new Solution().solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }

    public int solution(int[] scoville, int K) {

        Queue<Integer> q = new PriorityQueue<>();
        for (int s : scoville) {
            q.add(s);
        }

        int count = 0;
        while(q.peek() != null && q.peek() < K) {

            if(q.size() == 1) {
                return -1;
            }

            Integer a = q.poll();
            Integer b = q.poll();

            Integer c = a + (b*2);
            q.add(c);
            count++;
        }
        return count;
    }
}