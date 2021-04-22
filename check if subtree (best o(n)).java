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
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        String preorderS = preorder (s, true);
        String preorderT = preorder (t, true);
        
        return  preorderS.indexOf(preorderT) >= 0;  
    }
    
    public String preorder (TreeNode node, boolean left) {
        if (node == null) {
            if (left)
                return "lnull";
            else
                return "rnull";
        }
        
        return "#" + node.val + " " + preorder (node.left, true) + " " + preorder (node.right, false);
            
    }
    
}