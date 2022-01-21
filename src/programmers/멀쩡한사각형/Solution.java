package programmers.멀쩡한사각형;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


class Solution {

    // https://programmers.co.kr/learn/courses/30/lessons/62048

    public static void main(String[] args) {
        System.out.println("답:" + new Solution().solution(8, 12));
    }

    public long solution(int w, int h) {

        long wl = Long.parseLong(String.valueOf(w));
        long hl = Long.parseLong(String.valueOf(h));

        return wl * hl - (long)(wl + hl - gcd(wl, hl));
    }

    private static long gcd(long a, long b) {
        long tmp, n; //a에 큰 값을 위치시키기 위한 조건이다.
        if (a < b) {
            tmp = a;
            a = b;
            b = tmp;
        } //b가 0 될때까지(a%b), 반복문을 돌게되고, b가 0인 순간의 a를 GCD로 판단하고 리턴한다
        while (b != 0) {
            n = a % b;
            a = b;
            b = n;
        }
        return a;
    }

}