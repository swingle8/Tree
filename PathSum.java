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
// Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

// Note: A leaf is a node with no children.

// Example:

// Given the below binary tree and sum = 22,

//       5
//      / \
//     4   8
//    /   / \
//   11  13  4
//  /  \      \
// 7    2      1
// return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

class Solution {
    boolean hasPath = false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null)
            return false;
        TillNow (root, sum, 0);
        return hasPath;
    }

    public TreeNode TillNow (TreeNode root, int sum, int tillNow) {
        if (root == null) {
            return root;
        }
        tillNow = tillNow + root.val;
        TreeNode left = TillNow (root.left, sum, tillNow);
        TreeNode right = TillNow (root.right, sum, tillNow);
        
        if (left == null && right == null) {
            if (tillNow == sum)
                hasPath = true;
        }

        return root; 
    }
}