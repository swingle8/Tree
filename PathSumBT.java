/**
 * https://leetcode.com/problems/path-sum/
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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        return getPath (root, sum, 0);   
    }
    
    public boolean getPath (TreeNode root, int sum, int currSum) {
        if (root == null) {
            return false;
        }
        
        currSum += root.val;
        
        if (sum == currSum && root.left == null && root.right == null)
                return true;
        
       
        
        boolean left = getPath(root.left, sum, currSum);
        boolean right = getPath(root.right, sum, currSum);
        
        if (left || right)
            return true;
        return false;
        
    }
}