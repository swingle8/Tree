/**
 * https://leetcode.com/problems/symmetric-tree/submissions/
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
    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        
        if (root.left == null && root.right == null)
            return true;
        
        if ((root.left == null && root.right != null) || (root.right == null && root.left != null))
            return false;
        
        
        if (root.left.val != root.right.val)
            return false;
        
        ArrayList<TreeNode> al = new ArrayList<TreeNode>();
        al.add(root.left);
        al.add(root.right);
        
        
        while (al.size() > 0) {
            int len = al.size();
            ArrayList<TreeNode> alCurr = new ArrayList<TreeNode>();
            for (int i = 0 ; i < len/2 ; i ++) {
                TreeNode forward = al.get(i);
                TreeNode backward = al.get(len-1-i);
                
                if ((forward.left != null && backward.right != null && forward.left.val != backward.right.val) || (forward.left == null && backward.right != null) || (forward.left != null && backward.right == null))
                    return false;
                
                if ((forward.right != null && backward.left != null && forward.right.val != backward.left.val) || (forward.right == null && backward.left != null) || (forward.right != null && backward.left == null))
                    return false;
            
                if (forward.left != null)
                    alCurr.add(forward.left);
                    
                if (forward.right != null)
                    alCurr.add(forward.right);
            }
            
            for (int i = len/2 ; i < len ; i ++) {
                TreeNode forward = al.get(i);
                if (forward.left != null)
                    alCurr.add(forward.left);
                    
                if (forward.right != null)
                    alCurr.add(forward.right);
            }
                
            al = alCurr;
        }
           
        return true;
    }
}