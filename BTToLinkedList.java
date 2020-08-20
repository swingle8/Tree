/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/submissions/
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
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null) {
            TreeNode temp = root.right;
            root.right = root.left;
            root.left = null;
            flatten (root.right);
            
            while (root.right != null)
                root = root.right;
            root.right = temp;
            flatten (root.right);   
        }
          
        flatten(root.right);
    }
}