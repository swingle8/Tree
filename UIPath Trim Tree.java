public Node trimTree (Node root, int k) {
    if (root == null)
        return root;
    trimAtK (root, k, 1);
    return root;
}

public boolean trimAtK (Node root, int k, int count) {
    if (root == null || count == k)
        return false; 
    
    
    boolean removeLeft = trimAtK (root.left, k, count+1);
    boolean removeRight = trimAtK (root.right, k, count+1);
    
    if (removeLeft)
        root.left = null;
    if (removeRight)
        root.right = null;
    
    if (root.left == null && root.right == null) {
        if (count < k) {
            return true;
        }    
    }
    
    return false;
}