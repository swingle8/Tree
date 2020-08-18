/**
 * https://leetcode.com/problems/range-sum-of-bst/
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
    int ans = 0;
    public int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null)
            return ans;
        
        rangeSumBST(root.left, L, R);
        if (root.val >= L && root.val <= R) {
            ans = ans + root.val;
        }
        
        rangeSumBST(root.right, L, R);
        
        return ans;
    }
}