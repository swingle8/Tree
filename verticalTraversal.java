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
    int lowest = 0;
    int heighest = 0;
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        calculate(root, 0);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        //System.out.println(lowest);
        //System.out.println(heighest);
        
        for (int i = lowest ; i <= heighest ; i ++) {
            if (map.containsKey(i)) {
                ArrayList<Integer> val = map.get(i);
                ans.add(val);
            }
        }
        
        return ans;
        
    }
    
    public void calculate (TreeNode root, int index) {
        if (root == null)
            return;
        
        if (index < lowest)
            lowest = index;
        if (index > heighest)
            heighest = index;
        
        if (map.containsKey(index)) {
            ArrayList<Integer> al = map.get(index);
            al.add(root.val);
            map.put(index, al);
        }
        else {
            ArrayList<Integer> al = new ArrayList<Integer>();
            al.add(root.val);
            map.put(index, al);
        }
        
        calculate(root.left, index-1);
        calculate(root.right, index+1);
        
    }
}