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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        
        for (int i = 0 ; i < inorder.length ; i++) {
            int key = inorder[i];
            map.put(key, i);
        }
        
        return buildTreeRecur (inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
        
    }
    
    
    public TreeNode buildTreeRecur (int [] inorder, int inStart, int inEnd, int [] postorder, int poStart, int poEnd) {
        if (inEnd < inStart || poEnd < poStart)
            return null;
        TreeNode root = new TreeNode(postorder[poEnd]);
        int index = map.get(postorder[poEnd]);
        int newIndex = index - inStart;
        
        root.left = buildTreeRecur(inorder, inStart, index-1, postorder, poStart, poStart+newIndex-1);
        
        root.right = buildTreeRecur(inorder, index+1, inEnd, postorder, poStart+newIndex, poEnd-1);
        
        return root;
    }
}