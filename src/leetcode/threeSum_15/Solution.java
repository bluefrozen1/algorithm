package leetcode.threeSum_15;

import java.util.*;

class Solution {

    public static void main(String[] args) {
        //System.out.println(new Solution().threeSum(new int[]{-1,0,1,2,-1,-4}));
        System.out.println(new Solution().threeSum(new int[]{-2,0,1,1,2}));
    }
    public List<List<Integer>> threeSum(int[] nums) {

        if (nums.length == 1) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        Map<List<Integer>, String> map = new HashMap<>();
        List<List<Integer>> list = new ArrayList<>();
        for(int head=0; head<nums.length; head++) {

            int mid = head+1;
            int tail = nums.length-1;

            while(mid < tail) {
                int sum = nums[head] + nums[mid] + nums[tail];

                if(sum == 0) {
                    List<Integer> innerList = Arrays.asList(nums[head], nums[mid], nums[tail]);
                    Collections.sort(innerList);
                    map.put(innerList, "");

                    tail--;
                } else if (sum < 0) {
                    mid++;
                } else {
                    tail--;
                }
            }
        }
        return new ArrayList(map.keySet());
    }
}
