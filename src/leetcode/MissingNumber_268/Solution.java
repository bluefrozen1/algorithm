package leetcode.MissingNumber_268;

import java.util.Arrays;

public class Solution {
    // https://leetcode.com/problems/missing-number/

    public static void main(String[] args) {
        System.out.println(new Solution().missingNumber(new int[]{9,6,4,2,3,5,7,0,1}));
        System.out.println(new Solution().missingNumber(new int[]{3,0,1}));
        System.out.println(new Solution().missingNumber(new int[]{0,1}));
    }
    public int missingNumber(int[] nums) {

        Arrays.sort(nums);
        int beforeNumber = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] != beforeNumber) {
                return beforeNumber;
            } else {
                beforeNumber++;
            }
        }
        return beforeNumber;
    }
}
