/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null)
            return root;
        Node curr = root;
        Node horizontal = null;
        while (curr.left != null) {
            curr.left.next = curr.right;
            horizontal = curr;
            while (horizontal.next != null) {
                horizontal.right.next = horizontal.next.left;
                horizontal.next.left.next = horizontal.next.right;
                horizontal = horizontal.next;
            }
            
            curr = curr.left;
        }
        return root;
    }
}