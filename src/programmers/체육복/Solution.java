package programmers.체육복;


import java.util.Arrays;

public class Solution {

    // https://programmers.co.kr/learn/courses/30/lessons/42862
    public static void main(String[] args) {

        System.out.println(new Solution().solution(5, new int[]{2,4}, new int[]{5,3,1}));
        System.out.println(new Solution().solution(5, new int[]{2,4}, new int[]{3}));
        System.out.println(new Solution().solution(3, new int[]{3}, new int[]{1}));
    }
    public int solution(int n, int[] lost, int[] reserve) {


        Arrays.sort(lost);
        Arrays.sort(reserve);

        int total = n - lost.length;

        for(int i=0; i<lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    lost[i] = -1;
                    reserve[j] = -1;
                    total++;
                }
            }
        }

        for(int i=0; i<lost.length; i++) {
            if(lost[i] == -1) {
                continue;
            }
            for (int j = 0; j < reserve.length; j++) {
                if(reserve[j] == -1) {
                    continue;
                }
                if(lost[i] -1 == reserve[j] || lost[i] +1 == reserve[j]) {
                    total++;
                    reserve[j]=-1;
                    break;
                }
            }
        }

        return total;
    }
}
