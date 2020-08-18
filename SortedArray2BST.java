/**
 * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
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
    public TreeNode sortedArrayToBST(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        return makeTree(nums, 0, r);
        
        //return root;
    }
    
    TreeNode makeTree (int [] nums, int l, int r) {
        if (l > r)
            return null;
        
        int mid = l + (r-l)/2;
        TreeNode t = new TreeNode(nums[mid]);
        
        t.left = makeTree(nums, l, mid-1);
        t.right = makeTree(nums, mid+1, r);
        return t;
    }
}