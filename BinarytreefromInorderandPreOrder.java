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
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
       // HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0 ; i < inorder.length ; i++) {
            map.put(inorder[i], i);
        }
            
        return calculator (preorder, 0, preorder.length-1, inorder, 0, inorder.length-1);
    }
    
    public TreeNode calculator (int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preEnd < preStart || inEnd < inStart)
            return null;
        
        TreeNode root = new TreeNode (preorder[preStart]);
        int inIndex = map.get(preorder[preStart]);
        int count = inIndex - inStart;
        
        root.left = calculator(preorder, preStart+1, preStart+count, inorder, inStart, inStart+count-1);
        
        root.right = calculator(preorder, preStart+count+1, preEnd, inorder, inStart+count+1, inEnd);
        
        return root;
    }
}