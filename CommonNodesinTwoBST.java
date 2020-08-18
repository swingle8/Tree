// Common Nodes in Two BST
// Problem Description

// Given two BST's A and B, return the (sum of all common nodes in both A and B) % (109 +7) .

// In case there is no common node, return 0.

// NOTE:

// Try to do it one pass through the trees.



// Problem Constraints
// 1 <= Number of nodes in the tree A and B <= 105

// 1 <= Node values <= 106



// Input Format
// First argument represents the root of BST A.

// Second argument represents the root of BST B.



// Output Format
// Return an integer denoting the (sum of all common nodes in both BST's A and B) % (109 +7) .



// Example Input
// Input 1:

//  Tree A:
//     5
//    / \
//   2   8
//    \   \
//     3   15
//         /
//         9

//  Tree B:
//     7
//    / \
//   1  10
//    \   \
//     2  15
//        /
//       11
// Input 2:

//   Tree A:
//     7
//    / \
//   1   10
//    \   \
//     2   15
//         /
//        11

//  Tree B:
//     7
//    / \
//   1  10
//    \   \
//     2  15
//        /
//       11


// Example Output
// Output 1:

//  17
// Output 2:

//  46

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
public class Solution {
    ArrayList<Integer> al1 = new ArrayList<Integer>();
    ArrayList<Integer> al2 = new ArrayList<Integer>();
    
    public int solve(TreeNode A, TreeNode B) {
        al1 = makeInorder(A, al1);
        al2  = makeInorder(B, al2);
        
        int sum = 0;
        int start = 0;
        int end = 0;
        
        while (start < al1.size() && end < al2.size()) {
            if (al1.get(start) < al2.get(end)) {
                start++;
            }
            else if (al1.get(start) > al2.get(end)) {
                end++;
            }
            else {
                sum = sum + al1.get(start);
                end++;
                start++;
            }
            
        }
        return sum;
    }
    
    public ArrayList<Integer> makeInorder (TreeNode A, ArrayList<Integer> al) {
        if (A == null)
            return al;
        
        makeInorder (A.left, al);
        al.add(A.val);
        makeInorder (A.right, al);
        
        return al;
    }
}
