package leetcode.HouseRobberII_213;

class Solution {

    // https://leetcode.com/problems/house-robber-ii/submissions/

    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{2,3,2}));
        System.out.println(new Solution().rob(new int[]{1,2,3,1}));
        System.out.println(new Solution().rob(new int[]{1,2,3}));
    }
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        return Math.max(executeRob(nums, 2, nums.length-1), executeRob(nums, 3, nums.length));
    }

    public int executeRob(int[] nums, int startIndex, int endIndex) {

        int[] dp1 = new int[nums.length];
        dp1[startIndex-2] = nums[startIndex-2];
        dp1[startIndex-1] = Math.max(nums[startIndex-2], nums[startIndex-1]);

        for (int i = startIndex; i < endIndex; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
        }
        return dp1[endIndex-1];
    }
}
