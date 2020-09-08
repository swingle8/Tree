/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
// Equal Tree Partition
// Problem Description

// Given a binary tree A. Check whether it is possible to partition the tree to two trees which have equal sum of values after removing exactly one edge on the original tree.



// Problem Constraints
// 1 <= size of tree <= 100000

// -109 <= value of node <= 109



// Input Format
// First and only argument is head of tree A.



// Output Format
// Return 1 if the tree can be partitioned into two trees of equal sum else return 0.



// Example Input
// Input 1:

 
//                 5
//                /  \
//               3    7
//              / \  / \
//             4  6  5  6
// Input 2:

 
//                 1
//                / \
//               2   10
//                   / \
//                  20  2


// Example Output
// Output 1:

//  1
// Output 2:

//  0


// Example Explanation
// Explanation 1:

//  Remove edge between 5(root node) and 7: 
//         Tree 1 =                                               Tree 2 =
//                         5                                                     7
//                        /                                                     / \
//                       3                                                     5   6    
//                      / \
//                     4   6
//         Sum of Tree 1 = Sum of Tree 2 = 18
// Explanation 2:

//  The given Tree cannot be partitioned.

public class Solution {
    int ans = 0;
    public int solve(TreeNode A) {
        int total = findTotalSum(A);
        if (total % 2 != 0)
            return ans;
        isHalfPossible(A, total, A);
        return ans;
    }
    
    public int findTotalSum (TreeNode A) {
        if (A == null)
            return 0;
        
        int left = findTotalSum (A.left);
       
        int right = findTotalSum (A.right);
        return left + right + A.val;
        
    }
    
    public int isHalfPossible (TreeNode A, int sum, TreeNode root) {
        if (A == null)
            return 0;
        
        int left = isHalfPossible (A.left, sum, root);
        int right = isHalfPossible (A.right, sum, root);
        
        int sumtillHere = left + right + A.val;
        if (sumtillHere  == (sum * 1/2) && A != root)
            ans = 1;
        
        return (left + right + A.val);
        
    }
}
