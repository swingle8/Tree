/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<TreeNode, Time> map= new HashMap<TreeNode, Time>();
    int maxVal = 0;
    int minVal = 0;
    int min = Integer.MAX_VALUE;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        fillMap(root, 0, p, q);
        TreeNode ans = null;
        
        for (TreeNode curr : map.keySet()) {
            Time t = map.get(curr);

            if (t.in <= maxVal && t.out >= minVal) {
                int gap = (maxVal - t.in) + (t.out - minVal);
                if (gap < min) {
                    min = gap;
                    ans = curr;
                    
                }
                
            }
            
        }
        
        return ans;
    }
    
    public int fillMap(TreeNode root, int in, TreeNode p, TreeNode q) {
        if (root == null)
            return in;
        
        if (! map.containsKey(root)) {
            map.put(root, new Time(in, -1));
            if ((root == p || root == q) && (maxVal == 0))
                maxVal = in;
        }
        
        
       int out = fillMap(root.left, in+1, p, q);
       out = fillMap(root.right, out, p, q);
        
        if (map.containsKey(root)) {
            Time local = map.get(root);
            local.out = out;
            map.put(root, local);
            
            if (root == q || root == p)
                minVal = out;
        }
        
        return out+1;
     }
}

class Time {
    int in = 0;
    int out = 0;
    
    Time (int inTime, int outTime) {
        in = inTime;
        out = outTime;
    }
}