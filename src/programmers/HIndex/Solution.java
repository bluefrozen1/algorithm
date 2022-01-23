package programmers.HIndex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {

    public static void main(String[] args) {

        //System.out.println(new Solution().solution(new int[]{3, 0, 6, 1, 5}));
        System.out.println(new Solution().solution(new int[]{10,11,12,13}));
    }
    public int solution(int[] citations) {

        Arrays.sort(citations);

        for (int i = citations[citations.length-1]; i >= 0; i--) {
            int h = i;
            int count1 = 0;
            int count2 = 0;
            for (int j = citations.length-1; j >= 0; j--) {
                int h2 = citations[j];
                if(h2 >= h) {
                    count1++;
                } else {
                    count2++;
                }
                if(count1 < count2) {
                    break;
                }
            }

            if(count1 >= h && h >= count2) {
                return h;
            }
        }
        int answer = 0;
        return answer;
    }
}
