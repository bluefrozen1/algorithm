package leetcode.JumpGame_55;

class Solution {

    // https://leetcode.com/problems/jump-game/

    public static void main(String[] args) {
        //System.out.println(new Solution().canJump(new int[]{2,3,1,1,4}));
//        System.out.println(new Solution().canJump(new int[]{3,2,1,0,4}));
//        System.out.println(new Solution().canJump(new int[]{2,0,0}));
//        System.out.println(new Solution().canJump(new int[]{2,5,0,0}));
//        System.out.println(new Solution().canJump(new int[]{1,3,2}));
//        System.out.println(new Solution().canJump(new int[]{1,1,2,2,0,1,1}));
//        System.out.println(new Solution().canJump(new int[]{1,1,0,1}));
//        System.out.println(new Solution().canJump(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));
//        System.out.println(new Solution().canJump(new int[]{1,2,3}));
        System.out.println(new Solution().canJump(new int[]{0,1}));

    }
    public boolean canJump(int[] nums) {

        if(nums.length == 1) {
            return true;
        }

        if(nums[0] == 0) {
            return false;
        }

        int startIndex = 0;
        int finishIndex = 1;
        while(finishIndex<nums.length) {

            if(finishIndex >= nums.length) {
                return true;
            }

            int max = 0;
            for (int i = startIndex; i <= finishIndex; i++) {
                max = Math.max(max, i+nums[i]);
            }

            startIndex = finishIndex;
            finishIndex = max;

            if(finishIndex<=nums.length && startIndex == finishIndex) {
                return false;
            }
        }
        return true;
    }
}