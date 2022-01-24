package leetcode.BinaryTreeLevelOrderTraversal_102;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public static void main(String[] args) {
        TreeNode node = new TreeNode();
        node.val = 3;
        node.left = new TreeNode(9);
        node.right = new TreeNode(20, new TreeNode(15), new TreeNode(7));

        System.out.println(new Solution().levelOrder(node));

    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();

        searchNode(resultList, root, 1);
        return resultList;
    }

    public static void searchNode(List<List<Integer>> resultList, TreeNode node, int level) {
        if(node == null) {
            return;
        }
        if(resultList.size() < level) {
            for(int i=resultList.size(); i<level; i++) {
                resultList.add(new ArrayList<>());
            }
        }
        int value = node.val;
        resultList.get(level-1).add(value);
        if(node.left != null) {
            searchNode(resultList, node.left, level+1);
        }
        if(node.right != null) {
            searchNode(resultList, node.right, level+1);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


