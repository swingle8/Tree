/**
 * https://leetcode.com/problems/validate-binary-search-tree/submissions/
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
    
    public boolean isValidBST(TreeNode root) {
        if ((root == null) || (root.left == null && root.right == null))
            return true;
        return look(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        
        
        //Solution 2
        Answer ans = getLook(root);
        return ans.isValid;
    }
    
    public boolean look (TreeNode root, int minVal, int maxVal) {
        if (root == null)
            return true;

        if (root.val <= minVal || root.val >= maxVal) {
           return false;
        }
        else {
            return ((look (root.left, minVal, root.val)) && (look (root.right, root.val, maxVal)));
        }
    }
    
    public Answer getLook (TreeNode root) {
        if (root == null)
            return new Answer(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        
        Answer left = getLook(root.left);
        Answer right = getLook(root.right);
        
        if (root.val > left.max && root.val < right.min && left.isValid && right.isValid)
            return new Answer(true, Math.min(root.val,left.min), Math.max(root.val, right.max) );
        
        return new Answer(false, -1, -1);
    }
}

class Answer {
    boolean isValid = false;
    int min = Integer.MIN_VALUE;
    int max = Integer.MAX_VALUE;
    
    Answer (boolean val, int currMin, int currMax) {
        isValid = val;
        min = currMin;
        max = currMax;
    }
}