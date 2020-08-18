/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/submissions/
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
    int kth = 0;
    int val = -1;
    public int kthSmallest(TreeNode root, int k) {
         kth = k;
         calculate(root);
        return val;
    }
    
    public void calculate (TreeNode root) {
        if (root == null || kth == 0)
            return;
        
        calculate(root.left);
        
        if (kth == 1)
            val = root.val;
        
        kth--;
        
        calculate(root.right);
    }
}