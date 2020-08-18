/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
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
    ArrayList<Integer> al = new ArrayList<Integer>();
    public boolean findTarget(TreeNode root, int k) {
        getInOrder(root);
        
        int l = 0;
        int r = al.size()-1;
        
        while (l < r) {
            int low = al.get(l);
            int high = al.get(r);
            
            if (low + high > k) {
                r--;
            }
            else if (low + high < k) {
                l++;
            }
            else
                return true;
        }
        
        return false;
        
    }
    
    public void getInOrder(TreeNode root) {
        if (root == null)
            return;
        
        getInOrder(root.left);
        al.add(root.val);
        getInOrder(root.right);
    }
    
}