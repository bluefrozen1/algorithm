package leetcode.HouseRobber_192;

class Solution {

    // https://leetcode.com/problems/house-robber/

    public static void main(String[] args) {
        System.out.println(new Solution().rob(new int[]{2,7,9,3,1}));
        System.out.println(new Solution().rob(new int[]{0,0}));
        System.out.println(new Solution().rob(new int[]{1,2,1,1}));
        System.out.println(new Solution().rob(new int[]{1,7,9,4}));
    }
    public int rob(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        nums[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            nums[i] = Math.max(nums[i - 1], nums[i - 2] + nums[i]);
        }

        return nums[nums.length - 1];
    }
}
