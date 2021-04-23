// { Driver Code Starts
import java.util.*;
import java.io.*;
class Node
{
    int data; 
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}

class GFG
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node root = null;
            int inorder[] = new int[n];
            int preorder[] = new int[n];
            for(int i = 0; i < n; i++)
              inorder[i] = sc.nextInt();
              
            for(int i = 0; i < n; i++)
              preorder[i] = sc.nextInt();
              
            Solution ob = new Solution();
            root = ob.buildTree(inorder, preorder, n);
            postOrdrer(root);
            System.out.println();
        }
    }
    
    public static void postOrdrer(Node root)
    {
        if(root == null)
          return;
          
        postOrdrer(root.left);
        postOrdrer(root.right);
        System.out.print(root.data + " ");
    }
}// } Driver Code Ends


class Solution
{
    static int preIndex = 0;
    public static Node buildTree(int inorder[], int preorder[], int n)
    {
        int inLen = inorder.length;
        int preLen = preorder.length;
        preIndex = 0;
        Node ans = new Node (preorder[preIndex]);
        
        int index = search(preorder[preIndex], inorder); 
        
        ans.left = buildTree (preorder, inorder, 0, index-1);
        ans.right = buildTree (preorder, inorder, index+1, inLen-1);
        
        return ans;
    }
    
    public static Node buildTree (int [] preorder, int [] inorder, int start, int end) {
        if (start > end || preIndex == inorder.length-1) {
            return null;
        }
        preIndex++;
        Node current = new Node (preorder[preIndex]);
        int index = search (preorder[preIndex], inorder);
        current.left = buildTree (preorder, inorder, start, index-1);
        current.right = buildTree (preorder, inorder, index+1, end);
        
        return current;
    }
    
    public static int search (int val, int [] arr) {
        int len = arr.length;
        for (int i = 0 ; i < len ; i++) {
            if (arr[i] == val)
                return i;
        }
        return -1;
    }
}
