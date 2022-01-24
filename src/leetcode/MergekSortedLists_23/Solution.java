package leetcode.MergekSortedLists_23;

import java.util.Arrays;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {

    public static void main(String[] args) {

//        Output: [1,1,2,3,4,4,5,6]

        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(2, new ListNode(6));


        ListNode result = new Solution().mergeKLists(lists);

        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int totalCount = 0;
        for(ListNode node : lists) {
            while(node != null) {
                node = node.next;
                totalCount++;
            }
        }

        if(totalCount == 0) {
            return null;
        }

        ListNode[] currentNode = new ListNode[lists.length];
        for (int i = 0; i < lists.length; i++) {
            currentNode[i] = lists[i];
        }

        ListNode currentResultNode = new ListNode();
        ListNode tempNode = currentResultNode;
        ListNode result = currentResultNode;

        int count = 0;
        while(true) {

            int val = Integer.MAX_VALUE;
            int lowerIndex = 0;
            for (int i = 0; i < lists.length; i++) {
                if(lists[i] == null) {
                    continue;
                }
                if(lists[i].val < val) {
                    val = lists[i].val;
                    lowerIndex = i;
                }
            }
            if(val == Integer.MAX_VALUE) {
                break;
            }

            count++;
            currentResultNode.val = lists[lowerIndex].val;
            if(count < totalCount) {
                currentResultNode.next = new ListNode();
                currentResultNode = currentResultNode.next;
            }

            lists[lowerIndex] = lists[lowerIndex].next;
        }

        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
