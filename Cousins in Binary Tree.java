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
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null )
            return false;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        
        while (! q.isEmpty()) {
            int len = q.size();
            boolean found1 = false;
            boolean found2 = false;
            while (len > 0) {
                TreeNode current = q.remove();
                if (current.left != null && current.right != null && (current.left.val == x || current.left.val == y) && (current.right.val == x || current.right.val == y))
                    return false;
                if (current.left != null)
                    q.add(current.left);
                if (current.right != null)
                    q.add(current.right);
                    
                if ((current.left != null && current.left.val == x) || (current.right != null && current.right.val == x)) {
                    if (! found1)
                        found1 = true;
                    else
                        found2 = true;
                }
                
                if ((current.left != null && current.left.val == y) || (current.right != null && current.right.val == y)) {
                    if (! found1)
                        found1 = true;
                    else
                        found2 = true;
                }
                    
                if (found1 && found2)
                    return true;
            len--;
        }  
        if (found1 && ! found2)
            return false;
    }
        return false;
    }
}