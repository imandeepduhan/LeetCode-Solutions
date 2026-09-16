/*
Problem Name : 104. Maximum Depth of Binary Tree
Problem Link : https://leetcode.com/problems/maximum-depth-of-binary-tree/description/

My Approach: First, I create a function dfs that returns the maximum depth of the tree. In this function, I create two variables l and r to store the maximum depth of the left and right subtree.If the root is null, I return 0. Otherwise, I recursively find the depth of the left and right subtree. Then I take the maximum of l and r and add 1 for the current node.

*/

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

    public int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        int max = Math.max(l , r);
        return max + 1;
    }
    public int maxDepth(TreeNode root) {
        return dfs(root);
    }
}
