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
    ArrayList<Integer> al = new ArrayList<Integer>();
    public List<Integer> rightSideView(TreeNode root) {
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if (root == null)
            return al;
        q.add(root);
        while (! q.isEmpty()) {
            int len = q.size();
            for (int i = 0 ; i < len ; i++) {
                TreeNode curr = q.remove();
                if (i == len-1)
                    al.add(curr.val);
                
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
        }
        return al;
    }
}


    ========================================================Another Solution============
    
    
class Solution {
    ArrayList<Integer> al = new ArrayList<Integer>();
    public List<Integer> rightSideView(TreeNode root) {
            
        int currentDept = 0;
        getRightView(root, al, currentDept);
        return al;
    }
    
    public void getRightView (TreeNode root, ArrayList<Integer> al, int dept) {
        if (root == null)
            return;
        
        if (dept == al.size()) {
            al.add(root.val);
        }
        if (root.right != null)
            getRightView (root.right, al, dept+1);
        if (root.left != null)
            getRightView (root.left, al, dept+1);
    }
}