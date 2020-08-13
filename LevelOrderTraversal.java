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
    List<List<Integer>> ans = new ArrayList();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null)
            return ans;
        
        
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.add(root);
        while (! que.isEmpty()) {
             que = getQue(que);
        }
        
        return ans;
    }
    
    public Queue getQue (Queue<TreeNode> que) {
        Queue<TreeNode> temp = new LinkedList<TreeNode>();
        ArrayList<Integer> inside = new ArrayList<Integer>();
        while (! que.isEmpty()) {
            TreeNode curr = que.remove();
            if (curr != null) {
                inside.add(curr.val);
                if (curr.left != null) {
                    temp.add(curr.left);
                }
                if (curr.right != null) {
                    temp.add(curr.right);
                }
                
            }
        }
        ans.add(inside);
        return temp;
    }
}