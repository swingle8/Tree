/**
 * problem - https://leetcode.com/problems/recover-binary-search-tree/
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
    TreeNode parent1 = null;
    TreeNode parent2 = null;
    TreeNode previous = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        recursion(root);
        int val = parent1.val;
        parent1.val = parent2.val;
        parent2.val = val;
    }
    
    
    public void recursion (TreeNode root) {
       if (root == null)
           return;
        
        recursion(root.left);
        if (parent1 == null && previous.val > root.val) {
            parent1 = previous;
        }
            
        if (parent1 != null && previous.val > root.val) {
            parent2 = root;
        }
        
        previous = root;
        recursion(root.right);
    }
}