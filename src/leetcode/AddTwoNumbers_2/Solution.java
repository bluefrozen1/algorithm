package leetcode.AddTwoNumbers_2;

import java.util.LinkedList;
import java.util.Queue;

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

        int[] l1Arr = new int[]{9,9,9,9,9,9,9};
        int[] l2Arr = new int[]{9,9,9,9};

        ListNode l1Node = new ListNode();
        ListNode currentNode1 = l1Node;
        l1Node.val = l1Arr[0];
        for(int i=1; i<l1Arr.length; i++) {
            currentNode1.next = new ListNode(l1Arr[i]);
            currentNode1 = currentNode1.next;
        }

        ListNode l2Node = new ListNode();
        ListNode currentNode2 = l2Node;
        l2Node.val = l2Arr[0];
        for(int i=1; i<l2Arr.length; i++) {
            currentNode2.next = new ListNode(l2Arr[i]);
            currentNode2 = currentNode2.next;
        }

        System.out.println(new Solution().addTwoNumbers(l1Node, l2Node));
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Queue<Integer> l1Queue = new LinkedList<>();
        ListNode currentNode1 = l1;
        while(currentNode1 != null) {
            l1Queue.add(currentNode1.val);
            currentNode1 = currentNode1.next;
        }

        Queue<Integer> l2Queue = new LinkedList<>();
        ListNode currentNode2 = l2;
        while(currentNode2 != null) {
            l2Queue.add(currentNode2.val);
            currentNode2 = currentNode2.next;
        }

        ListNode resultNode = new ListNode();
        ListNode currentResultNode = resultNode;
        boolean upperTen = false;
        int loopCount = Math.max(l1Queue.size(), l2Queue.size());
        for(int i=0; i<loopCount; i++) {

            Integer l1Number = l1Queue.poll();
            if(l1Number == null) l1Number = 0;
            Integer l2Number = l2Queue.poll();
            if(l2Number == null) l2Number = 0;
            int sum = l1Number + l2Number;
            if(upperTen) {
                sum += 1;
                upperTen = false;
            }

            if(sum >= 10) {
                sum = sum - 10;
                upperTen = true;
            }

            if(currentResultNode == null) {
                currentResultNode = new ListNode();
            }
            currentResultNode.val = sum;
            if(i < loopCount -1) {
                currentResultNode.next = new ListNode();
                currentResultNode = currentResultNode.next;
            }
        }

        if(upperTen == true) {
            currentResultNode.next = new ListNode(1);
        }

        ListNode cc = resultNode;

        while(cc != null) {
            System.out.println(cc.val);
            cc = cc.next;
        }

        return resultNode;
    }
}
